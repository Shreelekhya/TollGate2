package com.example.sindhu.tollgate2;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Admin3 extends AppCompatActivity {
    String amt, phn, new_amt, p;
String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin3);

        Intent i = getIntent();
        amt = i.getStringExtra("amt");
        phn = i.getStringExtra("phn");
        message="Money is deducted from your Toll app wallet for your journey!Please check the app for more details.";
        new w_update(this).execute(amt, phn);
    }
    public void signout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void Next1(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        sendsms(phn, message);
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
    public class w_update extends AsyncTask<String, Void, String> {
        private Context context;

        public w_update(Context context) {
            this.context = context;

        }


        public String doInBackground(String... arg0) {
            try {
                new_amt = (String) arg0[0];
                p = (String) arg0[1];
                BigInteger ph = new BigInteger(p);
                int a = Integer.parseInt(new_amt);
                String link = "http://mss.site88.net/update_twallet.php";
                String data = "phone" + "=" + ph;
                data += "&" + "new_amt" + "=" + a;


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
        public void onPostExecute(String result) {

            //this.e1.setText(result);
            String[] r = result.split(":", result.length());
            if (r[0].equals("Yes")) {

                // int phone=Integer.parseInt(phn);

                // Intent intent = new Intent(Admin2.this, MainActivity.class);
                Toast.makeText(context, "Updated", Toast.LENGTH_LONG).show();
                //tartActivity(intent);
                //Admin2.this.finish();
            } else if (r[0].equals("No")) {
                Intent intent = new Intent(Admin3.this, MainActivity.class);
                Toast.makeText(context, "Updation failed", Toast.LENGTH_LONG).show();
                startActivity(intent);
                Admin3.this.finish();
            } else {
                Intent intent = new Intent(Admin3.this, MainActivity.class);
                Toast.makeText(context, r[0] + "Please check your internet connection and Try again...", Toast.LENGTH_LONG).show();
                startActivity(intent);
                Admin3.this.finish();
            }
        }


    }
}