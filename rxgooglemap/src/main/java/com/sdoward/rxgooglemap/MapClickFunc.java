package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

class MapClickFunc implements Function<GoogleMap, Observable<LatLng>> {

    @Override
    public Observable<LatLng> apply(final GoogleMap googleMap) {
        return Observable.create(new ObservableOnSubscribe<LatLng>() {
            @Override
            public void subscribe(final ObservableEmitter<LatLng> emitter) {
                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng latLng) {
                        emitter.onNext(latLng);
                    }
                });
            }
        });
    }
}
