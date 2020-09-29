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


public class Login extends AppCompatActivity {
    ApiInterface apiInterface;
EditText etUser,etPass;
SharedPreferences sharedPreferences;
private static final String SHARED_REF_KEY="mypref";
    private static final String EMAIL="EMAIL";
    TextView tvErrorMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        tvErrorMessage=findViewById(R.id.tvErrorMessage);

        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        sharedPreferences=getSharedPreferences(SHARED_REF_KEY,MODE_PRIVATE);
        String remember =sharedPreferences.getString("Remember","");
        if(remember.equals("true")){
            Intent intentLogin=new Intent(Login.this, Home.class);
            startActivity(intentLogin);
            finish();
        }
    }

    public void loginUser(View v){
        String email = etUser.getText().toString();
        String pass = etPass.getText().toString();

        if(TextUtils.isEmpty(email)){
            tvErrorMessage.setText("Email must not empty!");
            tvErrorMessage.setVisibility(View.VISIBLE);
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            tvErrorMessage.setText("Invalid Email address!");
            tvErrorMessage.setVisibility(View.VISIBLE);
        }else if(TextUtils.isEmpty(pass)) {
            tvErrorMessage.setText("Password must not empty!");
            tvErrorMessage.setVisibility(View.VISIBLE);
        }else{
            Call<User> loginCall = apiInterface.loginUser(etUser.getText().toString(), etPass.getText().toString());
            loginCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if(response.body()!=null)
                    {
                        User user = response.body();
                        if(user.isSuccess())
                        {
                            tvErrorMessage.setVisibility(View.INVISIBLE);
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString(EMAIL,user.getData().getEmail());
                            editor.putString("Remember","true");
                            editor.apply();
                            Intent intent1=new Intent(Login.this,Home.class);
                            startActivity(intent1);
                            finish();

                        }
                        else
                        {
                            tvErrorMessage.setText("User not found!");
                            tvErrorMessage.setVisibility(View.VISIBLE);
                        }
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    tvErrorMessage.setText("Error occured");
                    tvErrorMessage.setVisibility(View.VISIBLE);
                }
            });
        }


    }
    public void SignUP(View v){

        Intent intentSignUp=new Intent(Login.this, Signup.class);
        startActivity(intentSignUp);
    }
}