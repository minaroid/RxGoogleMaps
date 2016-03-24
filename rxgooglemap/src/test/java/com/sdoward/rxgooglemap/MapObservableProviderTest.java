package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

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

}