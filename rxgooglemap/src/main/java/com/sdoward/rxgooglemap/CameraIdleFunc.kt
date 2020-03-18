package com.sdoward.rxgooglemap

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Observable
import io.reactivex.functions.Function

class CameraIdleFunc : Function<GoogleMap, Observable<LatLng>> {

    override fun apply(t: GoogleMap): Observable<LatLng> {
        return Observable.create { subscriber ->
            t.setOnCameraIdleListener {
                subscriber.onNext(t.cameraPosition.target)
            }
        }
    }

}