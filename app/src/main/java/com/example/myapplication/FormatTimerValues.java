package com.example.myapplication;

import android.util.Log;

public class FormatTimerValues {
    private String[] displayWhatItIs = {"", "", ""};
    private int hours;
    private int minutes;
    private int seconds;

    public FormatTimerValues(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    private void setSeconds () {
        this.seconds++;
        if (this.seconds <= 9) {
            this.displayWhatItIs[2] = "0" + (this.seconds);
        } else if (this.seconds > 9 && this.seconds < 60) {
            this.displayWhatItIs[2] = "" + this.seconds;
        } else {
            this.displayWhatItIs[2] = "00";
            this.minutes++;
        }
    }

    private void setMinutes () {
        if (this.minutes <= 9) {
            this.displayWhatItIs[1] = "0" + (this.minutes);
        } else if (this.minutes > 9 && this.minutes < 60) {
            this.displayWhatItIs[1] = "" + this.minutes;
        } else {
            this.displayWhatItIs[1] = "00";
            this.hours++;
        }
    }

    private void setHours () {
        if (this.hours <= 9) {
            this.displayWhatItIs[0] = "0" + (this.hours);
        } else if (this.hours > 9 && this.hours < 24) {
            this.displayWhatItIs[0] = "" + this.hours;
        } else {
            this.displayWhatItIs[0] = "" + 24;
        }
    }

    public String getDisplayTimer () {
        setSeconds();
        setMinutes();
        setHours();

        Log.d("Seeing: ", this.displayWhatItIs[0] + ":" + this.displayWhatItIs[1] + ":" + this.displayWhatItIs[2]);
        return this.displayWhatItIs[0] + ":" + this.displayWhatItIs[1] + ":" + this.displayWhatItIs[2];
    }
}
