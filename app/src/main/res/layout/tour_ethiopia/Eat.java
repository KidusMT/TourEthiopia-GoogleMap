package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

/**
 * Created by KidusMT on 5/8/2016.
 */
public class Eat extends Activity {
    /** Called when the activity is first created. */

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //The following code requestes the user to use the screen portrait
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        ActionBar actionBar = getActionBar();
        assert actionBar != null;
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        actionBar.setDisplayShowTitleEnabled(true);

        /** Creating ANDROID Tab */
        ActionBar.Tab tab = actionBar.newTab()
                .setText("Food")
                .setTabListener(new com.googleplaystore.kidusmt.tour_ethiopia.CustomTabListener<>(this, "food", com.googleplaystore.kidusmt.tour_ethiopia.Eat_Food_Fragment.class))
                .setIcon(R.drawable.shop_food);

        actionBar.addTab(tab);
    }
}