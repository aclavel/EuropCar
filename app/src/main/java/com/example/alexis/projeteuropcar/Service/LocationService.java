package com.example.alexis.projeteuropcar.Service;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.alexis.projeteuropcar.Activity.LocationListActivity;
import com.example.alexis.projeteuropcar.BO.Location;
import com.example.alexis.projeteuropcar.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LocationService {

    public static List<Location> dataTest(){
        List<Location> locationList = new ArrayList<>();
        Location location = new Location();
        location.setDateDebut(new Date());
        location.setDateFin(new Date());
        location.setTarifJournalier(5.0f);
        locationList.add(location);
        locationList.add(location);
        locationList.add(location);
        return locationList;
    }
    public static List<Location> getReservationList(Context ctx) {

        List<Location> locationList = new ArrayList<>();
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                "TODO",
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
        return dataTest();
    }
}
