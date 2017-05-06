package com.googleplaystore.kidusmt.tour_ethiopia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by KidusMT on 7/4/2016.
 */

public class SuggestedLocations_Frag_All extends Fragment {

//    Integer[] SugImage = {
//            R.drawable.discover,
//            R.drawable.eat,
//            R.drawable.fun,
//            R.drawable.sleep,
//            R.drawable.shop,
//            R.drawable.emergency,
//            R.drawable.bank,
//            R.drawable.embassy,
//            R.drawable.tour_guide,
//            R.drawable.car,
//            R.drawable.taxi,
//    };

//    Integer[] suggestedImages =
//            {
//                    R.drawable.food_and_drink,
//                    R.drawable.bank_and_atm,
//                    R.drawable.embassies,
//                    R.drawable.airport,
//                    R.drawable.tour_guides,
//                    R.drawable.shops,
//                    R.drawable.night_clubs,
//                    R.drawable.cultural_house,
//                    R.drawable.entertainments,
//                    R.drawable.discover,
//                    R.drawable.bus_and_taxi,
//                    R.drawable.emergencies,
//                    R.drawable.libraries_and_bookshops,
//                    R.drawable.public_rest_rooms,
//                    R.drawable.carshops_and_rents,
//            };

   // ListView list;

    String[] suggestedLocations;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        /** Creating array adapter to set data in listview */

//        suggestedLocations = getResources().getStringArray(R.array.suggestedLocation_all);
//        setListAdapter(new ArrayAdapter<String>(getActivity().getBaseContext(),
//                android.R.layout.simple_list_item_1,suggestedLocations));

        return inflater.inflate(R.layout.suggested_locations_frag_all, container, false);
    }

//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        switch (position){
//            case 0:
//                break;
//            case 1:
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
//            case 4:
//                break;
//            case 5:
//                break;
//            case 6:
//                break;
//            case 7:
//                break;
//            case 8:
//                break;
//            case 9:
//                break;
//            case 10:
//                break;
//            case 11:
//                break;
//            case 12:
//                break;
//            case 13:
//                break;
//            case 14:
//                break;
//        }
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//    }

}