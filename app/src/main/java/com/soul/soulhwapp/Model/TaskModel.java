package com.soul.soulhwapp.Model;

import java.io.Serializable;

public class TaskModel implements Serializable {
    String taskname;
    String taskDescription;
    String sDate;
    String dDate;

    public TaskModel(String taskname, String taskDescription, String sDate, String dDate) {
        this.taskname = taskname;
        this.taskDescription = taskDescription;
        this.sDate = sDate;
        this.dDate = dDate;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String getdDate() {
        return dDate;
    }

    public void setdDate(String dDate) {
        this.dDate = dDate;
    }






}