package com.example.OMOA.Home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.OMOA.API.ApiClient;
import com.example.OMOA.API.ApiInterface;
import com.example.OMOA.LoginRegister.Login;
import com.example.wwlproject.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;
    ProgressBar progressBar;

    SearchView searchView;
    SharedPreferences sharedPreferences;
    private static final String SHARED_REF_KEY="mypref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        searchView=findViewById(R.id.searchView);
        progressBar = findViewById(R.id.progress);
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager  = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        sharedPreferences=getSharedPreferences(SHARED_REF_KEY,MODE_PRIVATE);


        Call<Product> call = apiInterface.getProduct();
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {

                progressBar.setVisibility(View.GONE);

                Product p=response.body();
                final List<ProductValue> products=p.getProduct();

                adapter = new Adapter(products, Home.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                CharSequence queryHint = searchView.getQueryHint();
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query)
                    {
                        List<ProductValue> itemstodisplay1 = new ArrayList<>();
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        List<ProductValue> itemstodisplay = new ArrayList<>();
                        for (int i = 0; i < products.size(); i++) {

                            itemstodisplay.add(products.get(i));

                        }
                        List<ProductValue> itemstoremove = new ArrayList<>();
                        for (int i = 0; i < products.size(); i++) {
                            if (!products.get(i).getName().toLowerCase().contains(newText.toLowerCase())) {
                                itemstoremove.add(products.get(i));
                            }
                        }
                        for (ProductValue myitem :
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

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(Home.this, "Error\n"+t.toString(), Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("Remember","false");
        editor.apply();
        Intent intent9=new Intent(Home.this, Login.class);
        startActivity(intent9);
        finish();
        return super.onOptionsItemSelected(item);
    }
}