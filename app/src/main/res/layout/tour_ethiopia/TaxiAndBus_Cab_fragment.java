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
public class TaxiAndBus_Cab_fragment extends ListFragment {
    /** An array of items to display in ArrayList */
    String Cabs_list[] = new String[]{
            "Lada",
            "Yellow Airport Cab",
            "Adika Yellow Cab"
    };

    double[] Lada_lat = {};
    double[] Lada_lng = {};

    double[] AirCab_lat = {};
    double[] AirCab_lng = {};

    double[] Adika_lat = {};
    double[] Adika_lng = {};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Creating array adapter to set data in listview */

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                android.R.layout.simple_list_item_single_choice, Cabs_list);

        /** Setting the array adapter to the listview */
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
            case 0:
                Intent iLada = new Intent("");
                iLada.putExtra("",Lada_lat);
                iLada.putExtra("",Lada_lng);
                startActivity(iLada);
                break;
            case 1:
                Intent iAirCab= new Intent("");
                iAirCab.putExtra("",AirCab_lat);
                iAirCab.putExtra("",AirCab_lng);
                startActivity(iAirCab);
                break;
            case 2:
                Intent iAdika= new Intent("");
                iAdika.putExtra("",Adika_lat);
                iAdika.putExtra("",Adika_lng);
                startActivity(iAdika);
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