package com.example.courierservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Payment extends AppCompatActivity {
    Button rd1,rd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        rd1=(Button)findViewById(R.id.radioButton);
        rd2=(Button)findViewById(R.id.radioButton2);

        rd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),Confirmation.class);
                startActivity(i);
            }
        });

        rd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(getApplication(),Confirmation.class);
                startActivity(i2);
            }
        });

    }

}