package com.kidusmt.android.tourethiopia;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback,
        NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    GoogleMap googleMap;
    EditText etsearchview;
    CheckBox CB_terrain, CB_normal, CB_sattelite, CB_hybrid;

    //The following is for using the SQLite of the mobile database
    SharedPreferences sharedPreferences;
    int locationCount = 0;

    // Latitude & Longitude
    private Double Latitude = 0.00;
    private Double Longitude = 0.00;

    ArrayList<HashMap<String, String>> location = new ArrayList<HashMap<String, String>>();
    HashMap<String, String> sub_cities_map;

    ArrayList<LatLng> markerPoints;
    ArrayList<Marker> markers = new ArrayList<Marker>();
    Polygon shape;
    static final int POLYGON_POINTS =3;

    //The below are for the navigation bar on the left
    //ActionBar actionBar;
    NavigationView navigationView;
    private ListView rightView;
    private ActionBarDrawerToggle actionBarDrawerToggle1;
    DrawerLayout drawerLayout;

//    ArrayList<LatLng> Betemengist = {
//            new LatLng(9.022572,38.76352),
//            new LatLng(9.023278,38.7617694),
//            new LatLng(9.0253138,38.76144167),
//            new LatLng(9.0274389,38.76295),
//            new LatLng(9.029267,38.7634916),
//            new LatLng(9.029594,38.76390278),
//            new LatLng(9.028694,38.7673083),
//            new LatLng(9.027242,38.7662694),
//            new LatLng(9.024463,38.7677583),
//            new LatLng(9.0235861,38.7792),
//            new LatLng(9.022827,38.76675)
//    };

    private String[] subNavigationMenus;
    Integer[] subImages = {
            R.drawable.addisketema,
            R.drawable.akaki,
            R.drawable.arada,
            R.drawable.bole,
            R.drawable.gullele,
            R.drawable.kirkos,
            R.drawable.kolfe,
            R.drawable.lideta,
            R.drawable.nifas,
            R.drawable.yeka,
            R.drawable.all
    };

    String sheraton_lat = "0.0";
    String sheraton_lng = "0.0";

    String capital_lat = "0.0";
    String capital_lng = "0.0";

    String radisson_lat = "0.0";
    String radisson_lng = "0.0";

    String hilton_lat = "0.0";
    String hilton_lng = "0.0";

    String elilly_lat = "0.0";
    String elilly_lng = "0.0";

    LatLng[] latlng_embassies = {};

    Button bsearch;
    //ImageButton embassy;

    String string_embassy ="";
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        //setContentView(R.layout.activity_maps);//At this place the mapActivity is empty(null)
        //Bundle bundle = getIntent().getExtras();

        //====================this section is for receiving sent data's from========================
        //Object Receiver from an other class
        try{
            capital_lat = getIntent().getExtras().getString("capital_lat");
            capital_lng = getIntent().getExtras().getString("capital_lng");

            sheraton_lat = getIntent().getExtras().getString("sheraton_lat");
            sheraton_lng = getIntent().getExtras().getString("sheraton_lng");

            elilly_lat = getIntent().getExtras().getString("elilly_lat");
            elilly_lng = getIntent().getExtras().getString("elilly_lng");

            radisson_lat = getIntent().getExtras().getString("radisson_lat");
            radisson_lng = getIntent().getExtras().getString("radisson_lng");

            hilton_lat = getIntent().getExtras().getString("hilton_lat");
            hilton_lng = getIntent().getExtras().getString("hilton_lng");

            string_embassy = getIntent().getExtras().getString("starter");
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        //for the toolbar in the maps Activity
        toolbar = (Toolbar) findViewById(R.id.maps_toolbar);
        if (toolbar != null) {
            toolbar.setLogo(R.drawable.toolbar_icon);
            toolbar.setTitle("TourEthiopia");
            //the following line of code is for helping fragments get AppcompatActivity methods((AppCompatActivity) getApplicationContext()).
            setSupportActionBar(toolbar);
        }

        //((AppCompatActivity) getApplicationContext()).
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        //===========================================================================
        drawerLayout = (DrawerLayout) findViewById(R.id.map_drawerLayout);
        //============================================================================
        //    the following are for the NAVIGATION DRAWER
        //============================================================================
        //for the left side navigation drawer
        actionBarDrawerToggle1 = new ActionBarDrawerToggle(this, drawerLayout, R.string.opendrawer, R.string.closedrawer){
            @Override
            public void onDrawerClosed(View drawerView) {
                Toast.makeText(MapsActivity.this, "Drawer Closed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(MapsActivity.this, "Drawer Opened", Toast.LENGTH_SHORT).show();
            }
        };
        //The Navigation Drawer is setup with these two lines of codes
        navigationView = (NavigationView) findViewById(R.id.map_drawer_nav_List);
        navigationView.setNavigationItemSelectedListener(this);

        //embassy = (ImageButton)findViewById(R.id.btemabassy);
        actionBarDrawerToggle1 = new ActionBarDrawerToggle(this, drawerLayout,R.string.opendrawer,R.string.closedrawer){
            @Override
            public void onDrawerClosed(View drawerView) {
            }
            @Override
            public void onDrawerOpened(View drawerView) {
            }
        };

        //  hidSoftInputKey();

        drawerLayout.setDrawerListener(actionBarDrawerToggle1);

        //for the right side navigation drawer==================
        rightView = (ListView)findViewById(R.id.map_drawer_nav_right);
        subNavigationMenus = getResources().getStringArray(R.array.sub_cities);
        CustomMapNavigationList rightAdapter =  new CustomMapNavigationList(this,subNavigationMenus,subImages);
        rightView.setAdapter(rightAdapter);

        rightView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                rightView.setItemChecked(position,true);
                rightView.setSelection(position);
                MapsLocations mp = new MapsLocations();

                try
                {
                    switch (position) {
                        case 0://Addis Ketema
                            drawPolygon(mp.addisketema);
                            break;
                        case 1://akaki
                            drawPolygon(mp.akaki);
                            break;
                        case 2://arada
                            drawPolygon(mp.arada);
                            break;
                        case 3://bole
                            drawPolygon(mp.bole);
                            break;
                        case 4://Gullele
                            drawPolygon(mp.gulelle);
                            break;
                        case 5://kirkos
                            drawPolygon(mp.kirkos);
                            break;
                        case 6://kolfekeranio
                            drawPolygon(mp.kolfe);
                            break;
                        case 7://lideta
                            drawPolygon(mp.lideta);
                            break;
                        case 8://nifas
                            drawPolygon(mp.nifas);
                            break;
                        case 9://yeka
                            drawPolygon(mp.yeka);
                            break;
                        case 10://all at once
                            drawPolygon(mp.addisketema);
                            drawPolygon(mp.yeka);
                            drawPolygon(mp.nifas);
                            drawPolygon(mp.akaki);
                            drawPolygon(mp.arada);
                            drawPolygon(mp.gulelle);
                            drawPolygon(mp.kolfe);
                            drawPolygon(mp.lideta);
                            drawPolygon(mp.kirkos);
                            drawPolygon(mp.bole);
                            break;

                    }
                    drawerLayout.closeDrawer(rightView);
                }
                catch (Exception e){
                    drawerLayout.closeDrawer(rightView);
                    int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());
                    int requestCode = 10;
                    Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, MapsActivity.this, requestCode);
                    dialog.show();
                }
            }
        });
        //===========================================================================

        sub_cities_map = new HashMap<String, String>();
        sub_cities_map.put("Latitude", "9.3428347");
        sub_cities_map.put("Longitude", "9.3428347");
        sub_cities_map.put("LocationName", "Addis Ketema");
        location.add(sub_cities_map);

        sub_cities_map = new HashMap<String, String>();
        sub_cities_map.put("Latitude", "9.3428347");
        sub_cities_map.put("Longitude", "9.3428347");
        sub_cities_map.put("LocationName", "Akaky Kaliti");
        location.add(sub_cities_map);

        sub_cities_map = new HashMap<String, String>();
        sub_cities_map.put("Latitude", "9.3428347");
        sub_cities_map.put("Longitude", "9.3428347");
        sub_cities_map.put("LocationName", "Arada");
        location.add(sub_cities_map);

        sub_cities_map = new HashMap<String, String>();
        sub_cities_map.put("Latitude", "9.3428347");
        sub_cities_map.put("Longitude", "9.3428347");
        sub_cities_map.put("LocationName", "Bole");
        location.add(sub_cities_map);

        sub_cities_map = new HashMap<String, String>();
        sub_cities_map.put("Latitude", "9.3428347");
        sub_cities_map.put("Longitude", "9.3428347");
        sub_cities_map.put("LocationName", "Gullele");
        location.add(sub_cities_map);

        sub_cities_map = new HashMap<String, String>();
        sub_cities_map.put("Latitude", "9.3428347");
        sub_cities_map.put("Longitude", "9.3428347");
        sub_cities_map.put("LocationName", "Kirkos");
        location.add(sub_cities_map);

        sub_cities_map = new HashMap<String, String>();
        sub_cities_map.put("Latitude", "9.3428347");
        sub_cities_map.put("Longitude", "9.3428347");
        sub_cities_map.put("LocationName", "Kolfe Keranio");
        location.add(sub_cities_map);

        sub_cities_map = new HashMap<String, String>();
        sub_cities_map.put("Latitude", "9.3428347");
        sub_cities_map.put("Longitude","9.3428347");
        sub_cities_map.put("LocationName", "Lideta");
        location.add(sub_cities_map);

        sub_cities_map = new HashMap<String, String>();
        sub_cities_map.put("Latitude", "9.3428347");
        sub_cities_map.put("Longitude","9.3428347");
        sub_cities_map.put("LocationName", "Nifas Silk-Lafto");
        location.add(sub_cities_map);

        sub_cities_map = new HashMap<String, String>();
        sub_cities_map.put("Latitude","9.3428347");
        sub_cities_map.put("Longitude","9.3428347");
        sub_cities_map.put("LocationName","Yeka");
        location.add(sub_cities_map);
//
//        // Getting Google Play availability status
//        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
//
//        // Showing status
//        if (status != ConnectionResult.SUCCESS) { // Google Play Services are not available
//
//            int requestCode = 10;
//            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
//            dialog.show();
//
//        } else {
//
//        }

        // Opening the sharedPreferences object

    }

    //==============================================================================================

    public void onMapSearch(View v) {

//        String Slocation = etsearchview.getText().toString();//getting the string for comparing
//        List<Address> addressList = null;//if not null initially, then we can not get(0) the first index
//        if(Slocation != null || !Slocation.equals("")){
//            Geocoder geocoder = new Geocoder(this);
//            try{
//                addressList = geocoder.getFromLocationName(Slocation, 1);
//            } catch (IOException a){
//                a.printStackTrace();
//            }
//            //hidSoftInputKey();
//            Address address = addressList.get(0);
//            String locality = address.getLocality();//Gets the locality name of the result
//            String country = address.getCountryName();//Gets the country name of the result
//            LatLng latLng = new LatLng(address.getLatitude(),address.getLongitude());
//            googleMap.addMarker(new MarkerOptions().position(latLng).title(locality)
//                    .snippet(country));//The snippet displays the country name of the search result
//            googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
//        }

        EditText locationSearch = (EditText) findViewById(R.id.searchView1);
        String location = locationSearch.getText().toString();
        List<Address> addressList = null;

        if (location != null || !location.equals("")) {
            Geocoder geocoder = new Geocoder(this);

            try {
                addressList = geocoder.getFromLocationName(location, 1);

            } catch (IOException e) {
                e.printStackTrace();
            }

            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            googleMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
            googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        }
    }

    //this method is called when the map is ready to launch(start)
    @Override
    public void onMapReady(GoogleMap mMap) {
        googleMap = mMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


        // Getting reference to SupportMapFragment of the activity_main
        SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        fm.getMapAsync(this);

        etsearchview = (EditText) findViewById(R.id.searchView1);
        etsearchview.setTextIsSelectable(false);
        bsearch = (Button)findViewById(R.id.btsearch);

        CB_terrain = (CheckBox) findViewById(R.id.VTerrain);
        CB_hybrid = (CheckBox) findViewById(R.id.VHybrid);
        CB_normal = (CheckBox) findViewById(R.id.VNormal);
        CB_sattelite = (CheckBox) findViewById(R.id.VSatellite);

        if (googleMap != null) {//meaning it's the map works

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            if(string_embassy.equals("start")) {
                // Opening the sharedPreferences object
                sharedPreferences = getSharedPreferences("location", 0);

                // Getting number of locations already stored
                locationCount = sharedPreferences.getInt("locationCount", 0);

                // Getting stored zoom level if exists else return 0
                String zoom = sharedPreferences.getString("zoom", "0");

                // If locations are already saved
                if (locationCount != 0) {

                    String lat = "";
                    String lng = "";

                    // Iterating through all the locations stored
                    for (int i = 0; i < locationCount; i++) {

                        // Getting the latitude of the i-th location
                        lat = sharedPreferences.getString("lat" + i, "0");

                        // Getting the longitude of the i-th location
                        lng = sharedPreferences.getString("lng" + i, "0");

                        // Drawing marker on the map
                        drawMarker(new LatLng(Double.parseDouble(lat), Double.parseDouble(lng)));
                    }

                    // Moving CameraPosition to last clicked position
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(Double.parseDouble(lat), Double.parseDouble(lng))));

                    // Setting the zoom level in the map on last position is clicked
                    googleMap.animateCamera(CameraUpdateFactory.zoomTo(Float.parseFloat(zoom)));
                }
            };
        }
        bsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMapSearch(v);
            }
        });


//NOTE:The location here has a problem()

        if(!(capital_lat == "0.0" && elilly_lat == "0.0" && sheraton_lat == "0.0" && radisson_lat == "0.0" && hilton_lat == "0.0")) {
            if (capital_lat != null) {
                double lat = Double.parseDouble(capital_lat);
                double lng = Double.parseDouble(capital_lng);

                LatLng coordinate7 = new LatLng(lat, lng);
                googleMap.addMarker(new MarkerOptions().title("Capital Hotel and Spa")
                        .position(coordinate7).icon(BitmapDescriptorFactory.defaultMarker())
                        .snippet("5 star international hotel"));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinate7, 17));
            }
            if (elilly_lat != null) {
                double lat = Double.parseDouble(elilly_lat);
                double lng = Double.parseDouble(elilly_lng);

                LatLng coordinate7 = new LatLng(lat, lng);
                googleMap.addMarker(new MarkerOptions().title("Elilly Hotel")
                        .position(coordinate7).icon(BitmapDescriptorFactory.defaultMarker())
                        .snippet("international hotel\n known by its deserts"));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinate7, 17));
            }
            if (sheraton_lat != null) {
                double lat = Double.parseDouble(sheraton_lat);
                double lng = Double.parseDouble(sheraton_lng);

                LatLng coordinate7 = new LatLng(lat, lng);
                googleMap.addMarker(new MarkerOptions().title("Sheraton Addis Hotel and Spa")
                        .position(coordinate7).icon(BitmapDescriptorFactory.defaultMarker())
                        .snippet("5 star international hotel"));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinate7, 17));
            }

            if (radisson_lat != null) {
                double lat = Double.parseDouble(radisson_lat);
                double lng = Double.parseDouble(radisson_lng);

                LatLng coordinate7 = new LatLng(lat, lng);
                googleMap.addMarker(new MarkerOptions().title("Radisson Hotel")
                        .position(coordinate7).icon(BitmapDescriptorFactory.defaultMarker())
                        .snippet("Found around bole\ngood hospitality"));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinate7, 17));
            }
            if (hilton_lat != null) {
                double lat = Double.parseDouble(hilton_lat);
                double lng = Double.parseDouble(hilton_lng);

                LatLng coordinate7 = new LatLng(lat, lng);
                googleMap.addMarker(new MarkerOptions().title("Hilton Addis Hotle and Spa")
                        .position(coordinate7).icon(BitmapDescriptorFactory.defaultMarker())
                        .snippet("3 star international hotel"));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinate7, 17));
            }
        }

        // Setting onclick event listener for the map
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @SuppressWarnings("deprecation")//This will suppress the warning
            @Override
            public void onMapClick(LatLng point) {
                // Already two locations
                if (markerPoints.size() > 1) {
                    markerPoints.clear();
                    googleMap.clear();
                }
                // Adding new item to the ArrayList
                markerPoints.add(point);

                // Creating MarkerOptions
                MarkerOptions options = new MarkerOptions();

                // Setting the position of the marker
                options.position(point);
                //options.position(new LatLng(googleMap.getMyLocation().getLatitude(),googleMap.getMyLocation().getLongitude()));
                /**
                 * For the start location, the color of marker is GREEN and
                 * for the end location, the color of marker is RED.
                 */
                if (markerPoints.size() == 1) {
                    options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory
                            .HUE_GREEN));}

                // Add new marker to the Google Map Android API V2
                googleMap.addMarker(options);

                if (markerPoints.size() >= 1) {

                    LatLng origin = new LatLng(googleMap.getMyLocation().getLatitude(),googleMap.getMyLocation().getLongitude());
                    LatLng dest = markerPoints.get(0);
                    googleMap.addMarker(new MarkerOptions().position(origin).icon(BitmapDescriptorFactory.defaultMarker())
                            .snippet("you're here"));
                    try{
                        // Getting URL to the Google Directions API
                        String url = getDirectionsUrl(origin, dest);

                        MapsActivity.DownloadTask downloadTask = new MapsActivity.DownloadTask();

                        // Start downloading json data from Google Directions API
                        downloadTask.execute(url);
                    }catch (Exception e){
                        Thread thread = new Thread() {
                            @Override
                            public void run() {
                                try {
                                    int waited = 0;
                                    // Splash screen pause time
                                    while (waited < 1500) {
                                        sleep(100);
                                        waited += 100;
                                    }
                                    String lowInternet = getResources().getString(R.string.low_internet_speed);
                                    AlertDialog.Builder builder = new AlertDialog.Builder(MapsActivity.this);
                                    builder.setMessage(lowInternet);
                                    Dialog d = builder.create();
                                    d.show();
                                } catch (InterruptedException e) {
                                    // do nothing
                                }
                            }
                        };
                    }
                }
            }
        });

        //Called when our click is a bit longer than the usual
        googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(final LatLng point) {

                String[] options;
                options = getResources().getStringArray(R.array.options);
                final AlertDialog.Builder builder = new AlertDialog.Builder(MapsActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Options");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0://For Clearing the Markers
                                //clear the markers from the map
                                googleMap.clear();

                                // Opening the editor object to delete data from sharedPreferences
                                SharedPreferences.Editor editor = sharedPreferences.edit();

                                // Clearing the editor
                                editor.clear();

                                // Committing the changes
                                editor.commit();

                                // Setting locationCount to zero
                                locationCount = 0;
                                break;
                            case 1://For Adding to Favorite
                                showSaveToFav();
                                break;
                            case 2://For Adding Marker
                                googleMap.addMarker(new MarkerOptions().title(getLocalClassName())
                                        .icon(BitmapDescriptorFactory.defaultMarker()));
                                break;
                            case 3://adds marker
                                MarkerOptions optn = new MarkerOptions()
                                        .icon(BitmapDescriptorFactory.defaultMarker())
                                        .position(point);
                                googleMap.addMarker(optn);
                                break;
                        }
                    }
                });
                //The Cancel Button on the Dialog
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                Dialog dialog = builder.create();
                dialog.show();//displays the alert message to user
//---------------------------------------------------------------------------------------------------
            }
        });

        googleMap.setMyLocationEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setZoomGesturesEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);
        googleMap.getUiSettings().setTiltGesturesEnabled(true);
        googleMap.getUiSettings().setScrollGesturesEnabled(true);
        googleMap.getUiSettings().setRotateGesturesEnabled(true);

        // If locations are already saved
        if (locationCount != 0) {

            String lat = "";
            String lng = "";

            // Iterating through all the locations stored
            for (int i = 0; i < locationCount; i++) {

                // Getting the latitude of the i-th location
                lat = sharedPreferences.getString("lat" + i, "0");

                // Getting the longitude of the i-th location
                lng = sharedPreferences.getString("lng" + i, "0");

                // Drawing marker on the map
                drawMarker(new LatLng(Double.parseDouble(lat), Double.parseDouble(lng)));
            }

            sharedPreferences = getSharedPreferences("location", 0);

            // Getting number of locations already stored
            locationCount = sharedPreferences.getInt("locationCount", 0);

            // Getting stored zoom level if exists else return 0
            String zoom = sharedPreferences.getString("zoom", "0");


            // Moving CameraPosition to last clicked position
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(Double.parseDouble(lat),
                    Double.parseDouble(lng))));

            // Setting the zoom level in the map on last position is clicked
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(Float.parseFloat(zoom)));
        }
    }

    //==============================================================================================

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.map_home) {
            Intent ihome = new Intent(MapsActivity.this,AvailableCities.class);
            startActivity(ihome);
        } else if (id == R.id.map_subCities) {//opens the subcity drawerlist
            drawerLayout.closeDrawer(navigationView);
            drawerLayout.openDrawer(rightView);
        } else if (id == R.id.map_suggested) {
            Intent imap = new Intent(MapsActivity.this,SuggestedActivity.class);
            startActivity(imap);
        } else if (id == R.id.map_fav) {
            //Intent ifav = new Intent(MapsActivity.this,FavoriteActivity.class);
            //startActivity(ifav);
        } else if (id == R.id.map_direction) {
            //show direction
        } else if (id == R.id.map_taxi) {
            //show taxi routes and stop
        } else if (id == R.id.map_bus) {
            //show bus stop and routes
        } else if (id == R.id.map_train) {
            //show train stops and routes

//            } else if (id == R.id.nav_settings) {
//                Intent i = new Intent(this, SettingsActivity.class);
//                //startActivityForResult(i, RESULT_SETTINGS);//this statement should work
//                startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.map_drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    ================================================================
//          Inflates the menu_map item on the main activity page
//    ================================================================

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle1.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_map; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_map, menu);
        return true;
    }

    //=========================================================================
    //      Controls the Map View Type: Hybrid, Normal, Satellite, Terrain
    //=========================================================================
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle1.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            case R.id.VHybrid:
                googleMap.setMapType(googleMap.MAP_TYPE_HYBRID);
                break;
            case R.id.VNormal:
                googleMap.setMapType(googleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.VSatellite:
                googleMap.setMapType(googleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.mapViewSetting:
                return true;
            case R.id.VTerrain:
                googleMap.setMapType(googleMap.MAP_TYPE_TERRAIN);
                break;
            case android.R.id.home://commands for the drawer open and close
                if (drawerLayout.isDrawerOpen(navigationView)) {
                    drawerLayout.closeDrawer(navigationView);
                } else {
                    drawerLayout.openDrawer(navigationView);
                }
            default:
                drawerLayout.openDrawer(navigationView);
        }
        return super.onOptionsItemSelected(item);
    }

    //show the UI for saving to favorite database
    public void showSaveToFav(){
        FragmentManager manager = getFragmentManager();
        Add_Fav_Frag save = new Add_Fav_Frag();
        save.show(manager, "SaveToFav");
//        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//       imm.hideSoftInputFromWindow(((EditText)findViewById(R.id.fav_name)).getWindowToken(), 0);
        Toast.makeText(this, "Added to Favorite", Toast.LENGTH_SHORT).show();
    }

    //==============================================================================================
    //
    //      NOTE: THis is where the Marker placer is located
    //
    //==============================================================================================

    //Drawer the Markers on the map taking a name of the marker image as a string
    public void drawMultipleMarkers(String img_markerName) {
        StringBuilder img_marker = new StringBuilder("");
        img_marker.append("R.drawable.");
        img_marker.append(img_markerName);
        Object M_marker ;//Instantiating the M-marker object
        M_marker = img_marker;//Implicit casting to an object

        for (int i = 0; i < location.size(); i++) {
            Latitude = Double.parseDouble(location.get(i).get("Latitude").toString());
            Longitude = Double.parseDouble(location.get(i).get("Longitude").toString());
            String name = location.get(i).get("LocationName").toString();
            MarkerOptions marker = new MarkerOptions().position(new LatLng(Latitude, Longitude)).title(name);
            marker.icon(BitmapDescriptorFactory.fromResource((int)M_marker));//M_marker is resource
            // location name of the marker(NOTE: called explicit casting)
            googleMap.addMarker(marker);//Sending the marker to the map to be drawn
        }
    }


//draws polygons on the map for showing the sub-cities
//    private void drawPolygon(int POLYGON_POINTS){
//        PolygonOptions options = new PolygonOptions()
//                .fillColor(0x330000ff)
//                .strokeColor(Color.CYAN)
//                .strokeWidth(3);
//        for (int i=0;i< POLYGON_POINTS; i++){
//            options.add(markers.get(i).getPosition());
//        }
//        shape = googleMap.addPolygon(options);
//    }

    private void drawPolygon(PolygonOptions pl){
        googleMap.addPolygon(pl);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(8.994686, 38.738337), 17));
    }

//    private void removeEverything(){
//        for (Marker marker : markers){
//            marker.remove();
//        }
//        markers.clear();
//        shape.remove();
//        shape = null;
//    }

    //This method is for executing the JSON parsing for the
    //Takes the current longitude and latitude form the map as a latlng
    //The final latlng will be where the tourist want to go
    @SuppressWarnings("deprecation")
    public void ShowMyDirection() {

        String[] localities;
        localities = getResources().getStringArray(R.array.localities);
        googleMap.clear();//for clearing any marker on the map activity

        LatLng currentPosition = new LatLng(googleMap.getMyLocation()
                .getLatitude(), googleMap.getMyLocation().getLongitude());

        //creates the alert dialog
        final AlertDialog.Builder builder = new AlertDialog.Builder(MapsActivity.this);
        builder.setCancelable(true);
        builder.setItems(localities, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                    case 9:

                        break;
                    case 10:

                        break;
                    case 11:

                        break;
                    case 12:

                        break;
                    case 13:

                        break;
                    case 14:

                        break;
                    case 15:

                        break;
                    case 16:

                        break;
                    case 17:

                        break;
                    case 18:

                        break;
                    case 19:

                        break;
                    case 20:

                        break;
                    case 21:

                        break;
                }

            }
        });
        //The Cancel Button on the Dialog
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        Dialog dialog = builder.create();
        dialog.show();


        // Adding new item to the ArrayList


        // Creating MarkerOptions
        MarkerOptions options = new MarkerOptions();

        // Setting the position of the marker
        options.position(currentPosition);
        options.title("");
        options.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_trymet));

        LatLng origin = currentPosition;
        LatLng dest = markerPoints.get(1);//This direction has to be changed to a location where
        // the tourist want to go

        // Getting URL to the Google Directions API
        String url = getDirectionsUrl(origin, dest);

        MapsActivity.DownloadTask downloadTask = new MapsActivity.DownloadTask();

        // Start downloading json data from Google Directions API
        downloadTask.execute(url);
    }

    //for drawing multiple markers on the map
    private void drawMarker(LatLng point){
        // Creating an instance of MarkerOptions
        MarkerOptions markerOptions = new MarkerOptions();

        // Setting latitude and longitude for the marker
        markerOptions.position(point);

        // Adding marker on the Google Map
        googleMap.addMarker(markerOptions);
    }

    private String getDirectionsUrl(LatLng origin,LatLng dest){

        // Origin of route
        String str_origin = "origin="+origin.latitude+","+origin.longitude;

        // Destination of route
        String str_dest = "destination="+dest.latitude+","+dest.longitude;

        // Sensor enabled
        String sensor = "sensor=false";

        // Building the parameters to the web service
        String parameters = str_origin+"&"+str_dest+"&"+sensor;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;

        return url;
    }
    /** A method to download json data from url */
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while( ( line = br.readLine()) != null){
                sb.append(line);
            }
            data = sb.toString();

            br.close();

        }catch(Exception e){
            e.printStackTrace();
            //Log.i("Exception while downloading url", e.toString());
        }finally{
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    //for hiding the keyboard key for a clear view
//    public void hidSoftInputKey(){
//        //Hide the keyboard instantly!
//        if (getCurrentFocus() != null)
//        {
//            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
//        }
//    }

    //==============================================================================================
    //                     controls the search location process
    //==============================================================================================
    //The amazing trick is by setting the onClick event on the layout to connect with the method
    // name onSearch here we can indirectly connect them with out the listener being coded.


    // Fetches data from url passed
    private class DownloadTask extends AsyncTask<String, Void, String> {

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try{
                // Fetching the data from web service
                data = downloadUrl(url[0]);
            }catch(Exception e){
                Log.d("Background Task",e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
// doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            MapsActivity.ParserTask parserTask = new MapsActivity.ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);
        }
    }

    /** A class to parse the Google Places in JSON format */
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String,String>>> >{

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try{
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            }catch(Exception e){
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();

            // Traversing through all the routes
            for(int i=0;i<result.size();i++){
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for(int j=0;j<path.size();j++){
                    HashMap<String,String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(2);
                lineOptions.color(Color.RED);
            }

            // Drawing polyline in the Google Map for the i-th route
            googleMap.addPolyline(lineOptions);
        }
    }

}




//This class is for handling the database staff
class favorite_db{
    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAME = "locality_name";
    public static final String KEY_DATE = "fav_date";
    public static final String KEY_TIME = "fav_time";
    public static final String FAV_NAME = "fav_name";

    private static final String DATABASE_NAME = "FavoriteDB";
    private static final String DATABASE_TABLE = "FavoriteTable";
    private static final int DATABASE_VERSION = 1;

    private DbHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;

    public long createEntry(String etfavName) {//

        String date = "";
        date = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
        String time = "";
        time = new SimpleDateFormat("HH:mm").format(new Date()).toString();

        ContentValues cv = new ContentValues();
        cv.put(FAV_NAME,etfavName);
        cv.put(KEY_TIME,time);
        cv.put(KEY_DATE,date);
        cv.put(KEY_NAME,"something");
        return ourDatabase.insert(DATABASE_TABLE, null, cv);
    }

    public static class DbHelper extends SQLiteOpenHelper {

        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
                    KEY_ROWID + " INTEGER PRIMARY KEY, " +
                    KEY_NAME + " VARCHAR(20), " +
                    FAV_NAME + " VARCHAR(20), " +
                    KEY_TIME + " VARCHAR(20), " +
                    KEY_DATE + " VARCHAR(20));"
            );
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }
    //This is the constructor
    public favorite_db(Context c){
        ourContext = c;
    }
    public favorite_db open() throws SQLException {
        ourHelper = new DbHelper(ourContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        ourHelper.close();
    }

    //Returns the data for us form our database
    public String showFavorite(){
        String[] columns = new String[]{KEY_ROWID, KEY_NAME , FAV_NAME,KEY_TIME, KEY_DATE};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns,null,null,null,null,null);
        String result = "";

        int iRow = c.getColumnIndex(KEY_ROWID);
        int iName = c.getColumnIndex(FAV_NAME);
        int iTime = c.getColumnIndex(KEY_TIME);
        int iDate = c.getColumnIndex(KEY_DATE);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            result = result + c.getString(iRow) + " \t "+ c.getString(iName)+" \t " +c.getString(iTime)+"\t "+c.getString(iDate)+ "\n" ;
        }
        return result;
    }
}