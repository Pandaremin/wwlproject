package com.example.wwlproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {

    private RecyclerView recyclerView;
//    private List<Product> products;
    private Adapter adapter;
    ProgressBar progressBar;
    TextView search,textView2;
    String[] item;
    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
searchView=findViewById(R.id.searchView2);
        progressBar = findViewById(R.id.progress);
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager  = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        textView2=findViewById(R.id.textView2);
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Product> call = apiInterface.getProduct();
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {

                progressBar.setVisibility(View.GONE);

                String first = "";
                first +=response.body().getProduct().get(0).getName() + "\n";
                first +=response.body().getProduct().get(0).getImage() + "\n";
                first +=response.body().getProduct().get(0).getPrice() + "\n";
                first +=response.body().getProduct().get(0).getDescription() + "\n";
                textView2.setText(first);

//                Product p=response.body();
//                List<ProductValue> product=p.getProduct();
//                for (int i = 0;i<product.size();i++){
//                    ProductValue image1= product.get(i);
//                    String a = image1.getName();
//                    String b = image1.getImage();
//                    String c = image1.getDescription();
//                    String d = image1.getPrice();
//
//                }


//                products= response.body();
//                adapter = new Adapter(products, Home.this);
//                recyclerView.setAdapter(adapter);
//                adapter.notifyDataSetChanged();
                Toast.makeText(Home.this, "Error !\n" +response.body().getProduct().get(1).getName(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(Home.this, "Error\n"+t.toString(), Toast.LENGTH_LONG).show();
            }
        });

//        CharSequence queryHint = searchView.getQueryHint();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                ArrayList<Product> itemstodisplay = new ArrayList<>();
//                for (int i = 0; i < products.size(); i++) {
//
//                    itemstodisplay.add(products.get(i));
//
//                }
//                ArrayList<Product> itemstoremove = new ArrayList<>();
//                for (int i = 0; i < products.size(); i++) {
//                    if (!products.get(i).getName().toLowerCase().contains(newText.toLowerCase())) {
//                        itemstoremove.add(products.get(i));
//                    }
//                }
//                for (Product myitem :
//                        itemstoremove) {
//                    itemstodisplay.remove(myitem);
//                }
//
//                adapter = new Adapter(itemstodisplay, Home.this);
//                recyclerView.setAdapter(adapter);
//                adapter.notifyDataSetChanged();
//                return false;
//            }
//        });
    }



}