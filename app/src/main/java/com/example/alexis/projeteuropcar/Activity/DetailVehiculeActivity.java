package com.example.alexis.projeteuropcar.Activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alexis.projeteuropcar.Adapter.LocationListAdapter;
import com.example.alexis.projeteuropcar.Adapter.VehiculeListAdapter;
import com.example.alexis.projeteuropcar.BO.Location;
import com.example.alexis.projeteuropcar.BO.Vehicule;
import com.example.alexis.projeteuropcar.Fragment.DetailVehiculeFragment;
import com.example.alexis.projeteuropcar.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DetailVehiculeActivity extends AppCompatActivity implements DetailVehiculeFragment.OnFragmentInteractionListener{

    private ListView detailVehiculeEntete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vehicule);

        this.detailVehiculeEntete = findViewById(R.id.detailVehiculeEntete);

        String idVehicule = getIntent().getStringExtra("idVehicule");

        List<Vehicule> vehicules = new ArrayList<>();
        vehicules.add(new Vehicule(1,"Peugeot 208 Rubis", 5,2,15, 200f, 300f));

        ArrayAdapter adapter = new VehiculeListAdapter(this ,R.layout.template_vehicule_list,vehicules);
        detailVehiculeEntete.setAdapter(adapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
