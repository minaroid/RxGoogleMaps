package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import rx.*;
import rx.functions.Func1;

class IndoorLevelActivatedFunc implements Func1<GoogleMap, Observable<IndoorBuilding>> {

    @Override
    public Observable<IndoorBuilding> call(final GoogleMap googleMap) {
        return Observable.create(new Observable.OnSubscribe<IndoorBuilding>() {
            @Override
            public void call(final Subscriber<? super IndoorBuilding> subscriber) {
                googleMap.setOnIndoorStateChangeListener(new GoogleMap.OnIndoorStateChangeListener() {
                    @Override
                    public void onIndoorBuildingFocused() {
                    }

                    @Override
                    public void onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
                        subscriber.onNext(indoorBuilding);
                    }
                });
            }
        });
    }
}