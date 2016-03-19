package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import com.sdoward.rxgooglemap.events.*;

import rx.*;
import rx.subjects.*;

public class MapObservableProvider {

    private final Subject<GoogleMap, GoogleMap> mapSubject = BehaviorSubject.create();

    public MapObservableProvider(final SupportMapFragment supportMapFragment) {
        Observable.create(new Observable.OnSubscribe<GoogleMap>() {
            @Override
            public void call(final Subscriber<? super GoogleMap> subscriber) {
                OnMapReadyCallback mapReadyCallback = new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        subscriber.onNext(googleMap);
                    }
                };
                supportMapFragment.getMapAsync(mapReadyCallback);
            }
        }).subscribe(mapSubject);
    }

    public MapObservableProvider(final MapFragment mapFragment) {
        Observable.create(new Observable.OnSubscribe<GoogleMap>() {
            @Override
            public void call(final Subscriber<? super GoogleMap> subscriber) {
                OnMapReadyCallback mapReadyCallback = new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        subscriber.onNext(googleMap);
                    }
                };
                mapFragment.getMapAsync(mapReadyCallback);
            }
        }).subscribe(mapSubject);
    }

    public MapObservableProvider(final MapView mapView) {
        Observable.create(new Observable.OnSubscribe<GoogleMap>() {
            @Override
            public void call(final Subscriber<? super GoogleMap> subscriber) {
                OnMapReadyCallback mapReadyCallback = new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        subscriber.onNext(googleMap);
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

    public Observable<CameraPosition> getCameraChangeObservable() {
        return mapSubject.flatMap(new CameraPositionFunc());
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

    public Observable<GroundOverlay> getGroundOverlayObservable() {
        return mapSubject.flatMap(new GroundOverlayClickFunc());
    }

}
