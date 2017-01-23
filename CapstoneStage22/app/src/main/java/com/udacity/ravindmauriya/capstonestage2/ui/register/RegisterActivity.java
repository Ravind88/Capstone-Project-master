package com.udacity.ravindmauriya.capstonestage2.ui.register;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.udacity.ravindmauriya.capstonestage2.R;
import com.udacity.ravindmauriya.capstonestage2.base.BaseActivity;
import com.udacity.ravindmauriya.capstonestage2.databinding.ActivityRegisterBinding;
import com.udacity.ravindmauriya.capstonestage2.model.RequestBean;
import com.udacity.ravindmauriya.capstonestage2.ui.home.HomeActivity;
import com.udacity.ravindmauriya.capstonestage2.utility.Constants;
import com.udacity.ravindmauriya.capstonestage2.utility.Utility;


/**
 * Created by ravind on 10/11/16.
 */

public class RegisterActivity extends BaseActivity implements RegisterView {

    RegisterPresenter mPresenter;

    @Override
    protected void initUi() {
        setBackButtonEnabled();
        findViewById(R.id.register_tv).setOnClickListener(this);
        mPresenter = new RegisterPresenter(this);
    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_register;
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.register_tv:
                RequestBean requestBean = new RequestBean();
                ActivityRegisterBinding activityRegisterBinding = (ActivityRegisterBinding) this.viewDataBinding;
                requestBean.setName(activityRegisterBinding.fullNameEd.getText().toString().trim());
                requestBean.setUsername(activityRegisterBinding.usernameEd.getText().toString().trim());
                requestBean.setPassword(activityRegisterBinding.passwordEd.getText().toString().trim());
                requestBean.setRePassword(activityRegisterBinding.rePasswordEd.getText().toString().trim());

                requestBean.setEmail(activityRegisterBinding.emailEd.getText().toString().trim());

                mPresenter.attemptSignUp(requestBean);
                break;
        }
    }

    @Override
    public void navigateHome() {
        ActivityRegisterBinding activityRegisterBinding = (ActivityRegisterBinding) this.viewDataBinding;

        Utility.putBooleanValueInSharedPreference(getActivity(), Constants.PREFS_LOGGED_IN, true);
        Utility.putStringValueInSharedPreference(getActivity(), Constants.PREFS_USER_NAME, activityRegisterBinding.usernameEd.getText().toString().trim());
        Utility.putStringValueInSharedPreference(getActivity(), Constants.PREFS_PASSWORD, activityRegisterBinding.passwordEd.getText().toString().trim());

        Intent intent = new Intent(getActivity(), HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    @Override
    public void registerFailed(String response) {


    }

    @Override
    public Context getViewContext() {
        return this;
    }

    @Override
    public void showProgress(boolean showProgress) {
        showProgressDialog(showProgress);
    }
}
