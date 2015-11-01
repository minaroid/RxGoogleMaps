package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.Marker;

import rx.*;

class MarkerDragEndOnSubscribe extends BaseOnSubscribe<Marker> {

    public static MarkerDragEndOnSubscribe getOnSubscribe(SupportMapFragment supportMapFragment) {
        return new MarkerDragEndOnSubscribe(supportMapFragment);
    }

    public MarkerDragEndOnSubscribe(SupportMapFragment supportMapFragment) {
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

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                observer.onNext(marker);
            }
        };
        googleMap.setOnMarkerDragListener(markerDragListener);
    }

}
