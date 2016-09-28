package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

class CircleClickFunc implements Func1<GoogleMap, Observable<Circle>> {

    @Override
    public Observable<Circle> call(final GoogleMap googleMap) {
        return Observable.create(new Observable.OnSubscribe<Circle>() {
            @Override
            public void call(final Subscriber<? super Circle> subscriber) {
                googleMap.setOnCircleClickListener(new GoogleMap.OnCircleClickListener() {
                    @Override
                    public void onCircleClick(Circle circle) {
                        subscriber.onNext(circle);
                    }
                });
            }
        });
    }
}
