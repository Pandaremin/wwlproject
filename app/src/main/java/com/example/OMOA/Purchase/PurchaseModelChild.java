package com.example.OMOA.Purchase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PurchaseModelChild {
    @Expose
    @SerializedName("product_id") private int product_id;
    @Expose
    @SerializedName("order_quantity") private String order_quantity;
    @Expose
    @SerializedName("price") private String price;
    @Expose
    @SerializedName("total_amount") private String total_amount;
    @Expose
    @SerializedName("delivery_fee") private String delivery_fee;
    @Expose
    @SerializedName("tax") private String tax;
    @Expose
    @SerializedName("user_email") private String user_email;
    @Expose
    @SerializedName("user_id") private int user_id;
    @Expose
    @SerializedName("name") private String name;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(String order_quantity) {
        this.order_quantity = order_quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
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

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
