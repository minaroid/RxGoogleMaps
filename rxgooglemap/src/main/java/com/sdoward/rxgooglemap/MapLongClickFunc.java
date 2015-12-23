package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;

import rx.*;
import rx.functions.Func1;

class MapLongClickFunc implements Func1<GoogleMap, Observable<LatLng>> {

    @Override
    public Observable<LatLng> call(final GoogleMap googleMap) {
        return Observable.create(new Observable.OnSubscribe<LatLng>() {
            @Override
            public void call(final Subscriber<? super LatLng> subscriber) {
                googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                    @Override
                    public void onMapLongClick(LatLng latLng) {
                        subscriber.onNext(latLng);
                    }
                });
            }
        });
    }
}