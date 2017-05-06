package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by KidusMT on 5/21/2016.
 */
public class Embassy extends Activity {

    ArrayList<Double> markersArray = new ArrayList<>();

    LatLng[] latlng_embassies;

    /** Called when the activity is first created. */

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void onEmbassies(){
        Intent imap = new Intent(this, com.googleplaystore.kidusmt.tour_ethiopia.MapsActivity.class);
        imap.putExtra("capital_latlng",latlng_embassies);
        startActivity(imap);
        this.finish();
    }
}