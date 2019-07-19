package com.sdoward.rxgooglemap.events

import com.google.android.gms.maps.model.IndoorBuilding

class IndoorLevelActivatedEvent(val indoorBuilding: IndoorBuilding) :
    IndoorBuildingEvent(){
}