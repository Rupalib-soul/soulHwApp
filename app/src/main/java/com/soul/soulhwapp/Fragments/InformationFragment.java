package com.soul.soulhwapp.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.soul.soulhwapp.Interface.NewTaskListener;
import com.soul.soulhwapp.R;


public class InformationFragment extends Fragment {
    View view;
    private EditText etTitle;
    private EditText etDescription;
    private Button btnSubmit;
    private NewTaskListener listener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        if (actionBar != null) {
            // Set the title based on the fragment
            actionBar.setTitle("Information");
        }
        view = inflater.inflate(R.layout.fragment_information, container, false);
        return view;
    }



}