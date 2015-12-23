package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.Polyline;

import rx.Observer;

class PolylineClickOnSubscribe extends BaseOnSubscribe<Polyline> {

    public static PolylineClickOnSubscribe getOnSubscribe(SupportMapFragment supportMapFragment) {
        return new PolylineClickOnSubscribe(supportMapFragment);
    }

    private PolylineClickOnSubscribe(SupportMapFragment supportMapFragment) {
        super(supportMapFragment);
    }

    @Override
    protected void mapReady(GoogleMap googleMap, final Observer<? super Polyline> observer) {
        GoogleMap.OnPolylineClickListener onPolylineClickListener = new GoogleMap.OnPolylineClickListener() {
            @Override
            public void onPolylineClick(Polyline polyline) {
                observer.onNext(polyline);
            }
        };
        googleMap.setOnPolylineClickListener(onPolylineClickListener);
    }
}
