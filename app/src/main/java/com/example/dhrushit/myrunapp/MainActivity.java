package com.example.dhrushit.myrunapp;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button start_button,stop_button,pause_button;
    TextView t1,t2;
    static int totalTime = 0;
    static  int secs = 0;
    static boolean isStart =  false;
    CountDownTimer cdt2 = new CountDownTimer(60000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            secs += 1;
            t2.setText(String.valueOf(secs));
        }

        @Override
        public void onFinish() {
            secs = 0;
            t2.setText(String.valueOf(secs));
        }
    };
    CountDownTimer cdt = new CountDownTimer(3600000,60000) {
        @Override
        public void onTick(long millisUntilFinished) {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(500);
            v.vibrate(500);
            totalTime += 1;
            t1.setText(String.valueOf(totalTime-1));
            secs = 0;
            cdt2.cancel();
            cdt2.start();

        }

        @Override
        public void onFinish() {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(1000);
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.text);
        t2 = (TextView) findViewById(R.id.text2);
        start_button = (Button) findViewById(R.id.btn_start);
//        stop_button = (Button) findViewById(R.id.btn_stop);
//        pause_button = (Button) findViewById(R.id.btn_pause);

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isStart){
                    cdt.start();
                    isStart = true;
                    start_button.setText("Stop");
                }else{
                    cdt.cancel();
                    cdt2.cancel();
                    isStart = false;
                    start_button.setText("Start");
                }
            }
        });

//        stop_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cdt.cancel();
//            }
//        });

    }
}
