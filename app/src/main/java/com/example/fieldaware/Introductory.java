package com.example.fieldaware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;


public class Introductory extends AppCompatActivity {
ImageView icon,splash;
LottieAnimationView lottieAnimationView;
TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);
        icon=findViewById(R.id.icon1);
        text=findViewById(R.id.text);

         lottieAnimationView=findViewById(R.id.lottie);

        lottieAnimationView.animate().translationY(1400).setDuration(3000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(Introductory.this,MainActivity.class));
                finish();
            }
        },1000);


    }
}