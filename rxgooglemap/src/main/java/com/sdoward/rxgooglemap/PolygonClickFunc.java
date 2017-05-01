package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

class PolygonClickFunc implements Function<GoogleMap, Observable<Polygon>> {

    @Override
    public Observable<Polygon> apply(final GoogleMap googleMap) {
        return Observable.create(new ObservableOnSubscribe<Polygon>() {
            @Override
            public void subscribe(final ObservableEmitter<Polygon> emitter) {
                googleMap.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() {
                    @Override
                    public void onPolygonClick(Polygon polygon) {
                        emitter.onNext(polygon);
                    }
                });
            }
        });
    }

}