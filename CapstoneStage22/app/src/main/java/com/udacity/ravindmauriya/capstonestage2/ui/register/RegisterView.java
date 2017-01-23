
package com.udacity.ravindmauriya.capstonestage2.ui.register;


import com.udacity.ravindmauriya.capstonestage2.ui.common.CommonView;

interface RegisterView extends CommonView {
    void navigateHome();

    void registerFailed(String response);

}
