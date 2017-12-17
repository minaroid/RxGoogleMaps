package com.sdoward.rxgooglemap;

import static org.mockito.Mockito.verify;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import io.reactivex.observers.TestObserver;

@RunWith(PowerMockRunner.class)
@PrepareForTest({GoogleMap.class, Circle.class})
public class CircleClickFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Mock
    private Circle circle;
    @Captor
    private ArgumentCaptor<GoogleMap.OnCircleClickListener> argumentCaptor;

    @Test
    public void shouldEmmitMarker() throws Exception {
        TestObserver<Circle> testSubscriber = new TestObserver<>();
        new CircleClickFunc().apply(googleMap)
                             .subscribe(testSubscriber);
        verify(googleMap).setOnCircleClickListener(argumentCaptor.capture());
        argumentCaptor.getValue().onCircleClick(circle);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onCircleClick(circle);
        testSubscriber.assertValueCount(2);
    }

}
