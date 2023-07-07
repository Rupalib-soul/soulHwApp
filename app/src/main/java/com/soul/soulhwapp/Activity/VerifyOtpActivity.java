package com.soul.soulhwapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.soul.soulhwapp.R;

import java.util.concurrent.TimeUnit;

public class VerifyOtpActivity extends AppCompatActivity {
    EditText et_inputNumber1, et_inputNumber2, et_inputNumber3, et_inputNumber4,et_inputNumber5,et_inputNumber6;
    String getOtpBackend;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);

        et_inputNumber1 = findViewById(R.id.inputOtp1);
        et_inputNumber2 = findViewById(R.id.inputOtp2);
        et_inputNumber3 = findViewById(R.id.inputOtp3);
        et_inputNumber4 = findViewById(R.id.inputOtp4);
        et_inputNumber5 = findViewById(R.id.inputOtp5);
        et_inputNumber6 = findViewById(R.id.inputOtp6);

        final Button btn_VerifyOtp = findViewById(R.id.btn_verify);
        final ProgressBar pb = findViewById(R.id.pb_sending_otp);
        mAuth = FirebaseAuth.getInstance();

        TextView textView = findViewById(R.id.txtMobileShow);
        textView.setText(String.format(
                "+91-%s", getIntent().getStringExtra("mobile")
        ));
        getOtpBackend = getIntent().getStringExtra("backendotp");

        btn_VerifyOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_inputNumber1.getText().toString().trim().isEmpty()
                        && !et_inputNumber2.getText().toString().trim().isEmpty()
                        && !et_inputNumber3.getText().toString().trim().isEmpty()
                        && !et_inputNumber4.getText().toString().trim().isEmpty()
                        && !et_inputNumber5.getText().toString().trim().isEmpty()
                        && !et_inputNumber6.getText().toString().trim().isEmpty()) {


                    String enterCodeOtp = et_inputNumber1.getText().toString() +
                            et_inputNumber2.getText().toString() +
                            et_inputNumber3.getText().toString() +
                            et_inputNumber4.getText().toString()+
                            et_inputNumber5.getText().toString()+
                            et_inputNumber6.getText().toString();

                    if (getOtpBackend != null) {
                        pb.setVisibility(View.VISIBLE);
                        btn_VerifyOtp.setVisibility(View.INVISIBLE);
                        PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                                getOtpBackend, enterCodeOtp
                        );
                        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        pb.setVisibility(View.GONE);
                                        btn_VerifyOtp.setVisibility(View.VISIBLE);

                                        if (task.isSuccessful()) {
                                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(VerifyOtpActivity.this, "Enter the correct OTP", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                    } else {
                        Toast.makeText(VerifyOtpActivity.this, "Please Check internet connection.", Toast.LENGTH_SHORT).show();
                    }
//                    Toast.makeText(VerifyOtpActivity.this, "otp verify", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(VerifyOtpActivity.this, "Please enter all the number", Toast.LENGTH_SHORT).show();
                }

            }
        });
        numberOtpMove();
        findViewById(R.id.tvResendOtp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneAuthOptions options =
                        PhoneAuthOptions.newBuilder(mAuth)
                                .setPhoneNumber("+91" + getIntent().getStringExtra("mobile"))       // Phone number to verify
                                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                .setActivity(VerifyOtpActivity.this)                 // (optional) Activity for callback binding
                                // If no activity is passed, reCAPTCHA verification can not be used.
//                                .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                                .build();
                PhoneAuthProvider.verifyPhoneNumber(options);


            }
        });
        PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks =
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {



                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {

                        Toast.makeText(VerifyOtpActivity.this, "Verification Failed", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCodeSent(@NonNull String newbackendotp,
                                           @NonNull PhoneAuthProvider.ForceResendingToken token) {
                    getOtpBackend=newbackendotp;
                        Toast.makeText(VerifyOtpActivity.this, "OTP sent successfully.", Toast.LENGTH_SHORT).show();

                    }
                };


    }

    private void numberOtpMove() {

        et_inputNumber1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().trim().isEmpty()) {
                    et_inputNumber2.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_inputNumber2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().trim().isEmpty()) {
                    et_inputNumber3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_inputNumber3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().trim().isEmpty()) {
                    et_inputNumber4.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_inputNumber4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().trim().isEmpty()) {
                    et_inputNumber5.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et_inputNumber5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().trim().isEmpty()) {
                    et_inputNumber6.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}