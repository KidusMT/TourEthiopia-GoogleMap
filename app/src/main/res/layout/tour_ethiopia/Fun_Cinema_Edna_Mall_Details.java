package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.model.LatLng;

/*
 * Created by KidusMT on 5/20/2016.
 */
public class Fun_Cinema_Edna_Mall_Details extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fun_coffee_kaldis_detail,container,false);
    }

    LatLng kaldis_coffee_latlng ;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fun_coffee_kaldis){
            Intent ikaldis = new Intent("android.intent.action.MAP");
            ikaldis.putExtra("kaldis_coffee",kaldis_coffee_latlng);
            startActivity(ikaldis);
        }
    }
}