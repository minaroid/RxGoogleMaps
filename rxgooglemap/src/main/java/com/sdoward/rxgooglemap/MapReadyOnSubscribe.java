package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;

import rx.Observer;

public class MapReadyOnSubscribe extends BaseOnSubscribe<GoogleMap> {

    public static MapReadyOnSubscribe getOnSubscribe(SupportMapFragment supportMapFragment) {
        return new MapReadyOnSubscribe(supportMapFragment);
    }

    private MapReadyOnSubscribe(SupportMapFragment supportMapFragment) {
        super(supportMapFragment);
    }

    @Override
    protected void mapReady(GoogleMap googleMap, Observer<? super GoogleMap> observer) {
        observer.onNext(googleMap);
        observer.onCompleted();
    }

}
