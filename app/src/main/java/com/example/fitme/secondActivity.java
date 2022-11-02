package com.example.fitme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class secondActivity extends AppCompatActivity {

int [] newArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        newArray=new int[]{
                R.id.a, R.id.b, R.id.c, R.id.d, R.id.e, R.id.f,

        };


    }

    public void imageButtonClicked(View view) {


        for (int i=0;i<newArray.length;i++){

            if(view.getId()==newArray[i]){
                int value= i+1;
                Log.i("First",String.valueOf(value));

                Intent intent= new Intent(secondActivity.this,thirdActivity.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }

        }
    }
}