package com.sdoward.rxgooglemap.mapClicks;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import rx.Observable;

public class MapClickObservable {

    public static Observable<LatLng> getMapClickObservable(GoogleMap googleMap) {
        return Observable.create(MapClickOnSubscribe.getOnSubscribe(googleMap));
    }

    public static Observable<LatLng> getMapLongClickObservable(GoogleMap googleMap) {
        return Observable.create(MapLongClickOnSubscribe.getOnSubscribe(googleMap));
    }

}
