package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.Marker;

import rx.*;

public class InfoClosedOnSubscribe extends BaseOnSubscribe<Marker> {

    public static Observable.OnSubscribe<Marker> getOnSubscribe(SupportMapFragment supportMapFragment) {
        return new InfoClosedOnSubscribe(supportMapFragment);
    }

    private InfoClosedOnSubscribe(SupportMapFragment supportMapFragment) {
        super(supportMapFragment);
    }

    @Override
    protected void mapReady(GoogleMap googleMap, final Observer<? super Marker> observer) {
        GoogleMap.OnInfoWindowCloseListener onInfoWindowCloseListener = new GoogleMap.OnInfoWindowCloseListener() {
            @Override
            public void onInfoWindowClose(Marker marker) {
                observer.onNext(marker);
            }
        };
        googleMap.setOnInfoWindowCloseListener(onInfoWindowCloseListener);
    }

}
