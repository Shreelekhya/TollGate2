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

public class CreditCard2 extends AppCompatActivity {

    String phone;

    String cardnumber;
    String amount,phn,vt1,vt2,vt3,vt4,tuser;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_credit_card2);
        Intent in=getIntent();
        phone=in.getStringExtra("phn");
        cardnumber=in.getStringExtra("cardnumber");
        amount=in.getStringExtra("amount");
        phn=in.getStringExtra("phn");
        vt1=in.getStringExtra("vt1");
        vt2=in.getStringExtra("vt2");
        vt3=in.getStringExtra("vt3");
        vt4=in.getStringExtra("vt4");
        tuser=in.getStringExtra("tuser");
        t1=(TextView)findViewById(R.id.editText3);


        t1.setText(amount);

    }
    public void signout(View view)
    {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void Next1(View view)
    {

        Intent intent=new Intent(CreditCard2.this, CreditCard3.class);
        // Toast.makeText(context, "Payment Successful", Toast.LENGTH_LONG).show();
        //startActivity(intent);
        new SigninActivity(this).execute(phone, cardnumber, amount);
    }
    public class SigninActivity  extends AsyncTask<String,Void,String> {
        private Context context;
        EditText e1;
        public SigninActivity(Context context) {
            this.context = context;
        }
        protected String doInBackground(String... arg0) {
            try{
                String phone = (String)arg0[0];
                BigInteger ph=new BigInteger(phone);
                String cardnum = (String)arg0[1];
                BigInteger cardnumber=new BigInteger(cardnum);
                String amount1= (String)arg0[2];
                int amount11=Integer.parseInt(amount1);
                String link="http://mss.site88.net/miniproj8.php";
                String data  = "phone" + "=" + ph;
                data += "&" + "cardnumber" + "=" + cardnumber;
                data += "&" + "amount" + "=" +amount11;
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


            if (result.equals("Yes"))
            {
                Intent intent=new Intent(CreditCard2.this, CreditCard3.class);
                Toast.makeText(context, "Payment Successful", Toast.LENGTH_LONG).show();
                intent.putExtra("phn",phone);
                intent.putExtra("amount",amount);
               // intent.putExtra("phn",phn);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3", vt3);
                intent.putExtra("vt4", vt4);
                intent.putExtra("tuser",tuser);
                startActivity(intent);
                CreditCard2.this.finish();
            } else if (result.equals("No")) {
                Intent intent = new Intent(CreditCard2.this, CreditCard.class);
                Toast.makeText(context, "Payment cannot be processed", Toast.LENGTH_LONG).show();
                intent.putExtra("phn", phone);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3",vt3);
                intent.putExtra("vt4", vt4);
                intent.putExtra("tuser",tuser);
                startActivity(intent);
                CreditCard2.this.finish();
            } else
            {
                Intent intent = new Intent(CreditCard2.this, CreditCard.class);
                Toast.makeText(context,result, Toast.LENGTH_LONG).show();
                intent.putExtra("phn",phone);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3",vt3);
                intent.putExtra("vt4", vt4);
                intent.putExtra("tuser",tuser);
                startActivity(intent);
                CreditCard2.this.finish();
            }
        }
    }

}
