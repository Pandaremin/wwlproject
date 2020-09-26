package com.example.wwlproject;

import android.content.Intent;
import android.content.SharedPreferences;
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
    SharedPreferences sharedPreferences;
    private static final String SHARED_REF_KEY="mypref";
//    private static final String KEY_TOKEN="Token";
private static final String EMAIL="EMAIL";
    private static final String USER_ID="USER_ID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextPassword=findViewById(R.id.editTextPassword);
        editTextUsername=findViewById(R.id.editTextUsername);
        editTextPhone=findViewById(R.id.editTextPhone);
        editTextAddress=findViewById(R.id.editTextAddress);
        sharedPreferences=getSharedPreferences(SHARED_REF_KEY,MODE_PRIVATE);
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        String remember =sharedPreferences.getString("Remember","");

    }
    public void registerUser(View v){
        Call<User> callRegister = apiInterface.registerUser( editTextUsername.getText().toString(),editTextEmail.getText().toString(),editTextPassword.getText().toString(), editTextPhone.getText().toString(), editTextAddress.getText().toString());
        callRegister.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.body()!=null && response.isSuccessful())
                {
                    User user = response.body();

                    if(user.isSuccess())
                    {
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString(EMAIL,user.getUser().getEmail());
                        editor.putString("Remember","true");
                        editor.apply();
                        Intent intent1=new Intent(Signup.this,Home.class);
                        startActivity(intent1);
                        finish();


                    }
                    else
                    {

                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
    public void loginpage(View v){
        Intent intent=new Intent(Signup.this,Login.class);
        startActivity(intent);
    }
}