package com.example.alexis.projeteuropcar.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alexis.projeteuropcar.Adapter.VehiculeListAdapter;
import com.example.alexis.projeteuropcar.BO.Vehicule;
import com.example.alexis.projeteuropcar.R;

import java.util.ArrayList;
import java.util.List;

public class VehiculeFragment extends Fragment {

    private ListView listeVehicules;

    private OnVehiculeFragmentInteractionListener mListener;

    public VehiculeFragment() {

    }

    public static VehiculeFragment newInstance() {
        VehiculeFragment fragment = new VehiculeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_vehicules, container, false);
        listeVehicules = v.findViewById(R.id.liste_vehicules);

        listeVehicules.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Vehicule v = (Vehicule) listeVehicules.getItemAtPosition(position);
                // appel detail
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnVehiculeFragmentInteractionListener) {
            mListener = (OnVehiculeFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnVehiculeFragmentInteractionListener {
        void onVehiculeFragmentInteractionInteraction(Uri uri);
    }

    public void refreshList(List<Vehicule> vehicules) {
        ArrayAdapter adapter = new VehiculeListAdapter(getContext(), R.layout.template_vehicule_list, vehicules);
        listeVehicules.setAdapter(adapter);
    }
}
