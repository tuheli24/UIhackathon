package com.example.shramona.uihackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.shramona.uihackathon.R.id.buttonLogin;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private Button buttonLogin;
   private TextView reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(this);
        reg = (TextView)findViewById(R.id.reg);
        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonLogin) {
            Intent intent = new Intent(Login.this, empadd.class);
            startActivity(intent);
        } if(v == reg) {
            Intent intent1 = new Intent(Login.this, registration.class);
            startActivity(intent1);
        }
    }

    }

