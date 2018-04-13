package com.example.alexis.projeteuropcar.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alexis.projeteuropcar.BO.Agence;
import com.example.alexis.projeteuropcar.Fragment.UpdateAgenceFragment;
import com.example.alexis.projeteuropcar.R;
import com.example.alexis.projeteuropcar.Service.AgenceService;

import java.util.List;

public class UpdateAgenceActivity extends AppCompatActivity implements UpdateAgenceFragment.OnUpdateAgenceFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_agence);
    }


    @Override
    public void onUpdateAgenceFragmentListener(Agence agence) {

        UpdateAgenceActivity.ConnectionTask task = new ConnectionTask();
        task.execute();
    }

    public class ConnectionTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            AgenceService agenceService = new AgenceService();
            agenceService.addAgence(
                    UpdateAgenceActivity.this,
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    ""
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
