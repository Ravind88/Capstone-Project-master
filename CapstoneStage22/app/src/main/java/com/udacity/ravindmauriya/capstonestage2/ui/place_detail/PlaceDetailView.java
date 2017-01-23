package com.udacity.ravindmauriya.capstonestage2.ui.place_detail;


import com.udacity.ravindmauriya.capstonestage2.ui.common.CommonView;

import org.json.JSONObject;

/**
 * Created by ravind on 21/01/17.
 */

public interface PlaceDetailView extends CommonView {
    void parseData(JSONObject jsonObject);
}
