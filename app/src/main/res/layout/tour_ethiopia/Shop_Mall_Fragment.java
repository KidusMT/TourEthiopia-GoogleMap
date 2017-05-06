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

public class Shop_Mall_Fragment extends ListFragment  {
    /** An array of items to display in ArrayList */
    String Shoping_Malls[] = new String[]{
            "Edna Mall",
            "Enho Tibeb",
            "Dembel City Center",
            "DH Tower",
            "Aberus Complex",
            "Paradise Fashion",
            "GIGI Ethiopi",
            "Friendship Shopping Center",
            "Getu Commercial",
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Creating array adapter to set data in listview */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                android.R.layout.simple_list_item_1, Shoping_Malls);

        /** Setting the array adapter to the listview */
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    double[] Edna_Lat = {};
    double[] Edna_Lng = {};

    double[] Enho_Lat = {};
    double[] Enho_Lng = {};

    double[] Dembel_Lat = {};
    double[] Dembel_Lng = {};

    double[] DH_Lat = {};
    double[] DH_Lng = {};

    double[] Aberu_Lat = {};
    double[] Aberu_Lng = {};

    double[] Paradise_Lat = {};
    double[] Paradise_Lng = {};

    double[] GIGI_Lat = {};
    double[] GIGI_Lng = {};

    double[] FriendShip_Lat = {};
    double[] FriendShip_Lng = {};

    double[] Getu_Lat = {};
    double[] Getu_Lng = {};

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
            case 0:
                Intent iEdna = new Intent("");
                iEdna.putExtra("shopLat",Edna_Lat);
                iEdna.putExtra("shopLng",Edna_Lng);
                startActivity(iEdna);
                break;
            case 1:
                Intent iEnho = new Intent("");
                iEnho.putExtra("shopLat",Enho_Lat);
                iEnho.putExtra("shopLng",Edna_Lng);
                startActivity(iEnho);
                break;
            case 2:
                Intent iDembel= new Intent("");
                iDembel.putExtra("shopLat",Dembel_Lat);
                iDembel.putExtra("shopLng",Dembel_Lng);
                startActivity(iDembel);
                break;
            case 3:
                Intent iDH= new Intent("");
                iDH.putExtra("shopLat",DH_Lat);
                iDH.putExtra("shopLng",DH_Lng);
                startActivity(iDH);
                break;
            case 4:
                Intent iAberu= new Intent("");
                iAberu.putExtra("shopLat",Aberu_Lat);
                iAberu.putExtra("shopLng",Aberu_Lng);
                startActivity(iAberu);
                break;
            case 5:
                Intent iParadise= new Intent("");
                iParadise.putExtra("shopLat",Paradise_Lat);
                iParadise.putExtra("shopLng",Paradise_Lng);
                startActivity(iParadise);
                break;
            case 6:
                Intent iGIGI= new Intent("");
                iGIGI.putExtra("shopLat",GIGI_Lat);
                iGIGI.putExtra("shopLng",GIGI_Lng);
                startActivity(iGIGI);
                break;
            case 7:
                Intent iFriendship= new Intent("");
                iFriendship.putExtra("shopLat",FriendShip_Lat);
                iFriendship.putExtra("shopLng",FriendShip_Lng);
                startActivity(iFriendship);
                break;
            case 8:
                Intent iGetu= new Intent("");
                iGetu.putExtra("shopLat",Getu_Lat);
                iGetu.putExtra("shopLng",Getu_Lng);
                startActivity(iGetu);
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
