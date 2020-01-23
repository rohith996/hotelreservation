package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class adminactivity extends AppCompatActivity {
    private TextView admin;
    private EditText etusername;
    private EditText etpassword;
    private Button login;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminactivity);
        admin = (TextView)findViewById(R.id.textView);
        etusername = (EditText)findViewById(R.id.editText);
        etpassword = (EditText)findViewById(R.id.editText2);
        login = (Button)findViewById(R.id.button);
        image = (ImageView)findViewById(R.id.imageView);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = etusername.getText().toString();
                String upwd = etpassword.getText().toString();
                if (uname.equals("rohith")&&upwd.equals("12345")){
                    Intent i = new Intent(adminactivity.this,adminpage.class);
                    startActivity(i);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Incorrect Credentials",Toast.LENGTH_SHORT).show();
                }






            }
        });

    }
}
