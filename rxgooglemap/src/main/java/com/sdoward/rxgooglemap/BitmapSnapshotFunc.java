package com.sdoward.rxgooglemap;

import android.graphics.Bitmap;

import com.google.android.gms.maps.GoogleMap;

import rx.*;
import rx.functions.Func1;

class BitmapSnapshotFunc implements Func1<GoogleMap, Observable<Bitmap>> {

    private final Bitmap bitmap;

    public BitmapSnapshotFunc(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public Observable<Bitmap> call(final GoogleMap googleMap) {
        return Observable.create(new Observable.OnSubscribe<Bitmap>() {
            @Override
            public void call(final Subscriber<? super Bitmap> subscriber) {
                googleMap.snapshot(new GoogleMap.SnapshotReadyCallback() {
                    @Override
                    public void onSnapshotReady(Bitmap bitmap) {
                        subscriber.onNext(bitmap);
                    }
                }, bitmap);
            }
        });
    }

}