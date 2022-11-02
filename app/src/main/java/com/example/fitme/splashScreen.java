package com.example.fitme;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("CustomSplashScreen")
public class splashScreen extends AppCompatActivity {

    Animation up,down;



    ImageView imageView;
    TextView textView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView imageView =findViewById(R.id.appSplash);

    up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);

imageView.setAnimation(up);

        TextView textView= findViewById(R.id.appName);

        down=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
      textView.setAnimation(down);
        new Handler().postDelayed(() -> {
startActivity(new Intent(getApplicationContext(),Log.class));

        finish();
        },3500);
    }
}