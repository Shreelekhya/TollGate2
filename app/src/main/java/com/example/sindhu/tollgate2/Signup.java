package com.example.sindhu.tollgate2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        e1=(EditText) findViewById(R.id.editText);
        e2=(EditText) findViewById(R.id.editText2);
        e3=(EditText) findViewById(R.id.editText3);
        e4=(EditText) findViewById(R.id.editText4);
        e5=(EditText) findViewById(R.id.editText5);
    }
    public void Next1(View view) {
        final String name = e1.getText().toString();
        final String email = e2.getText().toString();
        final String phone = e3.getText().toString();
        final String password = e4.getText().toString();
        final String rpassword = e5.getText().toString();
        int flag=0;
        // String empt=null;
        if(name.equals("")) {
            e1.setError("name cannot be null");
            flag++;
        }
        else if (!isValidName(name)) {
            e1.setError("only alphabets");
            flag++;
        }
        if(email.equals("")) {
            e2.setError("email cannot be null");
            flag++;
        }
        else if (!isValidEmail(email)) {
            e2.setError("Invalid Forrmat");
            flag++;
        }
        if(phone.equals("")) {
            e3.setError("phone number cannot be null");
            flag++;
        }
        else if (!isValidPhone(phone)) {
            e3.setError("Only Numbers");
            flag++;
        }
        if(password.equals("")) {
            e4.setError("password cannot be null");
            flag++;
        }
        else if (!isValidPassword(password)) {
            e4.setError("Length should be greater than 6");
            flag++;
        }
        if(rpassword.equals("")) {
            e5.setError("password cannot be null");
            flag++;
        }
        else if (!rpassword.equals(password)) {
            e5.setError("Password Mismatch");
            flag++;
        }

        if(flag == 0)
        {
            Intent intent = new Intent(this, Signup2.class);
            intent.putExtra("name", name);
            intent.putExtra("email", email);
            intent.putExtra("phone", phone);
            intent.putExtra("password", password);
            intent.putExtra("rpassword", rpassword);
            startActivity(intent);
        }
    }
    private boolean isValidName(String name) {
        String NAME_PATTERN = "^[A-Za-z+]+$";

        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[A-Za-z0-9]+(\\.[_A-Za-z0-9-]+)*@+[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private boolean isValidPhone(String number) {
        String NUMBER_PATTERN = "^[0-9]{10}$";

        Pattern pattern = Pattern.compile(NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
    private boolean isValidPassword(String password)
    {
        if (password != null && password.length() > 6) {
            return true;
        }
        return false;
    }

}
