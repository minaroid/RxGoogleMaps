package com.sdoward.rxgooglemap

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.IndoorBuilding
import com.sdoward.rxgooglemap.events.IndoorBuildingEvent
import com.sdoward.rxgooglemap.events.IndoorLevelActivatedEvent
import io.reactivex.Observable
import io.reactivex.Observable.create
import io.reactivex.functions.Function


class IndoorBuildingFunc : Function<GoogleMap, Observable<IndoorBuildingEvent>> {

    override fun apply(t: GoogleMap): Observable<IndoorBuildingEvent> {
        return create { subscriber ->
            t.setOnIndoorStateChangeListener(object : GoogleMap.OnIndoorStateChangeListener {
                override fun onIndoorBuildingFocused() {
                    subscriber.onNext(IndoorBuildingEvent())
                }

                override fun onIndoorLevelActivated(p0: IndoorBuilding?) {
                    subscriber.onNext(p0?.let { IndoorLevelActivatedEvent(it) })

                }

            })
        }
    }

}