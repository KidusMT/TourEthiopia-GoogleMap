package com.googleplaystore.kidusmt.tour_ethiopia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by KidusMT on 5/30/2016.
 */
public class Hotel_Sheraton_Addis extends android.app.Fragment {

    TextView contactNo ;
    TextView tvtopic;
    TextView tvabout;
    Button bshowmapfull;
    ImageView imageView;

    ArrayList<HashMap<String, String>> sheraton_location = new ArrayList<HashMap<String, String>>();
    HashMap<String, String> hotel_sheraton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        hotel_sheraton = new HashMap<String, String>();
        hotel_sheraton.put("Latitude", "9.3428347");
        hotel_sheraton.put("Longitude", "9.3428347");
        hotel_sheraton.put("LocationName", "Sheraton Addis Hotel");
        sheraton_location.add(hotel_sheraton);

        final String lat_capital = "9.020454";
        final String lng_capital = "38.759838";

        View view = inflater.inflate( R.layout.hotel_dreamlinear, container, false);
        contactNo = (TextView)view.findViewById(R.id.contactandlocation);
        bshowmapfull = (Button)view.findViewById(R.id.showFullMap);
        tvtopic = (TextView)view.findViewById(R.id.topic);
        tvabout = (TextView)view.findViewById(R.id.discover_text);
        imageView = (ImageView)view.findViewById(R.id.hotelimage);
        bshowmapfull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imap = new Intent(getActivity().getBaseContext(), com.googleplaystore.kidusmt.tour_ethiopia.MapsActivity.class);
                imap.putExtra("sheraton_lat",lat_capital);
                imap.putExtra("sheraton_lng",lng_capital);
                startActivity(imap);
            }
        });
        contactNo.setText("+251921304594\n+0224550190");
        tvtopic.setText("SHERATON ADDIS HOTEL");
        imageView.setImageResource(R.drawable.logo_sheraton);
        tvabout.setText(getResources().getText(R.string.about_sheraton));//this has to be changed after
        return view;
    }
}
