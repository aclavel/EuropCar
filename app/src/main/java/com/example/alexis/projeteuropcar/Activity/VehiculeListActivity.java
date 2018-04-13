package com.example.alexis.projeteuropcar.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.alexis.projeteuropcar.BO.Location;
import com.example.alexis.projeteuropcar.BO.Vehicule;
import com.example.alexis.projeteuropcar.Fragment.VehiculeFragment;
import com.example.alexis.projeteuropcar.R;
import com.example.alexis.projeteuropcar.Service.LocationService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VehiculeListActivity extends AppCompatActivity implements VehiculeFragment.OnVehiculeFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicule_list);

        new GetVehiculeListTask().execute();
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

    private class GetVehiculeListTask extends AsyncTask<Void, Void, Void> {

        List<Vehicule> vehiculeList = new ArrayList<>();
        @Override
        protected Void doInBackground(Void... v) {
            LocationService locationService = new LocationService();
            vehiculeList = locationService.getVehiculeList(VehiculeListActivity.this);


            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
            super.onPostExecute(v);

            VehiculeFragment fragment = (VehiculeFragment) getSupportFragmentManager().findFragmentById(R.id.frag_liste_vehicule);
            fragment.refreshList(vehiculeList);

        }


    }
}
