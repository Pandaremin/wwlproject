package com.example.OMOA.LoginRegister;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usermodel {
    @Expose
    @SerializedName("email")
    private String email ;

    @Expose
    @SerializedName("name")
    private String name ;

    @Expose
    @SerializedName("phone_number")
    private String phone_number;

    @Expose
    @SerializedName("password")
    private String password;

    @Expose
    @SerializedName("success")
    private boolean success;

    @Expose
    @SerializedName("message")
    private String message;


    @Expose
    @SerializedName("address")
    private String address;

    @Expose
    @SerializedName("token")
    private String token;
    @Expose
    @SerializedName("id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone_number;
    }

    public void setPhone(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getSuccess(){
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
