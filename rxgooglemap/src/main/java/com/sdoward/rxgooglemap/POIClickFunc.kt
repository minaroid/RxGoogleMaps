package com.sdoward.rxgooglemap

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.PointOfInterest
import io.reactivex.Observable
import io.reactivex.functions.Function

class POIClickFunc : Function<GoogleMap, Observable<PointOfInterest>> {

    override fun apply(t: GoogleMap): Observable<PointOfInterest> {
        return Observable.create { subscriber ->
            t.setOnPoiClickListener {
                subscriber.onNext(it)
            }
        }
    }

}