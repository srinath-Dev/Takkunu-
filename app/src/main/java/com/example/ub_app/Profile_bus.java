package com.example.ub_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Profile_bus extends AppCompatActivity {


    private EditText name,registerno,source,destination,bustype;
    private Button Placeorder;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference ref;
    EditText autoD8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_bus);

        name = findViewById(R.id.name);
        Placeorder = findViewById(R.id.orderbutt);
        registerno = findViewById(R.id.Reg_number);
        source = findViewById(R.id.from);
        destination = findViewById(R.id.Desti);
        bustype = findViewById(R.id.type_bus);

        firebaseDatabase = FirebaseDatabase.getInstance();
        ref = firebaseDatabase.getReference("BusDetails");

        Placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveToFirebase();

                Intent intent = new Intent(Profile_bus.this, DriverMapsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveToFirebase() {

        String Name = name.getText().toString();
        String Registerno = registerno.getText().toString();
        String Source = source.getText().toString();
        String Destination = destination.getText().toString();
        String Typeofbus = bustype.getText().toString();




        if (!TextUtils.isEmpty(Name)){
            Todoup todoup = new Todoup(Name,Registerno,Source,Destination,Typeofbus);


            ref.push().setValue(todoup).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(Profile_bus.this,"Details saved successfully",Toast.LENGTH_SHORT).show();

                    name.setText("");

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Profile_bus.this,"Sorry ..Try again",Toast.LENGTH_SHORT).show();
                }
            });

        } else {

            Toast.makeText(Profile_bus.this,"Fill all fields should be filled",Toast.LENGTH_SHORT).show();

        }
    }
}
