package com.example.OMOA.LoginRegister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.OMOA.API.ApiClient;
import com.example.OMOA.API.ApiInterface;
import com.example.OMOA.Home.Home;
import com.example.wwlproject.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signup extends AppCompatActivity {
    ApiInterface apiInterface;
    EditText editTextEmail,editTextPassword,editTextUsername,editTextPhone,editTextAddress;
    SharedPreferences sharedPreferences;
    private static final String SHARED_REF_KEY="mypref";
    TextView message;
//    private static final String KEY_TOKEN="Token";
private static final String EMAIL="EMAIL";
    private static final String USER_ID="USER_ID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editTextEmail=findViewById(R.id.etEmail);
        editTextPassword=findViewById(R.id.etPassword);
        editTextUsername=findViewById(R.id.etUsername);
        editTextPhone=findViewById(R.id.etPhone);
        editTextAddress=findViewById(R.id.etAddress);
        sharedPreferences=getSharedPreferences(SHARED_REF_KEY,MODE_PRIVATE);
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        String remember =sharedPreferences.getString("Remember","");
        message=findViewById(R.id.message);
    }
    public void registerUser(View v){
        String email = editTextEmail.getText().toString();
        String pass = editTextPassword.getText().toString();
        String name = editTextUsername.getText().toString();
        String phone = editTextPhone.getText().toString();
        String address = editTextAddress.getText().toString();


        if(TextUtils.isEmpty(name)){
           message.setText("Name must not empty!");
            message.setVisibility(View.VISIBLE);
        }else if(TextUtils.isEmpty(email)) {
            message.setText("Email must not empty!");
            message.setVisibility(View.VISIBLE);
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            message.setText("Invalid Email address!");
            message.setVisibility(View.VISIBLE);
        }else if(TextUtils.isEmpty(pass)) {
            message.setText("Password must be at least 8 number!");
            message.setVisibility(View.VISIBLE);
        }
        else if(TextUtils.isEmpty(phone)) {
            message.setText("Phone must not empty!");
            message.setVisibility(View.VISIBLE);
        }else if(TextUtils.isEmpty(address)) {
            message.setText("Address must not empty!");
            message.setVisibility(View.VISIBLE);
        }else {
            Call<User> callRegister = apiInterface.registerUser(editTextUsername.getText().toString(), editTextEmail.getText().toString(), editTextPassword.getText().toString(), editTextPhone.getText().toString(), editTextAddress.getText().toString());
            callRegister.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.body() != null && response.isSuccessful()) {
                        User user = response.body();

                        if (user.isSuccess()) {
                            message.setVisibility(View.INVISIBLE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString(EMAIL, user.getUser().getEmail());
                            editor.putString("Remember", "true");
                            editor.apply();
                            Intent intent1 = new Intent(Signup.this, Home.class);
                            startActivity(intent1);
                            finish();


                        } else {
                            message.setText("User registration failed!");
                            message.setVisibility(View.VISIBLE);
                        }
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    message.setText("Error occured");
                    message.setVisibility(View.VISIBLE);
                }
            });
        }
    }

    public void Login(View v){
        Intent intent=new Intent(Signup.this, Login.class);
        startActivity(intent);
    }
}