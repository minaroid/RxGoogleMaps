package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.model.CameraPosition;

import rx.functions.Func1;

class ZoomLevelFilter implements Func1<CameraPosition, Boolean> {

    private float zoomLevel = -1;

    @Override
    public Boolean call(CameraPosition cameraPosition) {
        if (zoomLevel == -1) {
            zoomLevel = cameraPosition.zoom;
            return true;
        } else {
            return cameraPosition.zoom != zoomLevel;
        }
    }
}