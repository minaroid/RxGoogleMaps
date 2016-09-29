package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

class CameraMoveStartedFunc implements Func1<GoogleMap, Observable<Integer>> {

    @Override
    public Observable<Integer> call(final GoogleMap googleMap) {
        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(final Subscriber<? super Integer> subscriber) {
                googleMap.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() {

                    @Override
                    public void onCameraMoveStarted(int i) {
                        subscriber.onNext(i);
                    }

                });
            }
        });
    }
}
