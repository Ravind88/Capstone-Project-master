package com.udacity.ravindmauriya.capstonestage2.ui.flights;


import com.udacity.ravindmauriya.capstonestage2.model.FlightDetailModel;
import com.udacity.ravindmauriya.capstonestage2.ui.common.CommonView;

import java.util.ArrayList;

/**
 * Created by ravind on 21/01/17.
 */
interface FlightsDetailView extends CommonView {
    void setData(ArrayList<FlightDetailModel> flightDetailModelArrayList);
}
