package com.example.fitme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class foodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
    }

    public void textClixked(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.maximuscle.com/sports/bodybuilding/4-Week-Diet-For-Cutting/"));
        startActivity(intent);

    }

    public void imageButtonClicked(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.maximuscle.com/sports/bodybuilding/4-Week-Bulking-Transformation-Diet/"));
        startActivity(intent);
    }

    public void imaButtonClicked(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.healthline.com/nutrition/ketogenic-diet-101"));
        startActivity(intent);
    }
}