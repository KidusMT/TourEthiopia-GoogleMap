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

public class Discovery_National_Museum extends Fragment implements View.OnClickListener{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.discovey_national_museum,container,false);

    }

    LatLng nationalMuseum_lnglng = new LatLng(9.234,33.43);

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.discover_nationalMuseum){

            Intent inationalMus = new Intent(com.googleplaystore.kidusmt.tour_ethiopia.Discovery_National_Museum.this.getContext(), com.googleplaystore.kidusmt.tour_ethiopia.MapsActivity.class);
            inationalMus.putExtra("nationalMuseum_lng",nationalMuseum_lnglng);
            startActivity(inationalMus);
        }
    }
}
