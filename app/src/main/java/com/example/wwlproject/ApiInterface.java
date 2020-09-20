package com.example.wwlproject;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiInterface {

    @POST("product")
    Call<List<Product>> getContact(
            @Query("item_type") String item_type,
            @Query("key") String keyword
    );
    @FormUrlEncoded
    @POST("login")
    Call<Usermodel> loginUser(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<Usermodel> registerUser(@Field("name") String name,@Field("email") String email, @Field("phone_number") String phone_number, @Field("password") String password,  @Field("address") String address);
}
