# RxGoogleMaps

[ ![Download](https://api.bintray.com/packages/sddoward/RxGoogleMaps/RxGoogleMaps/images/download.svg) ](https://bintray.com/sddoward/RxGoogleMaps/RxGoogleMaps/_latestVersion)

The idea of this library to handle interactions with google maps through rxJava. It can be thought of something similar to Jake Whartons rxBindings but for google maps.

Here is an example of how it works..

### Before
```java
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_maps);
    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
    mapFragment.getMapAsync(onMapReadyCallback);
}

OnMapReadyCallback onMapReadyCallback = new OnMapReadyCallback() {
    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {
                Log.d(MapsActivity.class.getName(), "camera position");
            }
        });
    }
};
```

### After
```java
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_maps);
    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
    new MapObservableProvider(mapFragment).getCameraChangeObservable().subscribe(new Action1<CameraPosition>() {
        @Override
        public void call(CameraPosition cameraPosition) {
            Log.d(MapsActivity.class.getName(), "camera position");
        }
    });
}
```

## API

There is just one class to interact with which is `MapObservableProvider`.



### Example Setup 

To use the example add `apikey=<your google api key>` to `local.properties` 
