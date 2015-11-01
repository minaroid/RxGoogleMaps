package com.sdoward.rxgooglemap.indoormaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.*;

import rx.*;

class IndoorLevelActivatedOnsubscribe implements
        Observable.OnSubscribe<IndoorBuilding> {

    public static Observable.OnSubscribe<IndoorBuilding> getOnSubscribe(GoogleMap googleMap) {
        return new IndoorLevelActivatedOnsubscribe(googleMap);
    }

    private final GoogleMap googleMap;

    private IndoorLevelActivatedOnsubscribe(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    @Override
    public void call(final Subscriber<? super IndoorBuilding> subscriber) {
        GoogleMap.OnIndoorStateChangeListener indoorStateChangeListener = new GoogleMap.OnIndoorStateChangeListener() {
            @Override
            public void onIndoorBuildingFocused() {
            }

            @Override
            public void onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
                subscriber.onNext(indoorBuilding);
            }
        };
        googleMap.setOnIndoorStateChangeListener(indoorStateChangeListener);
    }


}