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
public class Car_Rental_Fragment extends ListFragment {
    /** An array of items to display in ArrayList */
    String Sleep_lists[] = new String[]{
            "abc car rental",
            "Adika Car Rent ",
            "AVIS",
            "Habesha Car Rental ",
            "Polo Car Rent",
            "Roha Limo Rent ",
            "Unique Car Rent ",
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Creating array adapter to set data in listview */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                android.R.layout.simple_list_item_single_choice, Sleep_lists);

        /** Setting the array adapter to the listview */
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    double[] abc_car_rental_Lat = {};
    double[] abc_car_rental_Lng = {};

    double[] Adika_Lat = {};
    double[] Adika_Lng = {};

    double[] AVIS_Lat = {};
    double[] AVIS_Lng = {};

    double[] Habesha_Lat = {};
    double[] Habesha_Lng = {};

    double[] Polo_Lat = {};
    double[] Polo_Lng = {};

    double[] Roha_Lat = {};
    double[] Roha_Lng = {};

    double[] Unique_Lat = {};
    double[] Unique_Lng = {};

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
            case 0:
                Intent iEdna = new Intent("");
                iEdna.putExtra("shopLat",abc_car_rental_Lat);
                iEdna.putExtra("shopLng",abc_car_rental_Lng);
                startActivity(iEdna);
                break;
            case 1:
                Intent iEnho = new Intent("");
                iEnho.putExtra("shopLat",Adika_Lat);
                iEnho.putExtra("shopLng",Adika_Lng);
                startActivity(iEnho);
                break;
            case 2:
                Intent iDembel= new Intent("");
                iDembel.putExtra("shopLat",AVIS_Lat);
                iDembel.putExtra("shopLng",AVIS_Lng);
                startActivity(iDembel);
                break;
            case 3:
                Intent iDH= new Intent("");
                iDH.putExtra("shopLat",Habesha_Lat);
                iDH.putExtra("shopLng",Habesha_Lng);
                startActivity(iDH);
                break;
            case 4:
                Intent iAberu= new Intent("");
                iAberu.putExtra("shopLat",Polo_Lat);
                iAberu.putExtra("shopLng",Polo_Lng);
                startActivity(iAberu);
                break;
            case 5:
                Intent iParadise= new Intent("");
                iParadise.putExtra("shopLat",Roha_Lat);
                iParadise.putExtra("shopLng",Roha_Lng);
                startActivity(iParadise);
                break;
            case 6:
                Intent iGIGI= new Intent("");
                iGIGI.putExtra("shopLat",Unique_Lat);
                iGIGI.putExtra("shopLng",Unique_Lng);
                startActivity(iGIGI);
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
