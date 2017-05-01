package com.sdoward.rxgooglemap;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.GroundOverlay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest({GoogleMap.class, GroundOverlay.class})
public class GroundOverlayClickFuncTest {


    @Mock
    private GoogleMap googleMap;
    @Mock
    private GroundOverlay overlay;
    @Captor
    private ArgumentCaptor<GoogleMap.OnGroundOverlayClickListener> argumentCaptor;

    @Test
    public void shouldEmmitGroundOverlay() throws Exception {
        TestObserver<GroundOverlay> testSubscriber = new TestObserver<>();
        new GroundOverlayClickFunc().apply(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).setOnGroundOverlayClickListener(argumentCaptor.capture());
        argumentCaptor.getValue().onGroundOverlayClick(overlay);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        testSubscriber.assertValue(overlay);
    }
}