package com.soul.soulhwapp.Utils;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class GoogleSignInHelper {
    private static final int RC_SIGN_IN = 1001;
    private static final String TAG = "GoogleSignInHelper";

    private Activity activity;
    private GoogleSignInClient googleSignInClient;

    public GoogleSignInHelper(Activity activity) {
        this.activity = activity;

        // Configure Google Sign-In options
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options
        googleSignInClient = GoogleSignIn.getClient(activity, gso);
    }

    public void signIn() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        activity.startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    public void signOut() {
        googleSignInClient.signOut()
                .addOnCompleteListener(activity, task -> {
                    // Sign-out successful.
                    Log.d(TAG, "User signed out successfully");
                });
    }

    public void handleSignInResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                if (account != null) {
                    // You can access the account information here
                    String email = account.getEmail();
                    String displayName = account.getDisplayName();
                    String idToken = account.getIdToken();

                    Log.d(TAG, "Email: " + email);
                    Log.d(TAG, "Display Name: " + displayName);
                    Log.d(TAG, "ID Token: " + idToken);

                    // You can also pass this information to your authentication system or server
                }
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.e(TAG, "Google sign in failed", e);
                Toast.makeText(activity, "Google Sign-In failed. Please try again.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
