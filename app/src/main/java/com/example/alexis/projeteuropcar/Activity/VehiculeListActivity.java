package com.example.alexis.projeteuropcar.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alexis.projeteuropcar.BO.Location;
import com.example.alexis.projeteuropcar.BO.Vehicule;
import com.example.alexis.projeteuropcar.Fragment.VehiculeFragment;
import com.example.alexis.projeteuropcar.R;
import com.example.alexis.projeteuropcar.Service.LocationService;

import java.util.ArrayList;
import java.util.List;

public class VehiculeListActivity extends AppCompatActivity implements VehiculeFragment.OnVehiculeFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicule_list);

        List<Vehicule> vehicules = new LocationService().getVehiculeList(this);


        VehiculeFragment fragment = (VehiculeFragment) getSupportFragmentManager().findFragmentById(R.id.frag_liste_vehicule);
        fragment.refreshList(vehicules);
    }

    @Override
    public void seeDetailVehicule(Vehicule vehicule) {
        Intent intent = new Intent(VehiculeListActivity.this, DetailVehiculeActivity.class);
        intent.putExtra("idVehicule", vehicule.getId());
        startActivity(intent);
    }

    @Override
    public void onVehiculeFragmentInteractionInteraction(Uri uri) {

    }
}
