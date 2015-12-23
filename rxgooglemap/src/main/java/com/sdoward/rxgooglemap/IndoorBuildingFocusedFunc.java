package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.IndoorBuilding;

import rx.*;
import rx.functions.Func1;

class IndoorBuildingFocusedFunc implements Func1<GoogleMap, Observable<Void>> {

    @Override
    public Observable<Void> call(final GoogleMap googleMap) {
        return Observable.create(new Observable.OnSubscribe<Void>() {
            @Override
            public void call(final Subscriber<? super Void> subscriber) {
                googleMap.setOnIndoorStateChangeListener(new GoogleMap.OnIndoorStateChangeListener() {
                    @Override
                    public void onIndoorBuildingFocused() {
                        subscriber.onNext(null);

                    }

                    @Override
                    public void onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
                    }
                });
            }
        });
    }
}