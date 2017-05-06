package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by KidusMT on 5/21/2016.
 */
public class Discovery_Africa_Parks_Detail extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate( R.layout.discovery_aau_museum_detail, container, false);
    }

    LatLng[] africaPark = {};

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.discover_africapark){
            Intent iafricaPark = new Intent("android.intent.action.MAP");
            iafricaPark.putExtra("africaPark",africaPark);
            startActivity(iafricaPark);
        }
    }
}
