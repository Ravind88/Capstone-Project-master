package com.udacity.ravindmauriya.capstonestage2.ui.options;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.udacity.ravindmauriya.capstonestage2.R;
import com.udacity.ravindmauriya.capstonestage2.base.BaseActivity;
import com.udacity.ravindmauriya.capstonestage2.ui.flights.FlightsListActivity;
import com.udacity.ravindmauriya.capstonestage2.ui.hotels.HotelListActivity;
import com.udacity.ravindmauriya.capstonestage2.ui.restaurant_list.RestaurantListActivity;
import com.udacity.ravindmauriya.capstonestage2.ui.shopping.ShoppingActivity;
import com.udacity.ravindmauriya.capstonestage2.ui.tourist.TouristsActivity;
import com.udacity.ravindmauriya.capstonestage2.utility.Constants;


public class SelectOptionActivity extends BaseActivity implements SelectOptionView {

    String placeid;
    String url;
    LinearLayout hotels, restaurants, tourist, flights, shopping;
    FrameLayout frameLayout;
    ImageView back;
    TextView cityname;
    private SelectOptionPresenter selectOptionPresenter;

    @Override
    protected void initUi() {
        hotels = (LinearLayout) findViewById(R.id.hotels);
        restaurants = (LinearLayout) findViewById(R.id.restaurants);
        shopping = (LinearLayout) findViewById(R.id.shopping);
        tourist = (LinearLayout) findViewById(R.id.tourist);
        flights = (LinearLayout) findViewById(R.id.flight);
        frameLayout = (FrameLayout) findViewById(R.id.mainFrame);
        back = (ImageView) findViewById(R.id.back);
        cityname = (TextView) findViewById(R.id.cityname);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if (getIntent().getExtras() != null) {
            placeid = getIntent().getStringExtra(Constants.PLACE_ID);
            String name = getIntent().getStringExtra(Constants.NAME);
            cityname.setText(name);
        }

        url = "https://maps.googleapis.com/maps/api/place/details/json?placeid=" + placeid + "&key=" + getString(R.string.api_key);
        selectOptionPresenter = new SelectOptionPresenter(this);
        selectOptionPresenter.getPlaceDetail(url);

        restaurants.setOnClickListener(this);
        tourist.setOnClickListener(this);
        hotels.setOnClickListener(this);
        flights.setOnClickListener(this);
        shopping.setOnClickListener(this);
        /*


        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectOptionActivity.this, ShoppingActivity.class);
                i.putExtra("lat", lat);
                i.putExtra("lng", lng);
                startActivity(i);
                overridePendingTransition(R.anim.activity_open_translate, R.anim.activity_close_scale);
            }
        });*/
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.shopping:
                Intent i5 = new Intent(SelectOptionActivity.this, ShoppingActivity.class);
                i5.putExtra(Constants.LATITUDE, selectOptionPresenter.getLat());
                i5.putExtra(Constants.LONGTITUDE, selectOptionPresenter.getLng());
                startActivity(i5);
                break;
            case R.id.flight:
                Intent ir = new Intent(SelectOptionActivity.this, FlightsListActivity.class);
                startActivity(ir);
                break;
            case R.id.hotels:
                Intent i2 = new Intent(SelectOptionActivity.this, HotelListActivity.class);
                i2.putExtra(Constants.LATITUDE, selectOptionPresenter.getLat());
                i2.putExtra(Constants.LONGTITUDE, selectOptionPresenter.getLng());
                startActivity(i2);
                break;
            case R.id.tourist:
                Intent i1 = new Intent(SelectOptionActivity.this, TouristsActivity.class);
                i1.putExtra(Constants.LATITUDE, selectOptionPresenter.getLat());
                i1.putExtra(Constants.LONGTITUDE, selectOptionPresenter.getLng());
                startActivity(i1);
                break;
            case R.id.restaurants:
                Intent i = new Intent(SelectOptionActivity.this, RestaurantListActivity.class);
                i.putExtra(Constants.LATITUDE, selectOptionPresenter.getLat());
                i.putExtra(Constants.LONGTITUDE, selectOptionPresenter.getLng());
                startActivity(i);
                break;
        }
    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_select_option;
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
