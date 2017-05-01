package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.Marker;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

class MarkerClickFunc implements Function<GoogleMap, Observable<Marker>> {

    @Override
    public Observable<Marker> apply(final GoogleMap googleMap) {
        return Observable.create(new ObservableOnSubscribe<Marker>() {
            @Override
            public void subscribe(final ObservableEmitter<Marker> emitter) {
                googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        emitter.onNext(marker);
                        return true;
                    }
                });
            }
        });
    }
}

