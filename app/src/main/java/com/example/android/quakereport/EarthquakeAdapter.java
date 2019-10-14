package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(@NonNull Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable  View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null){
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeView = (TextView) listitemView.findViewById(R.id.magnitude);
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);
        magnitudeView.setText(formatMagnitude(currentEarthquake.getMagnitude()));

        String originalLocation = currentEarthquake.getLocation();
        String prymaryLocation;
        String locationOffset;

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            prymaryLocation = parts[1];
        }else{
            locationOffset = getContext().getString(R.string.near_the);
            prymaryLocation = originalLocation;
        }

        TextView location1 = (TextView) listitemView.findViewById(R.id.location_offset);
        location1.setText(locationOffset);

        TextView locationView = (TextView) listitemView.findViewById(R.id.primary_location);
        locationView.setText(prymaryLocation);

        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        TextView dataView = (TextView) listitemView.findViewById(R.id.data);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        dataView.setText(formattedDate);

        TextView timeView = (TextView) listitemView.findViewById(R.id.time);

        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listitemView;
    }

    private String formatDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(date);
    }

    private String formatTime(Date date){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(date);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude){
        int magColorRId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor){
            case 0:
            case 1:
                magColorRId = R.color.magnitude1;
                break;
            case 2:
                magColorRId = R.color.magnitude2;
                break;
            case 3:
                magColorRId = R.color.magnitude3;
                break;
            case 4:
                magColorRId = R.color.magnitude4;
                break;
            case 5:
                magColorRId = R.color.magnitude5;
                break;
            case 6:
                magColorRId = R.color.magnitude6;
                break;
            case 7:
                magColorRId = R.color.magnitude7;
                break;
            case 8:
                magColorRId = R.color.magnitude8;
                break;
            case 9:
                magColorRId= R.color.magnitude9;
                break;
            default:
                magColorRId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magColorRId);
    }
}
