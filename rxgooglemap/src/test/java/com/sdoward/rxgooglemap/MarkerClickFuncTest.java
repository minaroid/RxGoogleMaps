package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest({GoogleMap.class, Marker.class})
public class MarkerClickFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Mock
    private Marker marker;
    @Captor
    private ArgumentCaptor<GoogleMap.OnMarkerClickListener> argumentCaptor;

    @Test
    public void shouldEmmitMarker() throws Exception {
        TestObserver<Marker> testSubscriber = new TestObserver<>();
        new MarkerClickFunc().apply(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).setOnMarkerClickListener(argumentCaptor.capture());
        argumentCaptor.getValue().onMarkerClick(marker);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onMarkerClick(marker);
        testSubscriber.assertValueCount(2);
    }

}