package com.udacity.ravindmauriya.capstonestage2.ui.reviews;


import com.udacity.ravindmauriya.capstonestage2.model.ReviewModel;
import com.udacity.ravindmauriya.capstonestage2.ui.common.CommonView;

import java.util.ArrayList;

/**
 * Created by ravind on 21/01/17.
 */
interface ReviewsView extends CommonView {
    void setData(ArrayList<ReviewModel> reviewModelArrayList);
}
