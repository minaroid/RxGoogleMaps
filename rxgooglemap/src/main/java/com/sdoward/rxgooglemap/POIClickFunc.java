package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.PointOfInterest;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

class POIClickFunc implements Func1<GoogleMap, Observable<PointOfInterest>> {

    @Override
    public Observable<PointOfInterest> call(final GoogleMap googleMap) {
        return Observable.create(new Observable.OnSubscribe<PointOfInterest>() {
            @Override
            public void call(final Subscriber<? super PointOfInterest> subscriber) {
                googleMap.setOnPoiClickListener(new GoogleMap.OnPoiClickListener() {
                    @Override
                    public void onPoiClick(PointOfInterest pointOfInterest) {
                        subscriber.onNext(pointOfInterest);
                    }
                });
            }
        });
    }
}
