package com.example.ub_app;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ub_app.R;

public class Todoview extends RecyclerView.ViewHolder {

    public TextView names,regino,types,source,destin;
    public Button locbtn;


    public Todoview(@NonNull View itemView) {
        super(itemView);

        names = itemView.findViewById(R.id.busnoid);
        regino = itemView.findViewById(R.id.regiid);
        types = itemView.findViewById(R.id.typeid);
        source = itemView.findViewById(R.id.sourid);
        destin = itemView.findViewById(R.id.desid);
        locbtn=itemView.findViewById(R.id.locateid);
    }
}
