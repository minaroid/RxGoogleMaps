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
public class CameraMoveFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Captor
    private ArgumentCaptor<GoogleMap.OnCameraMoveListener> argumentCaptor;

    @Test
    public void shouldEmmitMarker() throws Exception {
        TestObserver<Boolean> testSubscriber = new TestObserver<>();
        new CameraMoveFunc().apply(googleMap)
                            .subscribe(testSubscriber);
        verify(googleMap).setOnCameraMoveListener(argumentCaptor.capture());
        argumentCaptor.getValue().onCameraMove();
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onCameraMove();
        testSubscriber.assertValueCount(2);
    }

}
