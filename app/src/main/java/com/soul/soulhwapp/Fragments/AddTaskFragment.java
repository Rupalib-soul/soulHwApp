package com.soul.soulhwapp.Fragments;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.soul.soulhwapp.Activity.LoginActivity;
import com.soul.soulhwapp.DataBase.DBHelperManager;
import com.soul.soulhwapp.R;

import java.util.Calendar;

public class AddTaskFragment extends Fragment implements View.OnClickListener {

    View view;
    private EditText etTaskName, etTaskDescription;
    private AppCompatButton btnSubmit, btnCancel;
    private DatePickerDialog datePickerDialog;
    private AppCompatButton btn_StartDatePickerButton, btn_DueDatePickerButton;
    private View selectedView;
    private String sTaskName = "";
    private String sTaskDescription = "";
    private String sStartDate = "";
    private String sDueDate = "";
    DBHelperManager myDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle(Html.fromHtml("<font color='#ffffff'>Add Task</font>"));
        }
        view = inflater.inflate(R.layout.fragment_add_task, container, false);


        etTaskName = view.findViewById(R.id.et_task_name);
        etTaskDescription = view.findViewById(R.id.et_task_description);
        btn_StartDatePickerButton = view.findViewById(R.id.btn_start_datePickerButton);
//      btn_StartDatePickerButton.setText(getTodaysDate());
        btn_DueDatePickerButton = view.findViewById(R.id.btn_due_datePickerButton);
        btnSubmit = view.findViewById(R.id.btn_task_submit);
        btnCancel = view.findViewById(R.id.btn_task_cancel);


        btnSubmit.setOnClickListener(this);
        btn_StartDatePickerButton.setOnClickListener(this);
        btn_DueDatePickerButton.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        return view;
    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private String makeDateString(int day, int month, int year) {

        return day + "/" + getMonthFormat(month) + "/" + year;
    }

    private String getMonthFormat(int month) {
        if (month == 1)
            return "01";
        if (month == 2)
            return "02";
        if (month == 3)
            return "03";
        if (month == 4)
            return "04";
        if (month == 5)
            return "05";
        if (month == 6)
            return "06";
        if (month == 7)
            return "07";
        if (month == 8)
            return "08";
        if (month == 9)
            return "09";
        if (month == 10)
            return "10";
        if (month == 11)
            return "11";
        if (month == 12)
            return "12";

        //default should never happen
        return "01";
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);

                switch (selectedView.getId()) {
                    case R.id.btn_start_datePickerButton:
                        btn_StartDatePickerButton.setText(date);
                        break;

                    case R.id.btn_due_datePickerButton:
                        btn_DueDatePickerButton.setText(date); // Replace btn_DueDatePickerButton with your actual button variable
                        break;
                }
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(getActivity(), style, dateSetListener, year, month, day);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_task_submit:

                sTaskName = etTaskName.getText().toString();
                sTaskDescription = etTaskDescription.getText().toString();
                sStartDate = btn_StartDatePickerButton.getText().toString();
                sDueDate = btn_DueDatePickerButton.getText().toString();

                if (TextUtils.isEmpty(sTaskName)) {
                    Toast.makeText(getActivity(), "Enter Task Name", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(sStartDate)) {
                    Toast.makeText(getActivity(), "Enter Start Date", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(sDueDate)) {
                    Toast.makeText(getActivity(), "Enter Due Date", Toast.LENGTH_SHORT).show();
                } else {

                    DoSubmit(sTaskName, sTaskDescription, sStartDate, sDueDate);
                    FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                    fragmentManager.popBackStack(); // Remove the current fragment from the back stack

                }
                break;
            case R.id.btn_task_cancel:
                clearFields();
                break;
            case R.id.btn_start_datePickerButton:
                selectedView = v;
                initDatePicker();
                datePickerDialog.show();
                break;
            case R.id.btn_due_datePickerButton:
                selectedView = v;
                initDatePicker();
                datePickerDialog.show();
                break;
        }
    }

    private void DoSubmit(String sTaskName, String sTaskDescription, String sStartDate, String sDueDate) {
        Log.v("sStartDate:::", sStartDate);
        Log.v("sDueDate:::", sDueDate);
        myDB = new DBHelperManager(getActivity());
        myDB.addTask(sTaskName, sTaskDescription, sStartDate, sDueDate);
    }

    private void clearFields() {
        etTaskName.setText("");
        etTaskDescription.setText("");
        btn_StartDatePickerButton.setText("");
        btn_DueDatePickerButton.setText("");
    }

    @Override
    public void onResume() {
        super.onResume();
        clearFields();
    }
}