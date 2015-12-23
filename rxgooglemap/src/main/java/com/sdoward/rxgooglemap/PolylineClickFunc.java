package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.Polyline;

import rx.*;
import rx.functions.Func1;

class PolylineClickFunc implements Func1<GoogleMap, Observable<Polyline>> {

    @Override
    public Observable<Polyline> call(final GoogleMap googleMap) {
        return Observable.create(new Observable.OnSubscribe<Polyline>() {
            @Override
            public void call(final Subscriber<? super Polyline> subscriber) {
                googleMap.setOnPolylineClickListener(new GoogleMap.OnPolylineClickListener() {
                    @Override
                    public void onPolylineClick(Polyline polyline) {
                        subscriber.onNext(polyline);
                    }
                });
            }
        });
    }

}
