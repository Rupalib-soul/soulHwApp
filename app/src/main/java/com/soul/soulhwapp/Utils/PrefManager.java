package com.soul.soulhwapp.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {

    private static final String PREF_NAME = "MyPreferences";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_LOGIN_TYPE = "login_type";
    private static final String KEY_REMEMBER = "remember_credentials";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static PrefManager prefManagerInstance;

    public PrefManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static PrefManager getInstance(Context context) {
        if (prefManagerInstance == null) {
            prefManagerInstance = new PrefManager(context.getApplicationContext());
        }
        return prefManagerInstance;
    }

    public void setUsername(String username) {
        editor.putString(KEY_USERNAME, username);
        editor.apply();
    }

    public String getUsername() {
        return sharedPreferences.getString(KEY_USERNAME, "");
    }

    public void setPassword(String password) {
        editor.putString(KEY_PASSWORD, password);
        editor.apply();
    }

    public String getPassword() {
        return sharedPreferences.getString(KEY_PASSWORD, "");
    }

    public void setLoginType(int loginType) {
        editor.putInt(KEY_LOGIN_TYPE, loginType);
        editor.apply();
    }

    public int getLoginType() {
        return sharedPreferences.getInt(KEY_LOGIN_TYPE, 0);
    }

    public void setRememberCredentials(boolean remember) {
        editor.putBoolean(KEY_REMEMBER, remember);
        editor.apply();
    }

    public boolean getRememberCredentials() {
        return sharedPreferences.getBoolean(KEY_REMEMBER, false);
    }

    public void clearPreferences() {
        editor.clear();
        editor.apply();
    }

    public boolean isUserLoggedOut() {
        boolean isUsernameEmpty = sharedPreferences.getString(KEY_USERNAME, "").isEmpty();
        boolean isPasswordEmpty = sharedPreferences.getString(KEY_PASSWORD, "").isEmpty();
        return isUsernameEmpty || isPasswordEmpty;
    }
}
