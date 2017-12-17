package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.sdoward.rxgooglemap.events.IndoorBuildingEvent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest({GoogleMap.class, IndoorBuilding.class})
public class IndoorBuildingFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Captor
    private ArgumentCaptor<GoogleMap.OnIndoorStateChangeListener> argumentCaptor;
    @Mock
    private IndoorBuilding indoorBuilding;

    @Test
    public void shouldEmmitIndoorBuildingEvent() throws Exception {
        TestObserver<IndoorBuildingEvent> testSubscriber = new TestObserver<>();
        new IndoorBuildingFunc().apply(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).setOnIndoorStateChangeListener(argumentCaptor.capture());
        argumentCaptor.getValue().onIndoorBuildingFocused();
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onIndoorBuildingFocused();
        testSubscriber.assertValueCount(2);
    }

    @Test
    public void shouldEmmitIndoorLevelActivatedEvent() throws Exception {
        TestObserver<IndoorBuildingEvent> testSubscriber = new TestObserver<>();
        new IndoorBuildingFunc().apply(googleMap)
                .subscribe(testSubscriber);
        verify(googleMap).setOnIndoorStateChangeListener(argumentCaptor.capture());
        argumentCaptor.getValue().onIndoorLevelActivated(indoorBuilding);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onIndoorLevelActivated(indoorBuilding);
        testSubscriber.assertValueCount(2);
    }

}