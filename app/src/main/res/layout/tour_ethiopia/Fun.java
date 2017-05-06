package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Created by KidusMT on 5/8/2016.
 */
public class Fun extends Activity {
    /** Called when the activity is first created. */

    ArrayList<HashMap<String, String>> coffee_location = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String, String>> cinema_location = new ArrayList<HashMap<String, String>>();
    HashMap<String, String> fun_coffee;
    HashMap<String, String> fun_cinema;

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fun);
        //The following code requestes the user to use the screen portrait
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        //For the cinema fun locations=============================
        fun_cinema = new HashMap<String, String>();
        //Edna Mall
        fun_cinema.put("Latitude", "");
        fun_cinema.put("Longitude", "");
        cinema_location.add(fun_cinema);
        //
        fun_cinema = new HashMap<String, String>();
        fun_cinema.put("Latitude", "");
        fun_cinema.put("Longitude", "");
        cinema_location.add(fun_cinema);
        //
        fun_cinema = new HashMap<String, String>();
        fun_cinema.put("Latitude", "");
        fun_cinema.put("Longitude", "");
        cinema_location.add(fun_cinema);

        //for the coffee fun locations==============================
        fun_coffee = new HashMap<String, String>();
        //Tomoca
        fun_coffee.put("Latitude","");
        fun_coffee.put("Longitude", "");
        coffee_location.add(fun_coffee);
        // Yeshi
        fun_coffee = new HashMap<String, String>();
        fun_coffee.put("Latitude","");
        fun_coffee.put("Longitude","");
        coffee_location.add(fun_coffee);
        //New York
        fun_coffee = new HashMap<String, String>();
        fun_coffee.put("Latitude","");
        fun_coffee.put("Longitude","");
        coffee_location.add(fun_coffee);
        //Kaldis
        fun_coffee = new HashMap<String, String>();
        fun_coffee.put("Latitude","");
        fun_coffee.put("Longitude","");
        coffee_location.add(fun_coffee);

        ActionBar actionBar = getActionBar();
        assert actionBar != null;
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.setDisplayShowTitleEnabled(true);

        /** Creating Coffee Tab */
        ActionBar.Tab tab = actionBar.newTab()
                .setText("Coffee")
                .setTabListener(new CustomTabListener<>(com.googleplaystore.kidusmt.tour_ethiopia.Fun.this, "coffee", Fun_Coffee_Fragment.class))
                .setIcon(R.drawable.shop_food);

        actionBar.addTab(tab);

        /** Creating Cinema Tab */
        tab = actionBar.newTab()
                .setText("Cinema")
                .setTabListener(new CustomTabListener<>(this, "cinema", com.googleplaystore.kidusmt.tour_ethiopia.Fun_Cinema_Fragment.class))
                .setIcon(R.drawable.shop_mall);

        actionBar.addTab(tab);
    }

    public void onShowCinemaFrag(){
        Intent ifragcinema = new Intent(this,MapsActivity.class);
        ifragcinema.putExtra("fragDetail",cinema_location);
        startActivity(ifragcinema);
    }
    public void onShowCoffeeFrag(){
        Intent ifragcoffee = new Intent(this,MapsActivity.class);
        ifragcoffee.putExtra("fragDetail",coffee_location);
        startActivity(ifragcoffee);
    }
//    public void onTomoca(){
//        Intent itomoca = new Intent(this,MapsActivity.class);
//        itomoca.putExtra("",location);
//        startActivity(itomoca);
//    }
//    public void onYeshi(){
//        Intent iyehi = new Intent(this,MapsActivity.class);
//        iyehi.putExtra();
//        startActivity(iyehi);
//    }
//    public void onKaldis(){
//        Intent ikaldis = new Intent(this,MapsActivity.class);
//        ikaldis.putExtra();
//        startActivity(ikaldis);
//    }
//    public void onGoSipCoffee(){
//        Intent igosipcoffee = new Intent(this,MapsActivity.class);
//        igosipcoffee.putExtra();
//        startActivity(igosipcoffee);
//    }
//    public void onNewYorkCafe(){
//        Intent inewyorkcafe= new Intent(this,MapsActivity.class);
//        inewyorkcafe.putExtra();
//        startActivity(inewyorkcafe);
//    }
}