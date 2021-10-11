package com.example.myapplication;

/**
 * Handles each of the hour:minutes:seconds sections
 */
public class FormatTimerValues {
    private final String[] formedTimerDisplay = {"", "", ""};
    private int hours = 0;
    private int minutes = 0;
    private int secondsToDisplay = 0;
    private final int seconds;

    /**
     * Handles each of the hour:minutes:seconds sections
     *
     * @param  seconds  the incremented second to calculate the time from
     */
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
            formedTimerDisplay[2] = "0" + (secondsToDisplay);
        } else if (secondsToDisplay < 60) {
            formedTimerDisplay[2] = "" + secondsToDisplay;
        } else {
            formedTimerDisplay[2] = "00";
        }
    }

    private void setMinutes () {
        if (minutes <= 9) {
            formedTimerDisplay[1] = "0" + (minutes);
        } else if (minutes < 60) {
            formedTimerDisplay[1] = "" + minutes;
        } else {
            formedTimerDisplay[1] = "00";
        }
    }

    private void setHours () {
        if (hours <= 9) {
            formedTimerDisplay[0] = "0" + (hours);
        } else if (hours < 24) {
            formedTimerDisplay[0] = "" + hours;
        } else {
            formedTimerDisplay[0] = "" + 24;
        }
    }

    public String getDisplayTimer () {
        setSeconds();
        setMinutes();
        setHours();

        return formedTimerDisplay[0] + ":" + formedTimerDisplay[1] + ":" + formedTimerDisplay[2];
    }
}
