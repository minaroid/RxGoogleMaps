package com.sdoward.rxgooglemap

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Polygon
import io.reactivex.Observable
import io.reactivex.functions.Function

class PolygonClickFunc : Function<GoogleMap, Observable<Polygon>> {

    override fun apply(t: GoogleMap): Observable<Polygon> {
        return Observable.create { subscriber ->
            t.setOnPolygonClickListener {
                subscriber.onNext(it)
            }
        }
    }

}