package com.googleplaystore.kidusmt.tour_ethiopia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by KidusMT on 7/4/2016.
 */
public class SuggestedLocations_suggested extends Fragment {

    String[] suggestedLocations_suggested;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        suggestedLocations_suggested = getResources().getStringArray(R.array.suggestedLocation_suggeted);
//
//        setListAdapter(new ArrayAdapter<String>(getActivity().getBaseContext(),android.R.layout.simple_list_item_1,suggestedLocations_suggested));

        return inflater.inflate(R.layout.suggested_locations_suggested, container, false);
    }
//
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
//        }
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        /** Setting the multiselect choice mode for the listview */
//        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//    }

}