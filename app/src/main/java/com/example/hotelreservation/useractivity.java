package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class useractivity extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" + "(?=.*[a-zA-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$)" + ".{4,}" + "$");
    private TextView user;
    private EditText etusername;
    private EditText etpassword;
    private Button login;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useractivity);
        user = (TextView) findViewById(R.id.textView2);
        etusername = (EditText) findViewById(R.id.editText3);
        etpassword = (EditText) findViewById(R.id.editText4);
        login = (Button) findViewById(R.id.button2);
        image = (ImageView) findViewById(R.id.imageView3);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateEmail() & validatePassword()){
                    Intent i = new Intent(useractivity.this,userpage.class);
                    startActivity(i);
                }

            }
        });
    }

    private boolean validateEmail() {
        String email = etusername.getEditableText().toString().trim();
        if (email.isEmpty()) {
            etusername.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etusername.setError("please enter a valid email address");
            return false;
        } else {
            etusername.setError(null);
            return true;
        }


    }

    private boolean validatePassword() {
        String pwd = etpassword.getEditableText().toString().trim();

        if (pwd.isEmpty()) {
            etpassword.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(pwd).matches()) {
            etpassword.setError("Password too weak");
            return false;
        } else {
            etpassword.setError(null);
            return true;
        }
    }

}