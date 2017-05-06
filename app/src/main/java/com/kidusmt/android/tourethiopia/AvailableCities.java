package com.kidusmt.android.tourethiopia;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AvailableCities extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private android.support.v7.widget.RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    DrawerLayout drawer;

    private static final int RESULT_SETTINGS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_cities);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.drawerList);
        recyclerAdapter = new RecyclerAdapter(getBaseContext(), getData());
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.addOnItemTouchListener(new MyRecyclerItemClickListener(getBaseContext(),
                recyclerView, new MyRecyclerItemClickListener.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                Intent i = new Intent(AvailableCities.this,SuggestedActivity.class);
                startActivity(i);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(AvailableCities.this, "Long Click is Working", Toast.LENGTH_SHORT).show();
            }
        }));

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    public List<Information> getData() {

        List<Information> data = new ArrayList<>();
        int[] icons = {
                R.drawable.addis,
                R.drawable.adama,
                R.drawable.hawassa,
                R.drawable.bahirdar,
                R.drawable.diredawa,
                R.drawable.gondar,
                R.drawable.axum};
        String[] title = {"Addis Ababa", "Nazret", "Hawassa", "Bahir Dar", "DireDawa", "Gondar", "Axum"};
        String[] disc = {"Capital City","100KM from Capital","250KM from Capital","430KM from Capital",
        "519KM from Capital","512KM from Capital","970KM from Capital"};
        for (int j = 0; j < icons.length && j < title.length; j++) {
            Information current = new Information();
            current.icon = icons[j];
            current.title = title[j];
            current.tilte2 = disc[j];
            data.add(current);
        }
        return data;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.available_cities, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.setting:
                Intent i = new Intent(this, SettingsActivity.class);
                startActivityForResult(i, RESULT_SETTINGS);//this statement should work
                //startActivity(i);
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
//                if (drawer.isDrawerOpen()) {
//                    drawer.closeDrawer(listView);
//                } else {
//                    drawer.openDrawer(listView);
//                }
//            default:
//                drawer.openDrawer(listView);
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
                DialogFragment newFragment = new Help();
                newFragment.show(ft,"dialog");
                break;
            case "about":
                DialogFragment about = new About();
                about.show(ft, "dialog");
                break;
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_info) {

        } else if (id == R.id.nav_map) {
            Intent imap = new Intent(AvailableCities.this,MapsActivity.class);
            startActivity(imap);
        } else if (id == R.id.nav_suggested) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_settings) {
            Intent i = new Intent(this, SettingsActivity.class);
            //startActivityForResult(i, RESULT_SETTINGS);//this statement should work
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static class MyRecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        public static interface OnItemClickListener {
            public void onItemClick(View view, int position);

            public void onItemLongClick(View view, int position);
        }

        private OnItemClickListener mListener;
        private GestureDetector mGestureDetector;

        public MyRecyclerItemClickListener(Context context, final
        RecyclerView recyclerView, OnItemClickListener listener) {
            mListener = listener;
            mGestureDetector = new GestureDetector(context, new
                    GestureDetector.SimpleOnGestureListener() {
                        @Override
                        public boolean onSingleTapUp(MotionEvent e) {
                            return true;
                        }

                        @Override
                        public void onLongPress(MotionEvent e) {
                            View child = recyclerView.findChildViewUnder(e.getX(),
                                    e.getY());
                            if (child != null && mListener != null) {
                                mListener.onItemLongClick(child, recyclerView.
                                        getChildPosition(child));
                            }
                        }
                    });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent
                e) {
            View child = view.findChildViewUnder(e.getX(), e.getY());
            if (child != null && mListener != null && mGestureDetector.
                    onTouchEvent(e)) {
                mListener.onItemClick(child, view.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
            //Empty
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            //Empty
        }
    }
}
