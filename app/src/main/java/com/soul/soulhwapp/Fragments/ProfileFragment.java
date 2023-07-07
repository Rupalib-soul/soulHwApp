package com.soul.soulhwapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.soul.soulhwapp.Activity.LoginActivity;
import com.soul.soulhwapp.R;
import com.soul.soulhwapp.Utils.PrefManager;

/**
 * Created by rupali on 04/07/2023.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {

    View view;
    Button btnSubmit, btnLogout;
    TextView tvUserName;
    EditText etUpdateMobileNo, etUpdateEmailId;
    String mobileNumber;
    FirebaseAuth mAuth;
    GoogleSignInClient mGoogleSignInClient;
    GoogleSignInOptions gso;
    private PrefManager prefManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle(Html.fromHtml("<font color='#ffffff'>My Account</font>"));
        }

        Bundle arguments = getArguments();
        if (arguments != null) {
            mobileNumber = arguments.getString("key");
        }

        view = inflater.inflate(R.layout.fragment_profile, container, false);
        mAuth = FirebaseAuth.getInstance();
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
        btnSubmit = view.findViewById(R.id.btn_update);
        btnLogout = view.findViewById(R.id.btn_logout);
        tvUserName = view.findViewById(R.id.tv_Username);

        prefManager = PrefManager.getInstance(getActivity());

        int loginType = prefManager.getLoginType();

        if (loginType == 0) {
            // Regular login
            String username = prefManager.getUsername();
            tvUserName.setText(username);
        } else if (loginType == 1) {
            GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getActivity());
            if (account != null) {
                String googleUsername = account.getDisplayName();
                Toast.makeText(getActivity(), "Google username: " + googleUsername, Toast.LENGTH_SHORT).show();
                tvUserName.setText(googleUsername);
            }
        } else if (loginType == 2) {
            // Mobile number login
            tvUserName.setText(mobileNumber);
        }

        btnSubmit.setOnClickListener(this);
        btnLogout.setOnClickListener(this);

        return view;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update:
                Toast.makeText(getActivity(), "button clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_logout:
                mAuth.signOut();

                // Clear the preferences
                prefManager.clearPreferences();

                // Sign out from Google SignInClient
                mGoogleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // Redirect to the login screen or perform any other desired action
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                });
                break;
        }
    }

}