package com.example.alexis.projeteuropcar.Activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alexis.projeteuropcar.Fragment.InscriptionFragment;
import com.example.alexis.projeteuropcar.R;

public class InscriptionActivity extends AppCompatActivity implements InscriptionFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
