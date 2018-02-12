package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by kienphan on 2/11/18.
 */

public class EarthQuakeListAdapter extends ArrayAdapter<EarthquakeItem> {

    /** constructor of the list Adapter */
    public EarthQuakeListAdapter(Activity context, ArrayList<EarthquakeItem> earthquakeItems) {
        super(context, 0, earthquakeItems);
    }

    /** inflate the get view and inflate the list
     * @param position      which EarthquakeItem is currently being added
     * @param convertView   the current view that is being recycle
     * @param parent        the viewGroup that contain the recycle views
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        /**Check if the existing view is being reused, otherwise inflate the view */
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        /** Get the {@link EarthquakeItem} object located at this position in the list */
        EarthquakeItem currentEarthquake = getItem(position);

        /** Find the TextView in the list_item.xml layout with the ID mag */
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitudeListItemText);

        /** set magnitudeTextView.text to EarthquakeItem.getMagnitude */
        magnitudeTextView.setText(currentEarthquake.getmMagnitude());

        /** Find the Textview in the list_item.xml layout with the ID locationListItemText */
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.locationListItemText);

        /** Set locationTextView.text to EarthquakeItem.getLocation */
        locationTextView.setText(currentEarthquake.getmLocation());

        /** Find the TextView in the list_item.xml layout with the ID dateListItemText */
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.dateListItemText);

        /** Set dateTextView.text to EarthquakeItem.getDate */
        dateTextView.setText(currentEarthquake.getmDate());

        /** Return the newly created view */
        return listItemView;
    }
}
