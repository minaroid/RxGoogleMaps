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
public class InfoWindowClickFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Mock
    private Marker marker;
    @Captor
    private ArgumentCaptor<GoogleMap.OnInfoWindowClickListener> argumentCaptor;

    @Test
    public void shouldEmmitMarker() throws Exception {
        TestObserver<Marker> testSubscriber = new TestObserver<>();
        new InfoWindowClickFunc().apply(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).setOnInfoWindowClickListener(argumentCaptor.capture());
        argumentCaptor.getValue().onInfoWindowClick(marker);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onInfoWindowClick(marker);
        testSubscriber.assertValueCount(2);
    }

}