package com.example.sindhu.tollgate2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.app.Activity;

public class Email extends AppCompatActivity {

    EditText editTextTo,editTextSubject,editTextMessage;
    Button send;
    String phn,vt1,vt2,vt3,vt4,tuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        Intent in = getIntent();
        phn = in.getStringExtra("phn");
        vt1=in.getStringExtra("vt1");
        vt2=in.getStringExtra("vt2");
        vt3=in.getStringExtra("vt3");
        vt4=in.getStringExtra("vt4");
        tuser=in.getStringExtra("tuser");
        editTextTo=(EditText)findViewById(R.id.editText1);
        editTextSubject=(EditText)findViewById(R.id.editText2);
        editTextMessage=(EditText)findViewById(R.id.editText3);
        editTextTo.setText("admtoll053@gmail.com");

        send=(Button)findViewById(R.id.button1);

        send.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View arg0) {
                String to = editTextTo.getText().toString();
                String subject = editTextSubject.getText().toString();
                String message = editTextMessage.getText().toString();


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }

        });

    }

    public void signout(View view) {
        Intent intent = new Intent(this, MainPage.class);
        intent.putExtra("phn",phn);
        intent.putExtra("vt1",vt1);
        intent.putExtra("vt2",vt2);
        intent.putExtra("vt3", vt3);
        intent.putExtra("vt4", vt4);
        intent.putExtra("tuser",tuser);
        startActivity(intent);
    }
}
