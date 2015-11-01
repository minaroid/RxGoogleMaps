package com.sdoward.rxgooglemap.cameraChange;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;

import rx.*;

class CameraPositionOnSubscribe implements
        Observable.OnSubscribe<CameraPosition> {

    private final GoogleMap googleMap;

    public static Observable.OnSubscribe<CameraPosition> getObservable(GoogleMap googleMap) {
        return new CameraPositionOnSubscribe(googleMap);
    }

    private CameraPositionOnSubscribe(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    @Override
    public void call(final Subscriber<? super CameraPosition> subscriber) {
        GoogleMap.OnCameraChangeListener onCameraChangeListener = new GoogleMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {
                if (subscriber.isUnsubscribed() == false) {
                    subscriber.onNext(cameraPosition);
                }
            }
        };
        googleMap.setOnCameraChangeListener(onCameraChangeListener);
    }

}
