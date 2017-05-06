package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

/*
 * Created by KidusMT on 5/10/2016.
 */
public class Suggested_list extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] title;
    private final Integer[] imageId;
    public Suggested_list(Activity context, String[] title, Integer[] imageId){
        super(context, R.layout.suggested_list);
        this.context = context;
        this.title = title;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.suggested_list, null, true);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.sugg_nav_img);

        imageView.setImageResource(imageId[position]);

        return rowView;
    }
}