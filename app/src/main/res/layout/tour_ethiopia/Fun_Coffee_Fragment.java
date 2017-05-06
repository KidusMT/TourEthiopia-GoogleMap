package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by KidusMT on 5/20/2016.
 */
public class Fun_Coffee_Fragment extends ListFragment {
        /** An array of items to display in ArrayList */

        ArrayList<HashMap<String, String>> location = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> sleep_locations;

            /** An array of items to display in ArrayList */
            String[] Fun_Coffee_Lists ;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Creating array adapter to set data in listview */

        Fun_Coffee_Lists= new String[]{
                "Tomoca-Coffee",
                "Kaldis-Coffee",
                "Yeshi-Coffee",
                "New York Cafe",
                "Go Sip Coffee",
                "La Parisienne",
                "Lime Tree",
                "Music Caffee"
        };

        /** Setting the array adapter to the listview */
        setListAdapter(new ArrayAdapter<String>(getActivity().getBaseContext(),android.R.layout
                .simple_list_item_1,Fun_Coffee_Lists));

//        sleep_locations = new HashMap<String, String>();
//        sleep_locations.put("Latitude", "9.3428347");
//        sleep_locations.put("Longitude", "9.3428347");
//        sleep_locations.put("LocationName", "Shebele Hotel");
//        location.add(sleep_locations);
//
//        sleep_locations.put("Latitude", "9.3428347");
//        sleep_locations.put("Longitude", "9.3428347");
//        sleep_locations.put("LocationName", "Sheraton");
//        location.add(sleep_locations);
//
//        sleep_locations.put("Latitude", "9.3428347");
//        sleep_locations.put("Longitude", "9.3428347");
//        sleep_locations.put("LocationName", "Jupiter");
//        location.add(sleep_locations);
//
//        sleep_locations.put("Latitude", "9.3428347");
//        sleep_locations.put("Longitude", "9.3428347");
//        sleep_locations.put("LocationName", "Capital");
//        location.add(sleep_locations);
//
//        sleep_locations.put("Latitude", "9.3428347");
//        sleep_locations.put("Longitude", "9.3428347");
//        sleep_locations.put("LocationName", "National Hotel");
//        location.add(sleep_locations);
//
//        sleep_locations.put("Latitude", "9.3428347");
//        sleep_locations.put("Longitude", "9.3428347");
//        sleep_locations.put("LocationName", "Ras Hotel");
//        location.add(sleep_locations);
//
//        sleep_locations.put("Latitude", "9.3428347");
//        sleep_locations.put("Longitude", "9.3428347");
//        sleep_locations.put("LocationName", "Harmony Hotel");
//        location.add(sleep_locations);

        return super.onCreateView(inflater, container, savedInstanceState);
        }

@Override
public void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
        case 0:
        Intent itomoca = new Intent(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.MapsActivity.class);
            itomoca.putExtra("Location_sheraton",location);
        startActivity(itomoca);
        break;
        case 1:
        Intent ielilly = new Intent(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.MapsActivity.class);
        ielilly.putExtra("Location_sheraton",location);
        startActivity(ielilly);
        break;
        case 2:
        Intent iradison = new Intent(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.MapsActivity.class);
        iradison.putExtra("Location_sheraton",location);
        startActivity(iradison);
        break;
        case 3:
        Intent intercontinental = new Intent(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.MapsActivity.class);
        intercontinental.putExtra("Location_sheraton",location);
        startActivity(intercontinental);
        break;
        case 4:
        Intent harmony = new Intent(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.MapsActivity.class);
        harmony.putExtra("Location_sheraton",location);
        startActivity(harmony);
        break;
        case 5:
        Intent dreamlinear = new Intent(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.MapsActivity.class);
        dreamlinear.putExtra("Location_sheraton",location);
        startActivity(dreamlinear);
        break;
        case 6:
        Intent jupiter = new Intent(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.MapsActivity.class);
        jupiter.putExtra("Location_sheraton",location);
        startActivity(jupiter);
        break;
        case 7:
        Intent saromaria = new Intent(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.MapsActivity.class);
        saromaria.putExtra("Location_sheraton",location);
        startActivity(saromaria);
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
