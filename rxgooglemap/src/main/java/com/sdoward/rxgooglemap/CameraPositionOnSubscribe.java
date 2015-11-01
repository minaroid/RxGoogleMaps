package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.CameraPosition;

import rx.*;

class CameraPositionOnSubscribe extends BaseOnSubscribe<CameraPosition> {

    public static Observable.OnSubscribe<CameraPosition> getObservable(SupportMapFragment supportMapFragment) {
        return new CameraPositionOnSubscribe(supportMapFragment);
    }

    private CameraPositionOnSubscribe(SupportMapFragment supportMapFragment) {
        super(supportMapFragment);
    }

    @Override
    protected void mapReady(GoogleMap googleMap, final Observer<? super CameraPosition> observer) {
        GoogleMap.OnCameraChangeListener onCameraChangeListener = new GoogleMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {
                observer.onNext(cameraPosition);
            }
        };
        googleMap.setOnCameraChangeListener(onCameraChangeListener);
    }

}
