package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.Polygon;

import rx.Observer;

class PolygonClickObservable extends BaseOnSubscribe<Polygon> {

    public static PolygonClickObservable getOnSubscribe(SupportMapFragment supportMapFragment) {
        return new PolygonClickObservable(supportMapFragment);
    }

    private PolygonClickObservable(SupportMapFragment supportMapFragment) {
        super(supportMapFragment);
    }

    @Override
    protected void mapReady(GoogleMap googleMap, final Observer<? super Polygon> observer) {
        GoogleMap.OnPolygonClickListener onPolygonClickListener = new GoogleMap.OnPolygonClickListener() {
            @Override
            public void onPolygonClick(Polygon polygon) {
                observer.onNext(polygon);
            }
        };
        googleMap.setOnPolygonClickListener(onPolygonClickListener);
    }
}
