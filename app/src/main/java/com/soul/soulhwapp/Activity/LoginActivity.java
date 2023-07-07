package com.soul.soulhwapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;
import com.soul.soulhwapp.Model.LoginUsers;
import com.soul.soulhwapp.R;
import com.soul.soulhwapp.Utils.PrefManager;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_mobileNumber;
    Button btn_getOtp, btn_mobileNumber, btn_userName;
    ProgressBar pb;
    private LinearLayout mobileLayout, userLayout;
    LinearLayout ll_GoogleButton;
    GoogleSignInClient mGoogleSignInClient;
    GoogleSignInOptions gso;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    EditText etUserName, etPassword;
    Button btn_Login;
    CheckBox cbRemember;
    TextView tvForgotPwd;
    String sCheckUserName, sCheckPassword;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_mobileNumber = findViewById(R.id.inputMobileNumber);
        btn_getOtp = findViewById(R.id.btnGetOtp);
        btn_mobileNumber = findViewById(R.id.btn_mobileNumber);
        btn_userName = findViewById(R.id.btn_userName);
        pb = findViewById(R.id.pb_sending_otp);
        mobileLayout = findViewById(R.id.mobile_layout);
        userLayout = findViewById(R.id.user_layout);
        etUserName = findViewById(R.id.et_UserName);
        etPassword = findViewById(R.id.et_Pwd);
        tvForgotPwd = findViewById(R.id.tv_ForgotPassword);
        cbRemember = findViewById(R.id.cb_Remember);

        btn_Login = findViewById(R.id.btnLogin);

        btn_mobileNumber.setOnClickListener(this);
        btn_userName.setOnClickListener(this);
        prefManager = PrefManager.getInstance(this);

        etUserName.setText("soul");
        etPassword.setText("1234");


        cbRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                prefManager.setRememberCredentials(isChecked);

            }
        });

        btn_mobileNumber.setBackground(getResources().getDrawable(R.drawable.background_button_login));
        btn_userName.setBackground(getResources().getDrawable(R.drawable.background_button_login_white));
        ll_GoogleButton = findViewById(R.id.ll_google_login);
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        ll_GoogleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();

            }
        });
        btn_getOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_mobileNumber.getText().toString().trim().isEmpty()) {
                    if ((et_mobileNumber.getText().toString().trim()).length() == 10) {
                        pb.setVisibility(View.VISIBLE);
                        btn_getOtp.setVisibility(View.INVISIBLE);
                        String number = et_mobileNumber.getText().toString();
                        sendVerificationCode(number);


                    } else {
                        Toast.makeText(LoginActivity.this, "Please Enter Correct Number", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sCheckUserName = etUserName.getText().toString();
                sCheckPassword = etPassword.getText().toString();
                if (sCheckUserName.equals("")) {
                    Toast.makeText(LoginActivity.this, "Enter Username or email id", Toast.LENGTH_SHORT).show();
                } else if (sCheckPassword.equals("")) {
                    Toast.makeText(LoginActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                } else {
                    DoLogin(sCheckUserName, sCheckPassword);

                }
            }
        });
    }


    int RC_SIGN_IN = 40;

    private void signIn() {
        Intent intent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(intent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuth(account.getIdToken());
                findViewById(R.id.ll_google_login).setVisibility(View.GONE);
                Toast.makeText(this, "Logged in:" + account.getDisplayName(), Toast.LENGTH_SHORT)
                        .show();
            } catch (ApiException e) {
                e.printStackTrace();
                Toast.makeText(this, "Sign in failed:" + e.getLocalizedMessage(), Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    private void firebaseAuth(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    LoginUsers users = new LoginUsers();
                    users.setUserId(user.getUid());
                    users.setName(user.getDisplayName());
                    users.setProfile(user.getPhotoUrl().toString());
                    firebaseDatabase.getReference().child("LoginUsers").child(user.getUid())
                            .setValue(users);
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    prefManager.setLoginType(1);
                } else {
                    Toast.makeText(LoginActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void sendVerificationCode(String phoneNumber) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91" + phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // (optional) Activity for callback binding
                        // If no activity is passed, reCAPTCHA verification can not be used.
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks =
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {

                    pb.setVisibility(View.GONE);
                    btn_getOtp.setVisibility(View.VISIBLE);

                }

                @Override
                public void onVerificationFailed(@NonNull FirebaseException e) {
                    pb.setVisibility(View.GONE);
                    btn_getOtp.setVisibility(View.VISIBLE);
                    Toast.makeText(LoginActivity.this, "Verification Failed", Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onCodeSent(@NonNull String backendotp,
                                       @NonNull PhoneAuthProvider.ForceResendingToken token) {
                    pb.setVisibility(View.GONE);
                    btn_getOtp.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getApplicationContext(), VerifyOtpActivity.class);
                    intent.putExtra("mobile", et_mobileNumber.getText().toString());
                    intent.putExtra("backendotp", backendotp);
                    startActivity(intent);
                    prefManager.setLoginType(2);
                }
            };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_mobileNumber:
                Drawable drawable = getResources().getDrawable(R.drawable.background_button_login_white);
                btn_userName.setBackground(drawable);
                Drawable drawable1 = getResources().getDrawable(R.drawable.background_button_login);
                btn_mobileNumber.setBackground(drawable1);
                mobileLayout.setVisibility(View.VISIBLE);
                userLayout.setVisibility(View.GONE);
                break;
            case R.id.btn_userName:
                Drawable drawables = getResources().getDrawable(R.drawable.background_button_login_white);
                btn_mobileNumber.setBackground(drawables);
                Drawable drawable2 = getResources().getDrawable(R.drawable.background_button_login);
                btn_userName.setBackground(drawable2);
                userLayout.setVisibility(View.VISIBLE);
                mobileLayout.setVisibility(View.GONE);
                break;
        }
    }

    public void DoLogin(String userid, String password) {
        try {
            prefManager.setUsername(userid);
            prefManager.setPassword(password);

            if (isValidCredentials(userid, password)) {
                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(i);
                prefManager.setLoginType(0);

                if (prefManager.getRememberCredentials()) {
                    startActivity(i);
                }

                finish();
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidCredentials(String userid, String password) {
        return userid.equals("soul") && password.equals("1234");
    }


    @Override
    public void onBackPressed() {
        finishAffinity();
    }

}