package com.sdoward.rxgooglemap.location;


import android.location.Location;

import com.google.android.gms.maps.GoogleMap;

import rx.*;

public class MyLocationChangedObservable implements Observable.OnSubscribe<Location> {

    public static Observable<Location> getMyLocationObservable(GoogleMap googleMap) {
        return Observable.create(new MyLocationChangedObservable(googleMap));
    }

    private final GoogleMap googleMap;

    private MyLocationChangedObservable(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    @Override
    public void call(final Subscriber<? super Location> subscriber) {
        GoogleMap.OnMyLocationChangeListener myLocationChangeListener = new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                if (subscriber.isUnsubscribed() == false) {
                    subscriber.onNext(location);
                }
            }
        };
        googleMap.setOnMyLocationChangeListener(myLocationChangeListener);
    }
}