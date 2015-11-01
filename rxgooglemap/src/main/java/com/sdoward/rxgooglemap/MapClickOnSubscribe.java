package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import rx.*;

class MapClickOnSubscribe extends BaseOnSubscribe<LatLng> {

    public static Observable.OnSubscribe<LatLng> getOnSubscribe(SupportMapFragment supportMapFragment) {
        return new MapClickOnSubscribe(supportMapFragment);
    }

    private MapClickOnSubscribe(SupportMapFragment supportMapFragment) {
        super(supportMapFragment);
    }

    @Override
    protected void mapReady(GoogleMap googleMap, final Observer<? super LatLng> observer) {
        GoogleMap.OnMapClickListener onMapClickListener = new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                observer.onNext(latLng);
            }
        };
        googleMap.setOnMapClickListener(onMapClickListener);
    }

}