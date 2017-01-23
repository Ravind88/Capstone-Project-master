package com.udacity.ravindmauriya.capstonestage2.ui.splash;

import android.content.Context;
import android.content.Intent;

import com.udacity.ravindmauriya.capstonestage2.R;
import com.udacity.ravindmauriya.capstonestage2.base.BaseActivity;
import com.udacity.ravindmauriya.capstonestage2.ui.home.HomeActivity;
import com.udacity.ravindmauriya.capstonestage2.ui.login.LoginActivity;
import com.udacity.ravindmauriya.capstonestage2.utility.Utility;


/**
 * Created by ravind on 08/11/16.
 */

public class SplashActivity extends BaseActivity implements SplashView {
    private SplashPresenterImpl splashPresenter;

    @Override
    protected void initUi() {
        Utility.generateFBKeyHash(getActivity());
        splashPresenter = new SplashPresenterImpl(this);
        splashPresenter.checkLoggedIn();
    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onDestroy() {
        splashPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void navigateHome() {
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void navigateLogin() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public Context getViewContext() {
        return this;
    }

    @Override
    public void showProgress(boolean showProgress) {

    }
}
