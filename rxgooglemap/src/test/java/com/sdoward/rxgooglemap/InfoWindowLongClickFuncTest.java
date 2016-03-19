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
public class InfoWindowLongClickFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Captor
    private ArgumentCaptor<GoogleMap.OnInfoWindowLongClickListener> argumentCaptor;

    @Test
    public void shouldEmmitMarker() throws Exception {
        TestSubscriber<Marker> testSubscriber = new TestSubscriber<>();
        new InfoWindowLongClickFunc().call(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).setOnInfoWindowLongClickListener(argumentCaptor.capture());
        argumentCaptor.getValue().onInfoWindowLongClick(null);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onInfoWindowLongClick(null);
        testSubscriber.assertValueCount(2);
    }

}