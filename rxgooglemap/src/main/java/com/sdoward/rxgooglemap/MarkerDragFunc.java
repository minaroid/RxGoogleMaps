package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.sdoward.rxgooglemap.events.*;

import rx.*;
import rx.functions.Func1;

class MarkerDragFunc implements Func1<GoogleMap, Observable<DragEvent>> {

    @Override
    public Observable<DragEvent> call(final GoogleMap googleMap) {
        return Observable.create(new Observable.OnSubscribe<DragEvent>() {
            @Override
            public void call(final Subscriber<? super DragEvent> subscriber) {
                GoogleMap.OnMarkerDragListener markerDragListener = new GoogleMap.OnMarkerDragListener() {

                    @Override
                    public void onMarkerDragStart(Marker marker) {
                        subscriber.onNext(new DragStartEvent(marker));
                    }

                    @Override
                    public void onMarkerDrag(Marker marker) {
                        subscriber.onNext(new DragEvent(marker));
                    }

                    @Override
                    public void onMarkerDragEnd(Marker marker) {
                        subscriber.onNext(new DragEndEvent(marker));
                    }
                };
                googleMap.setOnMarkerDragListener(markerDragListener);
            }
        });
    }
}
