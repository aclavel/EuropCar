package com.example.alexis.projeteuropcar.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.alexis.projeteuropcar.BO.Agence;
import com.example.alexis.projeteuropcar.Fragment.UpdateAgenceFragment;
import com.example.alexis.projeteuropcar.R;
import com.example.alexis.projeteuropcar.Service.AgenceService;

import java.util.List;

public class UpdateAgenceActivity extends AppCompatActivity implements UpdateAgenceFragment.OnUpdateAgenceFragmentListener {

    private Agence agence;
    private String agenceID;
    private String userID;
    private String mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_agence);
    }


    @Override
    public void onUpdateAgenceFragmentListener(Agence agence) {

        this.agence = agence;
        this.agenceID = getIntent().getStringExtra("agenceID");
        this.userID = getIntent().getStringExtra("userID");
        this.mail = getIntent().getStringExtra("mail");

        Log.i("", "***************************************************************************************************************");
        Log.i("Agence", agence.toString());
        Log.i("agenceID", this.agenceID);
        Log.i("userID", this.userID);
        Log.i("mail", this.mail);
        Log.i("", "***************************************************************************************************************");

        if(agenceID != null && !"".equals(agenceID) && userID != null && !"".equals(userID) && mail != null && !"".equals(mail)){
            UpdateAgenceActivity.ConnectionTask task = new ConnectionTask();
            task.execute();
        }
    }

    public class ConnectionTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            AgenceService agenceService = new AgenceService();
            agenceService.addAgence(
                    UpdateAgenceActivity.this,
                    UpdateAgenceActivity.this.agenceID,
                    UpdateAgenceActivity.this.userID,
                    UpdateAgenceActivity.this.mail,
                    UpdateAgenceActivity.this.agence.getRaisonSocial(),
                    UpdateAgenceActivity.this.agence.getSiret(),
                    UpdateAgenceActivity.this.agence.getVoie(),
                    UpdateAgenceActivity.this.agence.getCodePostal(),
                    UpdateAgenceActivity.this.agence.getVille()
            );
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent intent = new Intent(UpdateAgenceActivity.this, LocationListActivity.class);
            startActivity(intent);
        }
    }
}
