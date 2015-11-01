package com.sdoward.rxgooglemap;

import android.location.Location;

import com.google.android.gms.maps.*;

import rx.*;

class MyLocationChangedOnSubscribe extends BaseOnSubscribe<Location> {

    public static Observable.OnSubscribe<Location> getMyLocationObservable(SupportMapFragment supportMapFragment) {
        return new MyLocationChangedOnSubscribe(supportMapFragment);
    }

    private MyLocationChangedOnSubscribe(SupportMapFragment supportMapFragment) {
        super(supportMapFragment);
    }

    @Override
    protected void mapReady(GoogleMap googleMap, final Observer<? super Location> observer) {
        GoogleMap.OnMyLocationChangeListener myLocationChangeListener = new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                observer.onNext(location);
            }

        };
        googleMap.setOnMyLocationChangeListener(myLocationChangeListener);
    }
}