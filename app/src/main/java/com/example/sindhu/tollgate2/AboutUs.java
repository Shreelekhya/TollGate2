package com.example.sindhu.tollgate2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class AboutUs extends AppCompatActivity {
    String phn,vt1,vt2,vt3,vt4,tuser;
    TextView e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Intent in = getIntent();
        phn = in.getStringExtra("phn");
        vt1=in.getStringExtra("vt1");
        vt2=in.getStringExtra("vt2");
        vt3=in.getStringExtra("vt3");
        vt4=in.getStringExtra("vt4");
        tuser=in.getStringExtra("tuser");
       // new Show(this).execute();
        e=(TextView) findViewById(R.id.textView20);
    }

    public void email(View view)
    {
        Intent intent = new Intent(this, Email.class);
        intent.putExtra("phn",phn);
        intent.putExtra("vt1",vt1);
        intent.putExtra("vt2",vt2);
        intent.putExtra("vt3", vt3);
        intent.putExtra("vt4", vt4);
        intent.putExtra("tuser",tuser);
        startActivity(intent);

    }
    public void signout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}



