package com.sdoward.rxgooglemap.markers;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import rx.*;

class MarkerDragEndOnSubscribe implements
        Observable.OnSubscribe<Marker> {

    private final GoogleMap googleMap;

    public static MarkerDragEndOnSubscribe getOnSubscribe(GoogleMap googleMap) {
        return new MarkerDragEndOnSubscribe(googleMap);
    }

    private MarkerDragEndOnSubscribe(GoogleMap googleMap) {
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

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                if (subscriber.isUnsubscribed() == false) {
                    subscriber.onNext(marker);
                }
            }
        };
        googleMap.setOnMarkerDragListener(markerDragListener);
    }

}