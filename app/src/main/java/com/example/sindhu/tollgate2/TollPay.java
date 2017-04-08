package com.example.sindhu.tollgate2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class TollPay extends AppCompatActivity {
    String phone,tuser,phn,vt1,vt2,vt3,vt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toll_pay);
        Intent in=getIntent();
        phn=in.getStringExtra("phn");
        vt1=in.getStringExtra("vt1");
        vt2=in.getStringExtra("vt2");
        vt3=in.getStringExtra("vt3");
        vt4=in.getStringExtra("vt4");
        tuser=in.getStringExtra("tuser");
    }
    public void Credit(View view)
    {
        Intent intent=new Intent(this, CreditCard.class);
       // intent.putExtra("phn",phone);
        intent.putExtra("phn",phn);
        intent.putExtra("vt1",vt1);
        intent.putExtra("vt2",vt2);
        intent.putExtra("vt3",vt3);
        intent.putExtra("vt4",vt4);
        intent.putExtra("tuser",tuser);
        startActivity(intent);
    }
    public void Net(View view)
    {
        Intent intent=new Intent(this, Netbanking.class);
        intent.putExtra("phn",phn);
        intent.putExtra("vt1",vt1);
        intent.putExtra("vt2",vt2);
        intent.putExtra("vt3",vt3);
        intent.putExtra("vt4",vt4);
        intent.putExtra("tuser",tuser);
        startActivity(intent);
    }
    public void signout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

