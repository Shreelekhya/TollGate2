package com.example.sindhu.tollgate2;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Netbanking extends AppCompatActivity {

    EditText e1, e2;
    String phone, tuser, uname,passw,vt1,vt2,vt3,vt4,amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netbanking);
        Intent in = getIntent();
        phone = in.getStringExtra("phn");
        tuser = in.getStringExtra("tuser");
        vt1=in.getStringExtra("vt1");
        vt2=in.getStringExtra("vt2");
        vt3=in.getStringExtra("vt3");
        vt4=in.getStringExtra("vt4");

        e1 = (EditText) findViewById(R.id.editText6);
        e2 = (EditText) findViewById(R.id.Street);

    }

    public void signout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Nett(View view) {
        uname = e1.getText().toString();
         passw = e2.getText().toString();
        new SigninActivity(this).execute(uname, passw);
    }

    public class SigninActivity extends AsyncTask<String, Void, String> {
        private Context context;
        EditText e2;

        public SigninActivity(Context context) {
            this.context = context;

        }

        protected String doInBackground(String... arg0) {
            try {

                String uname = (String) arg0[0];
                String lpass = (String) arg0[1];
                String link = "http://mss.site88.net/netbanking.php";
                String data = URLEncoder.encode("uname", "UTF-8") + "=" + URLEncoder.encode(uname, "UTF-8");
                data += "&" + URLEncoder.encode("lpass", "UTF-8") + "=" + URLEncoder.encode(lpass, "UTF-8");

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
            if (result.equals("Yes")) {
                Intent intent = new Intent(Netbanking.this, Netbanking1_2.class);
                Toast.makeText(context, "Redirecting....", Toast.LENGTH_LONG).show();
                intent.putExtra("phn", phone);
                intent.putExtra("uname", uname);
                intent.putExtra("tuser", tuser);
                intent.putExtra("vt1", vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3", vt3);
                intent.putExtra("vt4", vt4);

                intent.putExtra("amount", amount);
                if (tuser.equals("Normal user")) {
                    amount = "700";
                    intent.putExtra("amount", amount);
                }
                if (tuser.equals("Cab owner")) {
                     amount = "1000";
                    intent.putExtra("amount", amount);
                }
                if (tuser.equals("Government user")) {
                     amount = "500";
                    intent.putExtra("amount", amount);
                }
                startActivity(intent);
                Netbanking.this.finish();
            } else if (result.equals("No")) {
                // e1.setText(r[0]);
                Intent intent = new Intent(Netbanking.this, MainPage.class);
                Toast.makeText(context, "Invalid Details!!please try again", Toast.LENGTH_LONG).show();
                intent.putExtra("phn", phone);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3", vt3);
                intent.putExtra("vt4", vt4);
                intent.putExtra("tuser", tuser);
                startActivity(intent);
                Netbanking.this.finish();
            } else {
                Intent intent = new Intent(Netbanking.this, MainPage.class);
                Toast.makeText(context, "Exception" + result, Toast.LENGTH_LONG).show();
                intent.putExtra("phn",phone);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3", vt3);
                intent.putExtra("vt4", vt4);
                intent.putExtra("tuser", tuser);
                startActivity(intent);
                Netbanking.this.finish();
            }
        }
    }


}
