package com.sdoward.rxgooglemap;

import android.graphics.Bitmap;

import com.google.android.gms.maps.GoogleMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import rx.observers.TestSubscriber;

import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GoogleMap.class)
public class SnapshotFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Captor
    private ArgumentCaptor<GoogleMap.SnapshotReadyCallback> argumentCaptor;

    @Test
    public void shouldProvideBitmap() throws Exception {
        TestSubscriber<Bitmap> testSubscriber = new TestSubscriber<>();
        new SnapshotFunc().call(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).snapshot(argumentCaptor.capture());
        argumentCaptor.getValue().onSnapshotReady(null);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        testSubscriber.assertValue(null);
    }

}