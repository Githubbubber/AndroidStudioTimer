package com.example.myapplication;

import android.widget.Button;
import android.widget.TextView;
import android.content.res.Resources;

import java.util.TimerTask;

public class TimeIncrementer extends TimerTask{
    private int seconds;
    private TextView txtShowTimer;
    private Button btnUseTimer;

    public TimeIncrementer(int seconds, TextView txtShowTimer, Button btnUseTimer) {
        this.seconds = seconds;
        this.txtShowTimer = txtShowTimer;
        this.btnUseTimer = btnUseTimer;
    }

    @Override
    public void run() {
        String endpointTime = Resources.getSystem().getString(R.string.endpoint_display_time);

        if  (txtShowTimer.getText() != endpointTime) {
            seconds++;

            FormatTimerValues formatTimerValues = new FormatTimerValues(seconds);
            String displayTimer = formatTimerValues.getDisplayTimer();

            txtShowTimer.setText(displayTimer);
        } else {
            txtShowTimer.setText(R.string.text_zero_display_time);
            btnUseTimer.setText(R.string.btn_start_timer);
        }
    }
}
