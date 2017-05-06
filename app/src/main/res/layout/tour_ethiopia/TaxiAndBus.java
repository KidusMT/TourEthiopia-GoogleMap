package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

/**
 * Created by KidusMT on 5/13/2016.
 */
public class TaxiAndBus extends Activity {
    /** Called when the activity is first created. */

    @Override
    @SuppressWarnings("deprecation")
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
                .setText("Cab")
                .setTabListener(new CustomTabListener<>(this, "Bus_Lada", Bus_Lada.class))
                .setIcon(R.drawable.shop_food);

        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Bus")
                .setTabListener(new CustomTabListener<>(this, "yellowAirPortCab", com.googleplaystore.kidusmt.tour_ethiopia.Bus_YellowAirPort.class))
                .setIcon(R.drawable.shop_food);

        actionBar.addTab(tab);

        /** Creating APPLE Tab */
        tab = actionBar.newTab()
                .setText("Train")
                .setTabListener(new CustomTabListener<>(this, "Kadika", Bus_Kadika.class))
                .setIcon(R.drawable.shop_mall);

        actionBar.addTab(tab);

    }
}