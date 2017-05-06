package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * Created by KidusMT on 5/8/2016.
 */
public class Discover extends Activity {
    /** An array of items to display in ArrayList */
    String DiscoveryList[] = new String[]{
            "National Museum",//Around Fil Wiha
            "Addis Ababa University Museum",//on a way from stadium to 4kilo(arat-kilo)
            "Lions Park",//Imaginary
            "Africa Park",//around sar-bet
    };

    ListView listView;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discover);
        manager = getFragmentManager();

        com.googleplaystore.kidusmt.tour_ethiopia.DiscoverList adapter = new com.googleplaystore.kidusmt.tour_ethiopia.DiscoverList(com.googleplaystore.kidusmt.tour_ethiopia.Discover.this, DiscoveryList);
        listView = (ListView) findViewById(R.id.discover_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Discovery_National_Museum national_museum = new Discovery_National_Museum();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.add(R.id.pager,national_museum,"nationalMuseum");
                        transaction.commit();
                        break;
                    case 1:
                        break;

                    case 2:

                        break;

                    case 3:

                        break;
                }
            }
        });
    }
}

class DiscoverList extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] web;
    public DiscoverList(Activity context, String[] web){
        super(context, R.layout.list_single, web);
        this.context = context;
        this.web = web;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        txtTitle.setText(web[position]);

        return rowView;
    }
}
