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
public class Hotel_Elilly extends Fragment {

    TextView tvtopic;
    TextView tvabout;
    Button bshowmapfull;
    ImageButton bcall;
    ImageButton bbrowse;
    ImageView imageView;

    ArrayList<HashMap<String, String>> elilly_location = new ArrayList<HashMap<String, String>>();
    HashMap<String, String> hotel_elilly;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        hotel_elilly = new HashMap<String, String>();
        hotel_elilly.put("Latitude", "9.3428347");
        hotel_elilly.put("Longitude", "9.3428347");
        hotel_elilly.put("LocationName", "Elilly Hotel");
        elilly_location.add(hotel_elilly);


        final String lat_elilly = "9.013472";
        final String lng_elilly = "38.779896";
        View view = inflater.inflate( R.layout.hotel_elilly, container, false);
        bshowmapfull = (Button)view.findViewById(R.id.showFullMap);
        tvtopic = (TextView)view.findViewById(R.id.topic);
        tvabout = (TextView)view.findViewById(R.id.discover_text);
        bshowmapfull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imap = new Intent(getActivity(),MapsActivity.class);
                imap.putExtra("capital_lat",lat_elilly);
                imap.putExtra("capital_lng",lng_elilly);
                startActivity(imap);
                getActivity().finish();
            }
        });
        bcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall(v);
            }
        });
        bbrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(browserIntent);
            }
        });
        tvtopic.setText("ELILLY HOTEL");
        //imageView.setImageResource(R.drawable.log);
        //tvabout.setText(getResources().getText(R.string.about_elilly));//this has to be changed after
        return view;
    }
    public void makePhoneCall(View view) {
        try {
            String number = "0921304594";
            Intent phoneIntent = new Intent(Intent.ACTION_CALL);
            phoneIntent.setData(Uri.parse("tel:0921304594"));
            startActivity(phoneIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "Call failed, please try again later!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
