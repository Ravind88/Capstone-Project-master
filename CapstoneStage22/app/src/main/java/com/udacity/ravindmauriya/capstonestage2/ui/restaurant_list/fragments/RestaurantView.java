package com.udacity.ravindmauriya.capstonestage2.ui.restaurant_list.fragments;


import com.udacity.ravindmauriya.capstonestage2.model.PlaceListDetail;
import com.udacity.ravindmauriya.capstonestage2.ui.common.CommonView;

import java.util.ArrayList;

/**
 * Created by ravind on 21/01/17.
 */
public interface RestaurantView extends CommonView {
    void setData(ArrayList<PlaceListDetail> placeListDetailArrayList);
}
