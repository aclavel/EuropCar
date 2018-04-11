package com.example.alexis.projeteuropcar.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.alexis.projeteuropcar.Fragment.InscriptionFragment;
import com.example.alexis.projeteuropcar.Fragment.ReservationListFragment;
import com.example.alexis.projeteuropcar.Fragment.VehiculeFragment;
import com.example.alexis.projeteuropcar.R;

public class InscriptionActivity extends AppCompatActivity implements InscriptionFragment.OnFragmentInteractionListener{


    private String mailConnexion;
    private String passwordConnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        mailConnexion = getIntent().getStringExtra("mail");
        passwordConnexion = getIntent().getStringExtra("password");

    }

    @Override
    public void onRegisterInteraction(String mail, String password, String confirmPassword, String token) {
        Intent intent = new Intent(InscriptionActivity.this, UpdateAgenceActivity.class);
        startActivity(intent);
    }

    public String getMailConnexion() {return mailConnexion;}
    public String getPasswordConnexion() {return passwordConnexion;}

}
