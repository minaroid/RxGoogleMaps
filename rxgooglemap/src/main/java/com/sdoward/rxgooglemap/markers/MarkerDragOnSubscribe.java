package com.sdoward.rxgooglemap.markers;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import rx.*;

class MarkerDragOnSubscribe implements
        Observable.OnSubscribe<Marker> {

    private final GoogleMap googleMap;


    public static MarkerDragOnSubscribe getOnSubscribe(GoogleMap googleMap) {
        return new MarkerDragOnSubscribe(googleMap);
    }

    private MarkerDragOnSubscribe(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    @Override
    public void call(final Subscriber<? super Marker> subscriber) {
        GoogleMap.OnMarkerDragListener markerDragListener = new GoogleMap.OnMarkerDragListener() {

            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {
                if (subscriber.isUnsubscribed() == false) {
                    subscriber.onNext(marker);
                }
            }

            @Override
            public void onMarkerDragEnd(Marker marker) {

            }
        };
        googleMap.setOnMarkerDragListener(markerDragListener);
    }

}
