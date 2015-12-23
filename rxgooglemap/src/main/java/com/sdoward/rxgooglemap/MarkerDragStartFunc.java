package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.Marker;

import rx.*;
import rx.functions.Func1;

class MarkerDragStartFunc implements Func1<GoogleMap, Observable<Marker>> {

    @Override
    public Observable<Marker> call(final GoogleMap googleMap) {
        return Observable.create(new Observable.OnSubscribe<Marker>() {
            @Override
            public void call(final Subscriber<? super Marker> subscriber) {
                GoogleMap.OnMarkerDragListener markerDragListener = new GoogleMap.OnMarkerDragListener() {

                    @Override
                    public void onMarkerDragStart(Marker marker) {
                        subscriber.onNext(marker);
                    }

                    @Override
                    public void onMarkerDrag(Marker marker) {

                    }

                    @Override
                    public void onMarkerDragEnd(Marker marker) {

                    }
                };
                googleMap.setOnMarkerDragListener(markerDragListener);
            }
        });
    }
}
