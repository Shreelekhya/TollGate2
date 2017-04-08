package com.example.sindhu.tollgate2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Signup2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText e1, e2, e3;
    Spinner e4;
    String n,e,ph,pa,rp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        Intent in = getIntent();
        n = in.getStringExtra("name");
        e = in.getStringExtra("email");
        ph = in.getStringExtra("phone");
        pa = in.getStringExtra("password");
        rp = in.getStringExtra("rpassword");
        e1 = (EditText) findViewById(R.id.editText6);
        e2 = (EditText) findViewById(R.id.Street);
        e3 = (EditText) findViewById(R.id.district);
        Spinner state = (Spinner) findViewById(R.id.state);
        state.setOnItemSelectedListener(this);
        List<String> list = new ArrayList<String>();
        list.add("AndhraPradesh");
        list.add("Arunachal Pradesh");
        list.add("Bihar");
        list.add("Goa");
        list.add("West Bengal");
        list.add("Maharstra");
        list.add("Kerala");
        list.add("Uttar Pradesh");
        list.add("Tamil Nadu");
        list.add("Telangana");
        list.add("Uttaranchal");
        list.add("Meghalaya");
        list.add("Mizoram");
        list.add("Madhya Pradesh");
        list.add("Karnatakaa");
        list.add("Manipur");
        list.add("Rajasthan");
        list.add("Jammu and Kashmir");
        list.add("Tripura");
        list.add("Nagaland");
        list.add("Odissa");
        list.add("Jharkhand");
        list.add("Himachal Pradesh");
        list.add("Haryana");
        list.add("Gujarath");
        list.add("Sikkim");
        list.add("Punjab");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,list);

        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        state.setAdapter(dataAdapter);

        // Spinner item selection Listener
        //addListenerOnSpinnerItemSelection();
        e4 = (Spinner) findViewById(R.id.state);

    }

    public void Next2(View view) {
        final String hnumber = e1.getText().toString();
        final String street = e2.getText().toString();
        final String district = e3.getText().toString();
        final String state = e4.getSelectedItem().toString();
        final String country ="India";
        int flag = 0;
        //String empt=null;

        if(hnumber.equals(""))
        {e1.setError("name cannot be null");
            flag++;
        }
        if (street.equals("")) {
            e2.setError("name cannot be null");
            flag++;
        }
        if (district.equals("")) {
            e3.setError("name cannot be null");
            flag++;
        }
        if (state.equals("")) {
            Toast.makeText(this, "please choose the State", Toast.LENGTH_SHORT).show();
            flag++;
        }
       /* if (country.equals("")) {
            e5.setError("name cannot be null");
            flag++;
        }*/
        if (flag == 0) {
            Intent intent = new Intent(this, Signup31.class);

            intent.putExtra("name", n);
            intent.putExtra("email", e);
            intent.putExtra("phone", ph);
            intent.putExtra("password", pa);
            intent.putExtra("rpassword", rp);
            intent.putExtra("hnumber", hnumber);
            intent.putExtra("street", street);
            intent.putExtra("district", district);
            intent.putExtra("state", state);
            intent.putExtra("country", country);
            startActivity(intent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
