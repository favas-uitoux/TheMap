package com.project.themap;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // Instantiates a new Polygon object and adds points to define a rectangle




    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        LatLng kochi = new LatLng(9.9338, 76.2671);
        LatLng coimbatore = new LatLng(11.0201, 76.9550);
        LatLng madurai = new LatLng(9.9255, 78.1245);
        LatLng munnar = new LatLng(10.0935, 77.0625);

        mMap.addMarker(new MarkerOptions().position(kochi).title("kochi"));
       mMap.addMarker(new MarkerOptions().position(coimbatore).title("coimbatore"));
        mMap.addMarker(new MarkerOptions().position(madurai).title("madurai"));
        mMap.addMarker(new MarkerOptions().position(munnar).title("munnar"));


        PolygonOptions rectOptions = new PolygonOptions()
                        .add(kochi,coimbatore,madurai,munnar


                        );

                Polygon polygon = mMap.addPolygon(rectOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(kochi));



    }
}