package com.example.OMOA;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.OMOA.Purchase.Purchase;
import com.example.wwlproject.R;
import com.master.glideimageview.GlideImageView;

public class Order extends AppCompatActivity implements View.OnClickListener {
Button btnMinus,btnPlus,btnCheckOut;
TextView tvCount;
GlideImageView glideImageView;
    private static final String SHARED_REF_KEY="mypref";
    int count=1;
    int ProductID;
    String ProductPrice;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        btnMinus=findViewById(R.id.btnMinus);
        btnPlus=findViewById(R.id.btnPlus);
        tvCount=findViewById(R.id.tvCount);
        btnCheckOut=findViewById(R.id.btnCheckOut);
        glideImageView=findViewById(R.id.glideImageView);
        sharedPreferences = getSharedPreferences(SHARED_REF_KEY, MODE_PRIVATE);
        btnMinus.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnCheckOut.setOnClickListener(this);
        if(getIntent().hasExtra("name") && getIntent().hasExtra("description")&& getIntent().hasExtra("price")&& getIntent().hasExtra("imageurl") ){
            String description2 = getIntent().getStringExtra("description");
            TextView description= findViewById(R.id.tvDescription2);
            description.setText(description2);

            String name2 = getIntent().getStringExtra("name");
            TextView name= findViewById(R.id.tvName);
            name.setText(name2);

            ProductPrice = getIntent().getStringExtra("price");
            TextView price= findViewById(R.id.tvPriceInt);
            price.setText(ProductPrice);

            ProductID = getIntent().getIntExtra("id",0);

            String imageUrl = getIntent().getStringExtra("imageurl");
            Glide.with(Order.this).load(imageUrl).into(glideImageView);

        }
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlus:
                count+=1;
                tvCount.setText(String.valueOf(count));
                break;
            case R.id.btnMinus:
                if (count!=1){  count-=1;
                    tvCount.setText(String.valueOf(count));
                }
                else {
                    count=1;
                    tvCount.setText(String.valueOf(count));
                }
                break;
            case R.id.btnCheckOut: {
                Intent intentCheck = new Intent(Order.this, Purchase.class);
                intentCheck.putExtra("order_quantity",count);
                intentCheck.putExtra("price", Integer.valueOf(ProductPrice));
                intentCheck.putExtra("id", ProductID);
                startActivity(intentCheck);
                
            }
                break;



        }
    }
}
