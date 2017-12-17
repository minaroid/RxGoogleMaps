package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

class InfoWindowClickFunc implements Function<GoogleMap, Observable<Marker>> {

    @Override
    public Observable<Marker> apply(final GoogleMap googleMap) {
        return Observable.create(new ObservableOnSubscribe<Marker>() {
            @Override
            public void subscribe(final ObservableEmitter<Marker> emitter) throws Exception {
                googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {
                        emitter.onNext(marker);
                    }
                });
            }
        });
    }
}
