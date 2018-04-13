package com.example.alexis.projeteuropcar.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alexis.projeteuropcar.Fragment.InscriptionFragment;
import com.example.alexis.projeteuropcar.R;
import com.example.alexis.projeteuropcar.Service.LoginService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InscriptionActivity extends AppCompatActivity implements InscriptionFragment.OnFragmentInteractionListener{

    String mailConnexion;
    String passwordConnexion;
    private String mail;
    private String password;
    private String token;
    private String agenceID;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mailConnexion = getIntent().getStringExtra("mailConnexion");
        this.passwordConnexion= getIntent().getStringExtra("passwordConnexion");
        setContentView(R.layout.activity_inscription);

    }

    @Override
    public void onRegisterInteraction(String mail, String password, String confirmPassword, String token) {

        this.mail = mail;
        this.password = password;
        this.token = token;

        InscriptionActivity.ConnectionTask task = new ConnectionTask();
        task.execute();

    }

    public void getLoginFromConnexion(EditText mail, EditText password){
        mail.setText(mailConnexion);
        password.setText(passwordConnexion);
    }

    public class ConnectionTask extends AsyncTask<Void, Void, List<String>> {

        @Override
        protected List<String> doInBackground(Void... voids) {

            LoginService loginService = new LoginService();
            List<String> strings =
                    loginService.subscribe(
                            InscriptionActivity.this,
                            InscriptionActivity.this.mail,
                            InscriptionActivity.this.password,
                            InscriptionActivity.this.token
                    );

            return strings;
        }

        @Override
        protected void onPostExecute(List<String> strings) {
            super.onPostExecute(strings);

            if (strings.size() == 2) {
                InscriptionActivity.this.agenceID = strings.get(0);
                InscriptionActivity.this.userID = strings.get(1);

                Intent intent = new Intent(InscriptionActivity.this, UpdateAgenceActivity.class);
                intent.putExtra("agenceID", strings.get(0));
                intent.putExtra("userID", strings.get(1));
                intent.putExtra("mail", InscriptionActivity.this.mail);
                startActivity(intent);

            } else if (strings.size() == 1) {
                try {
                    JSONObject error = new JSONObject(strings.get(0));
                    Toast.makeText(InscriptionActivity.this, error.getString("error"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
