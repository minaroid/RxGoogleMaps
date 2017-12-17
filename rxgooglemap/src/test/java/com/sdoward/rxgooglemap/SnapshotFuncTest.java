package com.sdoward.rxgooglemap;

import android.graphics.Bitmap;

import com.google.android.gms.maps.GoogleMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GoogleMap.class)
public class SnapshotFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Mock
    private Bitmap bitmap;
    @Captor
    private ArgumentCaptor<GoogleMap.SnapshotReadyCallback> argumentCaptor;

    @Test
    public void shouldProvideBitmap() throws Exception {
        TestObserver<Bitmap> testSubscriber = new TestObserver<>();
        new SnapshotFunc().apply(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).snapshot(argumentCaptor.capture());
        argumentCaptor.getValue().onSnapshotReady(bitmap);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        testSubscriber.assertValue(bitmap);
    }

}