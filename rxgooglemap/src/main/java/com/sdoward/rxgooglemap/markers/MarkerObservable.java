package com.sdoward.rxgooglemap.markers;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import rx.Observable;

public class MarkerObservable {

    public static Observable<Marker> getDragStartObservable(GoogleMap googleMap) {
        return Observable.create(MarkerDragStartOnSubscribe.getOnSubscribe(googleMap));
    }

    public static Observable<Marker> getDragObservable(GoogleMap googleMap) {
        return Observable.create(MarkerDragOnSubscribe.getOnSubscribe(googleMap));
    }

    public static Observable<Marker> getDragEndObservable(GoogleMap googleMap) {
        return Observable.create(MarkerDragEndOnSubscribe.getOnSubscribe(googleMap));
    }

    public static Observable<Marker> getMarkerClickObservable(GoogleMap googleMap) {
        return Observable.create(MarkerClickedOnSubscribe.getOnSubscribe(googleMap));
    }

    public static Observable<Marker> getInfoWindowClickObservable(GoogleMap googleMap) {
        return Observable.create(InfoWindowOnSubscribe.getOnSubscribe(googleMap));
    }

}
