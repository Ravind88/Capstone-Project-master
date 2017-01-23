package com.udacity.ravindmauriya.capstonestage2.ui.home;


import com.udacity.ravindmauriya.capstonestage2.ui.common.CommonView;

/**
 * Created by ravind on 11/11/16.
 */
public interface HomeView extends CommonView {
    /**
     * Called when an item in the navigation drawer is selected.
     *
     * @param navDrawerEnum Enum selected
     */
    void onNavigationDrawerItemSelected(NavDrawerEnum navDrawerEnum);

}
