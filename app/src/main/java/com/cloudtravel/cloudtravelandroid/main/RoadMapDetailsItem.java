package com.cloudtravel.cloudtravelandroid.main;

public class RoadMapDetailsItem {
    private String name;
    private String time;
    private int imageId;
    public RoadMapDetailsItem(String mTime, int mImageId, String mName){
        name=mName;
        time=mTime;
        imageId=mImageId;
    }
    public String getName(){
        return name;
    }
    public String getTime(){
        return time;
    }
    public int getImage(){
        return imageId;
    }
}