package com.example.sindhu.tollgate2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Thistor2 extends AppCompatActivity {
    String[] idA;
    String[] vnumA;String[] TSA;String[] amtDA=new String[5];
    int a1;
    String phone,vt1,vt2,vt3,vt4,tuser;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,t27,t28,t29,t30,t31,t32,t33,t34,t35,t36,t37,t38,t39,t40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thistor2);
        Intent in=getIntent();
        Bundle extras = getIntent().getExtras();
        idA = extras.getStringArray("idA");
        vnumA = extras.getStringArray("vnumA");
        TSA = extras.getStringArray("TSA");
        amtDA = extras.getStringArray("amtDA");
        phone=in.getStringExtra("phn");
        vt1=in.getStringExtra("vt1");
        vt2=in.getStringExtra("vt2");
        vt3=in.getStringExtra("vt3");
        vt4=in.getStringExtra("vt4");
        tuser=in.getStringExtra("tuser");
        t1 = (TextView) findViewById(R.id.textView1);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        t4 = (TextView) findViewById(R.id.textView4);
        t5 = (TextView) findViewById(R.id.textView5);
        t6 = (TextView) findViewById(R.id.textView6);
        t7 = (TextView) findViewById(R.id.textView7);
        t8 = (TextView) findViewById(R.id.textView8);
        t9 = (TextView) findViewById(R.id.textView9);
        t10 = (TextView) findViewById(R.id.textView10);
        t11 = (TextView) findViewById(R.id.textView11);
        t12 = (TextView) findViewById(R.id.textView12);
        t13 = (TextView) findViewById(R.id.textView13);
        t14 = (TextView) findViewById(R.id.textView14);
        t15 = (TextView) findViewById(R.id.textView15);
        t16 = (TextView) findViewById(R.id.textView16);
        t17= (TextView) findViewById(R.id.textView17);
        t18 = (TextView) findViewById(R.id.textView18);
        t19 = (TextView) findViewById(R.id.textView19);
        t20 = (TextView) findViewById(R.id.textView20);
        t21 = (TextView) findViewById(R.id.textView21);
        t22 = (TextView) findViewById(R.id.textView22);
        t23 = (TextView) findViewById(R.id.textView23);
        t24 = (TextView) findViewById(R.id.textView24);
        t25 = (TextView) findViewById(R.id.textView25);
        t26 = (TextView) findViewById(R.id.textView26);
        t27 = (TextView) findViewById(R.id.textView27);
        t28 = (TextView) findViewById(R.id.textView28);
        t29 = (TextView) findViewById(R.id.textView29);
        t30 = (TextView) findViewById(R.id.textView30);
        t31 = (TextView) findViewById(R.id.textView31);
        t32 = (TextView) findViewById(R.id.textView32);
        t33 = (TextView) findViewById(R.id.textView33);
        t34 = (TextView) findViewById(R.id.textView34);
        t35 = (TextView) findViewById(R.id.textView35);
        t36 = (TextView) findViewById(R.id.textView36);
        t37 = (TextView) findViewById(R.id.textView37);
        t38 = (TextView) findViewById(R.id.textView38);
        t39 = (TextView) findViewById(R.id.textView39);
        t40 = (TextView) findViewById(R.id.textView40);



        a1=TSA.length;
String b=String.valueOf(a1);
t2.setText(b);

        if(b.equals("1"))
        {


            if(idA[0].equals("1"))
                t2.setText("vellore");
            else if(idA[0].equals("2"))
                t2.setText("Gudiyatam");
            else if(idA[0].equals("3"))
                t2.setText("Hyderabad");
            else
                t2.setText("Bangalore");
            t4.setText(vnumA[0]);
            t6.setText(TSA[0]);
            t8.setText(amtDA[0]);
            t1.setVisibility(View.VISIBLE); t2.setVisibility(View.VISIBLE);
            t3.setVisibility(View.VISIBLE); t4.setVisibility(View.VISIBLE);
            t5.setVisibility(View.VISIBLE); t6.setVisibility(View.VISIBLE);
            t7.setVisibility(View.VISIBLE); t8.setVisibility(View.VISIBLE);

    }
    else if(b.equals("2"))
    {


        if(idA[0].equals("1"))
            t2.setText("vellore");
        else if(idA[0].equals("2"))
            t2.setText("Gudiyatam");
        else if(idA[0].equals("3"))
            t2.setText("Hyderabad");
        else
            t2.setText("Bangalore");
        t4.setText(vnumA[0]);
        t6.setText(TSA[0]);
        t8.setText(amtDA[0]);
        if(idA[1].equals("1"))
            t10.setText("vellore");
        else if(idA[1].equals("2"))
            t10.setText("Gudiyatam");
        else if(idA[1].equals("3"))
            t10.setText("Hyderabad");
        else
            t10.setText("Bangalore");
        t12.setText(vnumA[1]);
        t14.setText(TSA[1]);
        t16.setText(amtDA[1]);
           t1.setVisibility(View.VISIBLE); t2.setVisibility(View.VISIBLE);
            t3.setVisibility(View.VISIBLE); t4.setVisibility(View.VISIBLE);
            t5.setVisibility(View.VISIBLE); t6.setVisibility(View.VISIBLE);
            t7.setVisibility(View.VISIBLE); t8.setVisibility(View.VISIBLE);
            t9.setVisibility(View.VISIBLE); t10.setVisibility(View.VISIBLE);
            t11.setVisibility(View.VISIBLE); t12.setVisibility(View.VISIBLE);
            t13.setVisibility(View.VISIBLE); t14.setVisibility(View.VISIBLE);
            t15.setVisibility(View.VISIBLE); t16.setVisibility(View.VISIBLE);

    }
    else if(b.equals("3"))
    {
           if(idA[0].equals("1"))
                t2.setText("Vellore");
            else if(idA[0].equals("2"))
                t2.setText("Gudiyatam");
            else if(idA[0].equals("3"))
                t2.setText("Hyderabad");
            else
                t2.setText("Bangalore");
            t4.setText(vnumA[0]);
            t6.setText(TSA[0]);
            t8.setText(amtDA[0]);
            if(idA[1].equals("1"))
                t10.setText("vellore");
            else if(idA[1].equals("2"))
                t10.setText("Gudiyatam");
            else if(idA[1].equals("3"))
                t10.setText("Hyderabad");
            else
                t10.setText("Bangalore");
            t12.setText(vnumA[1]);
            t14.setText(TSA[1]);
            t16.setText(amtDA[1]);
            if(idA[2].equals("1"))
                t18.setText("vellore");
            else if(idA[2].equals("2"))
                t18.setText("Gudiyatam");
            else if(idA[2].equals("3"))
                t18.setText("Hyderabad");
            else
                t18.setText("Bangalore");
            t20.setText(vnumA[2]);
        t22.setText(TSA[2]);
        t24.setText(amtDA[2]);

            t1.setVisibility(View.VISIBLE); t2.setVisibility(View.VISIBLE);
            t3.setVisibility(View.VISIBLE); t4.setVisibility(View.VISIBLE);
            t5.setVisibility(View.VISIBLE); t6.setVisibility(View.VISIBLE);
            t7.setVisibility(View.VISIBLE); t8.setVisibility(View.VISIBLE);
            t9.setVisibility(View.VISIBLE); t10.setVisibility(View.VISIBLE);
            t11.setVisibility(View.VISIBLE); t12.setVisibility(View.VISIBLE);
            t13.setVisibility(View.VISIBLE); t14.setVisibility(View.VISIBLE);
            t15.setVisibility(View.VISIBLE); t16.setVisibility(View.VISIBLE);
            t17.setVisibility(View.VISIBLE); t18.setVisibility(View.VISIBLE);
            t19.setVisibility(View.VISIBLE); t20.setVisibility(View.VISIBLE);
            t21.setVisibility(View.VISIBLE); t22.setVisibility(View.VISIBLE);
            t23.setVisibility(View.VISIBLE); t24.setVisibility(View.VISIBLE);
    }
    else  if(b.equals("4"))
    {

        if(idA[0].equals("1"))
            t2.setText("vellore");
        else if(idA[0].equals("2"))
            t2.setText("Gudiyatam");
        else if(idA[0].equals("3"))
            t2.setText("Hyderabad");
        else
            t2.setText("Bangalore");
        t4.setText(vnumA[0]);
        t6.setText(TSA[0]);
        t8.setText(amtDA[0]);
        if(idA[1].equals("1"))
            t10.setText("vellore");
        else if(idA[1].equals("2"))
            t10.setText("Gudiyatam");
        else if(idA[1].equals("3"))
            t10.setText("Hyderabad");
        else
            t10.setText("Bangalore");
        t12.setText(vnumA[1]);
        t14.setText(TSA[1]);
        t16.setText(amtDA[1]);
        if(idA[2].equals("1"))
            t18.setText("vellore");
        else if(idA[2].equals("2"))
            t18.setText("Gudiyatam");
        else if(idA[2].equals("3"))
            t18.setText("Hyderabad");
        else
            t18.setText("Bangalore");
        t20.setText(vnumA[2]);
        t22.setText(TSA[2]);
        t24.setText(amtDA[2]);
        if(idA[3].equals("1"))
            t26.setText("vellore");
        else if(idA[3].equals("2"))
            t26.setText("Gudiyatam");
        else if(idA[3].equals("3"))
            t26.setText("Hyderabad");
        else
            t26.setText("Bangalore");
        t28.setText(vnumA[3]);
        t30.setText(TSA[3]);
        t32.setText(amtDA[3]);
            t1.setVisibility(View.VISIBLE); t2.setVisibility(View.VISIBLE);
            t3.setVisibility(View.VISIBLE); t4.setVisibility(View.VISIBLE);
            t5.setVisibility(View.VISIBLE); t6.setVisibility(View.VISIBLE);
            t7.setVisibility(View.VISIBLE); t8.setVisibility(View.VISIBLE);
            t9.setVisibility(View.VISIBLE); t10.setVisibility(View.VISIBLE);
            t11.setVisibility(View.VISIBLE); t12.setVisibility(View.VISIBLE);
            t13.setVisibility(View.VISIBLE); t14.setVisibility(View.VISIBLE);
            t15.setVisibility(View.VISIBLE); t16.setVisibility(View.VISIBLE);
            t17.setVisibility(View.VISIBLE); t18.setVisibility(View.VISIBLE);
            t19.setVisibility(View.VISIBLE); t20.setVisibility(View.VISIBLE);
            t21.setVisibility(View.VISIBLE); t22.setVisibility(View.VISIBLE);
            t23.setVisibility(View.VISIBLE); t24.setVisibility(View.VISIBLE);
            t25.setVisibility(View.VISIBLE); t26.setVisibility(View.VISIBLE);
            t27.setVisibility(View.VISIBLE); t28.setVisibility(View.VISIBLE);
            t29.setVisibility(View.VISIBLE); t30.setVisibility(View.VISIBLE);
            t31.setVisibility(View.VISIBLE); t32.setVisibility(View.VISIBLE);
    }
    else if(b.equals("5"))
    {

        if(idA[0].equals("1"))
            t2.setText("vellore");
        else if(idA[0].equals("2"))
            t2.setText("Gudiyatam");
        else if(idA[0].equals("3"))
            t2.setText("Hyderabad");
        else
            t2.setText("Bangalore");
        t4.setText(vnumA[0]);
        t6.setText(TSA[0]);
        t8.setText(amtDA[0]);
        if(idA[1].equals("1"))
            t10.setText("vellore");
        else if(idA[1].equals("2"))
            t10.setText("Gudiyatam");
        else if(idA[1].equals("3"))
            t10.setText("Hyderabad");
        else
            t10.setText("Bangalore");
        t12.setText(vnumA[1]);
        t14.setText(TSA[1]);
        t16.setText(amtDA[1]);
        if(idA[2].equals("1"))
            t18.setText("vellore");
        else if(idA[2].equals("2"))
            t18.setText("Gudiyatam");
        else if(idA[2].equals("3"))
            t18.setText("Hyderabad");
        else
            t18.setText("Bangalore");
        t20.setText(vnumA[2]);
        t22.setText(TSA[2]);
        t24.setText(amtDA[2]);
        if(idA[3].equals("1"))
            t26.setText("vellore");
        else if(idA[3].equals("2"))
            t26.setText("Gudiyatam");
        else if(idA[3].equals("3"))
            t26.setText("Hyderabad");
        else
            t26.setText("Bangalore");
        t28.setText(vnumA[3]);
        t30.setText(TSA[3]);
        t32.setText(amtDA[3]);
        if(idA[4].equals("1"))
            t34.setText("vellore");
        else if(idA[4].equals("2"))
            t34.setText("Gudiyatam");
        else if(idA[4].equals("3"))
            t34.setText("Hyderabad");
        else
            t34.setText("Bangalore");
        t36.setText(vnumA[4]);
        t38.setText(TSA[4]);
        t40.setText(amtDA[4]);
            t1.setVisibility(View.VISIBLE); t2.setVisibility(View.VISIBLE);
            t3.setVisibility(View.VISIBLE); t4.setVisibility(View.VISIBLE);
            t5.setVisibility(View.VISIBLE); t6.setVisibility(View.VISIBLE);
            t7.setVisibility(View.VISIBLE); t8.setVisibility(View.VISIBLE);
            t9.setVisibility(View.VISIBLE); t10.setVisibility(View.VISIBLE);
            t11.setVisibility(View.VISIBLE); t12.setVisibility(View.VISIBLE);
            t13.setVisibility(View.VISIBLE); t14.setVisibility(View.VISIBLE);
            t15.setVisibility(View.VISIBLE); t16.setVisibility(View.VISIBLE);
            t17.setVisibility(View.VISIBLE); t18.setVisibility(View.VISIBLE);
            t19.setVisibility(View.VISIBLE); t20.setVisibility(View.VISIBLE);
            t21.setVisibility(View.VISIBLE); t22.setVisibility(View.VISIBLE);
            t23.setVisibility(View.VISIBLE); t24.setVisibility(View.VISIBLE);
            t25.setVisibility(View.VISIBLE); t26.setVisibility(View.VISIBLE);
            t27.setVisibility(View.VISIBLE); t28.setVisibility(View.VISIBLE);
            t29.setVisibility(View.VISIBLE); t30.setVisibility(View.VISIBLE);
            t31.setVisibility(View.VISIBLE); t32.setVisibility(View.VISIBLE);
            t33.setVisibility(View.VISIBLE); t34.setVisibility(View.VISIBLE);
            t35.setVisibility(View.VISIBLE); t36.setVisibility(View.VISIBLE);
            t37.setVisibility(View.VISIBLE); t38.setVisibility(View.VISIBLE);
            t39.setVisibility(View.VISIBLE); t40.setVisibility(View.VISIBLE);
    }
    else {

        t1.setText("No records found!!");
       t1.setVisibility(View.VISIBLE);

    }


    }
    public void back(View view)
    {
        Intent inte=new Intent(this, MainPage.class);
        inte.putExtra("phn",phone);
        inte.putExtra("vt1",vt1);
        inte.putExtra("vt2",vt2);
        inte.putExtra("vt3", vt3);
        inte.putExtra("vt4", vt4);
        inte.putExtra("tuser",tuser);
        startActivity(inte);
    }
    public void signout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}