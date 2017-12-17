package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polyline;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest({GoogleMap.class, Polyline.class})
public class PolylineClickFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Mock
    private Polyline polyline;
    @Captor
    private ArgumentCaptor<GoogleMap.OnPolylineClickListener> argumentCaptor;

    @Test
    public void shouldEmmitPolyline() throws Exception {
        TestObserver<Polyline> testSubscriber = new TestObserver<>();
        new PolylineClickFunc().apply(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).setOnPolylineClickListener(argumentCaptor.capture());
        argumentCaptor.getValue().onPolylineClick(polyline);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onPolylineClick(polyline);
        testSubscriber.assertValueCount(2);
    }

}