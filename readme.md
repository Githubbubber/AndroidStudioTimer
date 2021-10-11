#### Summary
A Java timer to use in a studio during a recording. The timer will eventually be cast to a nearby screen.

It will have a simple layout with easy to understand directions. This version is a work in progress.

The meat and potatoes of the app code can be [found here: MainActivity, FormatTimerValues, and TimeIncrementer classes.](https://github.com/Githubbubber/AndroidStudioTimer/tree/main/app/src/main/java/com/example/myapplication) 

#### Help Needed
Currently the Start/End button is used to toggle the Timer thread but I'm having difficulty starting up a new thread once the first thread is canceled/purged in MainActivity.java.
![](https://raw.githubusercontent.com/Githubbubber/AndroidStudioTimer/main/timer_thread.JPG)

I was wondering if using finalize() in MainActivity helps with freeing up memory from the finished processes of Timer.

#### TODOs 
- Cast to nearby devices/screens
- A single account designated as a time keeper will control the timer while remote users can see the time. This is for remote recordings. 
- Tracks recording times and shows trends over time.
- Take notes in the app
- Countdown feature (single and multiple chained countdowns)
