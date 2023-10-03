package com.sparsh.quakereport;

import android.widget.Switch;

import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Earthquake {
    private String  mLocation,mUrl;
    Double mMagnitude;
    long mDate,mTime;
    public Earthquake(Double magnitude,String location,long date, long time,String url)
    {
        mMagnitude=magnitude;
        mLocation=location;
        mDate=date;
        mTime=time;
        mUrl=url;
    }
    //String originalString=mLocation;
    String location1,location2;
    private static final String SEPARATOR=" of ";

    public String getMagnitude()
    {
        DecimalFormat formatter=new DecimalFormat("0.0");
        return formatter.format(mMagnitude);
    }

    public String getLocation1()
    {
        location();
        return location1;
    }

    public String getLocation2()
    {
        location();
        return location2;
    }

    public String getDate()
    {
        return dateProvider(mDate);
    }

    public String getTime()
    {
        return timeProvider(mTime);
    }

    public static String dateProvider(long date)
    {
        Date dateobj=new Date(date);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("LLL dd, yyyy");
        String dateToDisplay = dateFormatter.format(dateobj);
        return dateToDisplay;
    }

    public static String timeProvider(long time)
    {
        Date timeobj=new Date(time);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("h:mm a");
        String timeToDisplay = dateFormatter.format(timeobj);
        return timeToDisplay;
    }

    public void location()
    {
        if (mLocation.contains(SEPARATOR)) {
            String[] parts = mLocation.split(SEPARATOR);
            location1 = parts[0] + SEPARATOR;
            location2 = parts[1];
        } else {
            location1 = "Near the";
            location2 = mLocation;
        }
    }
    
// Sets color based on magnitude of the earthquake
    public int getMagnitudeColor(String Magnitude)
    {
     int  magnitudeColorResourceId ;
     double mag=Double.parseDouble(Magnitude);
     int magnitudeInt=(int) Math.floor(mag);
        switch(magnitudeInt) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
    }
        return magnitudeColorResourceId;

    }
    public String getUrl()
    {
        return mUrl;
    }
}
