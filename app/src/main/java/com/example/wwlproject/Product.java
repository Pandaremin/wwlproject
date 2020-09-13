package com.example.wwlproject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by haerul on 17/03/18.
 */

public class Product {

    @SerializedName("id") private int Id;
    @SerializedName("name") private String Name;
    @SerializedName("price") private String Price;
    @SerializedName("imageurl") private String Imageurl;

    @SerializedName("description") private String Description;
    public int getId() {
        return Id;
    }

    public String getImageurl() {
        return Imageurl;
    }

    public String getName() {
        return Name;
    }

    public String getPrice() {
        return Price;
    }
    public String getDescription() {
        return Description;
    }
//
//    public String getImage() {
//        return Image;
//    }

}
