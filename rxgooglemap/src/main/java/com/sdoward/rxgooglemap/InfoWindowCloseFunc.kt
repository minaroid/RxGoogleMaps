package com.sdoward.rxgooglemap

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import io.reactivex.Observable
import io.reactivex.functions.Function

class InfoWindowCloseFunc : Function<GoogleMap, Observable<Marker>> {

    override fun apply(t: GoogleMap): Observable<Marker> {
        return Observable.create{ subscriber->
            t.setOnInfoWindowCloseListener {
                subscriber.onNext(it)
            }
        }
    }

}