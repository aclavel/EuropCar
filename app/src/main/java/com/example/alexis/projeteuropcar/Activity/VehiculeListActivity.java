package com.example.alexis.projeteuropcar.Activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alexis.projeteuropcar.BO.Vehicule;
import com.example.alexis.projeteuropcar.Fragment.LocationFragment;
import com.example.alexis.projeteuropcar.Fragment.VehiculeFragment;
import com.example.alexis.projeteuropcar.R;

import java.util.ArrayList;
import java.util.List;

public class VehiculeListActivity extends AppCompatActivity implements VehiculeFragment.OnVehiculeFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicule_list);

        List<Vehicule> vehicules = new ArrayList<>();
        vehicules.add(new Vehicule(1,"Peugeot 208 Rubis", 5,2,15, 200f, 300f));
        vehicules.add(new Vehicule(2,"Volkswagen Citreon", 5,8,35, 75f, 100f));
        vehicules.add(new Vehicule(3,"Citröen C3", 5,15,50, 15f, 35f));

        VehiculeFragment fragment = (VehiculeFragment) getSupportFragmentManager().findFragmentById(R.id.frag_liste_vehicule);
        fragment.refreshList(vehicules);
    }

    @Override
    public void onVehiculeFragmentInteractionInteraction(Uri uri) {

    }

     /*


        Intent intent = new Intent(CadeauxActivity.this, CadeauxDetailsActivity.class);
                intent.putExtra("id", c.getId());
                startActivity(intent);
*/


            /*
        }*/
}
