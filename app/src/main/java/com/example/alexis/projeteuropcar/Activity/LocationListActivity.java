package com.example.alexis.projeteuropcar.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.alexis.projeteuropcar.BO.Location;
import com.example.alexis.projeteuropcar.Fragment.LocationFragment;
import com.example.alexis.projeteuropcar.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LocationListActivity extends AppCompatActivity implements LocationFragment.OnFragmentInteractionListener{

    FloatingActionButton redirectVehiculeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        this.redirectVehiculeList = findViewById(R.id.redirectVehiculeList);

        this.redirectVehiculeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocationListActivity.this,VehiculeListActivity.class);
                startActivity(intent);
            }
        });
        List<Location> locationList = new ArrayList<>();
        locationList.add(new Location(new Date(),new Date(),5.0));
        locationList.add(new Location(new Date(),new Date(),4.0));
        locationList.add(new Location(new Date(),new Date(),3.0));
        LocationFragment fragment = (LocationFragment) getSupportFragmentManager().findFragmentById(R.id.locationFragment);
        fragment.refreshList(locationList);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}