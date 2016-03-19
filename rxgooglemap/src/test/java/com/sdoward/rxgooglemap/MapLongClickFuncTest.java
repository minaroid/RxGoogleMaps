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
public class MapLongClickFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Captor
    private ArgumentCaptor<GoogleMap.OnMapLongClickListener> argumentCaptor;

    @Test
    public void shouldEmmitLatLng() throws Exception {
        TestSubscriber<LatLng> testSubscriber = new TestSubscriber<>();
        new MapLongClickFunc().call(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).setOnMapLongClickListener(argumentCaptor.capture());
        argumentCaptor.getValue().onMapLongClick(new LatLng(1d, 2d));
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        testSubscriber.assertValue(new LatLng(1d, 2d));
    }

}