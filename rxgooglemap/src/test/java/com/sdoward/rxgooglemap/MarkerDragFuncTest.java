package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.sdoward.rxgooglemap.events.DragEvent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import rx.observers.TestSubscriber;

import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GoogleMap.class)
public class MarkerDragFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Captor
    private ArgumentCaptor<GoogleMap.OnMarkerDragListener> argumentCaptor;

    @Test
    public void shouldEmmitDragEvent() throws Exception {
        TestSubscriber<DragEvent> testSubscriber = new TestSubscriber<>();
        new MarkerDragFunc().call(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).setOnMarkerDragListener(argumentCaptor.capture());
        argumentCaptor.getValue().onMarkerDrag(null);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onMarkerDrag(null);
        testSubscriber.assertValueCount(2);
    }

    @Test
    public void shouldEmmitStartDragEvent() throws Exception {
        TestSubscriber<DragEvent> testSubscriber = new TestSubscriber<>();
        new MarkerDragFunc().call(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).setOnMarkerDragListener(argumentCaptor.capture());
        argumentCaptor.getValue().onMarkerDragStart(null);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onMarkerDragStart(null);
        testSubscriber.assertValueCount(2);
    }

    @Test
    public void shouldEmmitEndDragEvent() throws Exception {
        TestSubscriber<DragEvent> testSubscriber = new TestSubscriber<>();
        new MarkerDragFunc().call(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).setOnMarkerDragListener(argumentCaptor.capture());
        argumentCaptor.getValue().onMarkerDragEnd(null);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onMarkerDragEnd(null);
        testSubscriber.assertValueCount(2);
    }

}