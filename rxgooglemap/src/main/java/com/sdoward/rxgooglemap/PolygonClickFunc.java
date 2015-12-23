package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import rx.*;
import rx.functions.Func1;

class PolygonClickFunc implements Func1<GoogleMap, Observable<Polygon>> {

    @Override
    public Observable<Polygon> call(final GoogleMap googleMap) {
        return Observable.create(new Observable.OnSubscribe<Polygon>() {
            @Override
            public void call(final Subscriber<? super Polygon> subscriber) {
                googleMap.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() {
                    @Override
                    public void onPolygonClick(Polygon polygon) {
                        subscriber.onNext(polygon);
                    }
                });
            }
        });
    }

}