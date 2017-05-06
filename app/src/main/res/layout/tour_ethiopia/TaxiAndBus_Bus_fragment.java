package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by KidusMT on 5/21/2016.
 */
public class TaxiAndBus_Bus_fragment extends ListFragment {
    /** An array of items to display in ArrayList */
    String bus_list[] = new String[]{
            "Anbesa Bus",
            "Selam Bus",
            "Sky Bus",
            "Abay Bus"
    };

    double[] Anbesa_lat = {};
    double[] Anbesa_lng = {};

    double[] Selam_lat = {};
    double[] Selam_lng = {};

    double[] Sky_lat = {};
    double[] Sky_lng = {};

    double[] Abay_lat = {};
    double[] Abay_lng = {};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Creating array adapter to set data in listview */

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                android.R.layout.simple_list_item_single_choice, bus_list);

        /** Setting the array adapter to the listview */
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
            case 0:
                Intent iAnbesa = new Intent("");
                iAnbesa.putExtra("",Anbesa_lat);
                iAnbesa.putExtra("",Anbesa_lng);
                startActivity(iAnbesa);
                break;
            case 1:
                Intent iSelam= new Intent("");
                iSelam.putExtra("",Selam_lat);
                iSelam.putExtra("",Selam_lng);
                startActivity(iSelam);
                break;
            case 2:
                Intent iSkyBus= new Intent("");
                iSkyBus.putExtra("",Sky_lat);
                iSkyBus.putExtra("",Sky_lng);
                startActivity(iSkyBus);
                break;
            case 3:
                Intent iAbayBus= new Intent("");
                iAbayBus.putExtra("",Abay_lat);
                iAbayBus.putExtra("",Abay_lng);
                startActivity(iAbayBus);
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        /** Setting the multiselect choice mode for the listview */

        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

}