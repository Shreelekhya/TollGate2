package com.example.sindhu.tollgate2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Signup5 extends AppCompatActivity {


    EditText e1,e2,e3,e4;
    TextView t1,t2,t3,t4;
    RadioGroup r1,r2,r3,r4;
    String n,e,ph,pa,rp,h,s,d,st,c,user,lno,ano; String msg;
    String r11,r22,r33,r44,p1,p2,p3,p4,p11,p21;
    int i1,i2,i3,i4;
    boolean inserted;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup5);
        Intent in = getIntent();

        msg = in.getStringExtra("num");
        user = in.getStringExtra("Tuser");
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
        ano = in.getStringExtra("ano");
        t1 = (TextView) findViewById(R.id.textView5);
        t2 = (TextView) findViewById(R.id.textView6);
        t3 = (TextView) findViewById(R.id.textView7);
        t4 = (TextView) findViewById(R.id.textView8);
        e1 = (EditText) findViewById(R.id.editText7);
        e2 = (EditText) findViewById(R.id.editText8);
        e3 = (EditText) findViewById(R.id.editText9);
        e4 = (EditText) findViewById(R.id.editText10);
        r1 = (RadioGroup) findViewById(R.id.RadioGroup1);
        r2 = (RadioGroup) findViewById(R.id.RadioGroup2);
        r3 = (RadioGroup) findViewById(R.id.RadioGroup3);
        r4 = (RadioGroup) findViewById(R.id.RadioGroup4);


        //flag=0;
        if (msg.equals("1")) {

            e2.setVisibility(View.INVISIBLE);
            t2.setVisibility(View.INVISIBLE);
            r2.setVisibility(View.INVISIBLE);
            e3.setVisibility(View.INVISIBLE);
            t3.setVisibility(View.INVISIBLE);
            r3.setVisibility(View.INVISIBLE);
            e4.setVisibility(View.INVISIBLE);
            t4.setVisibility(View.INVISIBLE);
            r4.setVisibility(View.INVISIBLE);



        }
        else if (msg.equals("2")) {

            e3.setVisibility(View.INVISIBLE);
            t3.setVisibility(View.INVISIBLE);
            r3.setVisibility(View.INVISIBLE);
            e4.setVisibility(View.INVISIBLE);
            t4.setVisibility(View.INVISIBLE);
            r4.setVisibility(View.INVISIBLE);

        }
        else if (msg.equals("3")) {

            e4.setVisibility(View.INVISIBLE);
            t4.setVisibility(View.INVISIBLE);
            r4.setVisibility(View.INVISIBLE);


        }
    }

    public void Next5(View view) {
        int flag1=0,flag2=0;

        if(msg.equals("1")) {
            i1 = r1.getCheckedRadioButtonId();
            final String V1 = e1.getText().toString();

            if (i1 == -1) {
                flag1++;
                Toast.makeText(this, "Please Choose one option", Toast.LENGTH_SHORT).show();
            }
            if ( V1.equals("")) {
                e1.setError("Null values are not allowed");
                flag2++;
            }
        }
        else  if(msg.equals("2")) {
            i1 = r1.getCheckedRadioButtonId();
            final String V1 = e1.getText().toString();
            i2 = r2.getCheckedRadioButtonId();
            final String V2 = e2.getText().toString();

            if (i1 == -1 || i2==-1) {
                flag1++;
                Toast.makeText(this, "Please Choose one option", Toast.LENGTH_SHORT).show();
            }
            if (V1.equals("")) {
                e1.setError("Null values are not allowed");
                flag2++;
            }
            if (V2.equals("")) {
                e2.setError("Null values are not allowed");
                flag2++;
            }
        }
        else if(msg.equals("3")) {
            i1 = r1.getCheckedRadioButtonId();
            final String V1 = e1.getText().toString();
            i2 = r2.getCheckedRadioButtonId();
            final String V2= e2.getText().toString();
            i3 = r3.getCheckedRadioButtonId();
            final String V3 = e3.getText().toString();

            if (i1 == -1 || i2 == -1 || i3==-1) {
                flag1++;
                Toast.makeText(this, "Please Choose one option", Toast.LENGTH_SHORT).show();
            }
            if ( V1.equals("")) {
                e1.setError("Null values are not allowed");
                flag2++;
            }
            if ( V2.equals("")) {
                e2.setError("Null values are not allowed");
                flag2++;
            }
            if (V3.equals("")) {
                e3.setError("Null values are not allowed");
                flag2++;
            }

        }

        else
        {

            i1 = r1.getCheckedRadioButtonId();
            final String V1 = e1.getText().toString();
            i2 = r2.getCheckedRadioButtonId();
            final String V2= e2.getText().toString();
            i3 = r3.getCheckedRadioButtonId();
            final String V3 = e3.getText().toString();
            i4 = r4.getCheckedRadioButtonId();
            final String V4 = e4.getText().toString();
            if (i1 == -1 || i2 == -1 || i3==-1 || i4 == -1) {
                flag1++;
                Toast.makeText(this, "Please Choose one option", Toast.LENGTH_SHORT).show();
            }
            if (V1.equals("")) {
                e1.setError("Null values are not allowed");
                flag2++;
            }
            if ( V2.equals("")) {
                e2.setError("Null values are not allowed");
                flag2++;
            }
            if ( V3.equals("")) {
                e3.setError("Null values are not allowed");
                flag2++;
            }
            if ( V4.equals("")) {
                e4.setError("Null values are not allowed");
                flag2++;
            }

        }
        if(flag1 == 0 && flag2==0) {

            if(msg.equals("1"))
            {
                r11 = ((RadioButton) findViewById(r1.getCheckedRadioButtonId())).getText().toString();

                p1 = e1.getText().toString();

                r22= "null";
                p2 = "null";
                r33= "null";
                p3 = "null";
                r44= "null";
                p4 = "null";
}
            else if(msg.equals("2"))
            {
                r11 = ((RadioButton) findViewById(r1.getCheckedRadioButtonId())).getText().toString();
                r22 = ((RadioButton) findViewById(r2.getCheckedRadioButtonId())).getText().toString();

                p1 = e1.getText().toString();
                p2 = e2.getText().toString();

                r33= "null";
                p3 = "null";
                r44= "null";
                p4 = "null";

            }
            else if(msg.equals("3")) {
                r11 = ((RadioButton) findViewById(r1.getCheckedRadioButtonId())).getText().toString();
                r22 = ((RadioButton) findViewById(r2.getCheckedRadioButtonId())).getText().toString();
                r33 = ((RadioButton) findViewById(r3.getCheckedRadioButtonId())).getText().toString();

                p1 = e1.getText().toString();
                p2 = e2.getText().toString();
                p3 = e3.getText().toString();

                r44= "null";
                p4 = "null";

            }
            else
            {
                r11 = ((RadioButton) findViewById(r1.getCheckedRadioButtonId())).getText().toString();
                r22 = ((RadioButton) findViewById(r2.getCheckedRadioButtonId())).getText().toString();
                r33 = ((RadioButton) findViewById(r3.getCheckedRadioButtonId())).getText().toString();
                r44 = ((RadioButton) findViewById(r4.getCheckedRadioButtonId())).getText().toString();
                p1 = e1.getText().toString();
                p2 = e2.getText().toString();
                p3 = e3.getText().toString();
                p4 = e4.getText().toString();

            }

           new SignupActivity(this,e1).execute(n, e, ph, pa, h, s, d, st, c,lno,ano, user, msg, r11, p1, r22, p2, r33, p3, r44, p4);


        }


    }
    private boolean isValidVehicle(String v) {
        String VEHICLE_PATTERN = "^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}$";

        Pattern pattern = Pattern.compile(VEHICLE_PATTERN);
        Matcher matcher = pattern.matcher(v);
        return matcher.matches();
    }
    public class SignupActivity  extends AsyncTask<String,Void,String> {
        private Context context;
        EditText e1;

        public SignupActivity(Context context,EditText e1) {
            this.context = context;
            this.e1 = e1;
        }
        protected String doInBackground(String... arg0) {
            try{
                String name = (String)arg0[0];
                String email = (String)arg0[1];
                String phone = (String)arg0[2];
                BigInteger ph = new BigInteger(phone);
                String passw = (String)arg0[3];
                String hnumber= (String)arg0[4];
                String street = (String)arg0[5];
                String district = (String)arg0[6];
                String state = (String)arg0[7];
                String country = (String)arg0[8];

                String lno = (String)arg0[9];
                String ano = (String)arg0[10];
                String type_of_user = (String)arg0[11];
                String num_v = (String)arg0[12];
                int num_ve = Integer.parseInt(num_v);
                String vt1 = (String)arg0[13];
                String vn1 = (String)arg0[14];
                String vt2 = (String)arg0[15];
                String vn2 = (String)arg0[16];
                String vt3 = (String)arg0[17];
                String vn3 = (String)arg0[18];
                String  vt4 = (String)arg0[19];
                String vn4 = (String)arg0[20];

                String link="http://mss.site88.net/minit1.php";
                String data  = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
                data += "&" + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8");
                data += "&" + "phone" + "=" + ph;
                data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(passw, "UTF-8");
                data += "&" + URLEncoder.encode("hnumber", "UTF-8") + "=" + URLEncoder.encode(hnumber, "UTF-8");
                data += "&" + URLEncoder.encode("street", "UTF-8") + "=" + URLEncoder.encode(street, "UTF-8");
                data += "&" + URLEncoder.encode("district", "UTF-8") + "=" + URLEncoder.encode(district, "UTF-8");
                data += "&" + URLEncoder.encode("state", "UTF-8") + "=" + URLEncoder.encode(state, "UTF-8");
                data += "&" + URLEncoder.encode("country", "UTF-8") + "=" + URLEncoder.encode(country, "UTF-8");

                data += "&" + URLEncoder.encode("lno", "UTF-8") + "=" + URLEncoder.encode(lno, "UTF-8");
                data += "&" + URLEncoder.encode("ano", "UTF-8") + "=" + URLEncoder.encode(ano, "UTF-8");
                data += "&" + URLEncoder.encode("tuser", "UTF-8") + "=" + URLEncoder.encode(type_of_user, "UTF-8");
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

            //this.e1.setText(result);
            if (result.equals("Succesfully registered!")) {
                Intent intent = new Intent(Signup5.this, MainActivity.class);
                Toast.makeText(context, "You have Succesfully registered!! signin to access the facilities...", Toast.LENGTH_LONG).show();
                startActivity(intent);
                Signup5.this.finish();
            } else if (result.equals("not registered")) {
                Intent intent = new Intent(Signup5.this, MainActivity.class);
                Toast.makeText(context, "Phone number already exists!! Try again...", Toast.LENGTH_LONG).show();
                startActivity(intent);
                Signup5.this.finish();
            } else
            {
                Intent intent = new Intent(Signup5.this, MainActivity.class);
                Toast.makeText(context, "Registration failed!! Please check your internet connection and Try again..."+e, Toast.LENGTH_LONG).show();
                startActivity(intent);
                Signup5.this.finish();
            }
        }
    }

}
