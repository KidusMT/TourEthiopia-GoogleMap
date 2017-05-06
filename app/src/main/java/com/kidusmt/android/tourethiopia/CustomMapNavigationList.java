package com.kidusmt.android.tourethiopia;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by KidusMT on 6/1/2016.
 */
public class CustomMapNavigationList extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    public CustomMapNavigationList(Activity context, String[] web, Integer[] imageId){
        super(context, R.layout.list_single_map_nav,web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_single_map_nav, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.map_nav_txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.map_nav_img);
        txtTitle.setText(web[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
