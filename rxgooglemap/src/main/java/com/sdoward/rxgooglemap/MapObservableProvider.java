package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import rx.Observable;

public class MapObservableProvider {

    private final SupportMapFragment supportMapFragment;

    public MapObservableProvider(SupportMapFragment supportMapFragment) {
        this.supportMapFragment = supportMapFragment;
    }

    public Observable<GoogleMap> getMapReadyObservable() {
        return Observable.create(MapReadyOnSubscribe.getOnSubscribe(supportMapFragment));
    }

    public Observable<LatLng> getMapClickObservable() {
        return Observable.create(MapClickOnSubscribe.getOnSubscribe(supportMapFragment));
    }

    public Observable<LatLng> getMapLongClickObservable() {
        return Observable.create(MapLongClickOnSubscribe.getOnSubscribe(supportMapFragment));
    }

    public Observable<Marker> getDragStartObservable() {
        return Observable.create(MarkerDragStartOnSubscribe.getOnSubscribe(supportMapFragment));
    }

    public Observable<Marker> getDragObservable() {
        return Observable.create(MarkerDragOnSubscribe.getOnSubscribe(supportMapFragment));
    }

    public Observable<Marker> getDragEndObservable() {
        return Observable.create(MarkerDragEndOnSubscribe.getOnSubscribe(supportMapFragment));
    }

    public Observable<Marker> getMarkerClickObservable() {
        return Observable.create(MarkerClickedOnSubscribe.getOnSubscribe(supportMapFragment));
    }

    public Observable<Marker> getInfoWindowClickObservable() {
        return Observable.create(InfoWindowOnSubscribe.getOnSubscribe(supportMapFragment));
    }

    public Observable<Marker> getInfoWindowLongClickObservable() {
        return Observable.create(InfoLongClickOnSubscribe.getOnSubscribe(supportMapFragment));
    }

    public Observable<Marker> getInfoWindowCloseObservable() {
        return Observable.create(InfoClosedOnSubscribe.getOnSubscribe(supportMapFragment));
    }

    public Observable<CameraPosition> getCameraChangeObservable() {
        return Observable.create(CameraPositionOnSubscribe.getObservable(supportMapFragment));
    }

    public Observable<CameraPosition> getCameraTiltChangeObservable() {
        return Observable.create(CameraPositionOnSubscribe.getObservable(supportMapFragment))
                .filter(new TiltChangeFilter());
    }

    public Observable<CameraPosition> getCameraZoomChangeObservable() {
        return Observable.create(CameraPositionOnSubscribe.getObservable(supportMapFragment))
                .filter(new ZoomLevelFilter());
    }

    public Observable<IndoorBuilding> getIndoorLevelActivatedOnSubscribe() {
        return Observable.create(IndoorLevelActivatedOnSubscribe.getOnSubscribe(supportMapFragment));
    }

    public Observable<Void> getIndoorBuildingFocusedOnSubscribe() {
        return Observable.create(IndoorBuildingFocusedOnSubscribe.getOnSubscribe(supportMapFragment));
    }

    public Observable<Polyline> getPolylineClickObservable() {
        return Observable.create(PolylineClickOnSubscribe.getOnSubscribe(supportMapFragment));
    }

    public Observable<Polygon> getPolygonClickObservable() {
        return Observable.create(PolygonClickOnSubscribe.getOnSubscribe(supportMapFragment));
    }

    public Observable<GroundOverlay> getGroundOverlayObservable() {
        return Observable.create(GroundOverlayClickOnSubscribe.getOnSubscribe(supportMapFragment));
    }

}
