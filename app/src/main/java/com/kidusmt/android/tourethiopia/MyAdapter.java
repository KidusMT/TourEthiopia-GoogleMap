package com.kidusmt.android.tourethiopia;

/**
 * Created by KidusMT on 4/11/2017.
 */
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDataDescription;
    private String[] mDataTitle;
    private int[] mIcon;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardView;
        public ImageView mImageView;
        public TextView mTitle;
        public TextView mTextView;
        public MyViewHolder(View v) {
            super(v);
            mTitle = (TextView) v.findViewById(R.id.suggested_title);
            mImageView = (ImageView) v.findViewById(R.id.suggested_thumbnail);
            mCardView = (CardView) v.findViewById(R.id.card_view);
            mTextView = (TextView) v.findViewById(R.id.suggested_description);
        }
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] myDescription,String[] myDataTitle, int[] myPic) {
        mDataDescription = myDescription;
        mDataTitle = myDataTitle;
        mIcon = myPic;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextView.setText(mDataDescription[position]);
        holder.mTitle.setText(mDataTitle[position]);
        holder.mImageView.setImageResource(mIcon[position]);
    }

    @Override
    public int getItemCount() {
        return mDataDescription.length;
    }
}