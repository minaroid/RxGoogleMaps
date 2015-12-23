package com.sdoward.rxgooglemaps;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.sdoward.rxgooglemap.MapObservableProvider;

import rx.functions.Action1;

public class MapsActivity extends FragmentActivity {

    private SupportMapFragment mapFragment;
    private MapObservableProvider mapObservableProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapObservableProvider = new MapObservableProvider(mapFragment);
        mapObservableProvider.getCameraChangeObservable().subscribe(new Action1<CameraPosition>() {
            @Override
            public void call(CameraPosition cameraPosition) {
                Log.d(MapsActivity.class.getName(), "camera position");
            }
        });
    }

}
