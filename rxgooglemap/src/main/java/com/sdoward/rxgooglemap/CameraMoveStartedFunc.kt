package com.sdoward.rxgooglemap

import com.google.android.gms.maps.GoogleMap
import io.reactivex.Observable
import io.reactivex.functions.Function

class CameraMoveStartedFunc : Function<GoogleMap, Observable<Int>> {
    override fun apply(t: GoogleMap): Observable<Int> {
        return Observable.create { subscriber ->
            t.setOnCameraMoveStartedListener {
                subscriber.onNext(it)
            }
        }
    }

}