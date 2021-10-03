package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CTTDF extends AppCompatActivity {

    public String convertTimeToDateFormat(long milliseconds)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
        Date resultDate = new Date(milliseconds);
        return sdf.format(resultDate);
    }
    
    public void t2() {
        TextView allOutputs = findViewById(R.id.allOutputs);
        
        String fourthOutput = "Executing timer task on " + convertTimeToDateFormat(System.currentTimeMillis());

        allOutputs.setText(fourthOutput);
    }
}
