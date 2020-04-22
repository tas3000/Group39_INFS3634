package com.example.infs3634;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/***************************************************************************************
 *    Title: Using Google Map API in Android Studio Application
 *    Author:Akashkumar Patel
 *    Date: Uploaded date -> Oct 6, 2019
 *    Code version: No Version Outlined
 *    Availability: https://www.youtube.com/watch?v=Gcv2orQSMYA
 *
 ***************************************************************************************/

/* This is the java class for the map that is part of the unsw resources activity,
where when a user clicks the map button they will be able to view the location of the gym.*/

public class ResourcesUNSWAPI extends AppCompatActivity implements OnMapReadyCallback {
    static final LatLng UNSW = new LatLng(-33.9174159, 151.2283996);
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve the content view from the xml file that renders the map.
        setContentView(R.layout.activity_resources_api);

        // Getting the SupportMapFragment and requesting notification when the map is ready to be utilised.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    //The onMapReady method, which sets up the marker, camera, and the coordinates.
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng unsw= new LatLng(-33.9174159, 151.2283996);
        googleMap.addMarker(new MarkerOptions().position(unsw)
                .title("UNSW"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(unsw));
    }

}