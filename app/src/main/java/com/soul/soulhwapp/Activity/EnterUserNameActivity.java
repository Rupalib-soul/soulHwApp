//package com.soul.soulhwapp.Activity;
//
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.auth.api.signin.GoogleSignIn;
//import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
//import com.google.android.gms.auth.api.signin.GoogleSignInClient;
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
//import com.google.android.gms.common.api.ApiException;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthCredential;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.auth.GoogleAuthProvider;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.annotations.Nullable;
//import com.soul.soulhwapp.Model.LoginUsers;
//import com.soul.soulhwapp.R;
//import com.soul.soulhwapp.Utils.PrefManager;
//
//public class EnterUserNameActivity extends AppCompatActivity {
//    EditText etUserName, etPassword;
//    ImageView ivShow;
//    Button btn_Login;
//    CheckBox cbRemember;
//    TextView tvForgotPwd;
//    String sCheckUserName, sCheckPassword;
//    SharedPreferences shp;
//    SharedPreferences.Editor shpEditor;
//
//    LinearLayout ll_GoogleButton;
//    GoogleSignInClient mGoogleSignInClient;
//    GoogleSignInOptions gso;
//    FirebaseAuth mAuth;
//    FirebaseDatabase firebaseDatabase;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.enter_user);
//
//        etUserName = findViewById(R.id.et_UserName);
//        etPassword = findViewById(R.id.et_Pwd);
//        tvForgotPwd = findViewById(R.id.tv_ForgotPassword);
//        cbRemember = findViewById(R.id.cb_Remember);
//
//        btn_Login = findViewById(R.id.btnLogin);
//
//        etUserName.setText("soul");
//        etPassword.setText("1234");
//
//
//
//        shp = getSharedPreferences("myPreferences", MODE_PRIVATE);
//        CheckLogin();
//        if (!new PrefManager(this).isUserLoggedOut()) {
//            //user's email and password both are saved in preferences
//            Intent intent = new Intent(this, HomeActivity.class);
//            startActivity(intent);
//            finish();
//        }
//
//
//        tvForgotPwd.setOnClickListener(v -> {
//
//        });
//
//        mAuth = FirebaseAuth.getInstance();
//
//
//
//
//        btn_Login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sCheckUserName = etUserName.getText().toString();
//                sCheckPassword = etPassword.getText().toString();
//
//                if (sCheckUserName.equals("")) {
//                    Toast.makeText(EnterUserNameActivity.this, "Enter Username or email id", Toast.LENGTH_SHORT).show();
//                }
//
//                if (sCheckPassword.equals("")) {
//                    Toast.makeText(EnterUserNameActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
//                } else {
//                    DoLogin(sCheckUserName, sCheckPassword);
//                }
//            }
//        });
//    }
//
//
//
//
//
//
//
//    public void DoLogin(String userid, String password) {
//        try {
//            if (password.equals("1234")) {
//                if (shp == null)
//                    shp = getSharedPreferences("myPreferences", MODE_PRIVATE);
//
//                shpEditor = shp.edit();
//                shpEditor.putString("name", userid);
//                shpEditor.commit();
//
//                Intent i = new Intent(EnterUserNameActivity.this, HomeActivity.class);
//                startActivity(i);
//                finish();
//            } else
//                Toast.makeText(this, "Invalid Credentails", Toast.LENGTH_SHORT).show();
//
//        } catch (Exception ex) {
//            Toast.makeText(this, ex.getMessage().toString(), Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    public void CheckLogin() {
//        if (shp == null)
//            shp = getSharedPreferences("myPreferences", MODE_PRIVATE);
//
//        String userName = shp.getString("name", "");
//
//        if (userName != null && !userName.equals("")) {
//            Intent i = new Intent(EnterUserNameActivity.this, HomeActivity.class);
//            startActivity(i);
//            finish();
//        }
//    }
//
//}