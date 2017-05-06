package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

/**
 * Created by KidusMT on 5/21/2016.
 */
public class Car_Rental extends Activity {
    /** Called when the activity is first created. */

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //The following code requestes the user to use the screen portrait
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        ActionBar actionBar = getActionBar();
        assert actionBar != null;
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.setDisplayShowTitleEnabled(true);

        /** Creating ANDROID Tab */
        ActionBar.Tab tab = actionBar.newTab()
                .setText("International")
                .setTabListener(new com.googleplaystore.kidusmt.tour_ethiopia.CustomTabListener<>(this, "international", Bank_International.class))
                .setIcon(R.drawable.shop_food);//This have to change

        actionBar.addTab(tab);

        /** Creating APPLE Tab */
        tab = actionBar.newTab()
                .setText("National")
                .setTabListener(new com.googleplaystore.kidusmt.tour_ethiopia.CustomTabListener<>(this, "national", com.googleplaystore.kidusmt.tour_ethiopia.Bank_National.class))
                .setIcon(R.drawable.shop_mall);

        actionBar.addTab(tab);

    }
}