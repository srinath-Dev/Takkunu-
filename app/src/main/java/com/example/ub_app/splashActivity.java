package com.example.ub_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread()
        {
            @Override
            public void run() {
                try
                {
                    sleep(3000);
                }
                catch (Exception e){
                    e.printStackTrace();

                }
                finally {

                    Intent welcomeintent = new Intent(splashActivity.this,WelcomeActivity.class);
                    startActivity(welcomeintent);

                }
            }
        };

        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
