package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.sdoward.rxgooglemap.events.*;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

class MarkerDragFunc implements Function<GoogleMap, Observable<DragEvent>> {

    @Override
    public Observable<DragEvent> apply(final GoogleMap googleMap) {
        return Observable.create(new ObservableOnSubscribe<DragEvent>() {
            @Override
            public void subscribe(final ObservableEmitter<DragEvent> emitter) {
                GoogleMap.OnMarkerDragListener markerDragListener =
                        new GoogleMap.OnMarkerDragListener() {

                            @Override
                            public void onMarkerDragStart(Marker marker) {
                                emitter.onNext(new DragStartEvent(marker));
                            }

                            @Override
                            public void onMarkerDrag(Marker marker) {
                                emitter.onNext(new DragEvent(marker));
                            }

                            @Override
                            public void onMarkerDragEnd(Marker marker) {
                                emitter.onNext(new DragEndEvent(marker));
                            }
                        };
                googleMap.setOnMarkerDragListener(markerDragListener);
            }
        });
    }
}
