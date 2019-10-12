package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

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
        magnitudeView.setText(currentEarthquake.getMagnitude());

        TextView locationView = (TextView) listitemView.findViewById(R.id.location);
        locationView.setText(currentEarthquake.getLocation());

        TextView dataView = (TextView) listitemView.findViewById(R.id.data);
        dataView.setText(currentEarthquake.getData());

        return listitemView;
    }
}
