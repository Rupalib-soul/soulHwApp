//package com.soul.soulhwapp.DataBase;
//
//import android.content.Context;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
//
//public class DBConnector {
//
//    private static SQLiteDatabase db = null;
//
//    /**
//     * Opens the Database
//     *
//     * @return SQLiteDatabase Object
//     * @throws SQLException
//     */
//    public static SQLiteDatabase openDB(Context context) throws SQLException {
//
//        db = DBHelperManager.retrieveDBInstance(context);
//
//        /*
//         Delete Cascade function work only Foreign Keys are set ON.
//         Foreign key relation is used for case master and response
//          */
//        db.execSQL("PRAGMA foreign_keys = ON");
//
//        return db;
//    }
//
//    /**
//     * Closes the Database
//     *
//     * @return boolean - true if successfully closed, false otherwise
//     * @throws SQLException
//     */
//
//    public static boolean closeDB() {
//        boolean flag = false;
//        try {
//            db.close();
//            //dbHelper.close();
//            flag = true;
//        } catch (Exception e) {
//            // TODO: handle exception
//            flag = false;
//            e.printStackTrace();
//        }
//        return flag;
//    }
//
//    /**
//     * If static variable is released in time, it recreates object else reuses already created object
//     * @return new singleton SQLiteDatabase object else already created singleton SQLiteDatabase object
//     *//*
//    public static SQLiteDatabase checkAndRegainSQLiteDatabaseStatus(){
//		if(db == null)
//			return db =
//			return 	db = DBHelperM.getDBInstance(contexts);
//
//		return db;
//	}
//	  */
//}
