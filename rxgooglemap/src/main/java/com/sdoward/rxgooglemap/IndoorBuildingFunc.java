package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import com.sdoward.rxgooglemap.events.*;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

class IndoorBuildingFunc implements Function<GoogleMap, Observable<IndoorBuildingEvent>> {

    @Override
    public Observable<IndoorBuildingEvent> apply(final GoogleMap googleMap) {
        return Observable.create(new ObservableOnSubscribe<IndoorBuildingEvent>() {
            @Override
            public void subscribe(final ObservableEmitter<IndoorBuildingEvent> emitter) {
                googleMap.setOnIndoorStateChangeListener(
                        new GoogleMap.OnIndoorStateChangeListener() {
                            @Override
                            public void onIndoorBuildingFocused() {
                                emitter.onNext(new IndoorBuildingEvent());
                            }

                            @Override
                            public void onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
                                emitter.onNext(new IndoorLevelActivatedEvent(indoorBuilding));
                            }
                        });
            }
        });
    }
}