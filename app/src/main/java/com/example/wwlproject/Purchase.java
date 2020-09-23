package com.example.wwlproject;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Purchase extends AppCompatActivity {
ApiInterface apiInterface;
TextView user_id,name,price,order_quantity,tax,delivery_fee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        user_id=findViewById(R.id.textViewid);
        name=findViewById(R.id.textViewname);
        price=findViewById(R.id.textViewprice);
        order_quantity=findViewById(R.id.textViewquantity);
        tax=findViewById(R.id.textViewtax);
        delivery_fee=findViewById(R.id.textViewdeliveryfee);





    }
    public void order(View v){

        Call<ProductValue> callPurchase = apiInterface.purchase(3,10,5000,50000,100,100,2);
        callPurchase.enqueue(new Callback<ProductValue>() {
            @Override
            public void onResponse(Call<ProductValue> call, Response<ProductValue> response) {
                if(response.body()!=null && response.isSuccessful())
                {
                    Toast.makeText(Purchase.this,"Successful!",Toast.LENGTH_SHORT).show();

                    ProductValue productValue = response.body();

                    if(productValue.isSuccess())
                    {
                        Toast.makeText(Purchase.this,"Successful!",Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Toast.makeText(Purchase.this,"Unsuccessful",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ProductValue> call, Throwable t) {
                Toast.makeText(Purchase.this,"Error occured",Toast.LENGTH_SHORT).show();
            }
        });
    }
}