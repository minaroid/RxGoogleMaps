package com.sdoward.rxgooglemaps;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import com.sdoward.rxgooglemap.MapObservableProvider;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class MapsActivity extends FragmentActivity {

    private SupportMapFragment mapFragment;
    private MapObservableProvider mapObservableProvider;
    private CompositeDisposable subscriptions = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapObservableProvider = new MapObservableProvider(mapFragment);
        subscriptions.add(mapObservableProvider.getMapReadyObservable()
                                               .subscribe(new Consumer<GoogleMap>() {
                                                   @Override
                                                   public void accept(GoogleMap googleMap) {
                                                       CircleOptions circleOptions = new CircleOptions()
                                                               .center(new LatLng(0d, 0d))
                                                               .radius(100000)
                                                               .clickable(true);
                                                       googleMap.addCircle(circleOptions);
                                                       Log.d(MapsActivity.class.getName(), "map ready");
                                                   }
                                               }));
        subscriptions.add(mapObservableProvider.getMapLongClickObservable()
                                               .subscribe(new Consumer<LatLng>() {
                                                   @Override
                                                   public void accept(LatLng latLng) {
                                                       Log.d(MapsActivity.class.getName(), "map long click");
                                                   }
                                               }));
        subscriptions.add(mapObservableProvider.getMapClickObservable()
                                               .subscribe(new Consumer<LatLng>() {
                                                   @Override
                                                   public void accept(LatLng latLng) {
                                                       Log.d(MapsActivity.class.getName(), "map click");
                                                   }
                                               }));
        subscriptions.add(mapObservableProvider.getCameraMoveStartedObservable()
                                               .subscribe(new Consumer<Integer>() {
                                                   @Override
                                                   public void accept(Integer integer) {
                                                       Log.d(MapsActivity.class.getName(),
                                                             "map move started: " + integer);
                                                   }
                                               }));
        subscriptions.add(mapObservableProvider.getCameraMoveObservable()
                                               .subscribe(new Consumer<Boolean>() {
                                                   @Override
                                                   public void accept(Boolean ignored) {
                                                       Log.d(MapsActivity.class.getName(), "map move");
                                                   }
                                               }));
        subscriptions.add(mapObservableProvider.getCameraMoveCanceledObservable()
                                               .subscribe(new Consumer<Boolean>() {
                                                   @Override
                                                   public void accept(Boolean ignored) {
                                                       Log.d(MapsActivity.class.getName(), "map move canceled");
                                                   }
                                               }));
        subscriptions.add(mapObservableProvider.getCameraIdleObservable()
                                               .subscribe(new Consumer<Boolean>() {
                                                   @Override
                                                   public void accept(Boolean ignored) {
                                                       Log.d(MapsActivity.class.getName(), "map camera idle");
                                                   }
                                               }));
        subscriptions.add(mapObservableProvider.getCircleClickObservable()
                                               .subscribe(new Consumer<Circle>() {
                                                   @Override
                                                   public void accept(Circle circle) {
                                                       Log.d(MapsActivity.class.getName(), "circle clicked");
                                                   }
                                               }));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscriptions.dispose();
    }
}
