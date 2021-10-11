package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.TextView;
import android.widget.Button;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer timer = new Timer();
    boolean startTimer = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnUseTimerClick(View view) {
        TextView txtShowTimer = findViewById(R.id.txtShowTimer);
        Button btnUseTimer = findViewById(R.id.btnUseTimer);
        String btnStartTimer = getString(R.string.btn_start_timer);

        if (btnUseTimer.getText().toString().equals(btnStartTimer) && startTimer == true) {
            TimeIncrementer timeIncrementer = new TimeIncrementer(0, txtShowTimer, btnUseTimer);

            btnUseTimer.setText(R.string.btn_end_timer);

            timer.schedule(timeIncrementer, 0, 1000);
            startTimer = false;
        } else {
            timer.cancel();
            timer.purge();
            startTimer = true;
            txtShowTimer.setText(R.string.text_zero_display_time);
            btnUseTimer.setText(R.string.btn_start_timer);
        }
    }
}