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

public class Profile extends AppCompatActivity {
String phone;
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,vt1,vt2,vt3,vt4,tuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent in = getIntent();
        phone = in.getStringExtra("phn");
        vt1=in.getStringExtra("vt1");
        vt2=in.getStringExtra("vt2");
        vt3=in.getStringExtra("vt3");
        vt4=in.getStringExtra("vt4");
        tuser=in.getStringExtra("tuser");
        e1=(EditText) findViewById(R.id.editText1);
        e2=(EditText) findViewById(R.id.editText2);

        e3=(EditText) findViewById(R.id.editText3);
        e4=(EditText) findViewById(R.id.editText4);
        e5=(EditText) findViewById(R.id.editText5);
        e6=(EditText) findViewById(R.id.editText6);
        e7=(EditText) findViewById(R.id.editText7);
        e8=(EditText) findViewById(R.id.editText8);

        e9=(EditText) findViewById(R.id.editText9);
        e10=(EditText) findViewById(R.id.editText10);
        e11=(EditText) findViewById(R.id.editText11);
        e12=(EditText) findViewById(R.id.editText12);
        e13=(EditText) findViewById(R.id.editText13);
        e14=(EditText) findViewById(R.id.editText14);
        e15=(EditText) findViewById(R.id.editText15);
        e16=(EditText) findViewById(R.id.editText16);
        e17=(EditText) findViewById(R.id.editText17);
        e18=(EditText) findViewById(R.id.editText18);
         new Show(this,e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18).execute(phone);
    }
    public void signout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void UpdateProfile(View view)
    {
        s1=e1.getText().toString();
        s2=e2.getText().toString();
        s3=e3.getText().toString();
        s4=e4.getText().toString();
        s5=e5.getText().toString();
        s6=e6.getText().toString();
        s7=e7.getText().toString();
        s8=e8.getText().toString();
        s9=e9.getText().toString();
        s10=e10.getText().toString();
        s11=e11.getText().toString();
        s12=e12.getText().toString();
        s13=e13.getText().toString();
        s14=e14.getText().toString();
        s15=e15.getText().toString();
        s16=e16.getText().toString();
        s17=e17.getText().toString();
        s18=e18.getText().toString();


        new Update(this).execute(phone,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18);
    }
    public class Update extends AsyncTask<String, Void, String> {
        private Context context;
       // private String e1;
        public Update(Context context)
        {
            this.context = context;
            //this.e1 = e1;
        }
        protected String doInBackground(String... arg0) {
            try {
                String phn = (String)arg0[0];
                BigInteger phonepp=new BigInteger(phn);
String name = (String)arg0[1];
                String email = (String)arg0[2];
                String phone = (String)arg0[3];
                BigInteger ph = new BigInteger(phone);
                String password = (String)arg0[4];
               //String hnumber = (String)arg0[4];
                String street = (String)arg0[5];
                String district = (String)arg0[6];
                String state = (String)arg0[7];
                String country = (String)arg0[8];
                String tuser = (String)arg0[9];
                String nofvehicles = (String)arg0[10];
                int num_ve = Integer.parseInt(nofvehicles);
                String vt1 = (String)arg0[11];
                String vn1 = (String)arg0[12];
                String vt2 = (String)arg0[13];
                String vn2 = (String)arg0[14];
                String vt3 = (String)arg0[15];
                String vn3 = (String)arg0[16];
                String vt4 = (String)arg0[17];
                String vn4 = (String)arg0[18];

                String link = "http://mss.site88.net/updateprofile.php";
                String data = "phone" + "=" + phonepp;
                data += "&" + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
                data += "&" + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8");
                data += "&" + "phone2" + "=" + ph;
                data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
               // data += "&" + URLEncoder.encode("hnumber", "UTF-8") + "=" + URLEncoder.encode(hnumber, "UTF-8");
                data += "&" + URLEncoder.encode("street", "UTF-8") + "=" + URLEncoder.encode(street, "UTF-8");
                data += "&" + URLEncoder.encode("district", "UTF-8") + "=" + URLEncoder.encode(district, "UTF-8");
                data += "&" + URLEncoder.encode("state", "UTF-8") + "=" + URLEncoder.encode(state, "UTF-8");
                data += "&" + URLEncoder.encode("country", "UTF-8") + "=" + URLEncoder.encode(country, "UTF-8");
                data += "&" + URLEncoder.encode("tuser", "UTF-8") + "=" + URLEncoder.encode(tuser, "UTF-8");
                data += "&" + "nofvehicles" + "=" + num_ve;
                data += "&" + URLEncoder.encode("vt1", "UTF-8") + "=" + URLEncoder.encode(vt1, "UTF-8");
                data += "&" + URLEncoder.encode("vn1", "UTF-8") + "=" + URLEncoder.encode(vn1, "UTF-8");
                data += "&" + URLEncoder.encode("vt2", "UTF-8") + "=" + URLEncoder.encode(vt2, "UTF-8");
                data += "&" + URLEncoder.encode("vn2", "UTF-8") + "=" + URLEncoder.encode(vn2, "UTF-8");
                data += "&" + URLEncoder.encode("vt3", "UTF-8") + "=" + URLEncoder.encode(vt3, "UTF-8");
                data += "&" + URLEncoder.encode("vn3", "UTF-8") + "=" + URLEncoder.encode(vn3, "UTF-8");
                data += "&" + URLEncoder.encode("vt4", "UTF-8") + "=" + URLEncoder.encode(vt4, "UTF-8");
                data += "&" + URLEncoder.encode("vn4", "UTF-8") + "=" + URLEncoder.encode(vn4, "UTF-8");
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
        protected void onPostExecute(String result) {
if(result.equals("Yes"))
{
    Toast.makeText(context, "Updated Successfully", Toast.LENGTH_LONG).show();
}
            else if(result.equals("No"))
{
    Toast.makeText(context, "Failed to update. Please try again later.", Toast.LENGTH_LONG).show();
}
            else
{
    Toast.makeText(context, "Check your Internet conn and try again!"+result, Toast.LENGTH_LONG).show();
}
        }

    }
    public class Show extends AsyncTask<String, Void, String> {
        private Context context;
private EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18;

        public Show(Context context,EditText e1,EditText e2,EditText e3,EditText e4,EditText e5,EditText e6,EditText e7,EditText e8,EditText e9,EditText e10,EditText e11,EditText e12,EditText e13,EditText e14,EditText e15,EditText e16,EditText e17,EditText e18) {
            this.context = context;
            this.e1 = e1;this.e2 = e2;
            this.e3 = e3;this.e4 = e4;this.e5 = e5;this.e6 = e6;
            this.e7 = e7;this.e8 = e8;this.e9 = e9;this.e10 = e10;
            this.e11 = e11;this.e12 = e12;
            this.e13 = e13;this.e14 = e14;this.e15 = e15;
            this.e16 = e16;this.e17 = e17;this.e18 = e18;
        }

        protected String doInBackground(String... arg0) {
            try {
                String phn = (String)arg0[0];
BigInteger phonepp=new BigInteger(phn);

                String link = "http://mss.site88.net/minniprofile.php";
                String data = "phone" + "=" + phonepp;
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

            //this.e1.setText(result);
           String[] r=result.split(":",result.length());

                this.e1.setText(r[0]);
            this.e2.setText(r[1]);
            this.e3.setText(r[2]);
            this.e4.setText(r[3]);
            this.e5.setText(r[4]);
            this.e6.setText(r[5]);
            this.e7.setText(r[6]);
            this.e8.setText(r[7]);
            this.e9.setText(r[8]);
            this.e10.setText(r[9]);
            this.e11.setText(r[10]);
            this.e12.setText(r[11]);
            this.e13.setText(r[12]);
            this.e14.setText(r[13]);
            this.e15.setText(r[14]);
            this.e16.setText(r[15]);
            this.e17.setText(r[16]);
            this.e18.setText(r[17]);


        }
    }
}
