package com.sdoward.rxgooglemap

import android.graphics.Bitmap
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.*
import com.sdoward.rxgooglemap.events.DragEvent
import com.sdoward.rxgooglemap.events.IndoorBuildingEvent
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import com.google.android.gms.maps.GoogleMap


class MapObservableProvider {

    private val mapSubject = BehaviorSubject.create<GoogleMap>()!!

    constructor(supportMapFragment: SupportMapFragment) {
        val observable = Observable.create<GoogleMap> { subscriber ->
            supportMapFragment.getMapAsync {
                subscriber.onNext(it)
            }
        }
        observable.subscribe(mapSubject)
    }

    constructor(mapFragment: MapFragment) {
        val observable = Observable.create<GoogleMap> { subscriber ->
            val mapReadyCallback = OnMapReadyCallback {
                subscriber.onNext(it)
            }
            mapFragment.getMapAsync(mapReadyCallback)
        }
        observable.subscribe(mapSubject)
    }


    constructor(mapView: MapView) {
        val observable = Observable.create<GoogleMap> { subscriber ->
            val mapReadyCallback = OnMapReadyCallback {
                subscriber.onNext(it)
            }
            mapView.getMapAsync(mapReadyCallback)
        }
        observable.subscribe(mapSubject)
    }

    fun getMapReadyObservable(): Observable<GoogleMap> {
        return mapSubject
    }

    fun getMapClickObservable(): Observable<LatLng> {
        return mapSubject.flatMap(MapClickFunc())
    }

    fun getMapLongClickObservable(): Observable<LatLng> {
        return mapSubject.flatMap(MapLongClickFunc())
    }

    fun getCameraIdleObservable(): Observable<LatLng> {
        return mapSubject.flatMap(CameraIdleFunc())
    }

    fun getCameraMoveObservable(): Observable<Unit> {
        return mapSubject.flatMap(CameraMoveFunc())
    }

    fun getCameraMoveCanceledObservable(): Observable<Unit>{
        return mapSubject.flatMap(CameraMoveCanceledFunc())
    }

    fun getCameraMoveStartedObservable(): Observable<Int> {
        return mapSubject.flatMap(CameraMoveStartedFunc())
    }

    fun getCameraZoomChangedObservable(): Observable<Float> {
        return mapSubject.flatMap(CameraZoomChangedFunc())
    }

    fun getMarkerClickObservable(): Observable<Marker> {
        return mapSubject.flatMap(MarkerClickFunc())
    }

    fun getIndoorBuildingObservable(): Observable<IndoorBuildingEvent> {
        return mapSubject.flatMap(IndoorBuildingFunc())
    }

    fun getInfoWindowClickObservable(): Observable<Marker> {
        return mapSubject.flatMap(InfoWindowClickFunc())
    }

    fun getInfoWindowCloseObservable(): Observable<Marker> {
        return mapSubject.flatMap(InfoWindowCloseFunc())
    }

    fun getDragObservable(): Observable<DragEvent> {
        return mapSubject.flatMap(MarkerDragFunc())
    }

    fun getPOIClickObservable(): Observable<PointOfInterest> {
        return mapSubject.flatMap(POIClickFunc())
    }

    fun getPolygonClickObservable(): Observable<Polygon> {
        return mapSubject.flatMap(PolygonClickFunc())
    }

    fun getPolylineClickObservable(): Observable<Polyline> {
        return mapSubject.flatMap(PolylineFunc())
    }

    fun getSnapshotObservable(): Observable<Bitmap> {
        return mapSubject.flatMap(SnapshotFunc())
    }

    fun getSnapshotObservable(bitmap: Bitmap): Observable<Bitmap> {
        return mapSubject.flatMap(BitmapSnapshotFunc(bitmap))
    }

    fun getInfoWindowLongClickObservable(): Observable<Marker> {
        return mapSubject.flatMap(InfoWindowLongClickFunc())
    }

    fun getGroundOverlayObservable(): Observable<GroundOverlay> {
        return mapSubject.flatMap(GroundOverlayClickFunc())
    }

    fun getCircleClickObservable(): Observable<Circle> {
        return mapSubject.flatMap(CircleClickFunc())
    }

    @Deprecated("")
    fun getCameraChangeObservable(): Observable<CameraPosition> {
        return mapSubject.flatMap(CameraPositionFunc())
    }

}