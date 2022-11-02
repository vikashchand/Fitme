package com.example.fitme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    Button button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        button1=findViewById(R.id.yoga1);

        button2=findViewById(R.id.yoga2);
       button3=findViewById(R.id.food);

        button1.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,secondActivity.class);
            startActivity(intent);
        });
        button2.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,secondActivity2.class);
            startActivity(intent);
        });

        button3.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,foodActivity.class);
            startActivity(intent);
        });
        //




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        for(int i=0;i<menu.size();i++){
            MenuItem menuItem=menu.getItem(i);
            SpannableString spannableString=new SpannableString(menu.getItem(i).getTitle().toString());
            spannableString.setSpan(new ForegroundColorSpan(Color.RED),0,spannableString.length(),0);
            menuItem.setTitle(spannableString);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.privacy){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://leap.app/privacypolicy.html?pkg=menloseweight.loseweightappformen.weightlossformen"));
            startActivity(intent);

            return true;
        }
        if(id==R.id.terms){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://fitbodyweightloss.com/terms-and-conditions/"));
            startActivity(intent);

            return true;
        }
        if(id==R.id.rate){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/vikash-chand-9878471b8/"));
            startActivity(intent);
            return true;
        }
        if(id==R.id.more){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/tirthankar-chakraborty-93a3161b9/"));
            startActivity(intent);
            return true;
        }
        if(id==R.id.me){
            Intent intent=new Intent(getApplicationContext(),profile.class);
        startActivity(intent);


        return true;
    }
        return true;
    }

    public void after18(View view) {
        Intent intent =new Intent(MainActivity.this,secondActivity2.class);
        startActivity(intent);
    }

    public void before18(View view) {
        Intent intent =new Intent(MainActivity.this,secondActivity.class);
        startActivity(intent);
    }

    public void food1(View view) {
        Intent intent =new Intent(MainActivity.this,foodActivity.class);
        startActivity(intent);
    }


}


