package com.example.courierservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class Package_details extends AppCompatActivity {

    EditText description,weight;
    Spinner sp;
    Button packagebtn;
    TextWatcher text=null;
    String result;
    DatabaseReference db;
    int random = new Random().nextInt(61) + 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_details);

        db = FirebaseDatabase.getInstance().getReference("Package_Details");
        description=findViewById(R.id.package_desc);
        weight=findViewById(R.id.package_weight);
        sp=findViewById(R.id.package_spinner);

        packagebtn = findViewById(R.id.pac_submit);
        int val1=50,val2=100,val3;
        String weig = weight.getText().toString().trim();
//        int wei = Integer.parseInt(weig);


//        text=new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if(sp.getSelectedItem().toString().trim().equals("Standard Delivery"))
//                {
//                    result = String.valueOf(val1 * wei);
//                    price.setText(result);
//                }
//                else{
//                    result = String.valueOf(val2 * wei);
//                    price.setText(result);
//                }
//
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        };

        packagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String desc=description.getText().toString().trim();
                int we =Integer.parseInt(weight.getText().toString().trim());
                String sp1 =sp.getSelectedItem().toString().trim();
                String pr = result;

                if(TextUtils.isEmpty(desc)){
                    Toast.makeText(Package_details.this,"Enter description of package",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(String.valueOf(we))){
                    Toast.makeText(Package_details.this,"Enter weight of package",Toast.LENGTH_LONG).show();
                    return;
                }
                String ss = String.valueOf(we);
                if(!ss.matches("[0-9]{1}")){
                    weight.setError("Enter only numbers");
                }


                String user = getIntent().getStringExtra("Phone");

                Package p = new Package(desc,we,sp1,pr,user);
                db.setValue(p);
                Intent i = new Intent(getApplication(),Payment.class);

                startActivity(i);

            }
        });
    }
}