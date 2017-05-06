package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by KidusMT on 5/30/2016.
 */
public class Hotel_Dreamlinear extends Fragment {

    TextView contactNo ;
    TextView tvtopic;
    TextView tvabout;
    Button bshowmapfull;

    ArrayList<HashMap<String, String>> dreamlinear_location = new ArrayList<HashMap<String, String>>();
    HashMap<String, String> hotel_dreamlinear;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        hotel_dreamlinear = new HashMap<String, String>();
        hotel_dreamlinear.put("Latitude", "9.3428347");
        hotel_dreamlinear.put("Longitude", "9.3428347");
        hotel_dreamlinear.put("LocationName", "Dream Linear Hotel");
        dreamlinear_location.add(hotel_dreamlinear);

        View view = inflater.inflate( R.layout.hotel_dreamlinear, container, false);
        contactNo = (TextView)view.findViewById(R.id.contactandlocation);
        bshowmapfull = (Button)view.findViewById(R.id.showFullMap);
        tvtopic = (TextView)view.findViewById(R.id.topic);
        tvabout = (TextView)view.findViewById(R.id.discover_text);
        bshowmapfull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imap = new Intent(getActivity().getBaseContext(),MapsActivity.class);
                imap.putExtra("dreamlinear",dreamlinear_location);
                startActivity(imap);
            }
        });
        contactNo.setText("+251921304594\n+0224550190");
        tvtopic.setText("DREAM LINEAR HOTEL");
        tvabout.setText(getResources().getText(R.string.tomoca));//this has to be changed after
        return view;
    }
}
