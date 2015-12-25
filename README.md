# RxGoogleMaps

[ ![Download](https://api.bintray.com/packages/sddoward/RxGoogleMaps/RxGoogleMaps/images/download.svg) ](https://bintray.com/sddoward/RxGoogleMaps/RxGoogleMaps/_latestVersion)

The idea of this library to handle interactions with google maps through rxJava. It can be thought of something similar to [Jake Whartons rxBindings] (https://github.com/JakeWharton/RxBinding) but for google maps. This is currently using play services 8.4.0

## Download

```groovy
compile 'com.sdoward:rxGoogleMaps:0.2@aar'
compile 'compile io.reactivex:rxjava:1.1.0'
compile 'com.google.android.gms:play-services-maps:8.4.0'
```

## API

There is just one class to interact with which is `MapObservableProvider`.

This provides the following observables...
 - MapReady
 - MapClick
 - MapLngClick
 - PolylineClick
 - PolygonClick
 - GroundOverlayClick
 - MarkerClick
 - InfoWindowClick
 - InfoWindowLongClick
 - InfoWindowClose
 - DragChange
 - CameraChange
 - IndoorBuildingChange

### Example Setup 

To use the example add `apikey=<your google api key>` to `local.properties` 

License
-------

    Copyright (C) 2015 Sam Doward

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
