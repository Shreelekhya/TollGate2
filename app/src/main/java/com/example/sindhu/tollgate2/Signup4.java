package com.example.sindhu.tollgate2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Signup4 extends AppCompatActivity {
    private LinearLayout mLayout;
    RadioButton  mR4, mR5, mR6, mR7;
    RadioGroup rg2;
    String n,e,ph,pa,rp,h,s,d,st,c,lno,ano,value;

    // private DropBoxManager
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup4);
        mLayout = (LinearLayout) findViewById(R.id.LinearLayoutV);
        Intent in = getIntent();
        n = in.getStringExtra("name");
        e = in.getStringExtra("email");
        ph = in.getStringExtra("phone");
        pa = in.getStringExtra("password");
        rp = in.getStringExtra("rpassword");
        h = in.getStringExtra("hnumber");
        s = in.getStringExtra("street");
        d = in.getStringExtra("district");
        st = in.getStringExtra("state");
        c = in.getStringExtra("country");
        lno = in.getStringExtra("lno");
        ano = in.getStringExtra("ano");
        value=in.getStringExtra("number");
        mR4 = (RadioButton) findViewById(R.id.radioButton4);
        mR5 = (RadioButton) findViewById(R.id.radioButton5);
        mR6 = (RadioButton) findViewById(R.id.radioButton6);
        mR7 = (RadioButton) findViewById(R.id.radioButton7);

        rg2 = (RadioGroup) findViewById(R.id.RadioGroup1);


    }

    public void Next4(View view) {

        int flag=0;

        if (!mR4.isChecked() && !mR5.isChecked() && !mR6.isChecked() && !mR7.isChecked()) {
            Toast.makeText(this, "please choose one option", Toast.LENGTH_SHORT).show();
            flag++;
        }
        if(flag == 0) {

            final String value2 = ((RadioButton) findViewById(rg2.getCheckedRadioButtonId())).getText().toString();
            Intent intent = new Intent(this, Signup5.class);
            intent.putExtra("num", value2);
            intent.putExtra("Tuser", value);
            intent.putExtra("name", n);
            intent.putExtra("email", e);
            intent.putExtra("phone", ph);
            intent.putExtra("password", pa);
            intent.putExtra("rpassword", rp);
            intent.putExtra("hnumber", h);
            intent.putExtra("street", s);
            intent.putExtra("district", d);
            intent.putExtra("state", st);
            intent.putExtra("country", c);
            intent.putExtra("lno",lno);
            intent.putExtra("ano",ano);
            startActivity(intent);
        }




    }
}
