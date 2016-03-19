package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import rx.observers.TestSubscriber;

import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GoogleMap.class)
public class InfoWindowCloseFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Captor
    private ArgumentCaptor<GoogleMap.OnInfoWindowCloseListener> argumentCaptor;

    @Test
    public void shouldEmmitMarker() throws Exception {
        TestSubscriber<Marker> testSubscriber = new TestSubscriber<>();
        new InfoWindowCloseFunc().call(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).setOnInfoWindowCloseListener(argumentCaptor.capture());
        argumentCaptor.getValue().onInfoWindowClose(null);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onInfoWindowClose(null);
        testSubscriber.assertValueCount(2);
    }

}