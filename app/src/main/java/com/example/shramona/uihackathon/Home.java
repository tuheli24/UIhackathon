package com.example.shramona.uihackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity implements View.OnClickListener{

    private Button buttonproceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        buttonproceed = (Button) findViewById(R.id.buttonProceed);
        buttonproceed.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonproceed) {
            Intent intent = new Intent(Home.this, Feedback.class);
            startActivity(intent);
        }
    }
}
