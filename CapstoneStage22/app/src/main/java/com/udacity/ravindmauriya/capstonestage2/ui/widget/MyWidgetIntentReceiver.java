package com.udacity.ravindmauriya.capstonestage2.ui.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


import com.udacity.ravindmauriya.capstonestage2.model.WidgetRefreshEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by ravind on 22/01/17.
 */

public class MyWidgetIntentReceiver extends BroadcastReceiver {
    public static int clickCount = 0;
    private String msg[] = null;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(MyAppWidgetProvider.WIDGET_UPDATE_ACTION)) {
            updateWidgetPictureAndButtonListener();
        }
    }

    private void updateWidgetPictureAndButtonListener() {
        EventBus.getDefault().post(new WidgetRefreshEvent());
    }


}

