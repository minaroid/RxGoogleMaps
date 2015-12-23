package com.sdoward.rxgooglemap.events;

import com.google.android.gms.maps.model.Marker;

public class DragEndEvent extends DragEvent {
    public DragEndEvent(Marker marker) {
        super(marker);
    }
}
