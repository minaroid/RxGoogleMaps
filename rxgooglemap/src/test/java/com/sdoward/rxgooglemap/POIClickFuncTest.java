package com.sdoward.rxgooglemap;
import static org.mockito.Mockito.verify;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.PointOfInterest;
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
public class POIClickFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Captor
    private ArgumentCaptor<GoogleMap.OnPoiClickListener> argumentCaptor;

    @Test
    public void shouldEmmitPolygon() throws Exception {
        TestSubscriber<PointOfInterest> testSubscriber = new TestSubscriber<>();
        new POIClickFunc().call(googleMap)
                          .subscribe(testSubscriber);
        verify(googleMap).setOnPoiClickListener(argumentCaptor.capture());
        argumentCaptor.getValue().onPoiClick(null);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onPoiClick(null);
        testSubscriber.assertValueCount(2);
    }

}
