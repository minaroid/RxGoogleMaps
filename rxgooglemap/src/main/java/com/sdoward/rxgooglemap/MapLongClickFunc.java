package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

class MapLongClickFunc implements Function<GoogleMap, Observable<LatLng>> {

    @Override
    public Observable<LatLng> apply(final GoogleMap googleMap) throws Exception {
        return Observable.create(new ObservableOnSubscribe<LatLng>() {
            @Override
            public void subscribe(final ObservableEmitter<LatLng> emitter) throws Exception {
                googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                    @Override
                    public void onMapLongClick(LatLng latLng) {
                        emitter.onNext(latLng);
                    }
                });
            }
        });
    }
}