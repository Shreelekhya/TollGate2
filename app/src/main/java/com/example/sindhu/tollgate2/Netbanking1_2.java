package com.example.sindhu.tollgate2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Netbanking1_2 extends AppCompatActivity {
String phone,tuser,vt1,vt2,vt3,vt4,amount,uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netbanking1_2);
        Intent in = getIntent();
        phone=in.getStringExtra("phn");
        amount=in.getStringExtra("amount");
        uname=in.getStringExtra("uname");
        tuser=in.getStringExtra("tuser");
        vt1=in.getStringExtra("vt1");
        vt2=in.getStringExtra("vt2");
        vt3=in.getStringExtra("vt3");
        vt4=in.getStringExtra("vt4");
    }
    public void signout(View view)
    {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void Net1_2(View view)
    {
        Intent intent=new Intent(this, Netbanking2.class);
        intent.putExtra("phn", phone);
        intent.putExtra("uname", uname);
        intent.putExtra("tuser", tuser);
        intent.putExtra("amount", amount);
        intent.putExtra("vt1", vt1);
        intent.putExtra("vt2",vt2);
        intent.putExtra("vt3", vt3);
        intent.putExtra("vt4", vt4);
        startActivity(intent);
    }
}
