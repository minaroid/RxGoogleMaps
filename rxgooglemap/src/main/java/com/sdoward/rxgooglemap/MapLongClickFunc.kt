package com.sdoward.rxgooglemap

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Observable
import io.reactivex.functions.Function

class MapLongClickFunc : Function<GoogleMap, Observable<LatLng>> {

    override fun apply(t: GoogleMap): Observable<LatLng> {
        return Observable.create{ subscriber->
            t.setOnMapLongClickListener {
                subscriber.onNext(it)
            }
        }
    }

}