package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import rx.*;
import rx.functions.Func1;

@Deprecated
class CameraPositionFunc implements Func1<GoogleMap, Observable<CameraPosition>> {

    @Override
    public Observable<CameraPosition> call(final GoogleMap googleMap) {
        return Observable.create(new Observable.OnSubscribe<CameraPosition>() {
            @Override
            public void call(final Subscriber<? super CameraPosition> subscriber) {
                googleMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
                    @Override
                    public void onCameraChange(CameraPosition cameraPosition) {
                        subscriber.onNext(cameraPosition);
                    }
                });
            }
        });
    }
}
