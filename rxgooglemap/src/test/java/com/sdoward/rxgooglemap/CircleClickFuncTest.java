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
import rx.observers.TestSubscriber;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GoogleMap.class)
public class CircleClickFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Captor
    private ArgumentCaptor<GoogleMap.OnCircleClickListener> argumentCaptor;

    @Test
    public void shouldEmmitMarker() throws Exception {
        TestSubscriber<Circle> testSubscriber = new TestSubscriber<>();
        new CircleClickFunc().call(googleMap)
                             .subscribe(testSubscriber);
        verify(googleMap).setOnCircleClickListener(argumentCaptor.capture());
        argumentCaptor.getValue().onCircleClick(null);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onCircleClick(null);
        testSubscriber.assertValueCount(2);
    }

}
