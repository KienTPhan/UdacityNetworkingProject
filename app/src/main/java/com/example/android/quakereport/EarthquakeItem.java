package com.example.android.quakereport;

/**
 * Created by kienphan on 2/11/18.
 */

public class EarthquakeItem {

    /** magnitude of the earthquake */
    private double mMagnitude;

    /** location of the earthquake */
    private String mLocation;

    /** date the earthquake occurred */
    private Long mTimeInMilliseconds;

    /**
     * constructor
     * @param magnitude the magnitude of the earthquake
     * @param location  the location earthquake happened in
     * @param timeInMilliseconds the time in milliseconds (from the Epoch) in which the earthquake occurred
     */
    public EarthquakeItem(double magnitude, String location, Long timeInMilliseconds){
        mMagnitude              = magnitude;
        mLocation               = location;
        mTimeInMilliseconds     = timeInMilliseconds;
    }

    /** get the magnitude of the earthquake */
    public double getmMagnitude() {
        return mMagnitude;
    }

    /** get the Location where the earthquake occurred */
    public String getmLocation() {
        return mLocation;
    }

    /** get the date the earthquake occured */
    public Long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

}
