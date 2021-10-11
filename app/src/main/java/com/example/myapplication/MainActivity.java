/**
 * Timer to be cast to a nearby screen.
 */
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
    Timer timer = new Timer(); // Brought the Timer outside to make it accessible in a helper method
    boolean startTimer = true; // Added extra measure to try to prevent overlapping scheduled Timer threads

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Handles recreating display/data for orientations
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Handles the click event for both the Start and the End states.
     * Incrementer calculated in TimeIncrementer and
     * hour:minute:second formatted string created in FormatTimerValues
     *
     * @param  view  an absolute URL giving the base location of the image
     *
     * @return
     */
    public void onBtnUseTimerClick(View view) {
        TextView txtShowTimer = findViewById(R.id.txtShowTimer); // To be "00:00:00" incremented to "24:00:00"
        Button btnUseTimer = findViewById(R.id.btnUseTimer); // "Start" or "End" button text
        String btnStartTimer = getString(R.string.btn_start_timer); // "00:00:00"

        if (btnUseTimer.getText().toString().equals(btnStartTimer) && startTimer == true) {
            TimeIncrementer timeIncrementer = new TimeIncrementer(txtShowTimer, btnUseTimer);

            btnUseTimer.setText(R.string.btn_end_timer); // Button shows "End" text

            timer.schedule(timeIncrementer, 0, 1000); // Spreads out the incrementor each second
            startTimer = false; // Used to try to stop more than one Timer.
        } else {
            timer.cancel(); // Not sure if this is redundant with purge()
            timer.purge(); // Not sure if this is redundant with cancel()

            startTimer = true; // Used to try to stop more than one Timer.

            txtShowTimer.setText(R.string.text_zero_display_time); // Reset timer to "00:00:00"
            btnUseTimer.setText(R.string.btn_start_timer); // Reset button to "Start"
        }
    }
}