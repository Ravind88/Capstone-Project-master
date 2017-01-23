package com.udacity.ravindmauriya.capstonestage2.ui.common;

import android.content.Context;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface ApiListener {
    void onApiSuccess(ArrayList<LinkedHashMap> response);

    Context getViewContext();
}
