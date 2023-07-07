package com.soul.soulhwapp.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.soul.soulhwapp.Model.TaskModel;
import com.soul.soulhwapp.R;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {
    private ArrayList<TaskModel> taskList;

    public TaskAdapter(ArrayList<TaskModel> taskList) {
        this.taskList = taskList;
    }


    @Override
    public TaskAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_items, parent, false);
        return new TaskAdapter.MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    @Override
    public void onBindViewHolder(TaskAdapter.MyViewHolder holder, int position) {

        TaskModel tm = taskList.get(position);
        holder.taskname.setText(tm.getTaskname());
        holder.taskDescription.setText(tm.getTaskDescription());
        holder.startDate.setText("Start Date: "+ tm.getsDate());
        holder.dueDate.setText("Due Date: "+tm.getdDate());
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView taskname,taskDescription,startDate,dueDate;



        public MyViewHolder(View itemView) {
            super(itemView);
            taskname = itemView.findViewById(R.id.tv_task_name);
            taskDescription = itemView.findViewById(R.id.tv_description);
            startDate = itemView.findViewById(R.id.tv_start_date);
            dueDate = itemView.findViewById(R.id.tv_due_date);
        }
    }
}