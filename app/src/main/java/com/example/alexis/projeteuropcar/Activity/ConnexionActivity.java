package com.example.alexis.projeteuropcar.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alexis.projeteuropcar.Fragment.ConnexionFragment;
import com.example.alexis.projeteuropcar.R;

public class ConnexionActivity extends AppCompatActivity implements ConnexionFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

    }

    @Override
    public void onConnextionInteraction(String mail, String password) {
        Intent intent = new Intent(ConnexionActivity.this, LocationListActivity.class);
        startActivity(intent);
    }

    @Override
    public void onRegisterInteraction(String mailConnexion, String passwordConnexion) {
        Intent intent = new Intent(ConnexionActivity.this, InscriptionActivity.class);
        intent.putExtra("mailConnexion",mailConnexion);
        intent.putExtra("passwordConnexion", passwordConnexion);
        startActivity(intent);
    }
}
