package com.example.OMOA.Purchase;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.OMOA.API.ApiClient;
import com.example.OMOA.API.ApiInterface;
import com.example.OMOA.Home.Home;
import com.example.wwlproject.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Purchase extends AppCompatActivity {
ApiInterface apiInterface;
TextView prcm, taxm,delivery_fee, totalm;
    int product_id, order_quantity,price1,mprice,d,mtax,mtotal;
    int deli=1000;
    SharedPreferences sharedPreferences;
    private static final String SHARED_REF_KEY="mypref";
    private static final String EMAIL="EMAIL";
    String memail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        prcm =findViewById(R.id.prcm);
        delivery_fee=findViewById(R.id.delim);
        taxm =findViewById(R.id.taxm);
        totalm =findViewById(R.id.totm);
        product_id = getIntent().getIntExtra("id",0);
        order_quantity = getIntent().getIntExtra("order_quantity",0);
        price1 = getIntent().getIntExtra("price",0);
        mprice=price1* order_quantity;
        d=mprice*5;
        mtax=d/100;
        mtotal=mprice+mtax+deli;
        prcm.setText(String.valueOf(mprice));
        taxm.setText(String.valueOf(mtax));
        totalm.setText(String.valueOf(mtotal));
        sharedPreferences=getSharedPreferences(SHARED_REF_KEY,MODE_PRIVATE);
        memail =sharedPreferences.getString(EMAIL,"");

    }





    public void order(View v){

        Call<PurchaseModel> callOrder=apiInterface.purchase(product_id,String.valueOf(order_quantity),
                String.valueOf(mprice),String.valueOf(mtotal),String.valueOf(deli),String.valueOf(mtax),memail);
        callOrder.enqueue(new Callback<PurchaseModel>() {
            @Override
            public void onResponse(Call<PurchaseModel> call, Response<PurchaseModel> response) {

                if(response.body()!=null)
                {
                    PurchaseModel purchaseModel = response.body();


                    if(purchaseModel.isSuccess())
                    {
                        Intent intent8=new Intent(Purchase.this, Successful.class);
                        startActivity(intent8);

                    }
                    else
                    {

                        AlertDialog.Builder builder = new AlertDialog.Builder(Purchase.this);
                        builder.setTitle("Order Fail");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent9=new Intent(Purchase.this, Home.class);
                                startActivity(intent9);
                                finish();
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                           @Override
                            public void onClick(DialogInterface dialogInterface, int id) {
                                finish();
                            }
                        });

                        AlertDialog dialog=builder.create();
                        dialog.setMessage("Back to order");
                        dialog.show();

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