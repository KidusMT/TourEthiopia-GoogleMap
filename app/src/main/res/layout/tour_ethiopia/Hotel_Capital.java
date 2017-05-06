package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by KidusMT on 5/30/2016.
 */
public class Hotel_Capital extends Fragment {

    TextView tvtopic;
    TextView tvabout;
    Button bshowmapfull;
    ImageButton bcall;
    ImageButton bbrowse;
    ImageView imageView;

    ArrayList<HashMap<String, String>> capital_location = new ArrayList<HashMap<String, String>>();
    HashMap<String, String> hotel_capital;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        hotel_capital = new HashMap<String, String>();
        hotel_capital.put("Latitude", "9.013472");
        hotel_capital.put("Longitude", "38.779896");
        hotel_capital.put("LocationName", "Capital");
        capital_location.add(hotel_capital);

        final String lat_capital = "9.013472";
        final String lng_capital = "38.779896";

        View view = inflater.inflate( R.layout.hotel_capital, container, false);
        bshowmapfull = (Button)view.findViewById(R.id.showFullMap);
        tvtopic = (TextView)view.findViewById(R.id.topic);
        tvabout = (TextView)view.findViewById(R.id.discover_text);
        bcall = (ImageButton)view.findViewById(R.id.btcall);
        bbrowse = (ImageButton)view.findViewById(R.id.btbrowse);
        imageView = (ImageView)view.findViewById(R.id.hotelimage);
        bshowmapfull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imap = new Intent(getActivity(),MapsActivity.class);
                imap.putExtra("capital_lat",lat_capital);
                imap.putExtra("capital_lng",lng_capital);
                startActivity(imap);
                getActivity().finish();
            }
        });
        bcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
        bbrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(browserIntent);
            }
        });
        tvtopic.setText("CAPITAL HOTEL");
        imageView.setImageResource(R.drawable.logo_capital);
        tvabout.setText(getResources().getText(R.string.about_capital));//this has to be changed after
        return view;
    }
    public void makePhoneCall() {
        try {
            Intent phoneIntent = new Intent(Intent.ACTION_CALL);
            phoneIntent.setData(Uri.parse("tel:0921304594"));
            startActivity(phoneIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "Call failed, please try again later!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
