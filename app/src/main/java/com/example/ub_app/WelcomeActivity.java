package com.example.ub_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    Button Driverlog,Customerlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Driverlog = findViewById(R.id.driver_butt);
        Customerlog = findViewById(R.id.customer_butt);


        Driverlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this,DriverLoginRegisterActivity.class);
                startActivity(intent);
            }
        });

        Customerlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this,CustomerLoginRegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
