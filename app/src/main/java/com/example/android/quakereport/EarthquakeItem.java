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

    // the url that takes the user to more detail info
    private String mUrl;

    /**
     * constructor
     * @param magnitude the magnitude of the earthquake
     * @param location  the location earthquake happened in
     * @param timeInMilliseconds the time in milliseconds (from the Epoch) in which the earthquake occurred
     * @param url the url to the web page of the earthquake
     */
    public EarthquakeItem(double magnitude, String location, Long timeInMilliseconds, String url){
        mMagnitude              = magnitude;
        mLocation               = location;
        mTimeInMilliseconds     = timeInMilliseconds;
        mUrl                    = url;
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

    // get the url of the earthquake website
    public String getmUrl() { return mUrl;}

}
