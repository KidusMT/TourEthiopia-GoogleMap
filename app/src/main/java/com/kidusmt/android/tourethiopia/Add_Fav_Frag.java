package com.kidusmt.android.tourethiopia;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by KidusMT on 5/19/2016.
 */
public class Add_Fav_Frag extends DialogFragment implements View.OnClickListener {


    EditText Fav_Name;
    Button bAdd, bCancel;
    public static String favName ="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setCancelable(false);

        View view = inflater.inflate(R.layout.add_fav_frag,null);
        Fav_Name = (EditText) view.findViewById(R.id.fav_name);
        bAdd = (Button) view.findViewById(R.id.btadd);
        bCancel = (Button)view.findViewById(R.id.btcancel);
        bAdd.setOnClickListener(this);
        bCancel.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btadd:
                favName = Fav_Name.getText().toString();
                try {
                    favorite_db entry = new favorite_db(getActivity());
                    entry.open();
                    entry.createEntry(favName);
                    entry.close();
                    dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                    dismiss();
                }
                break;
            case R.id.btcancel:
                dismiss();
                break;
        }

    }
}