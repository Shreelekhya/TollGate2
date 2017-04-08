package com.example.sindhu.tollgate2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Signup3 extends AppCompatActivity {

    RadioButton mR1, mR2, mR3;
    private LinearLayout mLayout;
    RadioGroup rg,rg2;
    String n,e,ph,pa,rp,h,s,d,st,c,lno,ano;
    @Override
                                       protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup3);
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
        ano = in.getStringExtra("Ano");
        mR1 = (RadioButton) findViewById(R.id.radioButton);
        mR2 = (RadioButton) findViewById(R.id.radioButton2);
        mR3 = (RadioButton) findViewById(R.id.radioButton3);
        rg = (RadioGroup) findViewById(R.id.RadioGroup2);
    }








    public void Next3(View view) {

        int flag=0;
        if (!mR1.isChecked() && !mR2.isChecked() && !mR3.isChecked()) {
            Toast.makeText(this, "please choose one option", Toast.LENGTH_SHORT).show();
            flag++;
        }

        if(flag == 0) {
            final String value = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();

            Intent intent = new Intent(this, Signup4.class);
            intent.putExtra("number", value);

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
            intent.putExtra("lno", lno);
            intent.putExtra("ano", ano);
            startActivity(intent);
        }




    }
}
