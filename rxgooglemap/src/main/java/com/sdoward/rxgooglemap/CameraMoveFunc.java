package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

class CameraMoveFunc implements Function<GoogleMap, Observable<Boolean>> {

    @Override
    public Observable<Boolean> apply(final GoogleMap googleMap) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(final ObservableEmitter<Boolean> emitter) {
                googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {

                    @Override
                    public void onCameraMove() {
                        emitter.onNext(true);
                    }

                });
            }
        });
    }

}
