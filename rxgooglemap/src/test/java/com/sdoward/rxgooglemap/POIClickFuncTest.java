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

import io.reactivex.observers.TestObserver;

@RunWith(PowerMockRunner.class)
@PrepareForTest({GoogleMap.class, PointOfInterest.class})
public class POIClickFuncTest {

    @Mock
    private GoogleMap googleMap;
    @Mock
    private PointOfInterest poi;
    @Captor
    private ArgumentCaptor<GoogleMap.OnPoiClickListener> argumentCaptor;

    @Test
    public void shouldEmmitPolygon() throws Exception {
        TestObserver<PointOfInterest> testSubscriber = new TestObserver<>();
        new POIClickFunc().apply(googleMap)
                          .subscribe(testSubscriber);
        verify(googleMap).setOnPoiClickListener(argumentCaptor.capture());
        argumentCaptor.getValue().onPoiClick(poi);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        argumentCaptor.getValue().onPoiClick(poi);
        testSubscriber.assertValueCount(2);
    }

}
