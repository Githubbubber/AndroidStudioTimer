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
    public int seconds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnUseTimerClick(View view) {
        TextView txtShowTimer = findViewById(R.id.txtShowTimer);
        Button btnUseTimer = findViewById(R.id.btnUseTimer);
        String btnStartTimer = getString(R.string.btn_start_timer);
        Timer timer = new Timer();

        if (btnUseTimer.getText().toString().equals(btnStartTimer)) {
            btnUseTimer.setText(R.string.btn_end_timer);

            timer.schedule(new TimerTask() {
                public void run() {
                    seconds++;

                    FormatTimerValues formatTimerValues = new FormatTimerValues(seconds);
                    String answer = formatTimerValues.getDisplayTimer();

                    txtShowTimer.setText(answer);

                    if (answer == getString(R.string.endpoint_display_time)) {
                        cancel();
                        timer.cancel();
                        timer.purge();
                        btnUseTimer.setText(R.string.btn_start_timer);
                    }
                }
            }, 0, 1000);
        } else {
            timer.cancel();
            timer.purge();
            txtShowTimer.setText(R.string.text_zero_display_time);
            btnUseTimer.setText(R.string.btn_start_timer);
        }
    }
}