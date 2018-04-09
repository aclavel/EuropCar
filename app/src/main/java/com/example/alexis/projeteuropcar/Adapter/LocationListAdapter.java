package com.example.alexis.projeteuropcar.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.alexis.projeteuropcar.BO.Location;
import com.example.alexis.projeteuropcar.R;

import java.util.List;

/**
 * Created by alexis on 09/04/2018.
 */

public class LocationListAdapter extends ArrayAdapter<Location> {

    private int layout;
    private List<Location> locationList;
    public LocationListAdapter(@NonNull Context context, int resource, @NonNull List<Location> objects) {
        super(context, resource, objects);
        this.layout = resource;
        this.locationList = objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.layout, parent, false);

        }

        Location location = this.locationList.get(position);
        TextView beginDate = convertView.findViewById(R.id.beginDate);
        TextView endDate = convertView.findViewById(R.id.endDate);
        TextView tarif = convertView.findViewById(R.id.tarif);
        beginDate.setText(location.getDateDebut().toString());
        endDate.setText(location.getDateFin().toString());
        tarif.setText(location.getTarif().toString());

        return convertView;
    }


}
