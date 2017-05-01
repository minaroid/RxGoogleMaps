package com.sdoward.rxgooglemap;

import android.graphics.Bitmap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import com.sdoward.rxgooglemap.events.*;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

public class MapObservableProvider {

    private final Subject<GoogleMap> mapSubject = BehaviorSubject.create();

    public MapObservableProvider(final SupportMapFragment supportMapFragment) {
        Observable.create(new ObservableOnSubscribe<GoogleMap>() {
            @Override
            public void subscribe(final ObservableEmitter<GoogleMap> emitter) {
                OnMapReadyCallback mapReadyCallback = new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        emitter.onNext(googleMap);
                    }
                };
                supportMapFragment.getMapAsync(mapReadyCallback);
            }
        }).subscribe(mapSubject);
    }

    public MapObservableProvider(final MapFragment mapFragment) {
        Observable.create(new ObservableOnSubscribe<GoogleMap>() {
            @Override
            public void subscribe(final ObservableEmitter<GoogleMap> emitter) {
                OnMapReadyCallback mapReadyCallback = new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        emitter.onNext(googleMap);
                    }
                };
                mapFragment.getMapAsync(mapReadyCallback);
            }
        }).subscribe(mapSubject);
    }

    public MapObservableProvider(final MapView mapView) {
        Observable.create(new ObservableOnSubscribe<GoogleMap>() {
            @Override
            public void subscribe(final ObservableEmitter<GoogleMap> emitter) {
                OnMapReadyCallback mapReadyCallback = new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        emitter.onNext(googleMap);
                    }
                };
                mapView.getMapAsync(mapReadyCallback);
            }
        }).subscribe(mapSubject);
    }

    public Observable<GoogleMap> getMapReadyObservable() {
        return mapSubject;
    }

    public Observable<LatLng> getMapClickObservable() {
        return mapSubject.flatMap(new MapClickFunc());
    }

    public Observable<LatLng> getMapLongClickObservable() {
        return mapSubject.flatMap(new MapLongClickFunc());
    }

    public Observable<DragEvent> getDragObservable() {
        return mapSubject.flatMap(new MarkerDragFunc());
    }

    public Observable<Marker> getMarkerClickObservable() {
        return mapSubject.flatMap(new MarkerClickFunc());
    }

    public Observable<Marker> getInfoWindowClickObservable() {
        return mapSubject.flatMap(new InfoWindowClickFunc());
    }

    public Observable<Marker> getInfoWindowLongClickObservable() {
        return mapSubject.flatMap(new InfoWindowLongClickFunc());
    }

    public Observable<Marker> getInfoWindowCloseObservable() {
        return mapSubject.flatMap(new InfoWindowCloseFunc());
    }

    @Deprecated
    public Observable<CameraPosition> getCameraChangeObservable() {
        return mapSubject.flatMap(new CameraPositionFunc());
    }

    public Observable<Boolean> getCameraIdleObservable() {
        return mapSubject.flatMap(new CameraIdleFunc());
    }

    public Observable<Boolean> getCameraMoveObservable() {
        return mapSubject.flatMap(new CameraMoveFunc());
    }

    public Observable<Boolean> getCameraMoveCanceledObservable() {
        return mapSubject.flatMap(new CameraMoveCanceledFunc());
    }

    public Observable<Integer> getCameraMoveStartedObservable() {
        return mapSubject.flatMap(new CameraMoveStartedFunc());
    }

    public Observable<IndoorBuildingEvent> getIndoorBuildingObservable() {
        return mapSubject.flatMap(new IndoorBuildingFunc());
    }

    public Observable<Polyline> getPolylineClickObservable() {
        return mapSubject.flatMap(new PolylineClickFunc());
    }

    public Observable<Polygon> getPolygonClickObservable() {
        return mapSubject.flatMap(new PolygonClickFunc());
    }

    public Observable<Circle> getCircleClickObservable() {
        return mapSubject.flatMap(new CircleClickFunc());
    }

    public Observable<PointOfInterest> getPOIClickObservable() {
        return mapSubject.flatMap(new POIClickFunc());
    }

    public Observable<GroundOverlay> getGroundOverlayObservable() {
        return mapSubject.flatMap(new GroundOverlayClickFunc());
    }

    public Observable<Bitmap> getSnapshotObservable() {
        return mapSubject.flatMap(new SnapshotFunc());
    }

    public Observable<Bitmap> getSnapshotObservable(Bitmap bitmap) {
        return mapSubject.flatMap(new BitmapSnapshotFunc(bitmap));
    }

}
