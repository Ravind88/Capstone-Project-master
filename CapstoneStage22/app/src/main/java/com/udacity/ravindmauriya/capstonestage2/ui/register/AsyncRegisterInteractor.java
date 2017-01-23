package com.udacity.ravindmauriya.capstonestage2.ui.register;

import android.app.Activity;
import android.util.Log;

import com.kumulos.android.Kumulos;
import com.kumulos.android.ResponseHandler;
import com.udacity.ravindmauriya.capstonestage2.R;
import com.udacity.ravindmauriya.capstonestage2.base.ApplicationController;
import com.udacity.ravindmauriya.capstonestage2.model.RequestBean;
import com.udacity.ravindmauriya.capstonestage2.ui.common.ApiListener;
import com.udacity.ravindmauriya.capstonestage2.ui.common.ApiRegisterListener;
import com.udacity.ravindmauriya.capstonestage2.utility.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;


class AsyncRegisterInteractor {

    void validateCredentialsAsync(final ApiRegisterListener listener, RequestBean requestBean) {
        if (ApplicationController.getApplicationInstance().isNetworkConnected()) {
            HashMap<String, String> properties = new HashMap<>();
            properties.put("username", requestBean.getUsername());
            properties.put("password", requestBean.getPassword());
            properties.put("fullname", requestBean.getName());
            properties.put("email", requestBean.getEmail());


            Kumulos.call("register", properties, new ResponseHandler() {
                @Override
                public void didCompleteWithResult(Object result) {
                    // Do updates to UI/data models based on result
                    Log.i("Response", result.toString());
                    listener.onApiSuccess();
                }
            });

        } else
            Utility.showSnackBar((Activity) listener.getViewContext(),
                    listener.getViewContext().getString(R.string.no_internet_connection));
        // SOAP Api Logic
    }
}
