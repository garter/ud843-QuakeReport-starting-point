package com.example.android.quakereport;

public class Earthquake {

    //Magnitude of earthquake
    private String mMagnitude;

    //Location of the earthquake
    private String mLocation;

    /** Time of the earthquake */
    private long mTimeInMilliseconds;


    public Earthquake(String magnitude, String location, long timeInMilliseconds){
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
