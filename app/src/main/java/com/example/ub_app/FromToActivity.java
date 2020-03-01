package com.example.ub_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import static com.example.ub_app.Todoup.passdis;

public class FromToActivity extends AppCompatActivity {
    EditText from,to;
    Button findbtn;
    String fromm,too;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_from_to);
        from = findViewById(R.id.fromid);
        to = findViewById(R.id.toid);

        findbtn = findViewById(R.id.findbut);
        findbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromm= from.getText().toString();
                too= to.getText().toString();
                passdis(fromm,too);

                if(!fromm.equals("") && !too.equals(""))

                {
                    Intent intent = new Intent(FromToActivity.this,ListActivity.class);
                    startActivity(intent);


                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid From And To location", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
