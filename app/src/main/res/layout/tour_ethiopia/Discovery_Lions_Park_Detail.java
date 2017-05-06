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
public class Discovery_Lions_Park_Detail extends Fragment implements View.OnClickListener{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.discover_lions_park_detail,container,false);
    }

    LatLng africaLatlng = new LatLng(2.34,2.342);
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.discover_lionPark){
            Intent ilionPark = new Intent();
            ilionPark.putExtra("lionPark",africaLatlng);
            startActivity(ilionPark);
        }
    }
}
