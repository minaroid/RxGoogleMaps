package com.sdoward.rxgooglemap;


import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.Marker;

import rx.*;

class MarkerDragOnSubscribe extends BaseOnSubscribe<Marker> {

    public static MarkerDragOnSubscribe getOnSubscribe(SupportMapFragment supportMapFragment) {
        return new MarkerDragOnSubscribe(supportMapFragment);
    }

    public MarkerDragOnSubscribe(SupportMapFragment supportMapFragment) {
        super(supportMapFragment);
    }

    @Override
    protected void mapReady(GoogleMap googleMap, final Observer<? super Marker> observer) {
        GoogleMap.OnMarkerDragListener markerDragListener = new GoogleMap.OnMarkerDragListener() {

            @Override
            public void onMarkerDragStart(Marker marker) {
            }

            @Override
            public void onMarkerDrag(Marker marker) {
                observer.onNext(marker);
            }

            @Override
            public void onMarkerDragEnd(Marker marker) {

            }
        };
        googleMap.setOnMarkerDragListener(markerDragListener);
    }

}
