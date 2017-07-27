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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonLogin) {
            Intent intent = new Intent(Login.this, Home.class);
            startActivity(intent);
        }
    }

}


