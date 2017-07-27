package com.example.shramona.uihackathon;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    //Set Duration of the Splash Screen
    long Delay = 2000;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        int height = getResources ( ).getDisplayMetrics ( ).heightPixels;
        super.onCreate(savedInstanceState);
        // Remove the Title Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Get the view from splash_activity.xml
        setContentView(R.layout.activity_splash);

        // Create a Timer
        Timer RunSplash = new Timer();

        // Task to do when the timer ends
        TimerTask ShowSplash = new TimerTask() {
            @Override
            public void run() {
                // Close SplashScreenActivity.class
                finish();

                // Start MainActivity.class
                Intent myIntent = new Intent(Splash.this,
                        Login.class);
                startActivity(myIntent);
            }
        };

        // Start the timer
        RunSplash.schedule(ShowSplash, Delay);


        ProgressDialog progressDialog = new ProgressDialog ( this );
// Progress bar message.
        String progressBarMessage = "Loading, please wait...";
        progressDialog.getWindow().setGravity(Gravity.CENTER);
        WindowManager.LayoutParams wmlp = progressDialog.getWindow().getAttributes();
        wmlp.y = height / 4;
        progressDialog.getWindow().setAttributes(wmlp);
        progressDialog.setCancelable(false);

        progressDialog.setCancelable(false);
        progressDialog.setMessage(progressBarMessage);
// set the progress to be horizontal
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
// reset the bar to the default value of 0
        progressDialog.setProgress(0);
// convert the text value to a integer
        int maximum = 100;
// set the maximum value
        progressDialog.setMax(maximum);
// display the progressbar
        progressDialog.show();
    }

}

