package com.soul.soulhwapp.Model;

import android.util.Log;

public class LoginUsers {
    String userId,name,profile;


    public LoginUsers(String userId, String name, String profile) {
        this.userId = userId;
        this.name = name;
        this.profile = profile;
    }
    public LoginUsers(){

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
