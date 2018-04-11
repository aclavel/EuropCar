package com.example.alexis.projeteuropcar.DAO;

import com.example.alexis.projeteuropcar.BO.Agence;
import com.example.alexis.projeteuropcar.BO.Location;
import com.example.alexis.projeteuropcar.BO.Vehicule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LocationBouchon implements ILocationDAO {

    private List<Location> locations;

    public LocationBouchon() {
        locations = new ArrayList<>();

        locations.add(new Location("","", 45f, true, new Date(), new Date()));
        locations.add(new Location("","", 80f, true, new Date(), new Date()));
        locations.add(new Location("","", 125f, false, new Date(), new Date()));
        locations.add(new Location("","", 79f, true, new Date(), new Date()));
        locations.add(new Location("","", 49f, false, new Date(), new Date()));

    }



    @Override
    public List<Location> getListLocation() {
        return locations;
    }

    @Override
    public List<Location> getListLocationEnCours() {

        List<Location> locationList = new ArrayList<>();

        for (Location location : locations) {
            if (location.isOnProgress()){
                locationList.add(location);
            }
        }

        return locationList;
    }

    @Override
    public Location getLocationById(String id) {
        return null;
    }

    @Override
    public List<Vehicule> getListVehicule() {
        return null;
    }

    @Override
    public Vehicule getVehiculeById(String id) {
        return null;
    }
}
