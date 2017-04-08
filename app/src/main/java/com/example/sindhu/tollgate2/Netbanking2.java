package com.example.sindhu.tollgate2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Netbanking2 extends AppCompatActivity {

    String phone,amount,uname,tuser,vt1,vt2,vt3,vt4;
    int flag=0;
    EditText e1;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netbanking2);
        Intent in=getIntent();
        phone=in.getStringExtra("phn");
        amount=in.getStringExtra("amount");
        uname=in.getStringExtra("uname");
        tuser=in.getStringExtra("tuser");
        vt1=in.getStringExtra("vt1");
        vt2=in.getStringExtra("vt2");
        vt3=in.getStringExtra("vt3");
        vt4=in.getStringExtra("vt4");
        t1=(TextView)findViewById(R.id.editText3);
        e1=(EditText)findViewById(R.id.editText);
        t1.setText(amount) ;
    }
    public void signout(View view)
    {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void Net2(View view)
    {
        final String tpass=e1.getText().toString();
        new SigninActivity(this).execute(uname,tpass);

    }
    public class SigninActivity  extends AsyncTask<String,Void,String> {
        private Context context;
        EditText e2;

        public SigninActivity(Context context) {
            this.context = context;

        }
        protected String doInBackground(String... arg0) {
            try{
                String uname=(String)arg0[0];
                String tpass = (String)arg0[1];
                String link="http://mss.site88.net/netbanking2.php";
                String data  = URLEncoder.encode("uname", "UTF-8") + "=" + URLEncoder.encode(uname, "UTF-8");
                data += "&" + URLEncoder.encode("tpass", "UTF-8") + "=" + URLEncoder.encode(tpass, "UTF-8");

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
        protected void onPostExecute(String result) {
            if (result.equals("Yes")) {
                Toast.makeText(context, "Redirecting....", Toast.LENGTH_LONG).show();

                new Netbank(Netbanking2.this).execute(phone,"1234123412341234123",amount);


            } else if (result.equals("No")) {
                // e1.setText(r[0]);
                Intent intent = new Intent(Netbanking2.this, MainPage.class);
                Toast.makeText(context, "Invalid Details!!please try again", Toast.LENGTH_LONG).show();
                intent.putExtra("phn",phone);
                intent.putExtra("tuser", tuser);
                intent.putExtra("vt1", vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3", vt3);
                intent.putExtra("vt4", vt4);
                startActivity(intent);
                Netbanking2.this.finish();
            } else
            {
                Intent intent = new Intent(Netbanking2.this, MainPage.class);
                Toast.makeText(context, "Exception"+result, Toast.LENGTH_LONG).show();
                intent.putExtra("phn",phone);
                intent.putExtra("tuser", tuser);
                intent.putExtra("vt1", vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3", vt3);
                intent.putExtra("vt4", vt4);
                startActivity(intent);
                Netbanking2.this.finish();
            }
        }
    }
    public class Netbank  extends AsyncTask<String,Void,String> {
        private Context context;
        EditText e2;

        public Netbank(Context context) {
            this.context = context;

        }
        protected String doInBackground(String... arg0) {
            try{
                String phone=(String)arg0[0];
                BigInteger ph=new BigInteger(phone);
                String creditcard = (String)arg0[1];
                int creditcardno=1234556677;
                String amount=(String)arg0[2];
                int amount1=Integer.parseInt(amount);
                String link="http://mss.site88.net/miniproj8.php";
                String data  = "phone" + "=" + ph;
                data += "&" + "cardnumber" + "=" +creditcardno ;
                data += "&" + "amount" + "=" +amount1 ;
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
        protected void onPostExecute(String result) {
            if (result.equals("Yes")) {
                Intent intent = new Intent(Netbanking2.this, Netbanking3.class);
                Toast.makeText(context, "Redirecting....", Toast.LENGTH_LONG).show();
                intent.putExtra("phn", phone);
                intent.putExtra("amount",amount);
                intent.putExtra("tuser", tuser);
                intent.putExtra("vt1", vt1);
                intent.putExtra("vt2", vt2);
                intent.putExtra("vt3", vt3);
                intent.putExtra("vt4", vt4);
                startActivity(intent);
                Netbanking2.this.finish();
            } else if (result.equals("No")) {
                // e1.setText(r[0]);
                Intent intent = new Intent(Netbanking2.this, MainPage.class);
                Toast.makeText(context, "Invalid Details!!please try again", Toast.LENGTH_LONG).show();
                intent.putExtra("phn", phone);
                intent.putExtra("tuser", tuser);
                intent.putExtra("vt1", vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3", vt3);
                intent.putExtra("vt4", vt4);
                startActivity(intent);

                Netbanking2.this.finish();
            } else
            {
                Intent intent = new Intent(Netbanking2.this, MainPage.class);
                Toast.makeText(context, "Exception"+result, Toast.LENGTH_LONG).show();
                intent.putExtra("phn",phone);
                intent.putExtra("tuser", tuser);
                intent.putExtra("vt1", vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3", vt3);
                intent.putExtra("vt4", vt4);
                startActivity(intent);
                Netbanking2.this.finish();
            }
        }
    }
}
