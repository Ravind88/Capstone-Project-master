package com.udacity.ravindmauriya.capstonestage2.ui.hotels;


import com.udacity.ravindmauriya.capstonestage2.model.PlaceListDetail;
import com.udacity.ravindmauriya.capstonestage2.ui.common.CommonView;

import java.util.List;

/**
 * Created by ravind on 21/01/17.
 */
interface HotelView extends CommonView {
    void setData(List<PlaceListDetail> placeListDetailArrayList);
}
