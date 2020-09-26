package com.example.wwlproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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
    private static final String EMAIL="EMAIL";
    TextView unf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        unf=findViewById(R.id.unf);

        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
sharedPreferences=getSharedPreferences(SHARED_REF_KEY,MODE_PRIVATE);
        sharedPreferences=getSharedPreferences(SHARED_REF_KEY,MODE_PRIVATE);
        String remember =sharedPreferences.getString("Remember","");
        if(remember.equals("true")){
            Intent intent1=new Intent(Login.this,Home.class);
            startActivity(intent1);
            finish();
        }
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
        Call<User> studentModelCall = apiInterface.loginUser(etUser.getText().toString(), etPass.getText().toString());
        studentModelCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.body()!=null)
                {
                    User user = response.body();
                    if(user.isSuccess())
                    {
                        unf.setVisibility(View.INVISIBLE);
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
                        unf.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Login.this,"Error occured",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void text_click(View v){

        Intent intent=new Intent(Login.this,Signup.class);
        startActivity(intent);
    }
}