package com.example.sindhu.tollgate2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;

public class CreditCard3 extends AppCompatActivity {

    String phone,amount,message,phn,vt1,vt2,vt3,vt4,tuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card3);
        Intent in=getIntent();
        phone=in.getStringExtra("phn");
        amount=in.getStringExtra("amount");
        phn=in.getStringExtra("phn");
        vt1=in.getStringExtra("vt1");
        vt2=in.getStringExtra("vt2");
        vt3=in.getStringExtra("vt3");
        vt4=in.getStringExtra("vt4");
        tuser=in.getStringExtra("tuser");
        message="your account is debited of rs"+amount+"for toll payment by your card Thank You for using this app";
    }
    public void signout(View view)
    {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void Next1(View view)
    {
        Intent intent=new Intent(this, MainPage.class);
        sendsms(phone,message);
        intent.putExtra("phn",phone);
        //intent.putExtra("phn",phn);
        intent.putExtra("vt1",vt1);
        intent.putExtra("vt2",vt2);
        intent.putExtra("vt3", vt3);
        intent.putExtra("vt4", vt4);
        intent.putExtra("tuser",tuser);
        startActivity(intent);
    }
    public void sendsms(String phone,String message)
    {
        try
        {
            SmsManager sms=SmsManager.getDefault();
            sms.sendTextMessage(phone,null,message,null,null);
        }
        catch(Exception e)
        {
        }
    }
}
