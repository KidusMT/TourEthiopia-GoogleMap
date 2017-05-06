package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

/**
 * Created by KidusMT on 5/14/2016.
 */
public class Favorite extends FragmentActivity {

    ActionBar actionBar;
    TextView favList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite);

        //TextView localityName = (TextView)findViewById(R.id.locality_name);
        //TextView dateAndTime = (TextView)findViewById(R.id.fav_time);
        favList = (TextView) findViewById(R.id.fav_list);

        com.googleplaystore.kidusmt.tour_ethiopia.favorite_db info = new com.googleplaystore.kidusmt.tour_ethiopia.favorite_db(this);
        try {
            info.open();
            String data = info.showFavorite();
            info.close();
            favList.setText(data);
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT);
        }

        actionBar = getActionBar();
        actionBar.setTitle("Favorite Locations");
        actionBar.setDisplayShowTitleEnabled(true);//Displays the title on the actionbar
        actionBar.setDisplayHomeAsUpEnabled(true);//display the back arrow when drawer opened
    }

    //Inflates the menu_map item on the main activity page
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_map; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }
}

