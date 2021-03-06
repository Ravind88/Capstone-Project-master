package com.udacity.ravindmauriya.capstonestage2.ui.tourist_places.fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;


import com.udacity.ravindmauriya.capstonestage2.R;
import com.udacity.ravindmauriya.capstonestage2.base.BaseFragment;
import com.udacity.ravindmauriya.capstonestage2.model.PlaceListDetail;
import com.udacity.ravindmauriya.capstonestage2.ui.restaurant_list.adapters.PlaceListAdapter;
import com.udacity.ravindmauriya.capstonestage2.ui.restaurant_list.fragments.RestaurantPresenter;
import com.udacity.ravindmauriya.capstonestage2.ui.restaurant_list.fragments.RestaurantView;
import com.udacity.ravindmauriya.capstonestage2.utility.Constants;

import java.util.ArrayList;

public class MuseumFragment extends BaseFragment implements RestaurantView {

    private RecyclerView recyclerView;

    @Override
    protected void initUi() {
        Double latitude = getActivity().getIntent().getDoubleExtra(Constants.LATITUDE, 0.0);
        Double longitude = getActivity().getIntent().getDoubleExtra(Constants.LONGTITUDE, 0.0);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        int columnCount = 1;
        StaggeredGridLayoutManager sglm =
                new StaggeredGridLayoutManager(columnCount, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(sglm);


        //url to get list of places
        String sb = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?" + "location=" + latitude + "," + longitude +
                "&types=museum" +
                "&radius=30000" +
                "&rankby=prominence" +
                "&key=" + getString(R.string.api_key);

        RestaurantPresenter restaurantPresenter = new RestaurantPresenter(this);
        restaurantPresenter.getPlaceList(sb);
    }

    @Override
    protected int getLayoutById() {
        return R.layout.fragment_restaurants;
    }

    @Override
    public Context getViewContext() {
        return mContext;
    }

    @Override
    public void showProgress(boolean showProgress) {
        showProgressBar(showProgress);
    }

    @Override
    public void setData(ArrayList<PlaceListDetail> placeListDetailArrayList) {
        PlaceListAdapter placeListAdapter = new PlaceListAdapter(getActivity(), placeListDetailArrayList,
                Constants.TYPE_PLACES);
        recyclerView.setAdapter(placeListAdapter);
    }
}
