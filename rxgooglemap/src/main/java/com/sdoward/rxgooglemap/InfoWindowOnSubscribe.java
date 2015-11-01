package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.Marker;

import rx.*;

class InfoWindowOnSubscribe extends BaseOnSubscribe<Marker> {

    public static Observable.OnSubscribe<Marker> getOnSubscribe(SupportMapFragment supportMapFragment) {
        return new InfoWindowOnSubscribe(supportMapFragment);
    }

    private InfoWindowOnSubscribe(SupportMapFragment supportMapFragment) {
        super(supportMapFragment);
    }

    @Override
    protected void mapReady(GoogleMap googleMap, final Observer<? super Marker> observer) {
        GoogleMap.OnInfoWindowClickListener onInfoWindowClickListener = new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                observer.onNext(marker);
            }
        };
        googleMap.setOnInfoWindowClickListener(onInfoWindowClickListener);
    }

}
