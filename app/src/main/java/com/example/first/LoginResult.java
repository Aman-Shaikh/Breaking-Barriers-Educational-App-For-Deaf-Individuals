package com.example.first;

import com.google.gson.annotations.SerializedName;

public class LoginResult {

    @SerializedName("UserName")//to tell android that json object that is coming will have key as Name and store it in name variable
    private String name;
    @SerializedName("Email")//to tell android that json object that is coming will have key as Email
    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}