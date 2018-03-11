package com.cloudtravel.cloudtravelandroid.main;

/**
 * Created by Brandon on 2018/3/11.
 */

public class PlaceRcmd {
    private String title;
    private String city;
    private int imageId;

    public PlaceRcmd(String title, String city, int imageId) {
        this.title = title;
        this.city = city;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getCity() {
        return city;
    }

    public int getImageId() {
        return imageId;
    }
}
