package com.cloudtravel.cloudtravelandroid.widget;

public class SearchResultItem {

    private String name;
    private String address;

    public SearchResultItem(String name,String address){
        this.name=name;
        this.address=address;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }
}
