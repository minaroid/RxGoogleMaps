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
import rx.observers.TestSubscriber;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GoogleMap.class)
public class CameraMoveFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Captor
    private ArgumentCaptor<GoogleMap.OnCameraMoveListener> argumentCaptor;

    @Test
    public void shouldEmmitMarker() throws Exception {
        TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
        new CameraMoveFunc().call(googleMap)
                            .subscribe(testSubscriber);
        verify(googleMap).setOnCameraMoveListener(argumentCaptor.capture());
        argumentCaptor.getValue().onCameraMove();
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onCameraMove();
        testSubscriber.assertValueCount(2);
    }

}
