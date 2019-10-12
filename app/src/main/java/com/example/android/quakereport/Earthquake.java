package com.example.android.quakereport;

public class Earthquake {

    //Magnitude of earthquake
    private String mMagnitude;

    //Location of the earthquake
    private String mLocation;

    //Data of the earthquake
    private String mData;


    public Earthquake(String magnitude, String location, String data){
        mMagnitude = magnitude;
        mLocation = location;
        mData = data;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getData() {
        return mData;
    }
}
