package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/*
 * Created by KidusMT on 4/25/2016.
 */
public class MainActivity extends FragmentActivity {

    private String[] mNavigationDrawerItemTitles;
    private ListView listView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;

    private static final int RESULT_SETTINGS = 1;

    private CharSequence mTitle;

    ListView list;

    Integer[] imageId = {
            R.drawable.addis,
            R.drawable.adama,
            R.drawable.hawassa,
            R.drawable.diredawa,//change DireDawa picture
            R.drawable.bahirdar,
            R.drawable.gondar,
            R.drawable.jimma,
            R.drawable.mekelle,
            R.drawable.axum,
            R.drawable.axum//Change to Bishoftu
    };

    Integer[] nav_images = {
            R.drawable.menu_home,
            R.drawable.menu_fav,
            R.drawable.menu_information,
            R.drawable.menu_map
    };

    String[] main_nav_list ;
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        //============================================================================
        //    the following are for the NAVIGATION DRAWER
        //============================================================================
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.opendrawer,R.string.closedrawer){
            @Override
            public void onDrawerClosed(View drawerView) {
                Toast.makeText(com.googleplaystore.kidusmt.tour_ethiopia.MainActivity.this, "Drawer Closed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(com.googleplaystore.kidusmt.tour_ethiopia.MainActivity.this, "Drawer Opened", Toast.LENGTH_SHORT).show();
            }
        };

        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.DrawerEntryList);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        listView = (ListView)findViewById(R.id.drawer_nav_List);

        CustomNavigationList adapter = new CustomNavigationList(this,mNavigationDrawerItemTitles,nav_images);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    selectItem(position);
                }
            });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.opendrawer,R.string.closedrawer){
            @Override
            public void onDrawerClosed(View drawerView) {
            }
            @Override
            public void onDrawerOpened(View drawerView) {
            }
        };

        //-------------------------------------------------------------------------------
        //The code here controls the Menu ActionBar's Property
        //------------------------------------------------------------------------------

        getActionBar().setTitle("Where do you want to go?");
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowTitleEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //===========================================================================
        //              For the front City Menu lists
        //===========================================================================

        main_nav_list = getResources().getStringArray(R.array.main_nav_list);
        com.googleplaystore.kidusmt.tour_ethiopia.CustomList adapter2 = new com.googleplaystore.kidusmt.tour_ethiopia.CustomList(com.googleplaystore.kidusmt.tour_ethiopia.MainActivity.this, main_nav_list, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter2);

        //------------------------------------------------------------------------------
        //      THE ACTIONS FOR WHEN YOU CLICK THE CITY LIST
        //------------------------------------------------------------------------------
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setTitle(main_nav_list[position]);
                Intent intent = new Intent("android.intent.action.SUGGESTIONMANAGER");
                startActivity(intent);
            }
        });
        actionBarDrawerToggle.syncState();
    }

    private void selectItem(int position) {
        listView.setItemChecked(position, true);
        Fragment fragment = null;
        switch (position){
            case 0:
                //Because we are already in the MainActivity
                Toast.makeText(com.googleplaystore.kidusmt.tour_ethiopia.MainActivity.this, "First selected", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(listView);
                break;
            case 1:
                //Starts the favorite Activity
                Intent ifav = new Intent("android.intent.action.FAVORITE");
                startActivity(ifav);
                break;
            case 2://this is for the information page
                Toast.makeText(com.googleplaystore.kidusmt.tour_ethiopia.MainActivity.this, "coming soon", Toast.LENGTH_SHORT).show();
            case 3://This is for the map
                Intent imap = new Intent("android.intent.action.MAP");
                startActivity(imap);
                break;
        }

        if (fragment != null) {

            listView.setItemChecked(position, true);
            listView.setSelection(position);
            getActionBar().setTitle(mNavigationDrawerItemTitles[position]);
            drawerLayout.closeDrawer(listView);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    //for setting the title of the actionbar
    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    //Inflates the menu_map item on the main activity page
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_map; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    //Actions for the menu items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        //Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.setting:
                Intent i = new Intent(this, com.googleplaystore.kidusmt.tour_ethiopia.Prefs.class);
                startActivityForResult(i, RESULT_SETTINGS);
                break;
            case R.id.help:
                showDialog("help");
                break;
            case R.id.rate:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.googleplaystore.com"));
                startActivity(browserIntent);
                break;
            case R.id.about:
                showDialog("about");
                break;
            case R.id.exit:
                finish();//This method is used for exiting from the application
                break;
            case android.R.id.home://commands for the drawer open and close
                if (drawerLayout.isDrawerOpen(listView)) {
                    drawerLayout.closeDrawer(listView);
                } else {
                    drawerLayout.openDrawer(listView);
                }
            default:
                drawerLayout.openDrawer(listView);
        }
        return true;
    }

    void showDialog(String dialog){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment pre = getFragmentManager().findFragmentByTag("dialog");
        if (pre != null){
            ft.remove(pre);
        }
        ft.addToBackStack(null);
        switch (dialog){
            case "help":
                DialogFragment newFragment = new com.googleplaystore.kidusmt.tour_ethiopia.Help();
                newFragment.show(ft,"dialog");
                break;
            case "about":
                DialogFragment about = new com.googleplaystore.kidusmt.tour_ethiopia.About();
                about.show(ft, "dialog");
                break;
        }
    }

}
