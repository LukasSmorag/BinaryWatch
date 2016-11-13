package com.mobile.lukas.binarywatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import java.util.Calendar;
import android.os.Handler;

public class WatchActivity extends AppCompatActivity {

    private int minutes;
    private int hours;
    private int seconds;

    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);
        setTimeToViews();
        runClock();
    }

    private void runClock() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                Calendar c  = Calendar.getInstance();
                minutes     = c.get(Calendar.MINUTE);
                //getter for 12-based hour, 24 based: HOUR_OF_DAY
                hours       = c.get(Calendar.HOUR);
                seconds     = c.get(Calendar.SECOND);
                setTimeToViews();
                handler.postDelayed(this,1000);
            }
        });


    }

    private void setTimeToViews() {
        //get time led views
        ImageView hr_1_View = (ImageView) findViewById(R.id.hr_1_View);
        ImageView hr_2_View = (ImageView) findViewById(R.id.hr_2_View);
        ImageView hr_4_View = (ImageView) findViewById(R.id.hr_4_View);
        ImageView hr_8_View = (ImageView) findViewById(R.id.hr_8_View);

        ImageView min_1_View = (ImageView) findViewById(R.id.min_1_View);
        ImageView min_2_View = (ImageView) findViewById(R.id.min_2_View);
        ImageView min_4_View = (ImageView) findViewById(R.id.min_4_View);
        ImageView min_8_View = (ImageView) findViewById(R.id.min_8_View);
        ImageView min_16_View = (ImageView) findViewById(R.id.min_16_View);
        ImageView min_32_View = (ImageView) findViewById(R.id.min_32_View);

        ImageView sec_1_View = (ImageView) findViewById(R.id.sec_1_View);
        ImageView sec_2_View = (ImageView) findViewById(R.id.sec_2_View );
        ImageView sec_4_View = (ImageView) findViewById(R.id.sec_4_View);
        ImageView sec_8_View = (ImageView) findViewById(R.id.sec_8_View);
        ImageView sec_16_View = (ImageView) findViewById(R.id.sec_16_View);
        ImageView sec_32_View = (ImageView) findViewById(R.id.sec_32_View);

        //convert time to binary
        String min_string = Integer.toBinaryString(minutes);
        String hrs_string = Integer.toBinaryString(hours);
        String sec_string = Integer.toBinaryString(seconds);

        //Left pad string with 0 to fixed length
        hrs_string = String.format("%04d", Integer.parseInt(hrs_string));
        min_string = String.format("%06d", Integer.parseInt(min_string));
        sec_string = String.format("%06d", Integer.parseInt(sec_string));

        //set hour leds
        //counting starts left, index 0
        if(hrs_string.charAt(0) == '1') {
            hr_8_View.setImageResource(R.drawable.green);
        } else {
            hr_8_View.setImageResource(R.drawable.red);
        }

        if(hrs_string.charAt(1) == '1') {
            hr_4_View.setImageResource(R.drawable.green);
        } else {
            hr_4_View.setImageResource(R.drawable.red);
        }

        if(hrs_string.charAt(2) == '1') {
            hr_2_View.setImageResource(R.drawable.green);
        } else {
            hr_2_View.setImageResource(R.drawable.red);
        }

        if(hrs_string.charAt(3) == '1') {
            hr_1_View.setImageResource(R.drawable.green);
        } else {
            hr_1_View.setImageResource(R.drawable.red);
        }

        //set minute leds
        if(min_string.charAt(0) == '1') {
            min_32_View.setImageResource(R.drawable.green);
        } else {
            min_32_View.setImageResource(R.drawable.red);
        }

        if(min_string.charAt(1) == '1') {
            min_16_View.setImageResource(R.drawable.green);
        } else {
            min_16_View.setImageResource(R.drawable.red);
        }

        if(min_string.charAt(2) == '1') {
            min_8_View.setImageResource(R.drawable.green);
        } else {
            min_8_View.setImageResource(R.drawable.red);
        }

        if(min_string.charAt(3) == '1') {
            min_4_View.setImageResource(R.drawable.green);
        } else {
            min_4_View.setImageResource(R.drawable.red);
        }

        if(min_string.charAt(4) == '1') {
            min_2_View.setImageResource(R.drawable.green);
        } else {
            min_2_View.setImageResource(R.drawable.red);
        }

        if(min_string.charAt(5) == '1') {
            min_1_View.setImageResource(R.drawable.green);
        } else {
            min_1_View.setImageResource(R.drawable.red);
        }

        //set second leds
        if(sec_string.charAt(0) == '1') {
            sec_32_View.setImageResource(R.drawable.green);
        } else {
            sec_32_View.setImageResource(R.drawable.red);
        }

        if(sec_string.charAt(1) == '1') {
            sec_16_View.setImageResource(R.drawable.green);
        } else {
            sec_16_View.setImageResource(R.drawable.red);
        }

        if(sec_string.charAt(2) == '1') {
            sec_8_View.setImageResource(R.drawable.green);
        } else {
            sec_8_View.setImageResource(R.drawable.red);
        }

        if(sec_string.charAt(3) == '1') {
            sec_4_View.setImageResource(R.drawable.green);
        } else {
            sec_4_View.setImageResource(R.drawable.red);
        }

        if(sec_string.charAt(4) == '1') {
            sec_2_View.setImageResource(R.drawable.green);
        } else {
            sec_2_View.setImageResource(R.drawable.red);
        }

        if(sec_string.charAt(5) == '1') {
            sec_1_View.setImageResource(R.drawable.green);
        } else {
            sec_1_View.setImageResource(R.drawable.red);
        }
    }
}
