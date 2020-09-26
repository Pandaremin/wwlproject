package com.example.wwlproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {
    @SerializedName("success") private boolean success;
    @SerializedName("message") private String message;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    @SerializedName("product")
    private List<ProductValue> product;

    public List<ProductValue> getProduct() {
        return product;

    }
}
