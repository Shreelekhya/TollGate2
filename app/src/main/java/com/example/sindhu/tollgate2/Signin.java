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
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Signin extends AppCompatActivity {
EditText t1,t2;String p,phone;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        t1=(EditText) findViewById(R.id.editText11);
        t2=(EditText) findViewById(R.id.editText4);

p=t1.getText().toString();
    }

    public void Signin(View view)
    {
        String ph=t1.getText().toString();
        String pa=t2.getText().toString();
        new SigninActivity(this).execute(ph,pa);
    }
    public class SigninActivity  extends AsyncTask<String,Void,String> {
        private Context context;
        EditText e1;

        public SigninActivity(Context context) {
            this.context = context;
           // this.e1 = e1;
        }
        public String doInBackground(String... arg0) {
            try{
                 phone = (String)arg0[0];
                BigInteger ph=new BigInteger(phone);
                String password = (String)arg0[1];


                String link="http://mss.site88.net/minit2.php";
                String data  = "phone" + "=" + ph;
                data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

                URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write( data );
                wr.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while((line = reader.readLine()) != null)
                {
                    sb.append(line);
                    break;
                }
                return sb.toString();
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }
        @Override
        public void onPostExecute(String result) {

            //this.e1.setText(result);
String[] r=result.split(":",result.length());
            if (r[0].equals("Yes")) {
                Intent intent = new Intent(Signin.this, MainPage.class);
                intent.putExtra("phn",phone);
                intent.putExtra("tuser",r[2]);
                intent.putExtra("vt1",r[3]);
                intent.putExtra("vt2",r[4]);
                intent.putExtra("vt3",r[5]);
                intent.putExtra("vt4",r[6]);
                Toast.makeText(context, "Login Successful", Toast.LENGTH_LONG).show();
                startActivity(intent);
                Signin.this.finish();
            } else if (result.equals("No")) {
                Intent intent = new Intent(Signin.this, MainActivity.class);
                Toast.makeText(context, "Invalid phone number or password", Toast.LENGTH_LONG).show();
                startActivity(intent);
                Signin.this.finish();
            } else
            {
                Intent intent = new Intent(Signin.this, MainActivity.class);
                Toast.makeText(context, r[0]+"Login failed!! Please check your internet connection and Try again...", Toast.LENGTH_LONG).show();
                startActivity(intent);
                Signin.this.finish();
            }
        }
    }

}
