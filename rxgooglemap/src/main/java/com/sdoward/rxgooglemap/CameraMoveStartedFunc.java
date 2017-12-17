package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

class CameraMoveStartedFunc implements Function<GoogleMap, Observable<Integer>> {

    @Override
    public Observable<Integer> apply(final GoogleMap googleMap) {
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(final ObservableEmitter<Integer> emitter) throws Exception {
                googleMap.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() {

                    @Override
                    public void onCameraMoveStarted(int i) {
                        emitter.onNext(i);
                    }

                });
            }
        });
    }
}
