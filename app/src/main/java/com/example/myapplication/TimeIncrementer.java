package com.example.myapplication;

import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class TimeIncrementer implements Runnable{
    private int seconds;
    private TextView txtShowTimer;
    private Button btnUseTimer;

    public TimeIncrementer(View view, int seconds, TextView txtShowTimer, Button btnUseTimer) {
        this.seconds = seconds;
        this.txtShowTimer = txtShowTimer;
        this.btnUseTimer = btnUseTimer;
    }

    @Override
    public void run() {
        seconds++;

        FormatTimerValues formatTimerValues = new FormatTimerValues(seconds);
        String answer = formatTimerValues.getDisplayTimer();

        txtShowTimer.setText(answer);

        if (answer == getString(R.string.endpoint_display_time)) {
            btnUseTimer.setText(R.string.btn_start_timer);
        }
    }
}
