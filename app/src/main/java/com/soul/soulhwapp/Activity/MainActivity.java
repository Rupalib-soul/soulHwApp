package com.soul.soulhwapp.Activity;//package com.soul.soulhwapp.Activity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.FirebaseException;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.auth.PhoneAuthCredential;
//import com.google.firebase.auth.PhoneAuthOptions;
//import com.google.firebase.auth.PhoneAuthProvider;
//import com.soul.soulhwapp.R;
//
//import java.util.concurrent.TimeUnit;
//
//public class MainActivity extends AppCompatActivity {
//        EditText phone,otp;
//        Button btnGenOTP,btnVerify;
//        FirebaseAuth mAuth;
//        String verificationId;
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_main);
//            phone=findViewById(R.id.phoneText);
//            otp=findViewById(R.id.otpText);
//            btnGenOTP=findViewById(R.id.btnGenerateOtp);
//            btnVerify=findViewById(R.id.btnVerifyOtp);
//            mAuth=FirebaseAuth.getInstance();
//
//            btnGenOTP.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(TextUtils.isEmpty(phone.getText().toString())){
//                        Toast.makeText(MainActivity.this,"Enter Valid Phone No.",Toast.LENGTH_SHORT).show();
//                    }else{
//                        String number=phone.getText().toString();
//                        sendVerificationCode(number);
//                    }
//
//
//                }
//            });
//            btnVerify.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(TextUtils.isEmpty(otp.getText().toString())){
//                        Toast.makeText(MainActivity.this,"Wrong OTP Entered",Toast.LENGTH_SHORT).show();
//                    }else{
//                        verifyCode(otp.getText().toString());
//                    }
//
//                }
//            });
//        }
//
//        private void sendVerificationCode(String phoneNumber) {
//            PhoneAuthOptions options =
//                    PhoneAuthOptions.newBuilder(mAuth)
//                            .setPhoneNumber("+91"+phoneNumber)       // Phone number to verify
//                            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
//                            .setActivity(this)                 // (optional) Activity for callback binding
//                            // If no activity is passed, reCAPTCHA verification can not be used.
//                            .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
//                            .build();
//            PhoneAuthProvider.verifyPhoneNumber(options);
//        }
//        private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks =
//                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//
//                    @Override
//                    public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {
//
//                        final String code=credential.getSmsCode();
//                        if (code!=null)
//                        {
//                            verifyCode(code);
//                        }
//
//                    }
//
//                    @Override
//                    public void onVerificationFailed(@NonNull FirebaseException e) {
//                        Toast.makeText(MainActivity.this, "Verification Failed", Toast.LENGTH_SHORT).show();
//
//                    }
//
//                    @Override
//                    public void onCodeSent(@NonNull String s,
//                                           @NonNull PhoneAuthProvider.ForceResendingToken token) {
//
//                        super.onCodeSent(s,token);
//                        verificationId=s;
//                    }
//                };
//        private void verifyCode(String Code) {
//            PhoneAuthCredential credential= PhoneAuthProvider.getCredential(verificationId,Code);
//            signInByCredentials(credential);
//        }
//
//        private void signInByCredentials(PhoneAuthCredential credential) {
//            FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
//            firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if(task.isSuccessful()){
//                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
//                    }
//                }
//            });
//        }
//
//        @Override
//        protected void onStart() {
//            super.onStart();
//            FirebaseUser currentUser=FirebaseAuth.getInstance().getCurrentUser();
//            if(currentUser!=null)
//            {
//                startActivity(new Intent(MainActivity.this, HomeActivity.class));
//                finish();
//            }
//        }
//
//}