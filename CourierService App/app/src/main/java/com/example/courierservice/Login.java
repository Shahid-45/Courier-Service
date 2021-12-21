package com.example.courierservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    Button signup,login;
    EditText et_user,et_pwd;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       signup=(Button)findViewById(R.id.signup);
        login=(Button)findViewById(R.id.bt_login);
        et_user=(EditText)findViewById(R.id.et_user);
        et_pwd=(EditText)findViewById(R.id.et_pwd);



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent su = new Intent(getApplication(), Registration.class);
                startActivity(su);

            }


        });







        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = et_user.getText().toString().trim();
                String pas = et_pwd.getText().toString().trim();


//                login_reference l = new login_reference();
//                l.setUserid(user);

                if(TextUtils.isEmpty(user))
                {
                    Toast.makeText(Login.this,"Please Enter Username",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!user.matches("[0-9]{10}")){
                    et_user.setError("Enter 10 digits phone number");
                    return;
                }

//                if(TextUtils.isEmpty(pas))
//                {
//                    Toast.makeText(Login.this,"Please Enter Password",Toast.LENGTH_SHORT).show();
//                    return;
//                }

                reference = FirebaseDatabase.getInstance().getReference().child("Users");

                Query checkuser = reference.orderByChild("pn").equalTo(user);
                checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            String passwordfromdb = snapshot.child(user).child("pwd").getValue(String.class);

                            if (passwordfromdb.equals(pas)){
                                Intent i = new Intent(getApplication(),Menupage.class);
                                Toast.makeText(Login.this,"login successful",Toast.LENGTH_SHORT).show();
                                startActivity(i);
                            }
                            else{
                                Toast.makeText(Login.this,"Username or Password Incorrect",Toast.LENGTH_SHORT).show();
                                return;
                            }

                        }
                        else{
                            Toast.makeText(Login.this,"Username or Password Incorrect",Toast.LENGTH_SHORT).show();
                            return;
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



            }
        });




    }
}