package com.example.sindhu.tollgate2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup31 extends AppCompatActivity {
    EditText e1,e2;
    String n,e,ph,pa,rp,hnumber,street,district,state,country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_signup31);
        Intent in = getIntent();
        n = in.getStringExtra("name");
        e = in.getStringExtra("email");
        ph = in.getStringExtra("phone");
        pa = in.getStringExtra("password");
        rp = in.getStringExtra("rpassword");
        hnumber=in.getStringExtra("hnumber");
        street=in.getStringExtra("street");
        district=in.getStringExtra("district");
        state=in.getStringExtra("state");
        country=in.getStringExtra("country");
                e1=(EditText) findViewById(R.id.editText);
                e2=(EditText) findViewById(R.id.editText2);

            }
            public void Next1(View view) {
                final String lno = e1.getText().toString();
                final String Ano = e2.getText().toString();

                int flag=0;
                // String empt=null;
                if(lno.equals("")) {
                    e1.setError("name cannot be null");
                    flag++;
                }

                if(Ano.equals("")) {
                    e2.setError("email cannot be null");
                    flag++;
                }


                if(flag == 0)
                {
                    Intent intent = new Intent(this, Signup3.class);
                    intent.putExtra("name", n);
                    intent.putExtra("email", e);
                    intent.putExtra("phone", ph);
                    intent.putExtra("password", pa);
                    intent.putExtra("rpassword", rp);
                    intent.putExtra("hnumber", hnumber);
                    intent.putExtra("street", street);
                    intent.putExtra("district", district);
                    intent.putExtra("state", state);
                    intent.putExtra("country", country);
                    intent.putExtra("lno",lno);
                    intent.putExtra("Ano",Ano);

                    startActivity(intent);
                }
            }



        }
