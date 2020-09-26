package com.example.wwlproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Purchase extends AppCompatActivity {
ApiInterface apiInterface;
TextView user_id,name,price,order_quantity,tax,delivery_fee,total;
    int id1,order_quantity1,price1,mprice,d,mtax,mtotal;
    int deli=1000;
    SharedPreferences sharedPreferences;
    private static final String SHARED_REF_KEY="mypref";
    private static final String KEY_TOKEN="Token";
    private static final String EMAIL="EMAIL";
    String memail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        price=findViewById(R.id.prcm);
        delivery_fee=findViewById(R.id.delim);
        tax=findViewById(R.id.taxm);
        total=findViewById(R.id.totm);
        id1 = getIntent().getIntExtra("id",0);
        order_quantity1 = getIntent().getIntExtra("order_quantity",0);
        price1 = getIntent().getIntExtra("price",0);
        mprice=price1*order_quantity1;
        d=mprice*5;
        mtax=d/100;
        mtotal=mprice+mtax+deli;
        price.setText(String.valueOf(mprice));
        tax.setText(String.valueOf(mtax));
        total.setText(String.valueOf(mtotal));
        sharedPreferences=getSharedPreferences(SHARED_REF_KEY,MODE_PRIVATE);
        memail =sharedPreferences.getString(EMAIL,"");

    }





    public void order(View v){

        Call<PurchaseModel> callOrder=apiInterface.purchase(id1,String.valueOf(order_quantity1),
                String.valueOf(mprice),String.valueOf(mtotal),String.valueOf(deli),String.valueOf(mtax),memail);
        callOrder.enqueue(new Callback<PurchaseModel>() {
            @Override
            public void onResponse(Call<PurchaseModel> call, Response<PurchaseModel> response) {

                if(response.body()!=null)
                {
                    PurchaseModel purchaseModel = response.body();


                    if(purchaseModel.isSuccess())
                    {
                        Intent intent8=new Intent(Purchase.this,Successful.class);
                        startActivity(intent8);

                    }
                    else
                    {
                        Toast.makeText(Purchase.this,"Order failed",Toast.LENGTH_SHORT).show();
                        Intent intent9=new Intent(Purchase.this,Home.class);
                        startActivity(intent9);
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<PurchaseModel> call, Throwable t) {
                Toast.makeText(Purchase.this,"Error",Toast.LENGTH_SHORT).show();
            }
        });




    }
}