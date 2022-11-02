package com.example.fitme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class thirdActivity2 extends AppCompatActivity {
   ;
    String buttonvalue;
    Button startbutton;
    private CountDownTimer countDownTimer;
    TextView mtextView;
    private boolean running;
    private long    left;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third2);
        Intent intent=getIntent();
        buttonvalue=intent.getStringExtra("value");
        int intValue= Integer.valueOf(buttonvalue);
        switch (intValue){
            case 1:
                setContentView(R.layout.activity_h);
                break;
            case 2:
                setContentView(R.layout.activity_i);
                break;
            case 3:
                setContentView(R.layout.activity_j);
                break;
            case 4:
                setContentView(R.layout.activity_k);
                break;
            case 5:
                setContentView(R.layout.activity_l);
                break;
            case 6:
                setContentView(R.layout.activity_m);
                break;
            case 7:
                setContentView(R.layout.activity_n);
                break;
            case 8:
                setContentView(R.layout.activity_o);
                break;
        }
        startbutton=findViewById(R.id.startb);

        mtextView=findViewById(R.id.time);
        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(running){
                    stopTimer();
                }
                else{
                    startTimer();
                }
            }
        });


    }

    private void stopTimer(){
        countDownTimer.cancel();
        running=false;
        startbutton.setText("START");
    }

    private void startTimer(){
        final CharSequence value=mtextView.getText();
        String num1=value.toString();
        String num2=num1.substring(0,2);
        String num3=num1.substring(3,5);

        final int number=Integer.valueOf(num2)*60+Integer.valueOf(num3);
        left=number*1000;
        countDownTimer=new CountDownTimer(left,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                left=millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {
                int newval=Integer.valueOf(buttonvalue)+1;
                if (newval<=7){
                    Intent intent=new Intent(thirdActivity2.this,thirdActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newval));
                    startActivity(intent);


                }else{

                    newval=1;
                    Intent intent=new Intent(thirdActivity2.this,thirdActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newval));
                    startActivity(intent);
                }
            }
        }.start();
        startbutton.setText("PAUSE");
        running=true;


    }
    private  void updateTimer() {
        int min = (int) left / 60000;
        int sec = (int) left % 60000 / 1000;

        String timeleft = "";
        if (min < 10)
            timeleft = "0";
        timeleft = timeleft + min + ":";

        if (sec < 10)
            timeleft += "0";
        timeleft += timeleft + sec + ":";

        mtextView.setText(timeleft);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}