package com.example.alexis.projeteuropcar.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.alexis.projeteuropcar.BO.Vehicule;
import com.example.alexis.projeteuropcar.R;

import java.util.List;

public class VehiculeListAdapter extends ArrayAdapter<Vehicule> {

    private Context context;
    private int layout;
    private List<Vehicule> vehicules;

    private TextView id;
    private TextView libelle;
    private TextView nbPlaces;
    private TextView locationMinimum;
    private TextView locationMaximum;
    private TextView tarifMinimum;
    private TextView tarifMaximum;


    public VehiculeListAdapter(@NonNull Context context, int resource, @NonNull List<Vehicule> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.vehicules = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.layout, parent, false);
        }

        // RECUPERATION OBJET METIER
        Vehicule vehicule = this.vehicules.get(position);

        // RECUPERATION DES WIDGETS
        id = convertView.findViewById(R.id.tp_vehicule_id);
        libelle = convertView.findViewById(R.id.tp_vehicule_libelle);
        nbPlaces = convertView.findViewById(R.id.tp_vehicule_nb_places);
        locationMinimum = convertView.findViewById(R.id.tp_vehicule_loc_min);
        locationMaximum = convertView.findViewById(R.id.tp_vehicule_loc_max);
        tarifMinimum = convertView.findViewById(R.id.tp_vehicule_tarif_min);
        tarifMaximum = convertView.findViewById(R.id.tp_vehicule_tarif_max);


        // MISE A JOUR DES WIDGETS AVEC LES VALEURS METIER
        id.setText(String.valueOf(vehicule.getId()));
        libelle.setText(vehicule.getLibelle());
        nbPlaces.setText(String.valueOf(vehicule.getNbPlaces()));
        locationMinimum.setText(String.valueOf(vehicule.getLocationMinimum()));
        locationMaximum.setText(String.valueOf(vehicule.getLocationMaximum()));
        tarifMinimum.setText(vehicule.getTarifMinimum().toString());
        tarifMaximum.setText(vehicule.getTarifMaximum().toString());

        return convertView;
    }

}
