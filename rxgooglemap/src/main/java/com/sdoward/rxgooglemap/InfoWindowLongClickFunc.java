package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

class InfoWindowLongClickFunc implements Function<GoogleMap, Observable<Marker>> {

    @Override
    public Observable<Marker> apply(final GoogleMap googleMap) {
        return Observable.create(new ObservableOnSubscribe<Marker>() {
            @Override
            public void subscribe(@NonNull final ObservableEmitter<Marker> emitter) throws Exception {
                googleMap.setOnInfoWindowLongClickListener(
                        new GoogleMap.OnInfoWindowLongClickListener() {
                            @Override
                            public void onInfoWindowLongClick(Marker marker) {
                                emitter.onNext(marker);
                            }
                        });
            }
        });
    }
}
