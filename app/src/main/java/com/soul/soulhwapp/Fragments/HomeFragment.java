//package com.soul.soulhwapp.Fragments;
//
//import android.os.Bundle;
//
//import androidx.appcompat.app.ActionBar;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.cardview.widget.CardView;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.soul.soulhwapp.R;
//
//
//public class HomeFragment extends Fragment implements View.OnClickListener {
//
//    private CardView cvTask, cvGuide, cvPolicy, cvHistory, cvInfo, cvHelp;
//    private TaskFragment taskFragment;
//    private GuideFragment guideFragment;
//    private ViewTaskFragment policyFragment;
//    private HistoryFragment historyFragment;
//    private InfoFragment infoFragment;
//    private HelpFragment helpFragment;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_home, container, false);
//
//        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setTitle("Home");
//        }
//
//        cvTask = view.findViewById(R.id.cv_Task);
//        cvGuide = view.findViewById(R.id.cv_Guide);
//        cvPolicy = view.findViewById(R.id.cv_Policy);
//        cvHistory = view.findViewById(R.id.cv_History);
//        cvInfo = view.findViewById(R.id.cv_Info);
//        cvHelp = view.findViewById(R.id.cv_Help);
//
//        cvTask.setOnClickListener(this);
//        cvGuide.setOnClickListener(this);
//        cvPolicy.setOnClickListener(this);
//        cvHistory.setOnClickListener(this);
//        cvInfo.setOnClickListener(this);
//        cvHelp.setOnClickListener(this);
//
//        // Create the fragment instances
//        taskFragment = new TaskFragment();
//        guideFragment = new GuideFragment();
//        policyFragment = new ViewTaskFragment();
//        historyFragment = new HistoryFragment();
//        infoFragment = new InfoFragment();
//        helpFragment = new HelpFragment();
//
//        return view;
//    }
//
//    @Override
//    public void onClick(View v) {
//        Fragment fragment = null;
//
//        switch (v.getId()) {
//            case R.id.cv_Task:
//                fragment = taskFragment;
//                break;
//            case R.id.cv_Guide:
//                fragment = guideFragment;
//                break;
//            case R.id.cv_Policy:
//                fragment = policyFragment;
//                break;
//            case R.id.cv_History:
//                fragment = historyFragment;
//                break;
//            case R.id.cv_Info:
//                fragment = infoFragment;
//                break;
//            case R.id.cv_Help:
//                fragment = helpFragment;
//                break;
//        }
//
//        if (fragment != null) {
//            replaceFragment(fragment);
//        }
//    }
//
//    private void replaceFragment(Fragment fragment) {
//        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.home_frame, fragment);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
//    }
//}
