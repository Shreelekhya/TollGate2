package com.example.sindhu.tollgate2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

public class Netbanking3 extends AppCompatActivity {
    String phone, amount, message,vt1,vt2,vt3,vt4,tuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netbanking3);
        Intent in = getIntent();
        phone = in.getStringExtra("phn");
        amount = in.getStringExtra("amount");
        vt1=in.getStringExtra("vt1");
        vt2=in.getStringExtra("vt2");
        vt3=in.getStringExtra("vt3");
        vt4=in.getStringExtra("vt4");
        tuser=in.getStringExtra("tuser");
        message = "your account is debited of rs" + amount + "for toll payment via netbanking  Thank You for using this app";
        //ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
    }

    public void signout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Next1(View view) {
        Intent intent = new Intent(this, MainPage.class);
        sendsms(phone, message);
        intent.putExtra("phn",phone);
        intent.putExtra("tuser", tuser);
        intent.putExtra("vt1", vt1);
        intent.putExtra("vt2", vt2);
        intent.putExtra("vt3", vt3);
        intent.putExtra("vt4", vt4);
        startActivity(intent);
    }

    public void sendsms(String phone, String message) {
        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phone, null, message, null, null);
            Toast.makeText(getApplicationContext(), "Msg send!", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Msg failed!" + e, Toast.LENGTH_LONG).show();
        }
    }
}
