
package com.udacity.ravindmauriya.capstonestage2.ui.login;


import com.app.facebooklibrary.FBBean;
import com.udacity.ravindmauriya.capstonestage2.ui.common.CommonView;

import java.util.ArrayList;
import java.util.LinkedHashMap;

interface LoginView extends CommonView {
    void navigateHome(ArrayList<LinkedHashMap> response);
    void navigateFromFbHome(FBBean fbBean);
    void loginFailed(String response);

}
