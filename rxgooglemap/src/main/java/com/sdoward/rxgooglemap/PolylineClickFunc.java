package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.Polyline;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

class PolylineClickFunc implements Function<GoogleMap, Observable<Polyline>> {

    @Override
    public Observable<Polyline> apply(final GoogleMap googleMap) {
        return Observable.create(new ObservableOnSubscribe<Polyline>() {
            @Override
            public void subscribe(final ObservableEmitter<Polyline> emitter) {
                googleMap.setOnPolylineClickListener(new GoogleMap.OnPolylineClickListener() {
                    @Override
                    public void onPolylineClick(Polyline polyline) {
                        emitter.onNext(polyline);
                    }
                });
            }
        });
    }

}
