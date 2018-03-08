package com.cloudtravel.cloudtravelandroid.main;

/**
 * Created by KingJ on 2018/3/7.
 */

public class ScheduleItem {
    private String time;
    private int placeTypeId;
    private String position;
    private int transportationId;

    public ScheduleItem(String time, int placeTypeId, String position, int transportationId) {
        this.time = time;
        this.placeTypeId = placeTypeId;
        this.position = position;
        this.transportationId = transportationId;
    }

    public String getTime() {
        return time;
    }

    public int getPlaceTypeId() {
        return placeTypeId;
    }

    public void setPlaceTypeId(int placeTypeId) {
        this.placeTypeId = placeTypeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTransportationId() {
        return transportationId;
    }

    public void setTransportationId(int transportationId) {
        this.transportationId = transportationId;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
