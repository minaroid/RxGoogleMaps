package com.sdoward.rxgooglemap

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Circle
import io.reactivex.Observable
import io.reactivex.functions.Function

class CircleClickFunc : Function<GoogleMap, Observable<Circle>> {

    override fun apply(t: GoogleMap): Observable<Circle> {
        return Observable.create { subscriber ->
            t.setOnCircleClickListener {
                subscriber.onNext(it)
            }
        }
    }

}