package com.example.android.quakereport;

import android.app.Activity;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by kienphan on 2/11/18.
 */

public class EarthQuakeListAdapter extends ArrayAdapter<EarthquakeItem> {

    /** constructor of the list Adapter */
    public EarthQuakeListAdapter(Activity context, ArrayList<EarthquakeItem> earthquakeItems) {
        super(context, 0, earthquakeItems);
    }



}
