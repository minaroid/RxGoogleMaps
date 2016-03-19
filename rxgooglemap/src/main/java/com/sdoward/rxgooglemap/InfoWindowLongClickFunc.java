package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.Marker;

import rx.*;
import rx.functions.Func1;

class InfoWindowLongClickFunc implements Func1<GoogleMap, Observable<Marker>> {

    @Override
    public Observable<Marker> call(final GoogleMap googleMap) {
        return Observable.create(new Observable.OnSubscribe<Marker>() {
            @Override
            public void call(final Subscriber<? super Marker> subscriber) {
                googleMap.setOnInfoWindowLongClickListener(
                        new GoogleMap.OnInfoWindowLongClickListener() {
                            @Override
                            public void onInfoWindowLongClick(Marker marker) {
                                subscriber.onNext(marker);
                            }
                        });
            }
        });
    }
}
