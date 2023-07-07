package com.soul.soulhwapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.soul.soulhwapp.R;
import com.soul.soulhwapp.Utils.CommonUtils;

public class SplashScreenActivity extends AppCompatActivity {
    CommonUtils commonUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        if (commonUtils.isNetworkAvailable(SplashScreenActivity.this)) {
            Thread background = new Thread() {
                public void run() {

                    try {
                        // Thread will sleep for 5 seconds
                        sleep(2 * 1000);
                        // After 5 seconds redirect to another intent
//                    Intent i = new Intent(getBaseContext(),SignInActivity.class);
                        Intent i = new Intent(getBaseContext(), LoginActivity.class);
                        startActivity(i);

                        //Remove activity
                        finish();

                    } catch (Exception e) {

                    }
                }
            };


            background.start();
        } else {
            CommonUtils.Show_Dialog("Please Check your internet connectivity", SplashScreenActivity.this);

        }
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }

}