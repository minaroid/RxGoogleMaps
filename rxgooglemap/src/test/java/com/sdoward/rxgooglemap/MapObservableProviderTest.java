package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import rx.Observable;
import rx.observers.TestSubscriber;

import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GoogleMap.class)
public class MapObservableProviderTest {

    @Mock
    private MapFragment mapFragment;
    @Mock
    private SupportMapFragment supportMapFragment;
    @Mock
    private MapView mapView;
    @Mock
    private GoogleMap googleMap;
    @Captor
    private ArgumentCaptor<OnMapReadyCallback> argumentCaptor;

    @Test
    public void shouldReturnMapFromFragment() {
        TestSubscriber<GoogleMap> subscriber = new TestSubscriber<>();
        new MapObservableProvider(mapFragment)
                .getMapReadyObservable()
                .subscribe(subscriber);
        verify(mapFragment).getMapAsync(argumentCaptor.capture());
        argumentCaptor.getValue().onMapReady(googleMap);
        subscriber.assertNoErrors();
        subscriber.assertValue(googleMap);
    }

    @Test
    public void shouldReturnMapFromSupportFragment() {
        TestSubscriber<GoogleMap> subscriber = new TestSubscriber<>();
        new MapObservableProvider(supportMapFragment)
                .getMapReadyObservable()
                .subscribe(subscriber);
        verify(supportMapFragment).getMapAsync(argumentCaptor.capture());
        argumentCaptor.getValue().onMapReady(googleMap);
        subscriber.assertNoErrors();
        subscriber.assertValue(googleMap);
    }

    @Test
    public void shouldReturnMapFromView() {
        TestSubscriber<GoogleMap> subscriber = new TestSubscriber<>();
        new MapObservableProvider(mapView)
                .getMapReadyObservable()
                .subscribe(subscriber);
        verify(mapView).getMapAsync(argumentCaptor.capture());
        argumentCaptor.getValue().onMapReady(googleMap);
        subscriber.assertNoErrors();
        subscriber.assertValue(googleMap);
    }

    @Test
    public void shouldProvideClickObservable() throws Exception {
        Observable observable = new MapObservableProvider(mapFragment).getMapClickObservable();
        Assert.assertNotNull(observable);
    }

    @Test
    public void shouldProvideLongClickObservable() throws Exception {
        Observable observable = new MapObservableProvider(mapFragment).getMapLongClickObservable();
        Assert.assertNotNull(observable);
    }

    @Test
    public void shouldProvideDragObservable() throws Exception {
        Observable observable = new MapObservableProvider(mapFragment).getDragObservable();
        Assert.assertNotNull(observable);
    }

    @Test
    public void shouldProvideMarkerClickObservable() throws Exception {
        Observable observable = new MapObservableProvider(mapFragment).getMarkerClickObservable();
        Assert.assertNotNull(observable);
    }

    @Test
    public void shouldProvideInfoWindowClickObservable() throws Exception {
        Observable observable =
                new MapObservableProvider(mapFragment).getInfoWindowClickObservable();
        Assert.assertNotNull(observable);
    }

    @Test
    public void shouldProvideInfoLongClickObservable() throws Exception {
        Observable observable =
                new MapObservableProvider(mapFragment).getInfoWindowLongClickObservable();
        Assert.assertNotNull(observable);
    }

    @Test
    public void shouldProvideInfoClosedObservable() throws Exception {
        Observable observable =
                new MapObservableProvider(mapFragment).getInfoWindowCloseObservable();
        Assert.assertNotNull(observable);
    }

    @Deprecated
    @Test
    public void shouldProvideCameraChangedObservable() throws Exception {
        Observable observable = new MapObservableProvider(mapFragment).getCameraChangeObservable();
        Assert.assertNotNull(observable);
    }

    @Test
    public void shouldProvideCameraIdleObservable() throws Exception {
        Observable observable = new MapObservableProvider(mapFragment).getCameraIdleObservable();
        Assert.assertNotNull(observable);
    }

    @Test
    public void shouldProvideCameraMoveObservable() throws Exception {
        Observable observable = new MapObservableProvider(mapFragment).getCameraMoveObservable();
        Assert.assertNotNull(observable);
    }

    @Test
    public void shouldProvideCameraMoveCanceledObservable() throws Exception {
        Observable observable = new MapObservableProvider(mapFragment).getCameraMoveCanceledObservable();
        Assert.assertNotNull(observable);
    }

    @Test
    public void shouldProvideCameraMoveStartedObservable() throws Exception {
        Observable observable = new MapObservableProvider(mapFragment).getCameraMoveStartedObservable();
        Assert.assertNotNull(observable);
    }

    @Test
    public void shouldProvideIndoorBuildingObservable() throws Exception {
        Observable observable
                = new MapObservableProvider(mapFragment).getIndoorBuildingObservable();
        Assert.assertNotNull(observable);
    }

    @Test
    public void shouldProvidePolylineClickObservable() throws Exception {
        Observable observable = new MapObservableProvider(mapFragment).getPolylineClickObservable();
        Assert.assertNotNull(observable);
    }

    @Test
    public void shouldProvidePolygonClickObservable() throws Exception {
        Observable observable = new MapObservableProvider(mapFragment).getPolygonClickObservable();
        Assert.assertNotNull(observable);
    }

    @Test
    public void shouldProvideCircleClickObservable() throws Exception {
        Observable observable = new MapObservableProvider(mapFragment).getCircleClickObservable();
        Assert.assertNotNull(observable);
    }

    @Test
    public void shouldProvidePOIClickObservable() throws Exception {
        Observable observable = new MapObservableProvider(mapFragment).getPOIClickObservable();
        Assert.assertNotNull(observable);
    }

    @Test
    public void shouldProvideGroundOverlayObservable() throws Exception {
        Observable observable = new MapObservableProvider(mapFragment).getGroundOverlayObservable();
        Assert.assertNotNull(observable);
    }

    @Test
    public void shouldProvideSnapshotObservable() throws Exception {
        Observable observable = new MapObservableProvider(mapFragment).getSnapshotObservable();
        Assert.assertNotNull(observable);
    }

    @Test
    public void shouldProvideBitmapSnapshotObservable() throws Exception {
        Observable observable = new MapObservableProvider(mapFragment).getSnapshotObservable(null);
        Assert.assertNotNull(observable);
    }

}
