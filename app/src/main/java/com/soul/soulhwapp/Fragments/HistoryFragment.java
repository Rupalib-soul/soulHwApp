package com.soul.soulhwapp.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soul.soulhwapp.Adapter.HistoryAdapter;
import com.soul.soulhwapp.Model.TaskModel;
import com.soul.soulhwapp.R;
import com.soul.soulhwapp.Utils.Constants;

import java.util.ArrayList;


public class HistoryFragment extends Fragment {

    View view;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        if (actionBar != null) {
            // Set the title based on the fragment
            actionBar.setTitle("History");
        }
        view = inflater.inflate(R.layout.fragment_history, container, false);
        return view;
    }

//    public static HistoryFragment newInstance(String param1,
//                                              String param2) {
//        HistoryFragment fragment = new HistoryFragment();
//        Bundle args = new Bundle();
//        args.putString("param1", param1);
//        args.putString("param2", param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onViewCreated(View view,
                              Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // getting the employeelist
        ArrayList<TaskModel> employelist
                = Constants.getEmployeeData();

        // Assign employeelist to ItemAdapter
        HistoryAdapter itemAdapter = new HistoryAdapter(employelist);

        // Set the LayoutManager that
        // this RecyclerView will use.
        RecyclerView recyclerView
                = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));

        // adapter instance is set to the
        // recyclerview to inflate the items.
        recyclerView.setAdapter(itemAdapter);
    }

//    View view;
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
//
//        if (actionBar != null) {
//            // Set the title based on the fragment
//            actionBar.setTitle("History");
//        }
//        view = inflater.inflate(R.layout.fragment_history, container, false);
//        return view;
//    }
}