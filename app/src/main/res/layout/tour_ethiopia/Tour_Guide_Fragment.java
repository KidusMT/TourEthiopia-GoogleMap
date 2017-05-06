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
public class Tour_Guide_Fragment extends ListFragment {
    /** An array of items to display in ArrayList */
    String DiscoveryList[] = new String[]{
            "National Museum",//Around Fil Wiha
            "Addis Ababa University Museum",//on a way from stadium to 4kilo(arat-kilo)
            "Lions Park",//Imaginary
            "Africa Park",//around sar-bet
    };

    double[] NMuseum_lat = {};
    double[] NMuseum_lng = {};

    double[] AAUMuseum_lat = {};
    double[] AAUMuseum_lng = {};

    double[] LionPark_lat = {};
    double[] LionPark_lng = {};

    double[] Africa_lat = {};
    double[] Africa_lng = {};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Creating array adapter to set data in listview */

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                android.R.layout.simple_list_item_single_choice, DiscoveryList);

        /** Setting the array adapter to the listview */
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
            case 0:
                Intent iNationalMuseum = new Intent("");
                iNationalMuseum.putExtra("",NMuseum_lat);
                iNationalMuseum.putExtra("",NMuseum_lng);
                startActivity(iNationalMuseum);
                break;
            case 1:
                Intent iAAUMuseum= new Intent("");
                iAAUMuseum.putExtra("",AAUMuseum_lat);
                iAAUMuseum.putExtra("",AAUMuseum_lng);
                startActivity(iAAUMuseum);
                break;
            case 2:
                Intent iLionParks= new Intent("");
                iLionParks.putExtra("",LionPark_lat);
                iLionParks.putExtra("",LionPark_lng);
                startActivity(iLionParks);
                break;
            case 3:
                Intent iAfrica= new Intent("");
                iAfrica.putExtra("",Africa_lat);
                iAfrica.putExtra("",Africa_lng);
                startActivity(iAfrica);
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