package com.example.alexis.projeteuropcar.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alexis.projeteuropcar.Adapter.LocationListAdapter;
import com.example.alexis.projeteuropcar.BO.Location;
import com.example.alexis.projeteuropcar.BO.Retour;
import com.example.alexis.projeteuropcar.Fragment.DetailLocationFragment;
import com.example.alexis.projeteuropcar.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DetailLocationActivity extends AppCompatActivity implements DetailLocationFragment.OnDetailLocationFragmentInteractionListener {

    private ListView detailLocationEntete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_location);

        this.detailLocationEntete = findViewById(R.id.detailLocationEntete);

        String idLocation = getIntent().getStringExtra("idLocation");
        List<Location> locationList = new ArrayList<>();
        Location location = new Location();
        location.setDateDebut(new Date());
        location.setDateFin(new Date());
        location.setTarifJournalier(5.0f);
        locationList.add(location);
        ArrayAdapter adapter = new LocationListAdapter(this ,R.layout.template_location_list,locationList);
        detailLocationEntete.setAdapter(adapter);
    }

    @Override
    public void onClickBtnRendre(Retour retour) {
        Intent intent = new Intent(DetailLocationActivity.this, LocationListActivity.class);
        startActivity(intent);

        Toast.makeText(this, retour.toString(), Toast.LENGTH_LONG).show();
    }
}
