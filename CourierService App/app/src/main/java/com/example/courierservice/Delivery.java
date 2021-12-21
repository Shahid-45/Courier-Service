package com.example.courierservice;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Delivery extends AppCompatActivity {
    EditText dadd1,dadd2,dpin,dphone,gmail;
    Button btnext,btreset;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        btreset = (Button)findViewById(R.id.dreset);
        dadd1 = (EditText)findViewById(R.id.daddr1);
        dadd2 = (EditText)findViewById(R.id.daddr2);

        dpin = (EditText)findViewById(R.id.dpin);
        dphone = (EditText)findViewById(R.id.dphone);
        gmail = (EditText)findViewById(R.id.dmail);
        db = FirebaseDatabase.getInstance().getReference("Delivery_Details");

        btnext = (Button) findViewById(R.id.dnext);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String daddr1 = dadd1.getText().toString().trim();
                String daddr2 = dadd2.getText().toString().trim();

                String ddpin = dpin.getText().toString().trim();
                String ddphone = dphone.getText().toString().trim();
                String ddgmail = gmail.getText().toString().trim();


                if(TextUtils.isEmpty(daddr1))
                {
                    Toast.makeText(Delivery.this,"Enter Address",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(ddpin))
                {
                    Toast.makeText(Delivery.this,"Enter Pin",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!ddpin.matches("[0-9]{6}"))
                {
                    dpin.setError("Enter a valid Pin code");
                    return;
                }
                if(TextUtils.isEmpty(ddphone))
                {
                    Toast.makeText(Delivery.this,"Enter Phone",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!ddphone.matches("[0-9]{10}")){
                    dphone.setError("Enter only 10 digits number");
                    return;
                }

                if(TextUtils.isEmpty(ddgmail))
                {
                    Toast.makeText(Delivery.this,"Enter Gmail",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(ddgmail).matches()){
                    gmail.setError("Please Enter valid Email");
                    return;
                }


                Intent i = new Intent( getApplication(),Package_details.class);
                String user = getIntent().getStringExtra("Phone");
                i.putExtra("Phone",user);
                Delivery_Details dd = new Delivery_Details(daddr1,daddr2,ddpin,ddphone,ddgmail,user);
                db.child(ddphone).setValue(dd);
                Toast.makeText(Delivery.this,"Added",Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

        btreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dadd1.getText().clear();
                dadd2.getText().clear();
                dpin.getText().clear();
                dphone.getText().clear();

                gmail.getText().clear();
            }
        });
    }
}