package com.example.sindhu.tollgate2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Signin(View view)
    {
        Intent intent=new Intent(this, Signin.class);
        startActivity(intent);
    }
    public void Signup(View view)
    {
        Intent intent1=new Intent(this, Signup.class);
        startActivity(intent1);
    }
    public void adminlogin(View view)
    {
        Intent intent2=new Intent(this, AdminLogin.class);
        startActivity(intent2);
    }
}
