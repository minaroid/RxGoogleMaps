package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GoogleMap.class)
public class CameraPositionFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Captor
    private ArgumentCaptor<GoogleMap.OnCameraChangeListener> argumentCaptor;

    @Test
    public void shouldEmmitCameraPosition() throws Exception {
        TestObserver<CameraPosition> testSubscriber = new TestObserver<>();
        new CameraPositionFunc().apply(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).setOnCameraChangeListener(argumentCaptor.capture());
        CameraPosition cameraPosition = new CameraPosition(new LatLng(1d, 2d), 0, 0, 0);
        argumentCaptor.getValue().onCameraChange(cameraPosition);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        testSubscriber.assertValue(cameraPosition);
    }


}