package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;

/**
 * Created by KidusMT on 5/10/2016.
 */
@SuppressWarnings("deprecation")
public class Shop extends Activity {
    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActionBar();
        assert actionBar != null;
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.setDisplayShowTitleEnabled(true);

        /** Creating ANDROID Tab */
        Tab tab = actionBar.newTab()
                .setText("Food")
                .setTabListener(new CustomTabListener<>(this, "food", Shop_Food_Fragment.class))
                .setIcon(R.drawable.shop_food);

        actionBar.addTab(tab);

        /** Creating APPLE Tab */
        tab = actionBar.newTab()
                .setText("Mall")
                .setTabListener(new CustomTabListener<>(this, "mall", Shop_Mall_Fragment.class))
                .setIcon(R.drawable.shop_mall);

        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Goods")
                .setTabListener(new CustomTabListener<>(this, "goods", Shop_Goods_Fragmet.class))
                .setIcon(R.drawable.shop_goods);

        //noinspection deprecation,deprecation,deprecation,deprecation
        actionBar.addTab(tab);
    }
}