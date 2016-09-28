package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class CameraMoveFunc implements Func1<GoogleMap, Observable<Void>> {

    @Override
    public Observable<Void> call(final GoogleMap googleMap) {
        return Observable.create(new Observable.OnSubscribe<Void>() {
            @Override
            public void call(final Subscriber<? super Void> subscriber) {
                googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {

                    @Override
                    public void onCameraMove() {
                        subscriber.onNext(null);
                    }

                });
            }
        });
    }

}
