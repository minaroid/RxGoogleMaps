package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.IndoorBuilding;

import rx.*;

class IndoorBuildingFocusedOnSubscribe extends BaseOnSubscribe<Void> {

    public static Observable.OnSubscribe<Void> getOnSubscribe(SupportMapFragment supportMapFragment) {
        return new IndoorBuildingFocusedOnSubscribe(supportMapFragment);
    }

    private IndoorBuildingFocusedOnSubscribe(SupportMapFragment supportMapFragment) {
        super(supportMapFragment);
    }


    @Override
    protected void mapReady(GoogleMap googleMap, final Observer<? super Void> observer) {
        GoogleMap.OnIndoorStateChangeListener indoorStateChangeListener = new GoogleMap.OnIndoorStateChangeListener() {
            @Override
            public void onIndoorBuildingFocused() {
                observer.onNext(null);
            }

            @Override
            public void onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
            }
        };
        googleMap.setOnIndoorStateChangeListener(indoorStateChangeListener);
    }

}