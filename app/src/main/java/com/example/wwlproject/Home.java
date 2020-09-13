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
    private List<Product> products;
    private Adapter adapter;
    ProgressBar progressBar;
    TextView search;
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
        fetchContact("users", "");
        CharSequence queryHint = searchView.getQueryHint();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Product> itemstodisplay = new ArrayList<>();
                for (int i = 0; i < products.size(); i++) {

                    itemstodisplay.add(products.get(i));

                }
                ArrayList<Product> itemstoremove = new ArrayList<>();
                for (int i = 0; i < products.size(); i++) {
                    if (!products.get(i).getName().toLowerCase().contains(newText.toLowerCase())) {
                        itemstoremove.add(products.get(i));
                    }
                }
                for (Product myitem :
                        itemstoremove) {
                    itemstodisplay.remove(myitem);
                }

                adapter = new Adapter(itemstodisplay, Home.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    public void fetchContact(String type, String key){

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Product>> call = apiInterface.getContact(type, key);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                progressBar.setVisibility(View.GONE);
                products = response.body();
                adapter = new Adapter(products, Home.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(Home.this, "Error\n"+t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }



}