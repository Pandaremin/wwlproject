package com.example.OMOA.API;


import com.example.OMOA.Purchase.PurchaseModel;
import com.example.OMOA.LoginRegister.User;
import com.example.OMOA.Home.Product;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface ApiInterface {

    @POST("product")
    Call<Product> getProduct(

    );
    @FormUrlEncoded
    @POST("login")
    Call<User> loginUser(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<User> registerUser(@Field("name") String name,@Field("email") String email, @Field("phone_number") String phone_number, @Field("password") String password,  @Field("address") String address);

    @FormUrlEncoded
    @POST("orderitems")
    Call<PurchaseModel> purchase(@Field("product_id") int product_id,
                                 @Field("order_quantity") String order_quantity,
                                 @Field("price") String price,
                                 @Field("total_amount") String total_amount,
                                 @Field("delivery_fee") String delivery_fee,
                                 @Field("tax") String tax,
                                 @Field("user_email") String user_email);
}
