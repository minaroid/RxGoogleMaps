package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polyline;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import rx.observers.TestSubscriber;

import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GoogleMap.class)
public class PolylineClickFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Captor
    private ArgumentCaptor<GoogleMap.OnPolylineClickListener> argumentCaptor;

    @Test
    public void shouldEmmitPolyline() throws Exception {
        TestSubscriber<Polyline> testSubscriber = new TestSubscriber<>();
        new PolylineClickFunc().call(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).setOnPolylineClickListener(argumentCaptor.capture());
        argumentCaptor.getValue().onPolylineClick(null);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onPolylineClick(null);
        testSubscriber.assertValueCount(2);
    }

}