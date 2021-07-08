package com.sparsh.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import android.graphics.drawable.GradientDrawable;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Context context, List<Earthquake> earthquake)
    {
        super(context,0,earthquake);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView==null)
        {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list ,parent,false);
        }

        Earthquake currentItem=getItem(position);

        TextView magnitude=(TextView)listItemView.findViewById(R.id.magnitude);
        magnitude.setText(currentItem.getMagnitude());

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = ContextCompat.getColor(getContext(),currentItem.getMagnitudeColor(currentItem.getMagnitude()));

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        TextView location1=(TextView)listItemView.findViewById(R.id.location1);
        location1.setText(currentItem.getLocation1());

        TextView location2=(TextView)listItemView.findViewById(R.id.location2);
        location2.setText(currentItem.getLocation2());

        TextView date=(TextView)listItemView.findViewById(R.id.date);
        date.setText(currentItem.getDate());

        TextView time=(TextView)listItemView.findViewById(R.id.time);
        time.setText(currentItem.getTime());

        return listItemView;
    }
}
