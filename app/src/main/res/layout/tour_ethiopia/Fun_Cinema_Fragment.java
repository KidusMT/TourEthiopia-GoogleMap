package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by KidusMT on 5/20/2016.
 */
public class Fun_Cinema_Fragment extends ListFragment {
    /** An array of items to display in ArrayList */
    String Fun_Cinema[] = new String[]{
            "Edna-mall mati Cinema",
            "Bherawi Cinema",
            "Aristotle Cinema",
            "Galaxy Cinema",
            "Paramount Cinema",
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Creating array adapter to set data in listview */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                android.R.layout.simple_list_item_single_choice, Fun_Cinema);

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

    //==============================================================================================

//
//
//    double lat_Edna = 9.0087;
//    double lng_Edna = 9.0087;
//
//    double lat_Bherawi = 9.0087;
//    double lng_Bherawi = 9.0087;
//
//    double lat_Aristotle = 9.0087;
//    double lng_Aristotle = 9.0087;
//
//    double lat_Galaxy = 9.0087;
//    double lng_Galaxy = 9.0087;
//
//    double lat_Paramount = 9.0087;
//    double lng_Paramount = 9.0087;
//



//    Intent iEdnaMall = new Intent();
//    iEdnaMall.putExtra("lat_Edna",lat_Edna);
//    iEdnaMall.putExtra("lng_Edna",lng_Edna);
//    startActivity(iEdnaMall);
//
//    Intent iBrehawi = new Intent();
//    iBrehawi.putExtra("lat_Edna",lat_Bherawi);
//    iBrehawi.putExtra("lng_Edna",lng_Bherawi);
//    startActivity(iBrehawi);
//
//    Intent iAristotile = new Intent();
//    iAristotile.putExtra("lat_Edna",lat_Aristotle);
//    iAristotile.putExtra("lng_Edna",lng_Aristotle);
//    startActivity(iAristotile);
//
//    Intent iGalaxy = new Intent();
//    iGalaxy.putExtra("lat_Edna",lat_Galaxy);
//    iGalaxy.putExtra("lng_Edna",lng_Galaxy);
//    startActivity(iGalaxy);
//
//    Intent iParamount = new Intent();
//    iParamount.putExtra("lat_Edna",lat_Paramount);
//    iParamount.putExtra("lng_Edna", lng_Paramount);
//    startActivity(iParamount);


    //==============================================================================================

    @Override
    public void onStart() {
        super.onStart();

        /** Setting the multiselect choice mode for the listview */
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

}
