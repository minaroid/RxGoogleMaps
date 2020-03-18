package com.sdoward.rxgooglemap

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.sdoward.rxgooglemap.events.DragEndEvent
import com.sdoward.rxgooglemap.events.DragEvent
import com.sdoward.rxgooglemap.events.DragStartEvent
import io.reactivex.Observable
import io.reactivex.Observable.create
import io.reactivex.functions.Function


class MarkerDragFunc : Function<GoogleMap, Observable<DragEvent>> {

    override fun apply(t: GoogleMap): Observable<DragEvent> {
        return create { subscriber ->

            val markerDragListener: GoogleMap.OnMarkerDragListener = object : GoogleMap.OnMarkerDragListener {
                override fun onMarkerDragStart(marker: Marker) {
                    subscriber.onNext(DragStartEvent(marker))
                }

                override fun onMarkerDrag(marker: Marker) {
                    subscriber.onNext(DragStartEvent(marker))
                }

                override fun onMarkerDragEnd(marker: Marker) {
                    subscriber.onNext(DragEndEvent(marker))
                }

            }
            t.setOnMarkerDragListener(markerDragListener)

        }
    }

}