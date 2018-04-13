package com.example.alexis.projeteuropcar.Service;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;
import com.example.alexis.projeteuropcar.Activity.InscriptionActivity;
import com.example.alexis.projeteuropcar.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class LoginService {

    public List<String> connect(final Context ctx, String mail, String password) {

        Map<String, String> jsonParams = new HashMap<>();
        jsonParams.put("mail", mail);
        jsonParams.put("password", password);

        RequestFuture<JSONObject> future = RequestFuture.newFuture();
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                ctx.getString(R.string.API_url) +"connect",
                new JSONObject(jsonParams),
                future,
                future
        );

        RequestQueue queue = Volley.newRequestQueue(ctx);
        queue.add(request);

        List<String> stringList = new ArrayList<>();
        JSONObject response = null;
        try {
            response = future.get(5, TimeUnit.SECONDS);

            String agenceID = "";
            String userID = "";

            if (response.has("agenceID")){
                agenceID = response.getString("agenceID");
                stringList.add(agenceID);
            }

            if (response.has("userID")){
                userID = response.getString("userID");
                stringList.add(userID);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            if (VolleyError.class.isAssignableFrom(e.getCause().getClass())) {
                VolleyError ve = (VolleyError) e.getCause();
                if (ve.networkResponse != null) {
                    stringList.add(new String(ve.networkResponse.data));
                }
            }
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        return stringList;
    }

    // #################
    // ## INSCRIPTION ##
    // #################
    public List<String> subscribe(final InscriptionActivity ctx, String mail, String password, String token) {
        Map<String, String> jsonParams = new HashMap<>();
        jsonParams.put("mail", mail);
        jsonParams.put("password", password);

        RequestFuture<JSONObject> future = RequestFuture.newFuture();
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                ctx.getString(R.string.API_url)+ "subscribe/" + token,
                new JSONObject(jsonParams),
                future,
                future
        );

        RequestQueue queue = Volley.newRequestQueue(ctx);
        queue.add(request);

        List<String> stringList = new ArrayList<>();
        JSONObject response = null;
        try {
            response = future.get(5, TimeUnit.SECONDS);

            String agenceID = "";
            String userID = "";

            if (response.has("agenceID")){
                agenceID = response.getString("agenceID");
                stringList.add(agenceID);
            }

            if (response.has("userID")){
                userID = response.getString("userID");
                stringList.add(userID);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            if (VolleyError.class.isAssignableFrom(e.getCause().getClass())) {
                VolleyError ve = (VolleyError) e.getCause();
                if (ve.networkResponse != null) {
                    stringList.add(new String(ve.networkResponse.data));
                }
            }
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        return stringList;
    }
}
