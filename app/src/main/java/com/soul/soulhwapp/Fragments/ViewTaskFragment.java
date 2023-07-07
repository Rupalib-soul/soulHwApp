package com.soul.soulhwapp.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soul.soulhwapp.Adapter.TaskAdapter;
import com.soul.soulhwapp.DataBase.DBHelperManager;
import com.soul.soulhwapp.Model.TaskModel;
import com.soul.soulhwapp.R;

import java.util.ArrayList;
import java.util.List;


public class ViewTaskFragment extends Fragment {
    View view;
    DBHelperManager myDB;
    ArrayList<TaskModel> taskList;
    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle(Html.fromHtml("<font color='#ffffff'>Task Details</font>"));
        }
        view = inflater.inflate(R.layout.fragment_view_task, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view,
                              Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myDB = new DBHelperManager(getActivity());
        taskList = myDB.taskModelArrayList();
        TaskAdapter itemAdapter = new TaskAdapter(taskList);
        mRecyclerView= view.findViewById(R.id.rv_viewtask);
        mRecyclerView.setLayoutManager( new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(itemAdapter);
    }


}