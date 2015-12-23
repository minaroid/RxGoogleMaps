package com.sdoward.rxgooglemap;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.GroundOverlay;

import rx.Observer;

class GroundOverlayClickOnSubscribe extends BaseOnSubscribe<GroundOverlay> {

    public static GroundOverlayClickOnSubscribe getOnSubscribe(SupportMapFragment supportMapFragment) {
        return new GroundOverlayClickOnSubscribe(supportMapFragment);
    }

    private GroundOverlayClickOnSubscribe(SupportMapFragment supportMapFragment) {
        super(supportMapFragment);
    }

    @Override
    protected void mapReady(GoogleMap googleMap, final Observer<? super GroundOverlay> observer) {
        GoogleMap.OnGroundOverlayClickListener onGroundOverlayClickListener = new GoogleMap.OnGroundOverlayClickListener() {
            @Override
            public void onGroundOverlayClick(GroundOverlay groundOverlay) {
                observer.onNext(groundOverlay);
            }
        };
        googleMap.setOnGroundOverlayClickListener(onGroundOverlayClickListener);
    }

}
