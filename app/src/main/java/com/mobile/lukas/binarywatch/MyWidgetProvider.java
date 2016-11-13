package com.mobile.lukas.binarywatch;

import android.appwidget.AppWidgetProvider;

import java.util.Calendar;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RemoteViews;

/**
 * Created by Lukas on 13/11/2016.
 */

public class MyWidgetProvider extends AppWidgetProvider {

    private int minutes;
    private int hours;
    private int seconds;

    private static final String ACTION_CLICK = "ACTION_CLICK";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {

        // Get all ids
        ComponentName thisWidget = new ComponentName(context, MyWidgetProvider.class);
        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
        for (int widgetId : allWidgetIds) {
            // create some random data

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
            // Set the text
            Calendar c  = Calendar.getInstance();
            minutes     = c.get(Calendar.MINUTE);
            //getter for 12-based hour, 24 based: HOUR_OF_DAY
            hours       = c.get(Calendar.HOUR);
            seconds     = c.get(Calendar.SECOND);
            setTimeToViews(remoteViews);

            // Register an onClickListener
            Intent intent = new Intent(context, MyWidgetProvider.class);

            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
    }

 /*   private void runClock(final RemoteViews remoteViews) {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                Calendar c  = Calendar.getInstance();
                minutes     = c.get(Calendar.MINUTE);
                //getter for 12-based hour, 24 based: HOUR_OF_DAY
                hours       = c.get(Calendar.HOUR);
                seconds     = c.get(Calendar.SECOND);
                setTimeToViews(remoteViews);
                handler.postDelayed(this,1000);
            }
        });
    }*/

    private void setTimeToViews(RemoteViews remoteViews) {

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
            remoteViews.setImageViewResource(R.id.hr_8_View, R.drawable.green);
        } else {
            remoteViews.setImageViewResource(R.id.hr_8_View, R.drawable.red);
        }

        if(hrs_string.charAt(1) == '1') {
            remoteViews.setImageViewResource(R.id.hr_4_View, R.drawable.green);
        } else {
            remoteViews.setImageViewResource(R.id.hr_4_View, R.drawable.red);
        }

        if(hrs_string.charAt(2) == '1') {
            remoteViews.setImageViewResource(R.id.hr_2_View, R.drawable.green);
        } else {
            remoteViews.setImageViewResource(R.id.hr_2_View, R.drawable.red);
        }

        if(hrs_string.charAt(3) == '1') {
            remoteViews.setImageViewResource(R.id.hr_1_View, R.drawable.green);
        } else {
            remoteViews.setImageViewResource(R.id.hr_1_View, R.drawable.red);
        }

        //set minute leds
        if(min_string.charAt(0) == '1') {
            remoteViews.setImageViewResource(R.id.min_32_View, R.drawable.green);
        } else {
            remoteViews.setImageViewResource(R.id.min_32_View, R.drawable.red);
        }

        if(min_string.charAt(1) == '1') {
            remoteViews.setImageViewResource(R.id.min_16_View, R.drawable.green);
        } else {
            remoteViews.setImageViewResource(R.id.min_16_View, R.drawable.red);
        }

        if(min_string.charAt(2) == '1') {
            remoteViews.setImageViewResource(R.id.min_8_View, R.drawable.green);
        } else {
            remoteViews.setImageViewResource(R.id.min_8_View, R.drawable.red);
        }

        if(min_string.charAt(3) == '1') {
            remoteViews.setImageViewResource(R.id.min_4_View, R.drawable.green);
        } else {
            remoteViews.setImageViewResource(R.id.min_4_View, R.drawable.red);
        }

        if(min_string.charAt(4) == '1') {
            remoteViews.setImageViewResource(R.id.min_2_View, R.drawable.green);
        } else {
            remoteViews.setImageViewResource(R.id.min_2_View, R.drawable.red);
        }

        if(min_string.charAt(5) == '1') {
            remoteViews.setImageViewResource(R.id.min_1_View, R.drawable.green);
        } else {
            remoteViews.setImageViewResource(R.id.min_1_View, R.drawable.red);
        }

        //set second leds
        if(sec_string.charAt(0) == '1') {
            remoteViews.setImageViewResource(R.id.sec_32_View, R.drawable.green);
        } else {
            remoteViews.setImageViewResource(R.id.sec_32_View, R.drawable.red);
        }

        if(sec_string.charAt(1) == '1') {
            remoteViews.setImageViewResource(R.id.sec_16_View, R.drawable.green);
        } else {
            remoteViews.setImageViewResource(R.id.sec_16_View, R.drawable.red);
        }

        if(sec_string.charAt(2) == '1') {
            remoteViews.setImageViewResource(R.id.sec_8_View, R.drawable.green);
        } else {
            remoteViews.setImageViewResource(R.id.sec_8_View, R.drawable.red);
        }

        if(sec_string.charAt(3) == '1') {
            remoteViews.setImageViewResource(R.id.sec_4_View, R.drawable.green);
        } else {
            remoteViews.setImageViewResource(R.id.sec_4_View, R.drawable.red);
        }

        if(sec_string.charAt(4) == '1') {
            remoteViews.setImageViewResource(R.id.sec_2_View, R.drawable.green);
        } else {
            remoteViews.setImageViewResource(R.id.sec_2_View, R.drawable.red);
        }

        if(sec_string.charAt(5) == '1') {
            remoteViews.setImageViewResource(R.id.sec_1_View, R.drawable.green);
        } else {
            remoteViews.setImageViewResource(R.id.sec_1_View, R.drawable.red);
        }
    }
}
