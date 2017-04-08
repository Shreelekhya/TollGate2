package com.example.sindhu.tollgate2;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
dhvk fgcghvi
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Admin2 extends AppCompatActivity {
    String id, loc, id2, loc2,num1,time,new_amt,p;
    ListView listItemView;
    ImageButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    // Define string array.
    String[] listItemsValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2);
        Intent in = getIntent();
        id = in.getStringExtra("admin");
        loc = in.getStringExtra("location");
       t1=(TextView) findViewById(R.id.textView21);
        t2=(TextView) findViewById(R.id.textView22);
        t3=(TextView) findViewById(R.id.textView23);
        t4=(TextView) findViewById(R.id.textView24);
        t5=(TextView) findViewById(R.id.textView25);
        t6=(TextView) findViewById(R.id.textView26);
        t7=(TextView) findViewById(R.id.textView27);
        t8=(TextView) findViewById(R.id.textView28);
        t9=(TextView) findViewById(R.id.textView29);
        t10=(TextView) findViewById(R.id.textView30);
        b1=(ImageButton) findViewById(R.id.imageButton2);
        b2=(ImageButton) findViewById(R.id.imageButton3);
        b3=(ImageButton) findViewById(R.id.imageButton4);
        b4=(ImageButton) findViewById(R.id.imageButton5);
        b5=(ImageButton) findViewById(R.id.imageButton6);
        b6=(ImageButton) findViewById(R.id.imageButton7);
        b7=(ImageButton) findViewById(R.id.imageButton8);
        b8=(ImageButton) findViewById(R.id.imageButton9);
        b9=(ImageButton) findViewById(R.id.imageButton10);
        b10=(ImageButton) findViewById(R.id.imageButton11);
        new vehicle_data(this,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10).execute(id, loc);
    }
    public void signout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void verify1(View view)
    {
        String p1=t1.getText().toString();

        String[] r = p1.split(";", p1.length());
       // String pa=t2.getText().toString();
       // new deduct(this).execute(r[0],r[1]);
        Intent in=new Intent(this,Admin3.class);
        in.putExtra("phn","9629766763");
        in.putExtra("amt","150");
        startActivity(in);
    }
    public void verify2(View view)
    {
        String p2=t2.getText().toString();
        String[] r2 = p2.split(";", p2.length());
        // String pa=t2.getText().toString();
       // new deduct(this).execute(r2[0],r2[1]);
        Intent in=new Intent(this,Admin3.class);
        in.putExtra("phn","7845848839");
        in.putExtra("amt","150");
        startActivity(in);
    }
    public void verify3(View view)
    {
        String p1=t3.getText().toString();
        String[] r = p1.split(";", p1.length());
        // String pa=t2.getText().toString();
       // new deduct(this).execute(r[0],r[1]);
        Intent in=new Intent(this,Admin3.class);
        in.putExtra("phn","9629766763");
        in.putExtra("amt","150");
        startActivity(in);
    }
    public void verify4(View view)
    {
        String p1=t4.getText().toString();
        String[] r = p1.split(";", p1.length());
        // String pa=t2.getText().toString();
       // new deduct(this).execute(r[0],r[1]);
        Intent in=new Intent(this,Admin3.class);
        in.putExtra("phn","7845848823");
        in.putExtra("amt","150");
        startActivity(in);
    }
    public void verify5(View view)
    {
        String p1=t5.getText().toString();
        String[] r = p1.split(";", p1.length());
        // String pa=t2.getText().toString();
       // new deduct(this).execute(r[0],r[1]);
        Intent in=new Intent(this,Admin3.class);
        in.putExtra("phn","9629766763");
        in.putExtra("amt","150");
        startActivity(in);
    }
    public void verify6(View view)
    {
        String p1=t6.getText().toString();
        String[] r = p1.split(";", p1.length());
        // String pa=t2.getText().toString();
        new deduct(this).execute(r[0],r[1]);
    }
    public void verify7(View view)
    {
        String p1=t7.getText().toString();
        String[] r = p1.split(";", p1.length());
        // String pa=t2.getText().toString();
        new deduct(this).execute(r[0],r[1]);
    }
    public void verify8(View view)
    {
        String p1=t8.getText().toString();
        String[] r = p1.split(";", p1.length());
        // String pa=t2.getText().toString();
        new deduct(this).execute(r[0],r[1]);
    }
    public void verify9(View view)
    {
        String p1=t9.getText().toString();
        String[] r = p1.split(";", p1.length());
        // String pa=t2.getText().toString();
        new deduct(this).execute(r[0],r[1]);

    }
    public void verify10(View view)
    {
        String p1=t10.getText().toString();
        String[] r = p1.split(";", p1.length());
        // String pa=t2.getText().toString();
        new deduct(this).execute(r[0],r[1]);
    }
    public class deduct extends AsyncTask<String, Void, String> {
        private Context context;
        public deduct(Context context) {
            this.context = context;
        }

        public String doInBackground(String... arg0) {
            try {
                num1 = (String) arg0[0];
time=(String) arg0[1];
                String link = "http://mss.site88.net/deduct.php";
                String  data = URLEncoder.encode("num", "UTF-8") + "=" + URLEncoder.encode(num1, "UTF-8");


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
                String phn=r[1];
                String amt=r[2];
String d=r[3];
                int amount=Integer.parseInt(amt);
                int dec=Integer.parseInt(d);
                int l_amt=amount-dec;
                String n_amt=Integer.toString(l_amt);
               // int phone=Integer.parseInt(phn);

               // String message = "Your vehicle" + t1 +" has passed the toll gate at "+time+". Your wallet is debited by Rs."+dec+"for toll payment. Thank You for using this app";
                //sendsms(phn, message);

                Intent intent = new Intent(Admin2.this, Admin3.class);
                intent.putExtra("amt",n_amt);
                intent.putExtra("phn",phn);
                Toast.makeText(context, "Checking...", Toast.LENGTH_LONG).show();
                startActivity(intent);
                Admin2.this.finish();
            } else if (r[0].equals("No")) {
                Intent intent = new Intent(Admin2.this, MainActivity.class);
                Toast.makeText(context, "Some error! You might have already updated this.", Toast.LENGTH_LONG).show();
                startActivity(intent);
                Admin2.this.finish();
            } else {
                Intent intent = new Intent(Admin2.this, MainActivity.class);
                Toast.makeText(context, r[0] + " Please check your internet connection and Try again...", Toast.LENGTH_LONG).show();
                startActivity(intent);
                Admin2.this.finish();
            }
        }

    }

    public class vehicle_data extends AsyncTask<String, Void, String> {
        private Context context;
        EditText e1;
        ListView l1;
        String[] lv;
TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
        ImageButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
        public vehicle_data(Context context,TextView t1,TextView t2,TextView t3,TextView t4,TextView t5,TextView t6,TextView t7,TextView t8,TextView t9,TextView t10,ImageButton b1,ImageButton b2,ImageButton b3,ImageButton b4,ImageButton b5,ImageButton b6,ImageButton b7,ImageButton b8,ImageButton b9,ImageButton b10) {
            this.context = context;
             this.t1 = t1;
            this.t2=t2;
            this.t3=t3;
            this.t4 = t4;
            this.t5=t5;
            this.t6=t6;
            this.t7 = t7;
            this.t8=t8;
            this.t9=t9;
            this.t10=t10;
            this.b1=b1;
            this.b2=b2;
            this.b3=b3;
            this.b4=b4;
            this.b5=b5;
            this.b6=b6;
            this.b7=b7;
            this.b8=b8;
            this.b9=b9;
            this.b10=b10;
        }

        public String doInBackground(String... arg0) {
            try {
                id2 = (String) arg0[0];
                int id3 = Integer.parseInt(id2);
                 loc2 = (String) arg0[1];


                String link = "http://mss.site88.net/vehicle_data.php";
                String data = "id" + "=" + id3;


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
            String[] r = result.split("/", result.length());
            if (r[0].equals("Yes")) {
               int i=r.length;
                if(i==2) {
                    this.t1.setText(r[1]);
                    this.b1.setVisibility(View.VISIBLE);
                }
                if(i==3)
                {
                    this.t1.setText(r[1]);
                    this.t2.setText(r[2]);
                    this.b1.setVisibility(View.VISIBLE);
                    this.b2.setVisibility(View.VISIBLE);
                }
                if(i==4)
                {
                    this.t1.setText(r[1]);
                    this.t2.setText(r[2]);
                    this.t3.setText(r[3]);
                    this.b1.setVisibility(View.VISIBLE);
                    this.b2.setVisibility(View.VISIBLE);
                    this.b3.setVisibility(View.VISIBLE);
                }
                if(i==5)
                {
                    this.t1.setText(r[1]);
                    this.t2.setText(r[2]);
                    this.t3.setText(r[3]);
                    this.t4.setText(r[4]);
                    this.b1.setVisibility(View.VISIBLE);
                    this.b2.setVisibility(View.VISIBLE);
                    this.b3.setVisibility(View.VISIBLE);
                    this.b4.setVisibility(View.VISIBLE);
                }
                if(i==6)
                {
                    this.t1.setText(r[1]);
                    this.t2.setText(r[2]);
                    this.t3.setText(r[3]);
                    this.t4.setText(r[4]);
                    this.t5.setText(r[5]);
                    this.b1.setVisibility(View.VISIBLE);
                    this.b2.setVisibility(View.VISIBLE);
                    this.b3.setVisibility(View.VISIBLE);
                    this.b4.setVisibility(View.VISIBLE);
                    this.b5.setVisibility(View.VISIBLE);
                }
                if(i==7)
                {
                    this.t1.setText(r[1]);
                    this.t2.setText(r[2]);
                    this.t3.setText(r[3]);
                    this.t4.setText(r[4]);
                    this.t5.setText(r[5]);
                    this.t6.setText(r[6]);
                    this.b1.setVisibility(View.VISIBLE);
                    this.b2.setVisibility(View.VISIBLE);
                    this.b3.setVisibility(View.VISIBLE);
                    this.b4.setVisibility(View.VISIBLE);
                    this.b5.setVisibility(View.VISIBLE);
                    this.b6.setVisibility(View.VISIBLE);
                }
                if(i==8)
                {
                    this.t1.setText(r[1]);
                    this.t2.setText(r[2]);
                    this.t3.setText(r[3]);
                    this.t4.setText(r[4]);
                    this.t5.setText(r[5]);
                    this.t6.setText(r[6]);
                    this.t7.setText(r[7]);
                    this.b1.setVisibility(View.VISIBLE);
                    this.b2.setVisibility(View.VISIBLE);
                    this.b3.setVisibility(View.VISIBLE);
                    this.b4.setVisibility(View.VISIBLE);
                    this.b5.setVisibility(View.VISIBLE);
                    this.b6.setVisibility(View.VISIBLE);
                    this.b7.setVisibility(View.VISIBLE);
                }
                if(i==9)
                {
                    this.t1.setText(r[1]);
                    this.t2.setText(r[2]);
                    this.t3.setText(r[3]);
                    this.t4.setText(r[4]);
                    this.t5.setText(r[5]);
                    this.t6.setText(r[6]);
                    this.t8.setText(r[8]);
                    this.t7.setText(r[7]);
                    this.b1.setVisibility(View.VISIBLE);
                    this.b2.setVisibility(View.VISIBLE);
                    this.b3.setVisibility(View.VISIBLE);
                    this.b4.setVisibility(View.VISIBLE);
                    this.b5.setVisibility(View.VISIBLE);
                    this.b6.setVisibility(View.VISIBLE);
                    this.b7.setVisibility(View.VISIBLE);
                    this.b8.setVisibility(View.VISIBLE);
                }
                if(i==10)
                {
                    this.t1.setText(r[1]);
                    this.t2.setText(r[2]);
                    this.t3.setText(r[3]);
                    this.t4.setText(r[4]);
                    this.t5.setText(r[5]);
                    this.t6.setText(r[6]);
                    this.t7.setText(r[7]);
                    this.t8.setText(r[8]);
                    this.t9.setText(r[9]);
                    this.b1.setVisibility(View.VISIBLE);
                    this.b2.setVisibility(View.VISIBLE);
                    this.b3.setVisibility(View.VISIBLE);
                    this.b4.setVisibility(View.VISIBLE);
                    this.b5.setVisibility(View.VISIBLE);
                    this.b6.setVisibility(View.VISIBLE);
                    this.b7.setVisibility(View.VISIBLE);
                    this.b8.setVisibility(View.VISIBLE);
                    this.b9.setVisibility(View.VISIBLE);
                }
                if(i==11)
                {
                    this.t1.setText(r[1]);
                    this.t2.setText(r[2]);
                    this.t3.setText(r[3]);
                    this.t4.setText(r[4]);
                    this.t5.setText(r[5]);
                    this.t6.setText(r[6]);
                    this.t7.setText(r[7]);
                    this.t8.setText(r[8]);
                    this.t9.setText(r[9]);
                    this.t10.setText(r[10]);
                    this.b1.setVisibility(View.VISIBLE);
                    this.b2.setVisibility(View.VISIBLE);
                    this.b3.setVisibility(View.VISIBLE);
                    this.b4.setVisibility(View.VISIBLE);
                    this.b5.setVisibility(View.VISIBLE);
                    this.b6.setVisibility(View.VISIBLE);
                    this.b7.setVisibility(View.VISIBLE);
                    this.b8.setVisibility(View.VISIBLE);
                    this.b9.setVisibility(View.VISIBLE);
                    this.b10.setVisibility(View.VISIBLE);
                }


            } else if (r[0].equals("No")) {
                Intent intent = new Intent(Admin2.this, MainActivity.class);
                Toast.makeText(context, "Invalid id or password", Toast.LENGTH_LONG).show();
                startActivity(intent);
                Admin2.this.finish();
            } else {
                Intent intent = new Intent(Admin2.this, MainActivity.class);
                Toast.makeText(context, r[0] + "Login failed!! Please check your internet connection and Try again...", Toast.LENGTH_LONG).show();
                startActivity(intent);
                Admin2.this.finish();
            }
        }
    }
}