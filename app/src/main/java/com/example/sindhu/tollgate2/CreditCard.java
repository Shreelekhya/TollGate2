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
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCard extends AppCompatActivity {

    EditText e1,e2,e3;
    TextView t1;
    String phone,tuser,phn,vt1,vt2,vt3,vt4;
    String cardnumber1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card);
        Intent in=getIntent();
        phn=in.getStringExtra("phn");
        phone=in.getStringExtra("phn");
        vt1=in.getStringExtra("vt1");
        vt2=in.getStringExtra("vt2");
        vt3=in.getStringExtra("vt3");
        vt4=in.getStringExtra("vt4");
        tuser=in.getStringExtra("tuser");
        e1=(EditText) findViewById(R.id.editText);
        e2=(EditText) findViewById(R.id.editText2);
        e3=(EditText) findViewById(R.id.editText3);


    }
    public void signout(View view)
    {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void Next1(View view)
    {
        //t1.setText(phone);
        final String cardnumber = e1.getText().toString();
        final String expiration = e2.getText().toString();
        final String cvv = e3.getText().toString();

        int flag=0;
        // String empt=null;
        if(cardnumber.equals("")) {
            e1.setError("cardnumber cannot be null");
            flag++;
        }
        else if (!isValidNumber(cardnumber)) {
            e1.setError("only numbers");
            flag++;
        }
        if(expiration.equals("")) {
            e2.setError("ExpirationDate cannot be null");
            flag++;
        }
               /* else if (!isValidExpiration(expiration)) {
                    e2.setError("Invalid Forrmat");
                    flag++;
                }*/
        if(cvv.equals("")) {
            e3.setError("cvv cannot be null");
            flag++;
        }
        else if (!isValidCvv(cvv)) {
            e3.setError("Only Numbers");
            flag++;
        }


        if(flag == 0)
        {
            //Intent intent = new Intent(this, Signup2.class);
            new SigninActivity(this).execute(cardnumber,cvv);
            //startActivity(intent);
        }
    }
    private boolean isValidNumber(String cardnumber) {
        String NAME_PATTERN = "^[0-9]+$";

        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(cardnumber);
        return matcher.matches();
    }
    /* private boolean isValidExpiration(String expiration) {
         String EMAIL_PATTERN = "^[0-9]{2}(\\/)[0-9]{2}]$";

         Pattern pattern = Pattern.compile(EMAIL_PATTERN);
         Matcher matcher = pattern.matcher(expiration);
         return matcher.matches();
     }*/
    private boolean isValidCvv(String cvv) {
        String NUMBER_PATTERN = "^[0-9]{3}$";

        Pattern pattern = Pattern.compile(NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(cvv);
        return matcher.matches();
    }
    public class SigninActivity  extends AsyncTask<String,Void,String> {
        private Context context;
        EditText e2;

        public SigninActivity(Context context) {
            this.context = context;

        }
        protected String doInBackground(String... arg0) {
            try{

                String cardnum = (String)arg0[0];
                BigInteger creditcardno=new BigInteger(cardnum);
                // String expirationdate= (String)arg0[1];
                String cvv1= (String)arg0[1];
                int cvv=Integer.parseInt(cvv1);
                String link="http://mss.site88.net/miniproj3.php";
                String data  = "creditcardno" + "=" + creditcardno;
                // data += "&" + URLEncoder.encode("expirationdate", "UTF-8") + "=" + URLEncoder.encode(expirationdate, "UTF-8");
                data += "&" + "cvv" + "=" + cvv;

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
            String[] ro=result.split(" ",result.length());

            if (ro[0].equals("Yes")) {
                Intent intent = new Intent(CreditCard.this, CreditCard2.class);
                Toast.makeText(context, "Redirecting....", Toast.LENGTH_LONG).show();
                intent.putExtra("phn",phone);
                //intent.putExtra("phn",phn);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3",vt3);
                intent.putExtra("vt4", vt4);
                intent.putExtra("tuser",tuser);
                intent.putExtra("cardnumber",ro[1]);

                if(tuser.equals("Normal user"))
                {
                    String amount="700";
                    intent.putExtra("amount",amount);
                }
                if(tuser.equals("Cab owner"))
                {
                    String amount="1000";
                    intent.putExtra("amount",amount);
                }
                if(tuser.equals("Government user"))
                {
                    String amount="500";
                    intent.putExtra("amount",amount);
                }
                startActivity(intent);
                CreditCard.this.finish();
            } else if (result.equals("No")) {
                // e1.setText(r[0]);
                Intent intent = new Intent(CreditCard.this, MainPage.class);
                Toast.makeText(context, "Invalid Details!!please try again", Toast.LENGTH_LONG).show();
                intent.putExtra("phn",phn);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3",vt3);
                intent.putExtra("vt4",vt4);
                intent.putExtra("tuser", tuser);
                intent.putExtra("phn", phone);
                startActivity(intent);
                CreditCard.this.finish();
            } else
            {
                Intent intent = new Intent(CreditCard.this, MainPage.class);
                Toast.makeText(context, "Exception", Toast.LENGTH_LONG).show();
                intent.putExtra("phn",phn);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3",vt3);
                intent.putExtra("vt4",vt4);
                intent.putExtra("tuser",tuser);
                intent.putExtra("phn",phone);
                startActivity(intent);
                CreditCard.this.finish();
            }
        }
    }
}
