package com.sdoward.rxgooglemap.mapClicks;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import rx.*;

class MapLongClickOnSubscribe implements
        Observable.OnSubscribe<LatLng> {

    public static Observable.OnSubscribe<LatLng> getOnSubscribe(GoogleMap googleMap) {
        return new MapLongClickOnSubscribe(googleMap);
    }

    private final GoogleMap googleMap;

    private MapLongClickOnSubscribe(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    @Override
    public void call(final Subscriber<? super LatLng> subscriber) {
        GoogleMap.OnMapLongClickListener onMapClickListener = new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                if (subscriber.isUnsubscribed() == false) {
                    subscriber.onNext(latLng);
                }
            }
        };
        googleMap.setOnMapLongClickListener(onMapClickListener);
    }

}