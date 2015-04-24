package com.example.cavalos.sunshine.app;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by cavalos on 11/14/14.
 */
public class LocationActivity extends Activity implements LocationListener {

    private TextView mTextView;
    private LocationManager mLocationManager;
    //Set Val
    private static final long MIN_DISTANCE = 11;
    private static final long MIN_TIME = 10 * 1000;

    private String mProvider;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_layout);

        mTextView = (TextView) findViewById(R.id.location_text);

        Criteria criteria = new Criteria();
        criteria.setCostAllowed(false);
        criteria.setAltitudeRequired(false);
        criteria.setAccuracy(Criteria.ACCURACY_FINE);


        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        mProvider = mLocationManager.getBestProvider(criteria,true);

        if(mProvider != null){

            Location localization = mLocationManager.getLastKnownLocation(mProvider);

        } else {

            Log.d("Provider","Fail NULL");
        }




    }

    @Override
    protected void onResume() {
        super.onResume();
        mLocationManager.requestLocationUpdates(mProvider,MIN_TIME,MIN_DISTANCE,this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mLocationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
            mTextView.append(mTextView.getText().toString()  + location.toString() + "\n");
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
