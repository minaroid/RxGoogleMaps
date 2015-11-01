package com.sdoward.rxgooglemap.markers;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import rx.*;

public class InfoWindowOnSubscribe implements
        Observable.OnSubscribe<Marker> {

    private final GoogleMap googleMap;

    public static InfoWindowOnSubscribe getOnSubscribe(GoogleMap googleMap) {
        return new InfoWindowOnSubscribe(googleMap);
    }

    private InfoWindowOnSubscribe(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    @Override
    public void call(final Subscriber<? super Marker> subscriber) {
        GoogleMap.OnInfoWindowClickListener infoWindowClickListener = new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {

                if (subscriber.isUnsubscribed() == false) {
                    subscriber.onNext(marker);
                }
            }
        };
        googleMap.setOnInfoWindowClickListener(infoWindowClickListener);

    }

}
