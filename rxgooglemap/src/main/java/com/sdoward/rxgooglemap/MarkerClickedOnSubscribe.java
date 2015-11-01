package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.Marker;

import rx.*;

class MarkerClickedOnSubscribe extends BaseOnSubscribe<Marker> {

    public static Observable.OnSubscribe<Marker> getOnSubscribe(SupportMapFragment supportMapFragment) {
        return new MarkerClickedOnSubscribe(supportMapFragment);
    }

    private MarkerClickedOnSubscribe(SupportMapFragment supportMapFragment) {
        super(supportMapFragment);
    }

    @Override
    protected void mapReady(GoogleMap googleMap, final Observer<? super Marker> observer) {
        GoogleMap.OnMarkerClickListener onMarkerClickListener = new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                observer.onNext(marker);
                return false;
            }
        };
        googleMap.setOnMarkerClickListener(onMarkerClickListener);
    }

}

