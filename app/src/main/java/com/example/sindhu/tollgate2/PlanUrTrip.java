package com.example.sindhu.tollgate2;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class PlanUrTrip extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

   static EditText DateEdit;
String phn,vt1,vt2,vt3,vt4,tuser;
    Spinner s1,s2,from,to;
   public EditText nt,twoWcost,threeWcost,fourWLcost,fourWHcost;
String f,t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_ur_trip);
        Intent in =getIntent();
        phn=in.getStringExtra("phn");
        vt1=in.getStringExtra("vt1");
        vt2=in.getStringExtra("vt2");
        vt3=in.getStringExtra("vt3");
        vt4=in.getStringExtra("vt4");
        tuser=in.getStringExtra("tuser");

        from = (Spinner) findViewById(R.id.from);
        from.setOnItemSelectedListener(this);
        List<String> list = new ArrayList<String>();
        list.add("Hyderabad");
        list.add("Vellore");
        list.add("Pallikonda");
        list.add("Bangalore");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,list);

        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        from.setAdapter(dataAdapter);

        // Spinner item selection Listener
        //addListenerOnSpinnerItemSelection();
       s1 = (Spinner) findViewById(R.id.from);

        to = (Spinner) findViewById(R.id.to);
        from.setOnItemSelectedListener(this);
        List<String> list2 = new ArrayList<String>();
        list2.add("Vellore");
        list2.add("Hyderabad");
        list2.add("Pallikonda");
        list2.add("Bangalore");


        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,list);

        dataAdapter2.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        to.setAdapter(dataAdapter2);

        // Spinner item selection Listener
        //addListenerOnSpinnerItemSelection();
        s2 = (Spinner) findViewById(R.id.to);


        DateEdit = (EditText) findViewById(R.id.editText6);
        nt = (EditText) findViewById(R.id.editText7);
        twoWcost = (EditText) findViewById(R.id.editText8);
        threeWcost = (EditText) findViewById(R.id.editText9);
        fourWLcost = (EditText) findViewById(R.id.editText10);
        fourWHcost = (EditText) findViewById(R.id.editText11);
        DateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTruitonDatePickerDialog(v);
            }
        });

    }

    public void displaytolls(View view)
    {
        f= from.getSelectedItem().toString();;
t= to.getSelectedItem().toString();

        new PlanUrTrip2(this,nt,twoWcost,threeWcost,fourWLcost,fourWHcost).execute(phn,f,t,vt1,vt2,vt3,vt4,tuser);
    }
    public void store(View view)
    {
        f= from.getSelectedItem().toString();
        t= to.getSelectedItem().toString();
        if(t.equals(f))
        {
            Toast.makeText(PlanUrTrip.this,"cannot have same from and two places",Toast.LENGTH_LONG).show();
        }
        else
            new book(this).execute(phn,f,t);
    }
    public void signout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public class PlanUrTrip2  extends AsyncTask<String,Void,String> {
        private Context context;
        EditText nts,twoWcosts,threeWcosts,fourWLcosts,fourWHcosts;

        public PlanUrTrip2(Context context,EditText nts,EditText twoWcosts,EditText threeWcosts,EditText fourWLcosts,EditText fourWHcosts) {
            this.context = context;
            this.nts=nts;
            this.twoWcosts=twoWcosts;
            this.threeWcosts=threeWcosts;
            this.fourWLcosts=fourWLcosts;
            this.fourWHcosts=fourWHcosts;

            // this.e1 = e1;
        }
        public String doInBackground(String... arg0) {
            try{
                String phone = (String)arg0[0];
                BigInteger ph=new BigInteger(phone);
                String fr = (String)arg0[1];
                String to = (String)arg0[2];
                String t1 = (String)arg0[3];
                String t2 = (String)arg0[4];
                String t3 = (String)arg0[5];
                String t4 = (String)arg0[6];

String tuser=(String)arg0[7];
                String link="http://mss.site88.net/planurtrip.php";
                String data  = "phone" + "=" + ph;
                data += "&" + URLEncoder.encode("from", "UTF-8") + "=" + URLEncoder.encode(fr, "UTF-8");
                data += "&" + URLEncoder.encode("to", "UTF-8") + "=" + URLEncoder.encode(to, "UTF-8");
                data += "&" + URLEncoder.encode("vt1", "UTF-8") + "=" + URLEncoder.encode(t1, "UTF-8");
                data += "&" + URLEncoder.encode("vt2", "UTF-8") + "=" + URLEncoder.encode(t2, "UTF-8");
                data += "&" + URLEncoder.encode("vt3", "UTF-8") + "=" + URLEncoder.encode(t3, "UTF-8");
                data += "&" + URLEncoder.encode("vt4", "UTF-8") + "=" + URLEncoder.encode(t4, "UTF-8");
                data += "&" + URLEncoder.encode("tuser", "UTF-8") + "=" + URLEncoder.encode(tuser, "UTF-8");



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
                this.nts.setText(r[3]);
                this.twoWcosts.setText(r[4]);
                this.threeWcosts.setText(r[5]);
                this.fourWLcosts.setText(r[6]);
                this.fourWHcosts.setText(r[7]);
            } else
            {
                Intent intent = new Intent(PlanUrTrip.this, MainPage.class);
                Toast.makeText(context, r[0]+"Cannot have same from and to place...", Toast.LENGTH_LONG).show();
                intent.putExtra("phn", phn);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3",vt3);
                intent.putExtra("vt4", vt4);
                intent.putExtra("tuser", tuser);
                startActivity(intent);
                PlanUrTrip.this.finish();
            }
        }
    }

    public class book extends AsyncTask<String,Void,String> {
        private Context context;
        EditText e1;
        public book(Context context) {
            this.context = context;
        }
        protected String doInBackground(String... arg0) {
            try{
                String phone = (String)arg0[0];
                BigInteger ph=new BigInteger(phone);
                String f = (String)arg0[1];
                String t = (String)arg0[2];
                String link="http://mss.site88.net/book.php";
                String data  = "phone" + "=" + ph;
                data += "&" + URLEncoder.encode("f", "UTF-8") + "=" + URLEncoder.encode(f, "UTF-8");
                data += "&" + URLEncoder.encode("t", "UTF-8") + "=" + URLEncoder.encode(t, "UTF-8");
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
                return sb.toString().trim();
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }
        @Override
        protected void onPostExecute(String res) {

            if(res.equals("yeah"))
            {
                Intent intent=new Intent(PlanUrTrip.this, MainPage.class);
                Toast.makeText(context, "Booked Successfully", Toast.LENGTH_LONG).show();
                intent.putExtra("phn",phn);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3",vt3);
                intent.putExtra("vt4", vt4);
                intent.putExtra("tuser", tuser);
                startActivity(intent);
                PlanUrTrip.this.finish();
            }
            else if (res.equals("nnno")) {
                Intent intent = new Intent(PlanUrTrip.this, MainPage.class);
                Toast.makeText(context, "Could not book,Please try again", Toast.LENGTH_LONG).show();
                intent.putExtra("phn", phn);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3",vt3);
                intent.putExtra("vt4", vt4);
                intent.putExtra("tuser", tuser);
                startActivity(intent);
                PlanUrTrip.this.finish();
            }
            else
            {
                Intent intent = new Intent(PlanUrTrip.this, MainPage.class);
                Toast.makeText(context, "failed!! Please check your internet connection and Try again..."+res, Toast.LENGTH_LONG).show();
                intent.putExtra("phn",phn);
                intent.putExtra("vt1",vt1);
                intent.putExtra("vt2",vt2);
                intent.putExtra("vt3",vt3);
                intent.putExtra("vt4",vt4);
                intent.putExtra("tuser", tuser);
                startActivity(intent);
                PlanUrTrip.this.finish();
            }
        }
    }
    public void showTruitonDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            DateEdit.setText(day + "/" + (month + 1) + "/" + year);
        }
    }



}


