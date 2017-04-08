package com.example.sindhu.tollgate2;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;

public class MainPage extends AppCompatActivity {
String phn,vt1,vt2,vt3,vt4,tuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_main_page);
        Intent in =getIntent();
         phn=in.getStringExtra("phn");
        vt1=in.getStringExtra("vt1");
        vt2=in.getStringExtra("vt2");
        vt3=in.getStringExtra("vt3");
        vt4=in.getStringExtra("vt4");
        tuser=in.getStringExtra("tuser");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.signout, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.signout:
                startActivity(new Intent(MainPage.this,MainActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void planurtrip(View view)
    {
        Intent intent = new Intent(this, PlanUrTrip.class);
        intent.putExtra("phn",phn);
        intent.putExtra("vt1",vt1);
        intent.putExtra("vt2",vt2);
        intent.putExtra("vt3",vt3);
        intent.putExtra("vt4",vt4);
        intent.putExtra("tuser",tuser);
        startActivity(intent);
    }
    public void planYourtrip(View view)
    {
        Intent intent = new Intent(this, PlanUrTrip.class);
        intent.putExtra("phn",phn);
        intent.putExtra("vt1",vt1);
        intent.putExtra("vt2",vt2);
        intent.putExtra("vt3",vt3);
        intent.putExtra("vt4",vt4);
        intent.putExtra("tuser",tuser);
        startActivity(intent);
    }
    public void tollpay(View view)
    {
        Intent intent=new Intent(this, TollPay.class);
        intent.putExtra("phn",phn);
        intent.putExtra("vt1",vt1);
        intent.putExtra("vt2", vt2);
        intent.putExtra("vt3",vt3);
        intent.putExtra("vt4",vt4);
        intent.putExtra("tuser",tuser);
        startActivity(intent);
    }
    public void thist(View view) {
        new Thist1(this).execute(phn);
    }

    public class Thist1 extends AsyncTask<String, Void, String> {
        private Context context;
        EditText e2;

        public Thist1(Context context) {
            this.context = context;

        }

        protected String doInBackground(String... arg0) {
            try {

                String phone1 = (String) arg0[0];
                BigInteger ph = new BigInteger(phone1);
                String link = "http://mss.site88.net/thist1.php";
                String data = "phone" + "=" + ph;


                URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write(data);
                wr.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while ((line = reader.readLine()) != null) {
                    sb.append(line);

                    break;

                }
                return sb.toString();
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            String[] ro = result.split(":", result.length());
            if (ro[0].equals("Yes")) {
                Intent intent = new Intent(MainPage.this, Thistor1.class);
                intent.putExtra("phn", phn);
                intent.putExtra("vn1", ro[2]);
                intent.putExtra("vn2", ro[3]);
                intent.putExtra("vn3", ro[4]);
                intent.putExtra("vn4", ro[5]);
intent.putExtra("tuser",tuser);
                startActivity(intent);

            } else if (result.equals("No")) {
                // e1.setText(r[0]);
                String am = "0";
                Intent intent = new Intent(MainPage.this, TollWallet.class);
                intent.putExtra("amount", am);
                intent.putExtra("phn",phn);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3",vt3);
                intent.putExtra("vt4",vt4);
                intent.putExtra("tuser",tuser);
                startActivity(intent);
                // Mainpage.this.finish();
            } else {
                Intent intent = new Intent(MainPage.this, MainPage.class);
                Toast.makeText(context, "Exception" + result, Toast.LENGTH_LONG).show();
                intent.putExtra("phn", phn);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3",vt3);
                intent.putExtra("vt4",vt4);
                intent.putExtra("tuser",tuser);
                startActivity(intent);
                //.this.finish();
            }
        }
    }
    public void tollwallet(View view) {
        new Twallet(this).execute(phn);
    }
    public void Thistory(View view)
    {
        Intent intent = new Intent(this, THistory.class);
        intent.putExtra("phn",phn);
        startActivity(intent);
    }
    public void profile(View view)
    {
        Intent intent = new Intent(this, Profile.class);
        intent.putExtra("phn",phn);
        intent.putExtra("vt1",vt1);
        intent.putExtra("vt2",vt2);
        intent.putExtra("vt3",vt3);
        intent.putExtra("vt4",vt4);
        intent.putExtra("tuser",tuser);
        startActivity(intent);
    }

    public void aboutus(View view)
    {
        Intent intent = new Intent(this, AboutUs.class);
        intent.putExtra("phn",phn);
        intent.putExtra("vt1",vt1);
        intent.putExtra("vt2",vt2);
        intent.putExtra("vt3",vt3);
        intent.putExtra("vt4",vt4);
        intent.putExtra("tuser",tuser);
        startActivity(intent);
    }
    public class Twallet extends AsyncTask<String, Void, String> {
        private Context context;
        EditText e2;

        public Twallet(Context context) {
            this.context = context;

        }

        protected String doInBackground(String... arg0) {
            try {

                String phone1 = (String) arg0[0];
                BigInteger ph=new BigInteger(phone1);
                String link = "http://mss.site88.net/twallet1.php";
                String data = "phone" + "=" + ph;


                URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write(data);
                wr.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while ((line = reader.readLine()) != null) {
                    sb.append(line);

                    break;

                }
                return sb.toString();
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            String[] ro=result.split(" ",result.length());
            if (ro[0].equals("Yes")) {
                Intent intent = new Intent(MainPage.this, TollWallet.class);
                //Toast.makeText(context, "Redirecting....", Toast.LENGTH_LONG).show();
                intent.putExtra("phone", phn);
                intent.putExtra("amount",ro[1]);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2", vt2);
                intent.putExtra("vt3",vt3);
                intent.putExtra("vt4",vt4);
                intent.putExtra("tuser",tuser);

                startActivity(intent);
                // Mainpage.this.finish();
            } else if (result.equals("No")) {
                // e1.setText(r[0]);
                String am="0";
                Intent intent = new Intent(MainPage.this, TollWallet.class);
                intent.putExtra("phn",phn);
                intent.putExtra("amount",am);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3",vt3);
                intent.putExtra("vt4",vt4);
                intent.putExtra("tuser",tuser);
                startActivity(intent);
                // Mainpage.this.finish();
            } else {
                Intent intent = new Intent(MainPage.this, MainPage.class);
                intent.putExtra("phn",phn);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3",vt3);
                intent.putExtra("vt4",vt4);
                intent.putExtra("tuser",tuser);
                Toast.makeText(context, "Exception" + result, Toast.LENGTH_LONG).show();
                startActivity(intent);
                //.this.finish();
            }
        }
    }
}
