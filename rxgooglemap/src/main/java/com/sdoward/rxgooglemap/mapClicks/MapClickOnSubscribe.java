package com.sdoward.rxgooglemap.mapClicks;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.*;

import rx.*;

class MapClickOnSubscribe implements
        Observable.OnSubscribe<LatLng> {

    public static Observable.OnSubscribe<LatLng> getOnSubscribe(GoogleMap googleMap) {
        return new MapClickOnSubscribe(googleMap);
    }

    private final GoogleMap googleMap;

    private MapClickOnSubscribe(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    @Override
    public void call(final Subscriber<? super LatLng> subscriber) {
        GoogleMap.OnMapClickListener onMapClickListener = new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if (subscriber.isUnsubscribed() == false) {
                    subscriber.onNext(latLng);
                }
            }
        };
        googleMap.setOnMapClickListener(onMapClickListener);
    }

}