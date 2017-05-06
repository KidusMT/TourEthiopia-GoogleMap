package com.kidusmt.android.tourethiopia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class TwoFragment extends Fragment {

//    int[] covers = new int[]{
//            R.drawable.suggested_eat,
//            R.drawable.suggested_car,
//            R.drawable.suggested_coffee,
//            R.drawable.suggested_shoping,
//            R.drawable.suggested_search,
//            R.drawable.suggested_eat,
//            R.drawable.suggested_car,
//            R.drawable.suggested_coffee,
//            R.drawable.suggested_shoping,
//            R.drawable.suggested_search,
//            R.drawable.suggested_eat,
//            R.drawable.suggested_car,
//            R.drawable.suggested_coffee,
//            R.drawable.suggested_shoping,
//            R.drawable.suggested_search,
//            R.drawable.suggested_eat,
//            R.drawable.suggested_car,
//            R.drawable.suggested_coffee,
//            R.drawable.suggested_shoping,
//            R.drawable.suggested_search,
//            R.drawable.suggested_car,
//            R.drawable.suggested_settings};

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_two, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view_tab2);
        rv.setHasFixedSize(true);

//        String[] all_suggestions = getResources().getStringArray(R.array.suggestedLocation_all);
//        MyAdapter adapter = new MyAdapter(all_suggestions, all_suggestions, new int[]{
//                covers[0], covers[1], covers[2], covers[3], covers[4], covers[5],
//                covers[6], covers[7], covers[8], covers[9], covers[10], covers[11],
//                covers[12], covers[13], covers[14], covers[15], covers[16], covers[17],
//                covers[18], covers[19], covers[20], covers[21]});

        RecyclerAdapter_Suggestion_All adapter = new RecyclerAdapter_Suggestion_All(getContext(),getData());

        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }

    public List<Information> getData() {

        List<Information> data = new ArrayList<>();
        int[] icons = {
                R.drawable.suggested_eat,
                R.drawable.suggested_car,
                R.drawable.suggested_coffee,
                R.drawable.suggested_shoping,
                R.drawable.suggested_search,
                R.drawable.suggested_eat,
                R.drawable.suggested_car,
                R.drawable.suggested_coffee,
                R.drawable.suggested_shoping,
                R.drawable.suggested_search,
                R.drawable.suggested_eat,
                R.drawable.suggested_car,
                R.drawable.suggested_coffee,
                R.drawable.suggested_shoping,
                R.drawable.suggested_search,
                R.drawable.suggested_eat,
                R.drawable.suggested_car,
                R.drawable.suggested_coffee,
                R.drawable.suggested_shoping,
                R.drawable.suggested_search,
                R.drawable.suggested_car,
                R.drawable.suggested_settings};
        String[] title = getResources().getStringArray(R.array.suggestedLocation_all);
        String[] disc = getResources().getStringArray(R.array.suggestedLocation_all);
        for (int j = 0; j < icons.length && j < title.length; j++) {
            Information current = new Information();
            current.icon = icons[j];
            current.title = title[j];
            current.tilte2 = disc[j];
            data.add(current);
        }
        return data;
    }

}