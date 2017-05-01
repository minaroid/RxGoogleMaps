package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.PointOfInterest;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

class POIClickFunc implements Function<GoogleMap, Observable<PointOfInterest>> {

    @Override
    public Observable<PointOfInterest> apply(final GoogleMap googleMap) {
        return Observable.create(new ObservableOnSubscribe<PointOfInterest>() {
            @Override
            public void subscribe(final ObservableEmitter<PointOfInterest> emitter) {
                googleMap.setOnPoiClickListener(new GoogleMap.OnPoiClickListener() {
                    @Override
                    public void onPoiClick(PointOfInterest pointOfInterest) {
                        emitter.onNext(pointOfInterest);
                    }
                });
            }
        });
    }
}
