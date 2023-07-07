//package com.soul.soulhwapp.DataBase;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.os.Environment;
//
//import com.soul.soulhwapp.R;
//
//import java.io.File;
////import com.inube.hitpa.application.Hitpa;
//
///**
// * DbBackUp class takes back up of application database
// */
//@SuppressLint("NewApi")
//public class DbBackUp {
//
//    private static final String TAG = "DbBackUp";
//    Context context;
//    private String errorMessage = "";
//
//
//    /**
//     * {@link java.lang.reflect.Constructor}
//     *
//     * @param context {@link Context}
//     */
//    public DbBackUp(Context context) {
//        this.context = context;
//    }
//
//    /**
//     * Method to take back up of databases
//     */
//    public void backDataBaseFile() {
//
//        try {
//
//            /**
//             * Backup for main database
//             */
//            File externalFilePath = Environment.getDataDirectory();
//
//            String actualDBPath = context.getString(R.string.dbpath)
//                    + context.getString(R.string.dbname);
//
//            File copyDBPath = new File(externalFilePath.toString()
//                    + actualDBPath);
//
//            if (copyDBPath.exists())
//            {
//
//                File file = Hitpa.mFileOperations.createFolder(
//                        context.getString(R.string.dbbackuppath), "");
//
//                File f = null;
//                f = Hitpa.mFileOperations.createFile(
//                        context.getString(R.string.dbname), file.toString() + File.separator);
//
//                try {
//
//                    Hitpa.mFileOperations.copyFile(copyDBPath, f);
//                    if (!f.exists()) {
//                        Hitpa.mFileOperations.TakeDbBackUp(
//                                copyDBPath, f);
//                    }
//
//                } catch (Exception e) {
//                    /*errorMessage = ExceptionStackTrace
//                            .printStackTraceException(e);
//                    Hitpa.mErrorLogger.writeLog(errorMessage, TAG
//                            + " : backDataBaseFile", null, "Error");*/
//                    Hitpa.mFileOperations
//                            .TakeDbBackUp(copyDBPath, f);
//                }
//            }
//
//            /**
//             * End of actual database backup
//             */
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void backMarkerDataBaseFile() {
//
//        try {
//
//            File externalFilePath = Environment.getDataDirectory();
//
//            String actualDBPath = context.getString(R.string.dbpath)
//                    + "markinfo.db";
//
//            File copyDBPath = new File(externalFilePath.toString() + actualDBPath);
//
//
//            if (copyDBPath.exists()) {
//
//                File file = Hitpa.mFileOperations.createFolder(
//                        context.getString(R.string.dbbackuppath), "");
//
//                File f = null;
//                f = Hitpa.mFileOperations.createFile(
//                        "markinfo.db",
//                        file.toString());
//
//                try {
//                    Hitpa.mFileOperations.copyFile(copyDBPath, f);
////					copyFile(copyDBPath, f);
//                    if (!f.exists()) {
//                        Hitpa.mFileOperations.TakeDbBackUp(
//                                copyDBPath, f);
//                    }
//
//                } catch (Exception e) {
//
//                }
//            }
//        } catch (Exception e) {
//
//        }
//    }
//}
