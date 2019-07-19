package com.sdoward.rxgooglemap

import android.graphics.Bitmap
import com.google.android.gms.maps.GoogleMap
import io.reactivex.Observable
import io.reactivex.functions.Function

class SnapshotFunc : Function<GoogleMap, Observable<Bitmap>> {

    override fun apply(t: GoogleMap): Observable<Bitmap> {
        return Observable.create { subscriber ->
            t.snapshot {
                subscriber.onNext(it)
            }
        }
    }

}