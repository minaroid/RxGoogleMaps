package com.sdoward.rxgooglemaps;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import com.sdoward.rxgooglemap.MapObservableProvider;

import rx.functions.Action1;
import rx.subscriptions.*;

public class MapsActivity extends FragmentActivity {

    private SupportMapFragment mapFragment;
    private MapObservableProvider mapObservableProvider;
    private CompositeSubscription subscriptions = Subscriptions.from();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapObservableProvider = new MapObservableProvider(mapFragment);
        subscriptions.add(mapObservableProvider.getMapReadyObservable()
                                               .subscribe(new Action1<GoogleMap>() {
                                                   @Override
                                                   public void call(GoogleMap googleMap) {
                                                       CircleOptions circleOptions = new CircleOptions()
                                                               .center(new LatLng(0d, 0d))
                                                               .radius(100000)
                                                               .clickable(true);
                                                       googleMap.addCircle(circleOptions);
                                                       Log.d(MapsActivity.class.getName(), "map ready");
                                                   }
                                               }));
        subscriptions.add(mapObservableProvider.getMapLongClickObservable()
                                               .subscribe(new Action1<LatLng>() {
                                                   @Override
                                                   public void call(LatLng latLng) {
                                                       Log.d(MapsActivity.class.getName(), "map long click");
                                                   }
                                               }));
        subscriptions.add(mapObservableProvider.getMapClickObservable()
                                               .subscribe(new Action1<LatLng>() {
                                                   @Override
                                                   public void call(LatLng latLng) {
                                                       Log.d(MapsActivity.class.getName(), "map click");
                                                   }
                                               }));
        subscriptions.add(mapObservableProvider.getCameraMoveStartedObservable()
                                               .subscribe(new Action1<Integer>() {
                                                   @Override
                                                   public void call(Integer integer) {
                                                       Log.d(MapsActivity.class.getName(),
                                                             "map move started: " + integer);
                                                   }
                                               }));
        subscriptions.add(mapObservableProvider.getCameraMoveObservable()
                                               .subscribe(new Action1<Void>() {
                                                   @Override
                                                   public void call(Void aVoid) {
                                                       Log.d(MapsActivity.class.getName(), "map move");
                                                   }
                                               }));
        subscriptions.add(mapObservableProvider.getCameraMoveCanceledObservable()
                                               .subscribe(new Action1<Void>() {
                                                   @Override
                                                   public void call(Void aVoid) {
                                                       Log.d(MapsActivity.class.getName(), "map move canceled");
                                                   }
                                               }));
        subscriptions.add(mapObservableProvider.getCameraIdleObservable()
                                               .subscribe(new Action1<Void>() {
                                                   @Override
                                                   public void call(Void aVoid) {
                                                       Log.d(MapsActivity.class.getName(), "map camera idle");
                                                   }
                                               }));
        subscriptions.add(mapObservableProvider.getCircleClickObservable()
                                               .subscribe(new Action1<Circle>() {
                                                   @Override
                                                   public void call(Circle circle) {
                                                       Log.d(MapsActivity.class.getName(), "circle clicked");
                                                   }
                                               }));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscriptions.unsubscribe();
    }
}
