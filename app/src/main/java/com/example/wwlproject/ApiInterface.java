package com.example.wwlproject;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("getcontacts.php")
    Call<List<Product>> getContact(
            @Query("item_type") String item_type,
            @Query("key") String keyword
    );
    @FormUrlEncoded
    @POST("loginuser.php")
    Call<Usermodel> loginUser(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("registeruser.php")
    Call<Usermodel> registerUser(@Field("email") String email, @Field("password") String password, @Field("username") String username, @Field("phone") String phone);
}
