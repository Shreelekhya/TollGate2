package com.example.sindhu.tollgate2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TollWallet extends AppCompatActivity {

    String amount,phone,vt1,vt2,vt3,vt4,vt5,tuser;TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toll_wallet);
        Intent in=getIntent();
        amount=in.getStringExtra("amount");
        phone=in.getStringExtra("phone");
        vt1=in.getStringExtra("vt1");
        vt2=in.getStringExtra("vt2");
        vt3=in.getStringExtra("vt3");
        vt4=in.getStringExtra("vt4");
        tuser=in.getStringExtra("tuser");
        t1=(TextView)findViewById(R.id.editText3);
        t1.setText(amount);
    }
    public void Next1(View view)
    {
        Intent in=new Intent(this, TollPay.class);
        in.putExtra("phn",phone);
        in.putExtra("vt1",vt1);
        in.putExtra("vt2",vt2);
        in.putExtra("vt3", vt3);
        in.putExtra("vt4", vt4);
        in.putExtra("tuser",tuser);
        startActivity(in);
    }
    public void signout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
