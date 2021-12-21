package com.example.courierservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menupage extends AppCompatActivity {
    Button cre,csta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menupage);

        cre=(Button)findViewById(R.id.creq);
        csta=(Button)findViewById(R.id.cstat);

        cre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),Pickup1.class);
                String user = getIntent().getStringExtra("Phone");
                i.putExtra("Phone",user);
                startActivity(i);
            }
        });

        csta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),Status.class);
                startActivity(i);
            }
        });
    }
}