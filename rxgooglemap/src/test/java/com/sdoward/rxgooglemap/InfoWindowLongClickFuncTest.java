package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest({GoogleMap.class, Marker.class})
public class InfoWindowLongClickFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Mock
    private Marker marker;
    @Captor
    private ArgumentCaptor<GoogleMap.OnInfoWindowLongClickListener> argumentCaptor;

    @Test
    public void shouldEmmitMarker() throws Exception {
        TestObserver<Marker> testSubscriber = new TestObserver<>();
        new InfoWindowLongClickFunc().apply(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).setOnInfoWindowLongClickListener(argumentCaptor.capture());
        argumentCaptor.getValue().onInfoWindowLongClick(marker);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onInfoWindowLongClick(marker);
        testSubscriber.assertValueCount(2);
    }

}