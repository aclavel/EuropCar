package com.example.alexis.projeteuropcar.Service;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;
import com.example.alexis.projeteuropcar.Activity.LocationListActivity;
import com.example.alexis.projeteuropcar.Activity.VehiculeListActivity;
import com.example.alexis.projeteuropcar.BO.Location;
import com.example.alexis.projeteuropcar.BO.Vehicule;
import com.example.alexis.projeteuropcar.DAO.LocationBouchon;
import com.example.alexis.projeteuropcar.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class LocationService {

    private static LocationBouchon locationBouchon;
    private static List<Vehicule> vehiculeList = new ArrayList<>();
    public LocationService() {
        locationBouchon = new LocationBouchon();
    }

    public static List<Location> getReservationList(Context ctx) {

        List<Location> locationList = new ArrayList<>();
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                "http://localhost:8080/vehicules",
                null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("TODO");
                            // TODO JSON
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //TODO return data from Sqlite
                    }
                }
        );
        RequestQueue queue = Volley.newRequestQueue(ctx);
        queue.add(request);

        //TODO return locationList
        return locationBouchon.getListLocationEnCours();
    }

    public static List<Vehicule> getVehiculeList(final Context ctx) {
        RequestFuture<JSONObject> future = RequestFuture.newFuture();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                "http://10.0.2.2:8080/vehicules",
                null,
                future,future);


        RequestQueue queue = Volley.newRequestQueue(ctx);
        queue.add(request);
        JSONObject response = null;
        try {
            response = future.get(20, TimeUnit.SECONDS);
            JSONArray jsonArray = response.getJSONArray("vehicules");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Vehicule vehicule = new Vehicule(
                        jsonObject.getString("vehiculeID"),
                        jsonObject.getInt("nbPlaces"),
                        jsonObject.getInt("locationMin"),
                        jsonObject.getInt("locationMax"),
                        Float.valueOf(jsonObject.getString("tarifMin")),
                        Float.valueOf(jsonObject.getString("tarifMax")),
                        Float.valueOf(jsonObject.getString("tarifMoyen")),
                        jsonObject.getBoolean("isDisponible")
                );

                vehiculeList.add(vehicule);

            }
            return vehiculeList;
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


        return vehiculeList;
    }
}
