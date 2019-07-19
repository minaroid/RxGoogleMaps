package com.sdoward.rxgooglemap

import com.google.android.gms.maps.GoogleMap
import io.reactivex.Observable
import io.reactivex.functions.Function

class CameraZoomChangedFunc : Function<GoogleMap, Observable<Float>> {
    override fun apply(t: GoogleMap): Observable<Float> {
        return Observable.create { subscriber ->
            t.setOnCameraMoveStartedListener {
                subscriber.onNext(t.cameraPosition.zoom)
            }
        }
    }

}