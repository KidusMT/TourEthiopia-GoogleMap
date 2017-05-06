package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by KidusMT on 5/8/2016.
 */
public class Emergency extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Suggested Location");
        //The Lists on the Dialog
        builder.setItems(R.array.er, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MapsActivity m = new MapsActivity();
                m.googleMap.clear();
                // Add a marker in Addis Ababa locating CBE and move the camera
                LatLng sydney = new LatLng(8.9601550, 38.7650870);
                m.googleMap.addMarker(new MarkerOptions().position(sydney).title("Commercial Bank of Ethiopia"));
                m.googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            }
        });
        //The Cancel Button on the Dialog
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        //The ok button on the dialog
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        Dialog dialog = builder.create();
        dialog.show();

        return dialog;
    }
}
