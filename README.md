# RxGoogleMaps

[ ![Download](https://api.bintray.com/packages/sddoward/RxGoogleMaps/RxGoogleMaps/images/download.svg) ](https://bintray.com/sddoward/RxGoogleMaps/RxGoogleMaps/_latestVersion)
<img src="https://img.shields.io/badge/platform-android-green.svg"/>
[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)


[![Build Status](https://travis-ci.org/sdoward/RxGoogleMaps.svg?branch=master)](https://travis-ci.org/sdoward/RxGoogleMaps)
[![codecov.io](https://codecov.io/github/sdoward/RxGoogleMaps/coverage.svg?branch=master)](https://codecov.io/github/sdoward/RxGoogleMaps?branch=master)

<a href="https://opensource.org/licenses/Apache-2.0" target="_blank"><img src="https://img.shields.io/badge/License-Apache_v2.0-blue.svg?style=flat"/></a>
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-RxGoogleMaps-green.svg?style=true)](https://android-arsenal.com/details/1/3050)

A library which provides an RxJava wrapper for google maps. It is something similar to [Jake Whartons rxBindings] (https://github.com/JakeWharton/RxBinding) but for google maps.

This is currently using play services 8.4.0

## Download

```groovy
compile 'com.sdoward:rxgooglemaps:0.2@aar'
compile 'compile io.reactivex:rxjava:1.1.2'
compile 'com.google.android.gms:play-services-maps:8.4.0'
```

## Usage

```java
MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
mapObservableProvider = new MapObservableProvider(mapFragment);
mapObservableProvider.getMapClickObservable()
        .subscribe(new Action1<LatLng>() {
            @Override
            public void call(LatLng latLng) {
                Log.d(MapsActivity.class.getName(), "map click");
            }
        });
```

You can find a more comprehensive example in the `Example` module.

## API

There is one class to interact with which is `MapObservableProvider`. This has 3 constructors
which accepts either...
 - MapFragment
 - SupportMapFragment
 - MapView

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

To use the example add `MAP_API_KEY` as an environment variable

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
