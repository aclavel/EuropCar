package com.example.alexis.projeteuropcar.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alexis.projeteuropcar.Adapter.VehiculeListAdapter;
import com.example.alexis.projeteuropcar.BO.Vehicule;
import com.example.alexis.projeteuropcar.Fragment.DetailVehiculeFragment;
import com.example.alexis.projeteuropcar.R;
import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;

import org.joda.time.DateTime;
import java.util.ArrayList;
import java.util.List;

public class DetailVehiculeActivity extends AppCompatActivity implements DetailVehiculeFragment.OnFragmentInteractionListener, DatePickerListener{

    private ListView detailVehiculeEntete;

    private Button book;

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
    public void onClickBook(DateTime startDate, DateTime endDate, float tariJournalier) {
        Intent intent = new Intent(DetailVehiculeActivity.this, LocationListActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onDateSelected(DateTime dateSelected) {

    }
}











