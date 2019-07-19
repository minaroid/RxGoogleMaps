package com.sdoward.rxgooglemap

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Polyline
import io.reactivex.Observable
import io.reactivex.functions.Function

class PolylineFunc : Function<GoogleMap, Observable<Polyline>> {

    override fun apply(t: GoogleMap): Observable<Polyline> {
        return Observable.create { subscriber ->
            t.setOnPolylineClickListener {
                subscriber.onNext(it)
            }
        }
    }

}