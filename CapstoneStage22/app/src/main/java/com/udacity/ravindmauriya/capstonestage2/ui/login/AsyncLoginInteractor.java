package com.udacity.ravindmauriya.capstonestage2.ui.login;

import android.app.Activity;
import android.util.Log;

import com.app.facebooklibrary.FBBean;
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

class AsyncLoginInteractor {

    /******************************************************************************************
     * An Interactor helps models cross application boundaries such as networks or serialization
     * This LoginInteractor knows nothing about a UI or the LoginPresenter
     * Because this is an asynchronous call it will call back on the OnLoginFinishedListener when complete
     * ******************************************************************************************
     */

    void validateCredentialsAsync(final ApiListener listener, RequestBean requestBean) {
        if (ApplicationController.getApplicationInstance().isNetworkConnected()) {
            HashMap<String, String> properties = new HashMap<>();
            properties.put("username", requestBean.getUsername());
            properties.put("password", requestBean.getPassword());

            Kumulos.call("login", properties, new ResponseHandler() {
                @Override
                public void didCompleteWithResult(Object result) {
                    // Do updates to UI/data models based on result
                    Log.i("Response", result.toString());
                    if (result instanceof ArrayList) {
                        ArrayList<LinkedHashMap> linkedHashMapArrayList = (ArrayList<LinkedHashMap>) result;
                        listener.onApiSuccess(linkedHashMapArrayList);
                    }
                }
            });

        } else
            Utility.showSnackBar((Activity) listener.getViewContext(),
                    listener.getViewContext().getString(R.string.no_internet_connection));
        // SOAP Api Logic
    }


    void facebookLoginAsync(final ApiRegisterListener listener,final FBBean requestBean) {
        if (ApplicationController.getApplicationInstance().isNetworkConnected()) {
            HashMap<String, String> properties = new HashMap<>();
            properties.put("username", requestBean.getUserName());
            properties.put("password", requestBean.getUserID());
            properties.put("name", requestBean.getFirstName());
            properties.put("facebookid", requestBean.getUserID());

            Kumulos.call("facebooklogin", properties, new ResponseHandler() {
                @Override
                public void didCompleteWithResult(Object result) {
                    // Do updates to UI/data models based on result
                    Log.i("Response", result.toString());
                    listener.fbApiSuccess(requestBean);
                }
            });

        } else
            Utility.showSnackBar((Activity) listener.getViewContext(),
                    listener.getViewContext().getString(R.string.no_internet_connection));
        // SOAP Api Logic
    }
}
