package com.sdoward.rxgooglemap

import com.google.android.gms.maps.GoogleMap
import io.reactivex.Observable
import io.reactivex.functions.Function

class CameraMoveCanceledFunc : Function<GoogleMap, Observable<Unit>> {

    override fun apply(t: GoogleMap): Observable<Unit> {
        return Observable.create { subscriber ->
            t.setOnCameraMoveCanceledListener {
                subscriber.onNext(Unit)
            }
        }
    }

}