package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

class GroundOverlayClickFunc implements Function<GoogleMap, Observable<GroundOverlay>> {

    @Override
    public Observable<GroundOverlay> apply(final GoogleMap googleMap) {
        return Observable.create(new ObservableOnSubscribe<GroundOverlay>() {
            @Override
            public void subscribe(final ObservableEmitter<GroundOverlay> emitter) {
                googleMap.setOnGroundOverlayClickListener(
                        new GoogleMap.OnGroundOverlayClickListener() {
                            @Override
                            public void onGroundOverlayClick(GroundOverlay groundOverlay) {
                                emitter.onNext(groundOverlay);
                            }
                        });
            }
        });
    }

}