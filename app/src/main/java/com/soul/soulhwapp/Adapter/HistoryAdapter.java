package com.soul.soulhwapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.soul.soulhwapp.Model.TaskModel;
import com.soul.soulhwapp.R;

import java.util.ArrayList;

public class HistoryAdapter  extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
    private ArrayList<TaskModel> emplist;

    public HistoryAdapter(ArrayList<TaskModel> emplist) {
        this.emplist = emplist;
    }

    // This method creates a new ViewHolder object for each item in the RecyclerView
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item and return a new ViewHolder object
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    // This method returns the total
    // number of items in the data set
    @Override
    public int getItemCount() {
        return emplist.size();
    }

    // This method binds the data to the ViewHolder object
    // for each item in the RecyclerView
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TaskModel currentEmp = emplist.get(position);
        holder.taskname.setText(currentEmp.getTaskname());
        holder.date.setText(currentEmp.getsDate());
        holder.location.setText(currentEmp.getTaskDescription());
    }

    // This class defines the ViewHolder object for each item in the RecyclerView
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView taskname;
        private TextView date;
        private TextView location;

        public MyViewHolder(View itemView) {
            super(itemView);
            taskname = itemView.findViewById(R.id.tvTaskName);
            date = itemView.findViewById(R.id.tvDate);
            location = itemView.findViewById(R.id.tvLocation);
        }
    }
}
