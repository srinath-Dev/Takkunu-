package com.example.ub_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference ref;
    String Fromm;




    FirebaseRecyclerOptions<Todoup> options;

    FirebaseRecyclerAdapter<Todoup, Todoview> adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.Recycle);


        firebaseDatabase = FirebaseDatabase.getInstance();
        ref = firebaseDatabase.getReference("BusDetails");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        showTask();

    }


    private void showTask() {

        options = new  FirebaseRecyclerOptions.Builder<Todoup>().setQuery(ref,Todoup.class).build();

        adapter = new FirebaseRecyclerAdapter<Todoup, Todoview>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Todoview todoview, int i, @NonNull Todoup todoup) {
                todoview.names.setText(todoup.getName());
                todoview.types.setText(todoup.getBustype());
                todoview.regino.setText(todoup.getRegisterno());
                todoview.source.setText(todoup.getSource());
                todoview.destin.setText(todoup.getDestination());
                todoview.locbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ListActivity.this,CustomerMapsActivity.class);
                        startActivity(intent);
                    }
                });

            }

            @NonNull
            @Override
            public Todoview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data, parent,false);
                return new Todoview(itemView);
            }
        };


        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
