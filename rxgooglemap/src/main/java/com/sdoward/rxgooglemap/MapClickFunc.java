package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import rx.*;
import rx.functions.Func1;

class MapClickFunc implements Func1<GoogleMap, Observable<LatLng>> {

    @Override
    public Observable<LatLng> call(final GoogleMap googleMap) {
        return Observable.create(new Observable.OnSubscribe<LatLng>() {
            @Override
            public void call(final Subscriber<? super LatLng> subscriber) {
                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng latLng) {
                        subscriber.onNext(latLng);
                    }
                });
            }
        });
    }
}
