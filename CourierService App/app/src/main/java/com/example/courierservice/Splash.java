package com.example.courierservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    ImageView Splash_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Splash_img=(ImageView)findViewById(R.id.img_splash);

        Thread i=new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(1000);
                    Intent i = new Intent(getApplication(),Login.class);
                    startActivity(i);
                    finish();
                }catch(Exception e){

                }


            }
        };
        i.start();

    }
}