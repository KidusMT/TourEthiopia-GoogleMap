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
public class Bank_International extends ListFragment {
    /** An array of items to display in ArrayList */
    String bank_international[] = new String[]{
            "Awash International Bank",
            "Berhan International Bank",
            "Buna International Bank",
            "Lion International Bank",
            "Nib International Bank",
            "Wegagen Bank",
            "Zemen Bank"
    };

    @SuppressWarnings("deprecation")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Creating array adapter to set data in listview */

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                android.R.layout.simple_list_item_single_choice, bank_international);

        /** Setting the array adapter to the listview */
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    double[] lat_Awash = {};
    double[] lng_Awash = {};

    double[] lat_Berhan = {};
    double[] lng_Berhan = {};

    double[] lat_Buna = {};
    double[] lng_Buna = {};

    double[] lat_Lioh = {};
    double[] lng_Lioh = {};

    double[] lat_Nib = {};
    double[] lng_Nib = {};

    double[] lat_Wegagen = {};
    double[] lng_Wegagen = {};

    double[] lat_Zemen = {};
    double[] lng_Zemen = {};

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
            case 0:
                Intent iAwash = new Intent("android.intent.action.MAP");
                iAwash.putExtra("bank_int_Lat",lat_Awash);
                iAwash.putExtra("bank_int_Lng", lng_Awash);
                startActivity(iAwash);
                break;
            case 1:
                Intent iBerhan = new Intent("android.intent.action.MAP");
                iBerhan.putExtra("bank_int_Lat",lat_Berhan);
                iBerhan.putExtra("bank_int_Lng",lng_Berhan);
                startActivity(iBerhan);
                break;
            case 2:
                Intent iBuna = new Intent("android.intent.action.MAP");
                iBuna.putExtra("bank_int_Lat",lat_Buna);
                iBuna.putExtra("bank_int_Lng",lng_Buna);
                startActivity(iBuna);
                break;
            case 3:
                Intent iLion = new Intent("android.intent.action.MAP");
                iLion.putExtra("bank_int_Lat",lat_Lioh);
                iLion.putExtra("bank_int_Lng",lng_Lioh);
                startActivity(iLion);
                break;
            case 4:
                Intent iNib = new Intent("android.intent.action.MAP");
                iNib.putExtra("bank_int_Lat",lat_Nib);
                iNib.putExtra("bank_int_Lng", lng_Nib);
                startActivity(iNib);
                break;
            case 5:
                Intent iWegagne = new Intent("android.intent.action.MAP");
                iWegagne.putExtra("bank_int_Lat",lat_Wegagen);
                iWegagne.putExtra("bank_int_Lng",lng_Wegagen);
                startActivity(iWegagne);
                break;
            case 6:
                Intent iZemen = new Intent("android.intent.action.MAP");
                iZemen.putExtra("bank_int_Lat",lat_Zemen);
                iZemen.putExtra("bank_int_Lng", lng_Zemen);
                startActivity(iZemen);
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