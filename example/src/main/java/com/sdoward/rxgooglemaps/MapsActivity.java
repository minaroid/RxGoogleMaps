package com.sdoward.rxgooglemaps;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import com.sdoward.rxgooglemap.cameraChange.CameraChangeObservable;

import rx.functions.Action1;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        CameraChangeObservable.getCameraChangeObservable(googleMap)
                .subscribe(new Action1<CameraPosition>() {
                    @Override
                    public void call(CameraPosition cameraPosition) {
                        Log.d(MapsActivity.class.getName(), "camera moved");
                    }
                });
        mMap = googleMap;
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


}
