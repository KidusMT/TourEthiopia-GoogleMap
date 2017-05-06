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
 * Created by KidusMT on 5/15/2016.
 */

public class Shop_Food_Fragment extends ListFragment {
    /** An array of items to display in ArrayList */
    String Shop_Food_Fragment[] = new String[]{
            "Shewa Super Market",
            "Bambis Supermarket",
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Creating array adapter to set data in listview */

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                android.R.layout.simple_list_item_1, Shop_Food_Fragment);

        /** Setting the array adapter to the listview */
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    double[] showa_lat = {};
    double[] showa_lng = {};

    double[] Bambis_lat = {};
    double[] Bambis_lng = {};

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
            case 0:
                Intent iShowa = new Intent("");
                iShowa.putExtra("shopLat",showa_lat);
                iShowa.putExtra("shopLng",showa_lng);
                startActivity(iShowa);
                break;
            case 1:
                Intent iBambis = new Intent("");
                iBambis.putExtra("shopLat",Bambis_lat);
                iBambis.putExtra("shopLng",Bambis_lng);
                startActivity(iBambis);
                break;
            case 2:
//                Intent intent = new Intent("");
//                intent.putExtra("shopLat",lat_food_shop);
//                intent.putExtra("shopLng",lng_food_shop);
//                startActivity(intent);
                break;
            case 3:
//                Intent intent = new Intent("");
//                intent.putExtra("shopLat",lat_food_shop);
//                intent.putExtra("shopLng",lng_food_shop);
//                startActivity(intent);

                break;
            case 4:
//                Intent intent = new Intent("");
//                intent.putExtra("shopLat",lat_food_shop);
//                intent.putExtra("shopLng",lng_food_shop);
//                startActivity(intent);

                break;
            case 5:
//                Intent intent = new Intent("");
//                intent.putExtra("shopLat",lat_food_shop);
//                intent.putExtra("shopLng",lng_food_shop);
//                startActivity(intent);
                break;
            case 6:
//                Intent intent = new Intent("");
//                intent.putExtra("shopLat",lat_food_shop);
//                intent.putExtra("shopLng",lng_food_shop);
//                startActivity(intent);
                break;
            case 7:
//                Intent intent = new Intent("");
//                intent.putExtra("shopLat",lat_food_shop);
//                intent.putExtra("shopLng",lng_food_shop);
//                startActivity(intent);
                break;
            case 8:
//                Intent intent = new Intent("");
//                intent.putExtra("shopLat",lat_food_shop);
//                intent.putExtra("shopLng",lng_food_shop);
//                startActivity(intent);
                break;
            case 9:
//                Intent intent = new Intent("");
//                intent.putExtra("shopLat",lat_food_shop);
//                intent.putExtra("shopLng",lng_food_shop);
//                startActivity(intent);
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