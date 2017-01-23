package com.udacity.ravindmauriya.capstonestage2.ui.tourist;


import com.udacity.ravindmauriya.capstonestage2.model.PlaceListDetail;
import com.udacity.ravindmauriya.capstonestage2.ui.common.CommonView;

import java.util.List;

/**
 * Created by ravind on 21/01/17.
 */
interface TouristsView extends CommonView {
    void setData(List<PlaceListDetail> placeListDetailList);
}
