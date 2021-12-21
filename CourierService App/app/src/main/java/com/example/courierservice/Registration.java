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

public class Registration extends AppCompatActivity {


    Button regSubmit;
    EditText regname,regmail,regpwd,regcp,regaddr,regpin,regcity,regst,regph;

    DatabaseReference df;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        df = FirebaseDatabase.getInstance().getReference("Users");

        regSubmit=(Button)findViewById(R.id.regSubmit);
        regname=(EditText)findViewById(R.id.regname);
        regmail=(EditText)findViewById(R.id.regmail);
        regpwd=(EditText)findViewById(R.id.regpwd);
        regcp=(EditText)findViewById(R.id.regcp);
        regaddr=(EditText)findViewById(R.id.regaddr);
        regpin=(EditText)findViewById(R.id.regpin);
        regcity=(EditText)findViewById(R.id.regcity);
        regst=(EditText)findViewById(R.id.regst);
        regph=(EditText)findViewById(R.id.regph);

        regSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = regname.getText().toString().trim();
                String email = regmail.getText().toString().trim();
                String pwd = regpwd.getText().toString().trim();
                String Cp = regcp.getText().toString().trim();
                String addr = regaddr.getText().toString().trim();
                String pin = regpin.getText().toString().trim();
                String city = regcity.getText().toString().trim();
                String state = regst.getText().toString().trim();
                String pn = regph.getText().toString().trim();


                if (TextUtils.isEmpty(name))
                {
                    Toast.makeText(Registration.this,"Please Enter Name",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!name.matches("[a-z,A-Z]*")){
                    regname.setError("Enter only character");
                    return;
                }

                if (TextUtils.isEmpty(email))
                {
                    Toast.makeText(Registration.this,"Please Enter Gmail",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    regmail.setError("Enter valid mail ID");
                    return;
                }

                if (TextUtils.isEmpty(pwd))
                {
                    Toast.makeText(Registration.this,"Please Enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(Cp))
                {
                    Toast.makeText(Registration.this,"Please Enter Confirm password",Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(addr))
                {
                    Toast.makeText(Registration.this,"Please Enter Address",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(pin))
                {
                    Toast.makeText(Registration.this,"Please Enter Pincode",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!pin.matches("[0-9]{6}")){
                    regpin.setError("Enter valid pin");
                    return;
                }

                if (TextUtils.isEmpty(city))
                {
                    Toast.makeText(Registration.this,"Please Enter City",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(city.matches("[A-Za-z]")){
                    regcity.setError("Enter only characters");
                    return;
                }

                if (TextUtils.isEmpty(state))
                {
                    Toast.makeText(Registration.this,"Please Enter State",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(state.matches("[A-Za-z]")){
                    regst.setError("Enter only characters");
                    return;
                }

                if (TextUtils.isEmpty(pn))
                {
                    Toast.makeText(Registration.this,"Please Enter Phone Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!pn.matches("[0-9]{10}")){
                    regph.setError("Enter valid phone number");
                    return;
                }

                if(pwd.length()<6)
                {
                    Toast.makeText(Registration.this,"Password is too Short",Toast.LENGTH_SHORT).show();
                }
                if(!pwd.equals(Cp)){
                    regcp.setError("Both password don't match");
                    return;
                }

                login_reference l = new login_reference();
                l.setUserid(pn);
                Register u1=new Register(name,email,pwd,Cp,addr,pin,city,state,pn);
                df.child(pn).setValue(u1);
                Toast.makeText(Registration.this,"Added",Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplication(),Login.class);
                startActivity(i);


            }
        });







    }
}