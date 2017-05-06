package com.kidusmt.android.tourethiopia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

/**
 * Created by KidusMT on 8/22/2016.
 */
public class RecyclerAdapter_Suggestion_All extends RecyclerView.Adapter<RecyclerAdapter_Suggestion_All.MyViewHolder> {

    private LayoutInflater inflater;
    private Context mContext;
    private List<Information> data = Collections.EMPTY_LIST;//For controlling NullPointException
    public RecyclerAdapter_Suggestion_All(Context context, List<Information> data){
        inflater = LayoutInflater.from(context);
        mContext = context;
        this.data = data;
    }
    //Note: the onCreateViewHolder is used to inflate the root LinearLayout of the custom_row
    //      and so that it can be inflated once for the performance sake
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row,parent,false);
        MyViewHolder holder = new MyViewHolder(view);//we are passing it to our class we defined_below
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Information current = data.get(position);
        holder.name.setText(current.title);
        //holder.icon.setImageResource(current.icon);
        holder.disc.setText(current.tilte2);

        // loading album cover using Glide library
        Glide.with(mContext).load(current.icon).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return 21;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView icon;
        private TextView name;
        private TextView disc;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.city_name);
            disc = (TextView)itemView.findViewById(R.id.distance_from_capital);
            icon = (ImageView)itemView.findViewById(R.id.iconCard);

        }
    }
}
