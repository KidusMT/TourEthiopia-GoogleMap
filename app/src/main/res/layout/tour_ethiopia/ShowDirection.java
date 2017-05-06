package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by KidusMT on 6/3/2016.
 */
public class ShowDirection extends ListFragment {

    String[] famousLocations;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        famousLocations = new String[]{
                "Mexico",
                "Megenagna",
                "Bole",
                "Bole Michael",
                "Radison Blue Hotel",
                "Tor-hayloch",
                "Ambasader",
                "Bherawi",
                "Piasa",
                "Fil-Wiha",
                "Bethel",
                "Alem-Bank",
                "Ayer Tena",
                "Kotebe",
                "Shiromeda",
                "Lafto",
                "Mebrat",
                "Kera",
                "Stadium",
                "22 (haya-hulet)",
                "lideta",
                "Hayat"
        };

        /** Setting the array adapter to the listview */
        setListAdapter(new ArrayAdapter<String>(getActivity().getBaseContext(),android.R.layout.simple_list_item_1,famousLocations));

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
            case 0:

                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            case 10:

                break;
            case 11:

                break;
            case 12:

                break;
            case 13:

                break;
            case 14:

                break;
            case 15:

                break;
            case 16:

                break;
            case 17:

                break;
            case 18:

                break;
            case 19:

                break;
            case 20:

                break;
            case 21:

                break;
        }

        super.onListItemClick(l, v, position, id);
    }
}
