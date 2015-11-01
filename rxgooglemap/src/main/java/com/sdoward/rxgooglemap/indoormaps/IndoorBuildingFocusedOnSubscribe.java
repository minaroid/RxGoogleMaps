package com.sdoward.rxgooglemap.indoormaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.IndoorBuilding;

import rx.*;

class IndoorBuildingFocusedOnSubscribe implements
        Observable.OnSubscribe<Void> {

    public static Observable.OnSubscribe<Void> getOnSubscribe(GoogleMap googleMap) {
        return new IndoorBuildingFocusedOnSubscribe(googleMap);
    }

    private final GoogleMap googleMap;

    private IndoorBuildingFocusedOnSubscribe(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    @Override
    public void call(final Subscriber<? super Void> subscriber) {
        GoogleMap.OnIndoorStateChangeListener indoorStateChangeListener = new GoogleMap.OnIndoorStateChangeListener() {
            @Override
            public void onIndoorBuildingFocused() {
                subscriber.onNext(null);
            }

            @Override
            public void onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
            }
        };
        googleMap.setOnIndoorStateChangeListener(indoorStateChangeListener);
    }
}