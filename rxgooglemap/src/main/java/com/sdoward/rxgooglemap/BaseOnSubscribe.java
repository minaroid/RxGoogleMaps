package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;

import rx.*;

abstract class BaseOnSubscribe<T> implements Observable.OnSubscribe<T>, OnMapReadyCallback {

    private final SupportMapFragment supportMapFragment;
    private Observer<? super T> observer;

    public BaseOnSubscribe(SupportMapFragment supportMapFragment) {
        this.supportMapFragment = supportMapFragment;
    }

    @Override
    public void call(Subscriber<? super T> subscriber) {
        observer = subscriber;
        supportMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady(googleMap, observer);
    }

    protected abstract void mapReady(GoogleMap googleMap, Observer<? super T> observer);

}
