package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import rx.*;

class IndoorLevelActivatedOnSubscribe extends BaseOnSubscribe<IndoorBuilding> {

    public static Observable.OnSubscribe<IndoorBuilding> getOnSubscribe(SupportMapFragment supportMapFragment) {
        return new IndoorLevelActivatedOnSubscribe(supportMapFragment);
    }

    private IndoorLevelActivatedOnSubscribe(SupportMapFragment supportMapFragment) {
        super(supportMapFragment);
    }

    @Override
    protected void mapReady(GoogleMap googleMap, final Observer<? super IndoorBuilding> observer) {
        GoogleMap.OnIndoorStateChangeListener indoorStateChangeListener = new GoogleMap.OnIndoorStateChangeListener() {
            @Override
            public void onIndoorBuildingFocused() {
            }

            @Override
            public void onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
                observer.onNext(indoorBuilding);
            }
        };
        googleMap.setOnIndoorStateChangeListener(indoorStateChangeListener);
    }
}