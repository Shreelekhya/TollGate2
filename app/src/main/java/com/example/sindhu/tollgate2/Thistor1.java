package com.example.sindhu.tollgate2;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Thistor1 extends AppCompatActivity {

    String phone,vn1,vn2,vn3,vn4,tuser,vt1,vt2,vt3,vt4;
    TextView t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thistor1);
        Intent in = getIntent();
        phone = in.getStringExtra("phn");
        vn1 = in.getStringExtra("vn1");
        vn2=in.getStringExtra("vn2");
        vn3=in.getStringExtra("vn3");
        vn4=in.getStringExtra("vn4");
        tuser=in.getStringExtra("tuser");
        vt1=in.getStringExtra("vt1");
        vt2=in.getStringExtra("vt2");
        vt3=in.getStringExtra("vt3");
        vt4=in.getStringExtra("vt4");
        t1 = (TextView) findViewById(R.id.textView20);
        t2 = (TextView) findViewById(R.id.textView21);
        t3=(TextView) findViewById(R.id.textView22);
        t4=(TextView) findViewById(R.id.textView23);

        if(vn1.equals("null")&&vn2.equals("null")&&vn3.equals("null")&&vn4.equals("null")) {
            t1.setText("no record found");
        }
        else if(vn2.equals("null")&&vn3.equals("null")&vn4.equals("null"))
            t1.setText(vn1);

        else if(vn3.equals("null")&&vn4.equals("null")) {
            t1.setText(vn1);
            t2.setText(vn2);
        }
        else if(vn4.equals("null")) {
            t1.setText(vn1);
            t2.setText(vn2);
            t3.setText(vn3);
        }
        else
        {
            t1.setText(vn1);
            t2.setText(vn2);
            t3.setText(vn3);
            t4.setText(vn4);
        }

    }
    public void vn1(View view)
    {
        new Thist(this).execute(vn1);
    }
    public void vn2(View view)
    {
        new Thist(this).execute(vn2);
    }
    public void vn3(View view)
    {
        new Thist(this).execute(vn3);
    }
    public void vn4(View view)
    {
        new Thist(this).execute(vn4);
    }
    public void signout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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
    public class Thist extends AsyncTask<String, Void, String> {
        private Context context;
        EditText e2;

        public Thist(Context context) {
            this.context = context;

        }

        protected String doInBackground(String... arg0) {
            try {

                String vnum =(String)arg0[0];;
                String link = "http://mss.site88.net/thist2.php";
                String data = URLEncoder.encode("vnum", "UTF-8") + "=" + URLEncoder.encode(vnum, "UTF-8");

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
                return sb.toString().trim();
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            String[] ro=result.split("/",result.length());
            if (ro[0].equals("Yes")) {
                Intent intent = new Intent(Thistor1.this, Thistor2.class);

               //
                int b=ro.length;
                String idA[]=new String[b-1];String[] TS=new String[b-1];String[] v_num=new String[b-1];
                String amtD[]=new String[b-1];
                for(int i=1;i<b;i++)
                {
                    String[] r1=ro[i].split(";",ro[i].length());

                 idA[i-1]=r1[0];
                    v_num[i-1]=r1[1];
                    TS[i-1]=r1[2];
                    amtD[i-1]=r1[3];
                }
                Bundle b1=new Bundle();
                b1.putStringArray("TSA", TS);
                //intent.putExtras(b1);
                //Bundle b2=new Bundle();
                b1.putStringArray("idA", idA);
                b1.putStringArray("vnumA",v_num);
                b1.putStringArray("amtDA",amtD);
                intent.putExtras(b1);

                intent.putExtra("phn", phone);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3", vt3);
                intent.putExtra("vt4", vt4);
                intent.putExtra("tuser",tuser);
                startActivity(intent);
                Thistor1.this.finish();
            } else if (ro[0].equals("No")) {
                // e1.setText(r[0]);
                Intent intent = new Intent(Thistor1.this, MainPage.class);
                Toast.makeText(context, "No history found!", Toast.LENGTH_LONG).show();
                intent.putExtra("phn",phone);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3", vt3);
                intent.putExtra("vt4", vt4);
                intent.putExtra("tuser",tuser);
                startActivity(intent);
                Thistor1.this.finish();
            } else {
                Intent intent = new Intent(Thistor1.this, MainPage.class);
                Toast.makeText(context, "Exception" + ro[0], Toast.LENGTH_LONG).show();
                intent.putExtra("phn",phone);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3", vt3);
                intent.putExtra("vt4", vt4);
                intent.putExtra("tuser",tuser);
                startActivity(intent);
                Thistor1.this.finish();
            }
        }
    }



}
