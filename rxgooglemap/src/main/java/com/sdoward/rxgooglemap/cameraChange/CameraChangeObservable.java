package com.sdoward.rxgooglemap.cameraChange;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;

import rx.Observable;

public class CameraChangeObservable {

    public static Observable<CameraPosition> getCameraChangeObservable(GoogleMap googleMap) {
        return Observable.create(CameraPositionOnSubscribe.getObservable(googleMap));
    }

    public static Observable<CameraPosition> getCameraTiltChangeObservable(GoogleMap googleMap) {
        return Observable.create(CameraPositionOnSubscribe.getObservable(googleMap))
                .filter(new TiltChangeFilter());
    }

    public static Observable<CameraPosition> getCameraZoomChangeObservable(GoogleMap googleMap) {
        return Observable.create(CameraPositionOnSubscribe.getObservable(googleMap))
                .filter(new ZoomLevelFilter());
    }

}