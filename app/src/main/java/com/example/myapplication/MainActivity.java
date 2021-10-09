package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
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

        String hourMinSec = getString(R.string.initial_display_time_text);
        String[] times = hourMinSec.split(":");

        changeDisplayTimer(view, txtShowTimer, times);
        changeBtnText(btnUseTimer);
    }

    public void changeDisplayTimer(View view, TextView txtShowTimer, String[] times) {
//        if (txtShowTimer.getText().toString().equals(hourMinSec) {
            Timer timer = new Timer();

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run(){
                            int hour = Integer.valueOf(times[0]);
                            int minute = Integer.valueOf(times[1]);
                            int second = Integer.valueOf(times[2]);

                            FormatTimerValues formatTimerValues = new FormatTimerValues(hour, minute, second);
                            txtShowTimer.setText(formatTimerValues.getDisplayTimer());
                        }
                    });
                }
            }, 0, 1000);
//        } else {
//            txtShowTimer.setText(hourMinSec);
//        }
    }

    public void changeBtnText(Button btnUseTimer) {
        String startTimerText = getString(R.string.start_timer_text);

        if (btnUseTimer.getText().toString().equals(startTimerText)) {
            btnUseTimer.setText(R.string.end_timer_text);
        } else {
            btnUseTimer.setText(R.string.start_timer_text);
        }
    }
}