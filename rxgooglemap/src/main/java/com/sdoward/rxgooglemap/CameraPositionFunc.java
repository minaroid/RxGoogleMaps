package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

@Deprecated
class CameraPositionFunc implements Function<GoogleMap, Observable<CameraPosition>> {

    @Override
    public Observable<CameraPosition> apply(final GoogleMap googleMap) {
        return Observable.create(new ObservableOnSubscribe<CameraPosition>() {
            @Override
            public void subscribe(final ObservableEmitter<CameraPosition> emitter) {
                googleMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
                    @Override
                    public void onCameraChange(CameraPosition cameraPosition) {
                        emitter.onNext(cameraPosition);
                    }
                });
            }
        });
    }
}
