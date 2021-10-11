package com.example.myapplication;

import android.widget.Button;
import android.widget.TextView;
import android.content.res.Resources;

import java.util.TimerTask;

/**
 * Retrieving string of hour:minute:seconds from current seconds value
 * Shows in the timer field the current incremented time or the reset 00:00:00
 * Shows in the button Start once the incremented time reaches the 24 hour cap
 */
public class TimeIncrementer extends TimerTask{
    private int seconds = 0;
    private TextView txtShowTimer;
    private Button btnUseTimer;

    /**
     * Handles the click event for both the Start and the End states.
     * Incrementer calculated in TimeIncrementer and
     * hour:minute:second formatted string created in FormatTimerValues
     *
     * @param  txtShowTimer  the text field showing the (incremented) time
     * @param  btnUseTimer  the button
     */
    public TimeIncrementer(TextView txtShowTimer, Button btnUseTimer) {
        this.txtShowTimer = txtShowTimer;
        this.btnUseTimer = btnUseTimer;
    }

    @Override
    public void run() {
        String endpointTime = Resources.getSystem().getString(R.string.endpoint_display_time); // "24:00:00"

        if  (txtShowTimer.getText() != endpointTime) {
            seconds++;

            FormatTimerValues formatTimerValues = new FormatTimerValues(seconds);
            String displayTimer = formatTimerValues.getDisplayTimer(); // Retrieve hour:min:sec string

            txtShowTimer.setText(displayTimer); // Shows the hour:min:sec string in text field
        } else {
            txtShowTimer.setText(R.string.text_zero_display_time); // Reset timer to "00:00:00"
            btnUseTimer.setText(R.string.btn_start_timer); // Reset button to "Start"
        }
    }
}
