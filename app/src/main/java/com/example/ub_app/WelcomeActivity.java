package com.example.ub_app;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    private static final int ASK_MULTIPLE_PERMISSION_REQUEST_CODE = 1;
    Button Driverlog,Customerlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Driverlog = findViewById(R.id.driver_butt);
        Customerlog = findViewById(R.id.customer_butt);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.ACCESS_MEDIA_LOCATION,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE

                    },
                    ASK_MULTIPLE_PERMISSION_REQUEST_CODE);
        }


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
