package com.sdoward.rxgooglemap.markers;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import rx.*;

class MarkerClickedOnSubscribe implements
        Observable.OnSubscribe<Marker> {

    private final GoogleMap googleMap;

    public static MarkerClickedOnSubscribe getOnSubscribe(GoogleMap googleMap) {
        return new MarkerClickedOnSubscribe(googleMap);
    }

    private MarkerClickedOnSubscribe(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    @Override
    public void call(final Subscriber<? super Marker> subscriber) {
        GoogleMap.OnMarkerClickListener onMarkerClickListener = new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (subscriber.isUnsubscribed() == false) {
                    subscriber.onNext(marker);
                }
                return false;
            }
        };
        googleMap.setOnMarkerClickListener(onMarkerClickListener);

    }

}
