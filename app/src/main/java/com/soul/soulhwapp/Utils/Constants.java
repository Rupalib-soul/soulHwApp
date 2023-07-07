package com.soul.soulhwapp.Utils;

import com.soul.soulhwapp.Model.TaskModel;

import java.util.ArrayList;

public class Constants {
    public static ArrayList<TaskModel> getEmployeeData()
    {
        // create an ArrayList of type Employee class
        ArrayList<TaskModel> employeeList
                = new ArrayList<TaskModel>();
        TaskModel emp1 = new TaskModel("Visited Test Block",
                "Block-A","12-01-2019","12-01-2019");
        employeeList.add(emp1);
        TaskModel emp2
                = new TaskModel("Visited Test Block",
                "Block-A","12-01-2019","12-01-2019");
        employeeList.add(emp2);
        TaskModel emp3 = new TaskModel("Visited Test Block",
                "Block-A","12-01-2019","12-01-2019");
        employeeList.add(emp3);
        TaskModel emp4 = new TaskModel("Visited Test Block",
                "Block-A","12-01-2019","12-01-2019");
        employeeList.add(emp4);
        TaskModel emp5 = new TaskModel("Visited Test Block",
                "Block-A","12-01-2019","12-01-2019");
        employeeList.add(emp5);
        TaskModel emp6 = new TaskModel("Visited Test Block",
                "Block-A","12-01-2019","12-01-2019");
        employeeList.add(emp6);
        TaskModel emp7 = new TaskModel("Visited Test Block",
                "Block-A","12-01-2019","12-01-2019");
        employeeList.add(emp7);
        TaskModel emp8 = new TaskModel("Visited Test Block",
                "Block-A","12-01-2019","12-01-2019");
        employeeList.add(emp8);
        TaskModel emp9 = new TaskModel("Visited Test Block",
                "Block-A","12-01-2019","12-01-2019");
        employeeList.add(emp9);
        TaskModel emp10 = new TaskModel("Visited Test Block",
                "Block-A","12-01-2019","12-01-2019");
        employeeList.add(emp10);

        return employeeList;
    }
}
