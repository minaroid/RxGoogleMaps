package com.sdoward.rxgooglemap.cameraChange;

import com.google.android.gms.maps.model.CameraPosition;

import rx.functions.Func1;

class TiltChangeFilter implements Func1<CameraPosition, Boolean> {

    private float tiltAngle = -1;

    @Override
    public Boolean call(CameraPosition cameraPosition) {
        if (tiltAngle == -1) {
            tiltAngle = cameraPosition.tilt;
            return true;
        } else {
            return cameraPosition.tilt != tiltAngle;
        }
    }
}