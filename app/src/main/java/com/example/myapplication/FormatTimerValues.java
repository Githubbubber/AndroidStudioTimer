package com.example.myapplication;

import android.util.Log;

public class FormatTimerValues {
    private final String[] displayWhatItIs = {"", "", ""};
    private int hours = 0;
    private int minutes = 0;
    private int secondsToDisplay = 0;
    private final int seconds;

    public FormatTimerValues(int seconds) {
        this.seconds = seconds;
    }

    public void retrieveSeconds() {
        if (seconds < 60) {
            secondsToDisplay = seconds;
            return;
        }

        if (seconds > 86399) {
            hours = 24;
            return;
        }

        hours = seconds / 3600;
        minutes = (seconds % 3600) / 60;
        secondsToDisplay = ((seconds % 3600) % 60) > 59 ? 0 : (seconds % 3600) % 60;
    }

    private void setSeconds () {
        retrieveSeconds();

        if (secondsToDisplay <= 9) {
            displayWhatItIs[2] = "0" + (secondsToDisplay);
        } else if (secondsToDisplay < 60) {
            displayWhatItIs[2] = "" + secondsToDisplay;
        } else {
            displayWhatItIs[2] = "00";
        }
    }

    private void setMinutes () {
        if (minutes <= 9) {
            displayWhatItIs[1] = "0" + (minutes);
        } else if (minutes < 60) {
            displayWhatItIs[1] = "" + minutes;
        } else {
            displayWhatItIs[1] = "00";
        }
    }

    private void setHours () {
        if (hours <= 9) {
            displayWhatItIs[0] = "0" + (hours);
        } else if (hours < 24) {
            displayWhatItIs[0] = "" + hours;
        } else {
            displayWhatItIs[0] = "" + 24;
        }
    }

    public String getDisplayTimer () {
        setSeconds();
        setMinutes();
        setHours();

        return displayWhatItIs[0] + ":" + displayWhatItIs[1] + ":" + displayWhatItIs[2];
    }
}
