package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;
import android.graphics.drawable.GradientDrawable;
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

        /** change magnitude to the right decimal format **/

        String formattedMagnitude  = formatMagnitude(currentEarthquake.getmMagnitude());

        /** set magnitudeTextView.text to output */
        magnitudeTextView.setText(formattedMagnitude);

        /** get the location string from currentEarthquakeItem to split it into offsetLocation and primaryLocation */
        String location = currentEarthquake.getmLocation();

        /** get the index where the first of appears */
        int indexWhereOffsetLocationEnds = location.indexOf("of")+2;

        String offsetLocation;
        String primaryLocation;

        /** if of is in string location split the string and set offsetLocation and location
         * else set offsetLocation to "near the" and set  to whatever is in location
         */
        if (indexWhereOffsetLocationEnds!=-1){
            offsetLocation = location.substring(0,indexWhereOffsetLocationEnds);
            primaryLocation = location.substring(indexWhereOffsetLocationEnds+1,location.length());
        } else {
            offsetLocation = "Near the ";
            primaryLocation = location;
        }

        /** Find the TextView in the list_item.xml layout with the ID offsetLocation */
        TextView offsetLocationTextView = (TextView) listItemView.findViewById(R.id.offsetLocation);

        /** Display the offsetLocation in its Textview */
        offsetLocationTextView.setText(offsetLocation);

        /** Find the TextView in the list_item.xml layout with the ID primaryLocation */
        TextView primaryLocationTextView = (TextView) listItemView.findViewById(R.id.primaryLocation);

        /** Display the PrimaryLocation in its Textview */
        primaryLocationTextView.setText(primaryLocation);

        /** Create a new Date object from the time in milliseconds of the earthquake */
        Date dateObject = new Date(currentEarthquake.getmTimeInMilliseconds());

        /** Find the TextView in the list_item.xml layout with the ID date */
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);

        /** Format the date string (i.e. "Mar 3,1949") */
        String formattedDate = formatDate(dateObject);

        /** Display the time of the current earthquake in that TextView */
        dateTextView.setText(formattedDate);

        /** Find the TextView in list_item.xml layout with the ID time */
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);

        /** Format the Time string (i.e. "4:30 pm") */
        String formattedTime = formatTime(dateObject);

        /** Display the time when the earthquake occur in timeTextView */
        timeTextView.setText(formattedTime);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getmMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        /** Return the newly created view */
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude){
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    /** this picks the correct color for the magnitude background circle **/
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude); // round the magnitude double to the nearest lowest integer
        int color = (magnitudeFloor);
        Log.w("getMag",Integer.toString(color));
        switch (color) {
            case 0:
            case 1:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(),R.color.magnitude1);
                return magnitudeColorResourceId;
            case 2:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(),R.color.magnitude2);
                return magnitudeColorResourceId;
            case 3:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(),R.color.magnitude3);
                return magnitudeColorResourceId;
            case 4:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(),R.color.magnitude4);
                return magnitudeColorResourceId;
            case 5:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(),R.color.magnitude5);
                return magnitudeColorResourceId;
            case 6:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(),R.color.magnitude6);
                return magnitudeColorResourceId;
            case 7:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(),R.color.magnitude7);
                return magnitudeColorResourceId;
            case 8:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(),R.color.magnitude8);
                return magnitudeColorResourceId;
            case 9:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(),R.color.magnitude9);
                return magnitudeColorResourceId;
            default:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(),R.color.magnitude10plus);
                return magnitudeColorResourceId;

        }
    }

}
