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
public class Bank_National extends ListFragment {
    /** An array of items to display in ArrayList */
    String bank_national[] = new String[]{
            "Bank of Abyssinia",
            "Construction and Business Bank",
            "Cooperative Bank of Oromia",
            "Dashen Bank",
            "Development Bank of Ethiopia",
            "United Bank",
    };


    @SuppressWarnings("deprecation")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Creating array adapter to set data in listview */

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                android.R.layout.simple_list_item_single_choice, bank_national);

        /** Setting the array adapter to the listview */
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    double[] lat_Cooperative = {};
    double[] lng_Cooperative = {};

    double[] lat_Dashen = {};
    double[] lng_Dashen = {};

    double[] lat_Development = {};
    double[] lng_Development = {};

    double[] lat_United = {};
    double[] lng_United = {};

    double[] lat_Abyssinia = {};
    double[] lng_Abyssinia = {};

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
            case 0:
                Intent iCooperative = new Intent("android.intent.action.MAP");
                iCooperative.putExtra("bank_int_Lat",lat_Cooperative);
                iCooperative.putExtra("bank_int_Lng",lng_Cooperative);
                startActivity(iCooperative);
                break;
            case 1:
                Intent iBerhan = new Intent("android.intent.action.MAP");
                iBerhan.putExtra("bank_int_Lat",lat_Dashen);
                iBerhan.putExtra("bank_int_Lng",lng_Dashen);
                startActivity(iBerhan);
                break;
            case 2:
                Intent iDevelopment = new Intent("android.intent.action.MAP");
                iDevelopment.putExtra("bank_int_Lat",lat_Development);
                iDevelopment.putExtra("bank_int_Lng",lng_Development);
                startActivity(iDevelopment);
                break;
            case 3:
                Intent iUnited = new Intent("android.intent.action.MAP");
                iUnited.putExtra("bank_int_Lat",lat_United);
                iUnited.putExtra("bank_int_Lng",lng_United);
                startActivity(iUnited);
                break;
            case 4:
                Intent iAbyssinia = new Intent("android.intent.action.MAP");
                iAbyssinia.putExtra("bank_int_Lat",lat_Abyssinia);
                iAbyssinia.putExtra("bank_int_Lng",lng_Abyssinia);
                startActivity(iAbyssinia);
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