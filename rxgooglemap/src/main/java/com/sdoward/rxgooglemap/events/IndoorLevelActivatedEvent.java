package com.sdoward.rxgooglemap.events;

import com.google.android.gms.maps.model.*;

public class IndoorLevelActivatedEvent extends IndoorBuildingEvent {

    private final IndoorBuilding indoorBuilding;

    public IndoorLevelActivatedEvent(IndoorBuilding indoorBuilding) {
        this.indoorBuilding = indoorBuilding;
    }

    public IndoorBuilding getIndoorBuilding() {
        return indoorBuilding;
    }
}
