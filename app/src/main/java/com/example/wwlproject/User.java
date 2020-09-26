package com.example.wwlproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {
    @Expose
    @SerializedName("success")
    private boolean success;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("token")
    private String token;

    @Expose
    @SerializedName("user")
    private Usermodel user;

    @Expose
    @SerializedName("data")
    private Usermodel data;

    public Usermodel getData() {
        return data;
    }

    public void setData(Usermodel data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Usermodel getUser() {
        return user;
    }

    public void setUser(Usermodel user) {
        this.user = user;
    }
}
