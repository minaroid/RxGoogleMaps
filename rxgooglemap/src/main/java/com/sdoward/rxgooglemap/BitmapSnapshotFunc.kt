package com.sdoward.rxgooglemap

import android.graphics.Bitmap
import com.google.android.gms.maps.GoogleMap
import io.reactivex.Observable
import io.reactivex.functions.Function

class BitmapSnapshotFunc(private val bitmap: Bitmap) : Function<GoogleMap, Observable<Bitmap>> {

    override fun apply(t: GoogleMap): Observable<Bitmap> {
        return Observable.create { subscriber ->

            t.snapshot({ bitmap -> subscriber.onNext(bitmap) }, bitmap)
        }
    }

}