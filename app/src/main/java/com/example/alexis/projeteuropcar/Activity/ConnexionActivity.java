package com.example.alexis.projeteuropcar.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.alexis.projeteuropcar.Fragment.ConnexionFragment;
import com.example.alexis.projeteuropcar.R;
import com.example.alexis.projeteuropcar.Service.LoginService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ConnexionActivity extends AppCompatActivity implements ConnexionFragment.OnFragmentInteractionListener {

    private String mail;
    private String password;
    private String agenceID;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
    }

    @Override
    public void onRegisterInteraction(String mailConnexion, String passwordConnexion) {
        Intent intent = new Intent(ConnexionActivity.this, InscriptionActivity.class);
        intent.putExtra("mailConnexion", mailConnexion);
        intent.putExtra("passwordConnexion", passwordConnexion);
        startActivity(intent);
    }

    @Override
    public void onConnextionInteraction(String mail, String password) {

        this.mail = mail;
        this.password = password;

        ConnectionTask task = new ConnectionTask();
        task.execute();
    }

    public class ConnectionTask extends AsyncTask<Void, Void, List<String>> {

        @Override
        protected List<String> doInBackground(Void... voids) {

            LoginService loginService = new LoginService();
            List<String> strings =
                    loginService.connect(
                            ConnexionActivity.this,
                            ConnexionActivity.this.mail,
                            ConnexionActivity.this.password
                    );

            return strings;
        }

        @Override
        protected void onPostExecute(List<String> strings) {
            super.onPostExecute(strings);

            if (strings.size() == 2) {
                ConnexionActivity.this.agenceID = strings.get(0);
                ConnexionActivity.this.userID = strings.get(1);

                Intent intent = new Intent(ConnexionActivity.this, LocationListActivity.class);
                startActivity(intent);

            } else {
                Toast.makeText(ConnexionActivity.this, "Identifiants incorrectes", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
