package com.soul.soulhwapp.DataBase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.soul.soulhwapp.Model.TaskModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by rupali on 04/07/2023.
 */
public class DBHelperManager extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "soul.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_task";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TASK_NAME = "task_name";
    private static final String COLUMN_TASK_DESCRIPTION = "task_description";
    private static final String COLUMN_START_DATE = "task_start_date";
    private static final String COLUMN_DUE_DATE = "task_due_date";

    public DBHelperManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TASK_NAME + " TEXT, " +
                COLUMN_TASK_DESCRIPTION + " TEXT, " +
                COLUMN_START_DATE + " TEXT, " +
                COLUMN_DUE_DATE + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addTask(String name, String description, String startDate, String dueDate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TASK_NAME, name);
        cv.put(COLUMN_TASK_DESCRIPTION, description);
        cv.put(COLUMN_START_DATE, startDate);
        cv.put(COLUMN_DUE_DATE, dueDate);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public ArrayList<TaskModel> taskModelArrayList() {
        ArrayList<TaskModel> taskModelList = null;
        String sql = "select * from " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        taskModelList = new ArrayList<>();
        try {
            cursor = db.rawQuery(sql, null);
            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") int taskId = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                    @SuppressLint("Range") String taskName = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_NAME));
                    @SuppressLint("Range") String taskDescription = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_DESCRIPTION));
                    @SuppressLint("Range") String startDate = cursor.getString(cursor.getColumnIndex(COLUMN_START_DATE));
                    @SuppressLint("Range") String dueDate = cursor.getString(cursor.getColumnIndex(COLUMN_DUE_DATE));

                    TaskModel taskModel = new TaskModel(taskName, taskDescription, startDate, dueDate);
                    taskModelList.add(taskModel);
                }
                while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
        return taskModelList;
    }

    public ArrayList<TaskModel> pendingTaskModelArrayList() {
        ArrayList<TaskModel> pendingTaskModelList = null;
        String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_DUE_DATE + " > '" + currentDate + "'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        pendingTaskModelList = new ArrayList<>();
        try {
            cursor = db.rawQuery(sql, null);
            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") int taskId = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                    @SuppressLint("Range") String taskName = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_NAME));
                    @SuppressLint("Range") String taskDescription = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_DESCRIPTION));
                    @SuppressLint("Range") String startDate = cursor.getString(cursor.getColumnIndex(COLUMN_START_DATE));
                    @SuppressLint("Range") String dueDate = cursor.getString(cursor.getColumnIndex(COLUMN_DUE_DATE));

                    TaskModel taskModel = new TaskModel(taskName, taskDescription, startDate, dueDate);
                    pendingTaskModelList.add(taskModel);
                }
                while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
        return pendingTaskModelList;
    }

    void updateData(String row_id, String title, String author, String pages) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TASK_NAME, title);
        cv.put(COLUMN_TASK_DESCRIPTION, author);
        cv.put(COLUMN_START_DATE, pages);
        cv.put(COLUMN_DUE_DATE, pages);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRow(String row_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

}


