package com.udacity.ravindmauriya.capstonestage2.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.udacity.ravindmauriya.capstonestage2.base.ApplicationController;
import com.udacity.ravindmauriya.capstonestage2.utility.Utility;


public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (Utility.getNetworkState(context)) {
            ApplicationController.getApplicationInstance().setIsNetworkConnected(true);
            Log.i("Network Receiver", "connected");
        } else {
            ApplicationController.getApplicationInstance().setIsNetworkConnected(false);
            Log.i("Network Receiver", "disconnected");
        }
    }
}

