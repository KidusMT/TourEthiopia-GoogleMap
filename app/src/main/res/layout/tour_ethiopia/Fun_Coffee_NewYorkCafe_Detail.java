package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by KidusMT on 5/20/2016.
 */
public class Fun_Coffee_NewYorkCafe_Detail extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fun_coffee_new_york_detail,container,false);
    }

    LatLng ny_coffee_latlng ;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fun_coffee_ny){
            Intent iny = new Intent("android.intent.action.MAP");
            iny.putExtra("kaldis_coffee",ny_coffee_latlng);
            startActivity(iny);
        }
    }
}