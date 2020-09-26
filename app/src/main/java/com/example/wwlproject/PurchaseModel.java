package com.example.wwlproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PurchaseModel {

    @Expose
    @SerializedName("success") private boolean success;
    @Expose
    @SerializedName("message") private String message;
    @Expose
    @SerializedName("orderitems") private PurchaseModelChild orderitems;

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

    public PurchaseModelChild getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(PurchaseModelChild orderitems) {
        this.orderitems = orderitems;
    }
}
