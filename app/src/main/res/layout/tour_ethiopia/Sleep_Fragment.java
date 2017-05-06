package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by KidusMT on 5/21/2016.
 */
public class Sleep_Fragment extends ListFragment {
    /** An array of items to display in ArrayList */

    String[] hotels;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Creating array adapter to set data in listview */

        hotels = getResources().getStringArray(R.array.hotels_list);
        /** Setting the array adapter to the listview */
        setListAdapter(new ArrayAdapter<String>(getActivity().getBaseContext(),android.R.layout.simple_list_item_1,hotels));

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft;
        Fragment hotel;
        switch (position){
            case 0:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), Hotel_Sheraton_Addis.class.getName());
                ft.add(android.R.id.content, hotel, "Sheraton");
                ft.commit();
                break;
            case 1:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.Hotel_Elilly.class.getName());
                ft.add(android.R.id.content,hotel, "Elilly");
                ft.commit();
                break;
            case 2:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.Hotel_Capital.class.getName());
                ft.add(android.R.id.content, hotel, "Capital");
                ft.commit();
                break;
            case 3:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), Hotel_Radison_Blue.class.getName());
                ft.add(android.R.id.content, hotel, "Radison");
                ft.commit();
                break;
            case 4:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), Hotel_International.class.getName());
                ft.add(android.R.id.content, hotel, "Intercontinental");
                ft.commit();
                break;
            case 5:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.Hotel_Harmony.class.getName());
                ft.add(android.R.id.content, hotel, "Harmony");
                ft.commit();
                break;
            case 6:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.Hotel_Dreamlinear.class.getName());
                ft.add(android.R.id.content, hotel, "Dreamlinear");
                ft.commit();
                break;
            case 7:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.Hotel_Jupiter.class.getName());
                ft.add(android.R.id.content, hotel, "Jupiter");
                ft.commit();
                break;
            case 8:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.Hotel_Saromaria.class.getName());
                ft.add(android.R.id.content, hotel, "saromaria");
                ft.commit();
                break;
            case 9:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.Hotel_Debre_Damo.class.getName());
                ft.add(android.R.id.content, hotel, "debredamo");
                ft.commit();
                break;
            case 10:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.Hotel_Nazra.class.getName());
                ft.add(android.R.id.content, hotel, "nazra");
                ft.commit();
                break;
            case 11:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.Hotel_Friendship.class.getName());
                ft.add(android.R.id.content, hotel, "friendship");
                ft.commit();
                break;
            case 12:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.Hotel_Nexus.class.getName());
                ft.add(android.R.id.content, hotel, "nexus");
                ft.commit();
                break;
            case 13:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.Hotel_Washington.class.getName());
                ft.add(android.R.id.content, hotel, "washington");
                ft.commit();
                break;
            case 15:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.Hotel_Sariem_International.class.getName());
                ft.add(android.R.id.content, hotel, "sariem");
                ft.commit();
                break;
            case 16:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.Hotel_Tegen_Guest_Accomodation.class.getName());
                ft.add(android.R.id.content, hotel, "tegen");
                ft.commit();
                break;
            case 17:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.Hotel_The_Resident.class.getName());
                ft.add(android.R.id.content, hotel, "resident");
                ft.commit();
                break;
            case 18:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.Hotel_Hilton_Addis.class.getName());
                ft.add(android.R.id.content, hotel,"hilton");
                ft. commit();
                break;
            case 19:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), Hotel_Syonat.class.getName());
                ft.add(android.R.id.content, hotel, "syonat");
                ft.commit();
                break;
            case 20:
                ft = manager.beginTransaction();
                hotel = Fragment.instantiate(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.Hotel_Bear_Garden_In.class.getName());
                ft.add(android.R.id.content, hotel, "bear");
                ft.commit();
                break;
        }
    }

//    Intent bear = new Intent(getActivity().getBaseContext(),MapsActivity.class);
//    bear.putExtra("Location_sheraton",location);
//    startActivity(bear);

    @Override
    public void onStart() {
        super.onStart();

        /** Setting the multiselect choice mode for the listview */
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }
}
