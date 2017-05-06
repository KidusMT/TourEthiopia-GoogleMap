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
public class Shop_Food_Babis_Detail extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate( R.layout.shop_food_babis_detail, container, false);
    }

    LatLng[] babi = {};

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.shop_food_babis){
            Intent iBambis = new Intent("");
            iBambis.putExtra("babi",babi);
            startActivity(iBambis);
        }
    }
}
