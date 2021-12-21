package com.example.courierservice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Pickup1 extends AppCompatActivity {

    EditText paddr1,paddr2,ptime,ppin,pphone,pmail;
    Button pnext,prset,pdate;
    DatabaseReference df;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup1);

        dateView = (TextView) findViewById(R.id.Date_display);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        pnext=(Button)findViewById(R.id.pnext);
        paddr1=(EditText) findViewById(R.id.paddr1);
        paddr2=(EditText)findViewById(R.id.paddr2);
        ptime=(EditText)findViewById(R.id.ptime);
        pdate=(Button) findViewById(R.id.pdate);
        ppin=(EditText)findViewById(R.id.ppin);
        pphone=(EditText)findViewById(R.id.pphone);
        pmail=(EditText)findViewById(R.id.pmail);
        df = FirebaseDatabase.getInstance().getReference("Pickup_address");



        pnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pad1 = paddr1.getText().toString().trim();
                String pad2 = paddr2.getText().toString().trim();
                String pt = ptime.getText().toString().trim();
                String pd = pdate.getText().toString().trim();
                String pp = ppin.getText().toString().trim();
                String pph = pphone.getText().toString().trim();
                String pm = pmail.getText().toString().trim();



                if (TextUtils.isEmpty(pad1))
                {
                    Toast.makeText(Pickup1.this,"Please Enter Name",Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(pt))
                {
                    Toast.makeText(Pickup1.this,"Please Enter time",Toast.LENGTH_SHORT).show();
                    return;
                }

//                if (TextUtils.isEmpty(pd))
//                {
//                    Toast.makeText(Pickup1.this,"Please Enter date",Toast.LENGTH_SHORT).show();
//                    return;
//                }

                if (TextUtils.isEmpty(pp))
                {
                    Toast.makeText(Pickup1.this,"Please Enter Pincode",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!pp.matches("[0-9]{6}")){
                    ppin.setError("Enter valid Pin");
                    return;
                }

                if (TextUtils.isEmpty(pph))
                {
                    Toast.makeText(Pickup1.this,"Please Enter Phone Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!pph.matches("[0-9]{10}")){
                    pphone.setError("Enter only 10 digits");
                    return;
                }

                if (TextUtils.isEmpty(pm))
                {
                    Toast.makeText(Pickup1.this,"Please Enter mailId",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(pm).matches()){
                    pmail.setError("Enter Valid Email");
                    return;
                }

                Intent i = new Intent(getApplication(),Delivery.class);
                String user = getIntent().getStringExtra("Phone");
                i.putExtra("Phone",user);
                Pickup p1 = new Pickup(pad1,pad2,pt,pp,pph,pm,pd,user);
                df.child(pph).setValue(p1);
                Toast.makeText(Pickup1.this,"Added",Toast.LENGTH_SHORT).show();
                startActivity(i);


            }
        });

        prset = (Button) findViewById(R.id.preset);
        prset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paddr1.getText().clear();
                paddr2.getText().clear();
                ptime.getText().clear();
                ppin.getText().clear();
                pphone.getText().clear();
                pmail.getText().clear();
            }
        });


    }



    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }



    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {

                    showDate(arg1, arg2+1, arg3);
                }
            };

    @Override
    protected Dialog onCreateDialog(int id) {

        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }


    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

}