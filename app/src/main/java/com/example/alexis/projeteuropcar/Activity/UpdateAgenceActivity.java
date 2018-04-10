package com.example.alexis.projeteuropcar.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.alexis.projeteuropcar.BO.Agence;
import com.example.alexis.projeteuropcar.Fragment.UpdateAgenceFragment;
import com.example.alexis.projeteuropcar.R;

public class UpdateAgenceActivity extends AppCompatActivity implements UpdateAgenceFragment.OnUpdateAgenceFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_agence);
    }


    @Override
    public void onUpdateAgenceFragmentListener(Agence agence) {
        Intent intent = new Intent(UpdateAgenceActivity.this, LocationListActivity.class);
        startActivity(intent);
    }
}
