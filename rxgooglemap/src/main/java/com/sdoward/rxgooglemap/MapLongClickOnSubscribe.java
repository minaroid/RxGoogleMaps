package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;

import rx.*;

class MapLongClickOnSubscribe extends BaseOnSubscribe<LatLng> {

    public static Observable.OnSubscribe<LatLng> getOnSubscribe(SupportMapFragment supportMapFragment) {
        return new MapLongClickOnSubscribe(supportMapFragment);
    }

    private MapLongClickOnSubscribe(SupportMapFragment supportMapFragment) {
        super(supportMapFragment);
    }

    @Override
    protected void mapReady(GoogleMap googleMap, final Observer<? super LatLng> observer) {
        GoogleMap.OnMapLongClickListener onMapClickListener = new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                observer.onNext(latLng);
            }
        };
        googleMap.setOnMapLongClickListener(onMapClickListener);
    }

}