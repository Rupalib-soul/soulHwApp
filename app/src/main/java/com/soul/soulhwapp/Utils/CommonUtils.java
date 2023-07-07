package com.soul.soulhwapp.Utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class CommonUtils {
    static CommonUtils utils;

    private CommonUtils() {
    }

    public static CommonUtils getInstance() {
        if (utils == null) {
            return utils = new CommonUtils();

        }

        return utils;
    }


    /**
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        boolean isConnected = false;
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            @SuppressLint("MissingPermission") NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        if (!isConnected) {
//                            Log.v("info", "Now you are connected to Internet!");
                            isConnected = true;
                            return isConnected;
                        }
                    }
                }
            }
        }
//        Log.v("info", "You are not connected to Internet!");
        return false;
    }

    public static void Show_Dialog(String message, Activity act) {

        AlertDialog.Builder builder = new AlertDialog.Builder(act);
        builder.setCancelable(true);
        builder.setTitle(message);
        builder.setInverseBackgroundForced(true);

        builder.setNeutralButton("Ok",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();

                    }
                });

        AlertDialog alert = builder.create();
        alert.show();

//        android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(act, R.style.AppCompatAlertDialogStyle);
//        alertDialogBuilder.setTitle("Aurora Alert \n");
//        alertDialogBuilder
//                .setTitle(message)
//                .setCancelable(false)
//
//                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                });
//
//        // create alert dialog
//        android.support.v7.app.AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();
    }

}
