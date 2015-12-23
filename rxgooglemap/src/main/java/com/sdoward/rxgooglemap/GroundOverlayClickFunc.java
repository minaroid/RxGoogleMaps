package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import rx.*;
import rx.functions.Func1;

class GroundOverlayClickFunc implements Func1<GoogleMap, Observable<GroundOverlay>> {

    @Override
    public Observable<GroundOverlay> call(final GoogleMap googleMap) {
        return Observable.create(new Observable.OnSubscribe<GroundOverlay>() {
            @Override
            public void call(final Subscriber<? super GroundOverlay> subscriber) {
                googleMap.setOnGroundOverlayClickListener(new GoogleMap.OnGroundOverlayClickListener() {
                    @Override
                    public void onGroundOverlayClick(GroundOverlay groundOverlay) {
                        subscriber.onNext(groundOverlay);
                    }
                });
            }
        });
    }

}