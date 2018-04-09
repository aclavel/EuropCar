package com.example.alexis.projeteuropcar.Activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alexis.projeteuropcar.Fragment.UpdateAgenceFragment;
import com.example.alexis.projeteuropcar.R;

public class UpdateAgenceActivity extends AppCompatActivity implements UpdateAgenceFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_agence);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
