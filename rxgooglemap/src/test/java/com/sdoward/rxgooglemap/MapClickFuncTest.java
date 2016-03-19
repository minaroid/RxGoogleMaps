package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import rx.observers.TestSubscriber;

import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GoogleMap.class)
public class MapClickFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Captor
    private ArgumentCaptor<GoogleMap.OnMapClickListener> argumentCaptor;

    @Test
    public void shouldEmmitLatLng() throws Exception {
        TestSubscriber<LatLng> testSubscriber = new TestSubscriber<>();
        new MapClickFunc().call(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).setOnMapClickListener(argumentCaptor.capture());
        argumentCaptor.getValue().onMapClick(new LatLng(1d, 2d));
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        testSubscriber.assertValue(new LatLng(1d, 2d));
    }

}