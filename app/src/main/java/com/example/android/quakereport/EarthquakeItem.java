package com.example.android.quakereport;

/**
 * Created by kienphan on 2/11/18.
 */

public class EarthquakeItem {

    /** magnitude of the earthquake */
    private String mMagnitude;

    /** location of the earthquake */
    private String mLocation;

    /** date the earthquake occurred */
    private String mDate;

    /**
     * constructor
     * @param magnitude the magnitude of the earthquake
     * @param location  the location earthquake happened in
     * @param date      the date in which the earthquake occurred
     */
    public EarthquakeItem(String magnitude, String location, String date){
        mMagnitude = magnitude;
        mLocation  = location;
        mDate      = date;
    }

    /** get the magnitude of the earthquake */
    public String getmMagnitude() {
        return mMagnitude;
    }

    /** get the Location where the earthquake occurred */
    public String getmLocation() {
        return mLocation;
    }

    /** get the date the earthquake occured */
    public String getmDate() {
        return mDate;
    }

}
