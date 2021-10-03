package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.TextView;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnUseTimerClick(View view) {
        TextView txtShowTimer = findViewById(R.id.txtShowTimer);
        Button btnUseTimer = findViewById(R.id.btnUseTimer);
        TextView allOutputs = findViewById(R.id.allOutputs);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable(){
                    @Override
                    public void run(){
                        String iClicks = allOutputs.getText().toString();
                        int x = Integer.valueOf(iClicks);

                        // task to be done every 1000 milliseconds
                        iClicks = String.valueOf(x + 1);
                        allOutputs.setText(iClicks);
                    }
                });

            }
        }, 0, 1000);
    }

}