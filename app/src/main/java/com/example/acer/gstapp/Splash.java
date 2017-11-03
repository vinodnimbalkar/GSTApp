package com.example.acer.gstapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Aditya on 10/27/2017.
 */

public class Splash extends AppCompatActivity {

    ImageView iv;
    Intent intent;
    final int length=2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        iv=(ImageView)findViewById(R.id.splash_logo);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                intent= new Intent(Splash.this,Menu.class);
                startActivity(intent);
            }
        },length);

    }
}