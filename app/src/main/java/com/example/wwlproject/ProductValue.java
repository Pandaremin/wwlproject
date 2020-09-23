package com.example.wwlproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class ProductValue {

    @Expose
    @SerializedName("success") private boolean success;
    @Expose
    @SerializedName("id") private int id;
    @Expose
    @SerializedName("name") private String name;
    @Expose
    @SerializedName("price") private String price;
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
    @SerializedName("delivery_fee") private String delivery_fee;
    @Expose
    @SerializedName("tax") private String tax;
    @Expose
    @SerializedName("total_amount") private String total_amount;

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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

    public String getDelivery_fee() {
        return delivery_fee;
    }

    public void setDelivery_fee(String delivery_fee) {
        this.delivery_fee = delivery_fee;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
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
