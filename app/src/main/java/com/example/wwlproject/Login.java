package com.example.wwlproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Login extends AppCompatActivity {
    ApiInterface apiInterface;
EditText etUser,etPass;
SharedPreferences sharedPreferences;
private static final String SHARED_REF_KEY="mypref";
    private static final String KEY_TOKEN="Token";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
sharedPreferences=getSharedPreferences(SHARED_REF_KEY,MODE_PRIVATE);
    }

    public void loginUser(View v){
        String mEmail = etUser.getText().toString().trim();
        String mPassword = etPass.getText().toString().trim();
        if (TextUtils.isEmpty(mEmail)){
            etUser.setError("Required Field..");
            return;
        }
        if (TextUtils.isEmpty(mPassword)) {
            etPass.setError("Required Field..");
            return;
        }
        Call<Usermodel> studentModelCall = apiInterface.loginUser(etUser.getText().toString(), etPass.getText().toString());
        studentModelCall.enqueue(new Callback<Usermodel>() {
            @Override
            public void onResponse(Call<Usermodel> call, Response<Usermodel> response) {
                if(response.body()!=null)
                {
                    Usermodel usermodel = response.body();



                    if(usermodel.getSuccess())
                    {
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString(KEY_TOKEN,usermodel.getToken());
                        editor.apply();
                        Intent intent1=new Intent(Login.this,Purchase.class);
                        startActivity(intent1);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(Login.this,"User not found",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Usermodel> call, Throwable t) {
                Toast.makeText(Login.this,"Error occured",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void text_click(View v){
        Intent intent=new Intent(Login.this,Signup.class);
        startActivity(intent);
    }
}