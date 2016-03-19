package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polygon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import rx.observers.TestSubscriber;

import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GoogleMap.class)
public class PolygonClickFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Captor
    private ArgumentCaptor<GoogleMap.OnPolygonClickListener> argumentCaptor;

    @Test
    public void shouldEmmitPolygon() throws Exception {
        TestSubscriber<Polygon> testSubscriber = new TestSubscriber<>();
        new PolygonClickFunc().call(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).setOnPolygonClickListener(argumentCaptor.capture());
        argumentCaptor.getValue().onPolygonClick(null);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onPolygonClick(null);
        testSubscriber.assertValueCount(2);
    }

}