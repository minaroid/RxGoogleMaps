package com.sdoward.rxgooglemap;

import static org.mockito.Mockito.verify;

import com.google.android.gms.maps.GoogleMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import io.reactivex.observers.TestObserver;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GoogleMap.class)
public class CameraIdleFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Captor
    private ArgumentCaptor<GoogleMap.OnCameraIdleListener> argumentCaptor;

    @Test
    public void shouldEmmitMarker() throws Exception {
        TestObserver<Boolean> testSubscriber = new TestObserver<>();
        new CameraIdleFunc().apply(googleMap)
                            .subscribe(testSubscriber);
        verify(googleMap).setOnCameraIdleListener(argumentCaptor.capture());
        argumentCaptor.getValue().onCameraIdle();
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onCameraIdle();
        testSubscriber.assertValueCount(2);
    }

}
