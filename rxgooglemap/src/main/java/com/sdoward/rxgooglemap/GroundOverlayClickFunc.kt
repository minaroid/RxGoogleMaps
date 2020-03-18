package com.sdoward.rxgooglemap

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.GroundOverlay
import io.reactivex.Observable
import io.reactivex.functions.Function

class GroundOverlayClickFunc : Function<GoogleMap, Observable<GroundOverlay>> {

    override fun apply(t: GoogleMap): Observable<GroundOverlay> {
        return Observable.create { subscriber ->
            t.setOnGroundOverlayClickListener {
                subscriber.onNext(it)
            }
        }
    }

}