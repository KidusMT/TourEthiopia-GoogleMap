package com.googleplaystore.kidusmt.tour_ethiopia;


import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by KidusMT on 5/15/2016.
 */
public class Shop_Goods_Fragmet extends ListFragment  {
    /** An array of items to display in ArrayList */
    String shop_goods[] = new String[]{
            "Philips",
            "Future Funiture",
            "Suzanne's",
            "Buy Car",
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Creating array adapter to set data in listview */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                android.R.layout.simple_list_item_1, shop_goods);

        /** Setting the array adapter to the listview */
        setListAdapter(adapter);


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
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        /** Setting the multiselect choice mode for the listview */
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

}