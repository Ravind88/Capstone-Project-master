package com.udacity.ravindmauriya.capstonestage2.ui.common;

import android.content.Context;

import com.app.facebooklibrary.FBBean;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface ApiRegisterListener {
    void onApiSuccess();

    void fbApiSuccess(FBBean fb);

    Context getViewContext();
}
