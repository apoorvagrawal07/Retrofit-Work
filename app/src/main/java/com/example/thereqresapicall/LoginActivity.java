package com.example.thereqresapicall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
        EditText username;
        EditText password;
        SharedPreferences sharedPreferences;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        Button signin = findViewById(R.id.signin);
        if(sharedPreferences.contains("isLogin")){
            gotoMain();
        }
    }

    public void signButton(View view)
    {
        boolean isUser= true , isPass = true;
        String Username = username.getText().toString().trim();
        String Password = password.getText().toString().trim();
        if(Username.length()<4)
        {
            isUser = false;
            username.setError("Username must be at least 4 characters Long!");
        }
        if (Password.length() < 6) {
            isPass = false;
           password.setError("Password must be of at least 6 characters");
        }

        if(isUser && isPass)
        {
            SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putBoolean("isLogin",true);
            editor.apply();
            gotoMain();

        }
    }
    public void gotoMain()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}