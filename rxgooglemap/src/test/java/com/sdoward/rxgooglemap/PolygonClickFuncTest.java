package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polygon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest({GoogleMap.class, Polygon.class})
public class PolygonClickFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Mock
    private Polygon polygon;
    @Captor
    private ArgumentCaptor<GoogleMap.OnPolygonClickListener> argumentCaptor;

    @Test
    public void shouldEmmitPolygon() throws Exception {
        TestObserver<Polygon> testSubscriber = new TestObserver<>();
        new PolygonClickFunc().apply(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).setOnPolygonClickListener(argumentCaptor.capture());
        argumentCaptor.getValue().onPolygonClick(polygon);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onPolygonClick(polygon);
        testSubscriber.assertValueCount(2);
    }

}