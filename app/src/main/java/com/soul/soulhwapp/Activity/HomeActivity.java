package com.soul.soulhwapp.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.soul.soulhwapp.Fragments.MapFragment;
import com.soul.soulhwapp.Fragments.HelpFragment;
import com.soul.soulhwapp.Fragments.HistoryFragment;
import com.soul.soulhwapp.Fragments.InformationFragment;
import com.soul.soulhwapp.Fragments.ProfileFragment;
import com.soul.soulhwapp.Fragments.TaskFragment;
import com.soul.soulhwapp.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    FirebaseAuth mAuth;
    Button logout;


    private LinearLayout cvTask, cvGuide, cvPolicy, cvHistory, cvMyAccount, cvHelp;
    private TaskFragment taskFragment;
    private MapFragment mapFragment;
    private InformationFragment policyFragment;
    private HistoryFragment historyFragment;
    private ProfileFragment profileFragment;
    private HelpFragment helpFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAuth = FirebaseAuth.getInstance();




        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffffff'>SOUL HW APP</font>"));
        actionBar.setIcon(R.drawable.logo);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.colorTask)));
        }

        cvTask = findViewById(R.id.cv_Task);
        cvGuide = findViewById(R.id.cv_Guide);
        cvPolicy = findViewById(R.id.cv_Policy);
        cvHistory = findViewById(R.id.cv_History);
        cvMyAccount = findViewById(R.id.cv_my_account);
        cvHelp = findViewById(R.id.cv_Help);

        cvTask.setOnClickListener(this);
        cvGuide.setOnClickListener(this);
        cvPolicy.setOnClickListener(this);
        cvHistory.setOnClickListener(this);
        cvMyAccount.setOnClickListener(this);
        cvHelp.setOnClickListener(this);

        // Create the fragment instances
        taskFragment = new TaskFragment();
        mapFragment = new MapFragment();
        policyFragment = new InformationFragment();
        historyFragment = new HistoryFragment();
        profileFragment = new ProfileFragment();
        helpFragment = new HelpFragment();

//        logout=findViewById(R.id.logout);

//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mAuth.signOut();
//                startActivity(new Intent(HomeActivity.this, MainActivity.class));
//                finish();
//            }
//        });

    }


    @Override
    public void onClick(View v) {
        Fragment fragment = null;

        switch (v.getId()) {
            case R.id.cv_Task:
                fragment = taskFragment;
                break;
            case R.id.cv_Guide:
                fragment = mapFragment;
                break;
            case R.id.cv_Policy:
                fragment = policyFragment;
                break;
            case R.id.cv_History:
                fragment = historyFragment;
                break;
            case R.id.cv_my_account:
                fragment = profileFragment;
                break;
            case R.id.cv_Help:
                fragment = helpFragment;
                break;
        }

        if (fragment != null) {
            replaceFragment(fragment);
        }
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        updateActionBarTitle("SOUL HW APP");
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }
//        finishAffinity();
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//            // Get the currently displayed fragment
//            Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame_container);
//
//            // Check if the click is outside of any fragment's view
//            if (currentFragment != null && currentFragment.getView() != null &&
//                    !currentFragment.getView().dispatchTouchEvent(ev)) {
//                // If click is outside, do nothing
//                return true;
//            }
//        }
//        return super.dispatchTouchEvent(ev);
//    }

    public void updateActionBarTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }


}