package com.sdoward.rxgooglemap.indoormaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.IndoorBuilding;

import rx.Observable;

public class IndoorMapsObservable {

    public static Observable<IndoorBuilding> getIndoorLevelActivatedOnSubscribe(GoogleMap googleMap) {
        return Observable.create(IndoorLevelActivatedOnsubscribe.getOnSubscribe(googleMap));
    }

    public static Observable<Void> getIndoorBuildingFocusedOnSubscribe(GoogleMap googleMap) {
        return Observable.create(IndoorBuildingFocusedOnSubscribe.getOnSubscribe(googleMap));
    }

}