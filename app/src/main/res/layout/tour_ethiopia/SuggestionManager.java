package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Created by KidusMT on 5/14/2016.
 */

public class SuggestionManager extends FragmentActivity implements ActionBar.TabListener {
    /**
     * Called when the activity is first created.
     */

    private ViewPager viewPager;
    private ActionBar actionBar;
    // Tab titles
    private String[] tabs = { "All", "Suggested"};

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suggestion_manager);

        viewPager = (ViewPager) findViewById(R.id.suggestion_pager);
        viewPager.setAdapter(new com.googleplaystore.kidusmt.tour_ethiopia.MySuggestedAdapter(getSupportFragmentManager()));
        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setHomeButtonEnabled(true);

        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {

    }
}

class MySuggestedAdapter extends FragmentPagerAdapter {
    public MySuggestedAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SuggestedLocations_Frag_All();
            case 1:
                return new SuggestedLocations_suggested();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}