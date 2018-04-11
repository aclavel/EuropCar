package com.example.alexis.projeteuropcar.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.alexis.projeteuropcar.Fragment.InscriptionFragment;
import com.example.alexis.projeteuropcar.Fragment.ReservationListFragment;
import com.example.alexis.projeteuropcar.R;

import java.util.ArrayList;
import java.util.List;

public class InscriptionActivity extends AppCompatActivity implements InscriptionFragment.OnFragmentInteractionListener{

    String mailConnexion;
    String passwordConnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mailConnexion = getIntent().getStringExtra("mailConnexion");
        this.passwordConnexion= getIntent().getStringExtra("passwordConnexion");
        setContentView(R.layout.activity_inscription);

    }

    @Override
    public void onRegisterInteraction(String mail, String password, String confirmPassword, String token) {
        Intent intent = new Intent(InscriptionActivity.this, UpdateAgenceActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void getLoginFromConnexion(EditText mail, EditText password){
        mail.setText(mailConnexion);
        password.setText(passwordConnexion);
    }
}
