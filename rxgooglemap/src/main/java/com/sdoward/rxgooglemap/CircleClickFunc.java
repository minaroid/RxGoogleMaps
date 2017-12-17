package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

class CircleClickFunc implements Function<GoogleMap, Observable<Circle>> {

    @Override
    public Observable<Circle> apply(final GoogleMap googleMap) {
        return Observable.create(new ObservableOnSubscribe<Circle>() {
            @Override
            public void subscribe(final ObservableEmitter<Circle> emitter) throws Exception {
                googleMap.setOnCircleClickListener(new GoogleMap.OnCircleClickListener() {
                    @Override
                    public void onCircleClick(Circle circle) {
                        emitter.onNext(circle);
                    }
                });
            }
        });
    }
}
