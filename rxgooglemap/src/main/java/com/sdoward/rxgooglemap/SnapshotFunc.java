package com.sdoward.rxgooglemap;

import android.graphics.Bitmap;

import com.google.android.gms.maps.GoogleMap;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

class SnapshotFunc implements Function<GoogleMap, Observable<Bitmap>> {

    @Override
    public Observable<Bitmap> apply(final GoogleMap googleMap) throws Exception {
        return Observable.create(new ObservableOnSubscribe<Bitmap>() {
            @Override
            public void subscribe(final ObservableEmitter<Bitmap> emitter) throws Exception {
                googleMap.snapshot(new GoogleMap.SnapshotReadyCallback() {
                    @Override
                    public void onSnapshotReady(Bitmap bitmap) {
                        emitter.onNext(bitmap);
                    }
                });
            }
        });
    }
}
