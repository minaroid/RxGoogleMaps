package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.Marker;

import rx.*;

class InfoLongClickOnSubscribe extends BaseOnSubscribe<Marker> {

    public static Observable.OnSubscribe<Marker> getOnSubscribe(SupportMapFragment supportMapFragment) {
        return new InfoLongClickOnSubscribe(supportMapFragment);
    }

    private InfoLongClickOnSubscribe(SupportMapFragment supportMapFragment) {
        super(supportMapFragment);
    }

    @Override
    protected void mapReady(GoogleMap googleMap, final Observer<? super Marker> observer) {
        GoogleMap.OnInfoWindowLongClickListener onInfoWindowLongClickListener = new GoogleMap.OnInfoWindowLongClickListener() {
            @Override
            public void onInfoWindowLongClick(Marker marker) {
                observer.onNext(marker);
            }
        };
        googleMap.setOnInfoWindowLongClickListener(onInfoWindowLongClickListener);
    }

}
