package com.soul.soulhwapp.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.soul.soulhwapp.Activity.HomeActivity;
import com.soul.soulhwapp.R;


public class TaskFragment extends Fragment implements View.OnClickListener {

    View view;
    LinearLayout btAddTask, btViewTask, btPendingTask;
    private AddTaskFragment addTaskFragment;
    private ViewTaskFragment viewTaskFragment;
    private PendingTaskFragment pendingTaskFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        if (actionBar != null) {
//            actionBar.setTitle("Task");
            actionBar.setTitle(Html.fromHtml("<font color='#ffffff'>Task</font>"));
        }
        view = inflater.inflate(R.layout.fragment_task, container, false);

        btAddTask = view.findViewById(R.id.btn_add_task);
        btViewTask = view.findViewById(R.id.btn_view_task);
        btPendingTask = view.findViewById(R.id.btn_pending_task);

        btAddTask.setOnClickListener(this);
        btViewTask.setOnClickListener(this);
        btPendingTask.setOnClickListener(this);


        addTaskFragment = new AddTaskFragment();
        viewTaskFragment = new ViewTaskFragment();
        pendingTaskFragment = new PendingTaskFragment();
        return view;
    }

    @Override
    public void onClick(View v) {

        Fragment fragment = null;

        switch (v.getId()) {
            case R.id.btn_add_task:
                fragment = addTaskFragment;
                break;
            case R.id.btn_view_task:
                fragment = viewTaskFragment;
                break;
            case R.id.btn_pending_task:
                fragment = pendingTaskFragment;
                break;

        }

        if (fragment != null) {
            replaceFragment(fragment);
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.task_frame, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    @Override
    public void onDetach() {
        super.onDetach();
        ((HomeActivity) requireActivity()).updateActionBarTitle("SOUL HW APP");
    }

}
