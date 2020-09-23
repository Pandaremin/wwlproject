package com.example.wwlproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by haerul on 17/03/18.
 */

public class ProductValue {

    @Expose
    @SerializedName("success") private boolean success;
    @Expose
    @SerializedName("id") private int id;
    @Expose
    @SerializedName("name") private String name;
    @Expose
    @SerializedName("price") private int price;
    @Expose
    @SerializedName("image_name") private String image_name;
    @Expose
    @SerializedName("message") private String message;
    @Expose
    @SerializedName("description") private String description;
    @SerializedName("user_id") private int user_id;
    @Expose
    @SerializedName("quantity") private int quantity;
    @Expose
    @SerializedName("delivery_fee") private int delivery_fee;
    @Expose
    @SerializedName("tax") private int tax;
    @Expose
    @SerializedName("total_amount") private int total_amount;

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Expose
    @SerializedName("product_id") private int product_id;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDelivery_fee() {
        return delivery_fee;
    }

    public void setDelivery_fee(int delivery_fee) {
        this.delivery_fee = delivery_fee;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }




















    //
//    public String getImage() {
//        return Image;
//    }
    //    public void setImage_name(String image_name) {
//        this.image_name = image_name;
//    }

}
