package com.sdoward.rxgooglemap

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.CameraPosition
import io.reactivex.Observable
import io.reactivex.functions.Function

@Deprecated("")
class CameraPositionFunc : Function<GoogleMap, Observable<CameraPosition>> {

    override fun apply(t: GoogleMap): Observable<CameraPosition> {
        return Observable.create { subscriber ->
            t.setOnCameraChangeListener {
                subscriber.onNext(it)
            }
        }
    }

}