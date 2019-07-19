package com.sdoward.rxgooglemaps;

import android.os.Bundle;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.sdoward.rxgooglemap.MapObservableProvider;
import io.reactivex.disposables.CompositeDisposable;

public class MapsActivity extends AppCompatActivity {

    private static final String TAG = MapsActivity.class.getSimpleName();

    private SupportMapFragment mapFragment;
    private MapObservableProvider mapObservableProvider;
    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapObservableProvider = new MapObservableProvider(mapFragment);

        disposable.add(mapObservableProvider.getMapReadyObservable()
                .subscribe(googleMap -> {
                    CircleOptions circleOptions = new CircleOptions()
                            .center(new LatLng(0d, 0d))
                            .radius(100000)
                            .clickable(true);
                    googleMap.addCircle(circleOptions);
                    Log.d(TAG, "map ready");
                }, throwable -> Log.e(TAG, throwable.getLocalizedMessage())));


        disposable.add(mapObservableProvider.getMapLongClickObservable()
                .subscribe(latLng -> Log.d(TAG, "map long click"),
                        throwable -> Log.e(TAG, throwable.getLocalizedMessage())));

        disposable.add(mapObservableProvider.getMapClickObservable()
                .subscribe(latLng -> Log.d(TAG, "map click"),
                        throwable -> Log.e(TAG, throwable.getLocalizedMessage())));


        disposable.add(mapObservableProvider.getCameraMoveStartedObservable()
                .subscribe(integer -> Log.d(TAG, "map move started: " + integer),
                        throwable -> Log.e(TAG, throwable.getLocalizedMessage())));

        disposable.add(mapObservableProvider.getCameraMoveObservable()
                .subscribe(Void -> Log.d(TAG, "map move started"),
                        throwable -> Log.e(TAG, throwable.getLocalizedMessage())));

        disposable.add(mapObservableProvider.getCameraMoveCanceledObservable()
                .subscribe(Void -> Log.d(TAG, "map move canceled"),
                        throwable -> Log.e(TAG, throwable.getLocalizedMessage())));


        disposable.add(mapObservableProvider.getCameraIdleObservable()
                .subscribe(latLng -> Log.d(TAG, "map camera idle "),
                        throwable -> Log.e(TAG, throwable.getLocalizedMessage())));

        disposable.add(mapObservableProvider.getCircleClickObservable()
                .subscribe(circle -> Log.d(TAG, "circle clicked"),
                        throwable -> Log.e(TAG, throwable.getLocalizedMessage())));

    }

    @Override
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }
}
