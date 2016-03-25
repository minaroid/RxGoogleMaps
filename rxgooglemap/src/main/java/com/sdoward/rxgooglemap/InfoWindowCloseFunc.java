package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.Marker;

import rx.*;
import rx.functions.Func1;

class InfoWindowCloseFunc implements Func1<GoogleMap, Observable<Marker>> {

    @Override
    public Observable<Marker> call(final GoogleMap googleMap) {
        return Observable.create(new Observable.OnSubscribe<Marker>() {
            @Override
            public void call(final Subscriber<? super Marker> subscriber) {
                googleMap.setOnInfoWindowCloseListener(new GoogleMap.OnInfoWindowCloseListener() {
                    @Override
                    public void onInfoWindowClose(Marker marker) {
                        subscriber.onNext(marker);
                    }
                });
            }
        });
    }
}