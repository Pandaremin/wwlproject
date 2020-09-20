package com.example.wwlproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signup extends AppCompatActivity {
    ApiInterface apiInterface;
    EditText editTextEmail,editTextPassword,editTextUsername,editTextPhone,editTextAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextPassword=findViewById(R.id.editTextPassword);
        editTextUsername=findViewById(R.id.editTextUsername);
        editTextPhone=findViewById(R.id.editTextPhone);
        editTextAddress=findViewById(R.id.editTextAddress);

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
    }
    public void registerUser(View v){
        Call<Usermodel> callRegister = apiInterface.registerUser(editTextEmail.getText().toString(),editTextPassword.getText().toString(),
                editTextUsername.getText().toString(), editTextPhone.getText().toString(), editTextAddress.getText().toString());
        callRegister.enqueue(new Callback<Usermodel>() {
            @Override
            public void onResponse(Call<Usermodel> call, Response<Usermodel> response) {
                if(response.body()!=null && response.isSuccessful())
                {
                    Usermodel usermodel = response.body();

                    if(usermodel.getSuccess())
                    {
                        Toast.makeText(Signup.this,"User registration successful!",Toast.LENGTH_SHORT).show();
                        Intent i1=new Intent(Signup.this,Login.class);
                        startActivity(i1);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(Signup.this,"User could not be registered",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Usermodel> call, Throwable t) {
                Toast.makeText(Signup.this,"Error occured"+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}