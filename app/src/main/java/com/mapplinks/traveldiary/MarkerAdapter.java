package com.mapplinks.traveldiary;

import android.view.LayoutInflater;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by Aditya Vikram on 9/14/2015.
 */
public class MarkerAdapter implements GoogleMap.InfoWindowAdapter {

    private LayoutInflater mLayoutInflator;
    private View mView;

    MarkerAdapter(LayoutInflater layoutInflater){
        mLayoutInflator=layoutInflater;
    }
    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        if(mView==null){
            mView=mLayoutInflator.inflate(R.layout.marker,null);
        }

        return null;
    }
}
