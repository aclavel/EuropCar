package com.example.alexis.projeteuropcar.Service;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrateur on 12/04/2018.
 */

public class AgenceService {

    public void addAgence(final Context ctx, String agenceID, String userID, String mail, String raisonSocial, String siret, String voie, String codePostal, String ville) {

        Map<String, String> jsonParams = new HashMap<>();
        jsonParams.put("agenceID", mail);
        jsonParams.put("raisonSociale", raisonSocial);
        jsonParams.put("siret", siret);
        jsonParams.put("voie", voie);
        jsonParams.put("codePostal", codePostal);
        jsonParams.put("ville", ville);

        RequestFuture<JSONObject> future = RequestFuture.newFuture();
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                "http://10.0.2.2:8080/agences/" + agenceID + "/" + userID,
                new JSONObject(jsonParams),
                future,
                future
        );

        RequestQueue queue = Volley.newRequestQueue(ctx);
        queue.add(request);

        JSONObject response = null;
        try {
            response = future.get(5, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
