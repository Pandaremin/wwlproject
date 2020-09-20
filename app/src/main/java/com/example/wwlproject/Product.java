package com.example.wwlproject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by haerul on 17/03/18.
 */

public class Product {

    @SerializedName("id") private int id;
    @SerializedName("name") private String name;
    @SerializedName("price") private String price;
    @SerializedName("image_name") private String image_name;

    @SerializedName("description") private String description;
    public int getId() {
        return id;
    }

    public String getImage() {
        return image_name;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
//
//    public String getImage() {
//        return Image;
//    }

}
