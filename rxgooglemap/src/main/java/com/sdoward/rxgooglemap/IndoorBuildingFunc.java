package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import com.sdoward.rxgooglemap.events.*;

import rx.*;
import rx.functions.Func1;

class IndoorBuildingFunc implements Func1<GoogleMap, Observable<IndoorBuildingEvent>> {

    @Override
    public Observable<IndoorBuildingEvent> call(final GoogleMap googleMap) {
        return Observable.create(new Observable.OnSubscribe<IndoorBuildingEvent>() {
            @Override
            public void call(final Subscriber<? super IndoorBuildingEvent> subscriber) {
                googleMap.setOnIndoorStateChangeListener(new GoogleMap.OnIndoorStateChangeListener() {
                    @Override
                    public void onIndoorBuildingFocused() {
                        subscriber.onNext(new IndoorBuildingEvent());
                    }

                    @Override
                    public void onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
                        subscriber.onNext(new IndoorLevelActivatedEvent(indoorBuilding));
                    }
                });
            }
        });
    }
}