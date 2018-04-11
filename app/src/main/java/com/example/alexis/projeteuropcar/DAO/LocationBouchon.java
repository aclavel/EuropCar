package com.example.alexis.projeteuropcar.DAO;

import com.example.alexis.projeteuropcar.BO.Agence;
import com.example.alexis.projeteuropcar.BO.Location;
import com.example.alexis.projeteuropcar.BO.Vehicule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LocationBouchon implements ILocationDAO {

    private List<Location> locations;
    private List<Vehicule> vehicules;

    public LocationBouchon() {

        locations = new ArrayList<>();
        locations.add(new Location("","", 45f, true, new Date(), new Date()));
        locations.add(new Location("","", 80f, true, new Date(), new Date()));
        locations.add(new Location("","", 125f, false, new Date(), new Date()));
        locations.add(new Location("","", 79f, true, new Date(), new Date()));
        locations.add(new Location("","", 49f, false, new Date(), new Date()));

        vehicules = new ArrayList<>();
        vehicules.add(new Vehicule(1,"Peugeot 208 Rubis", 5,2,15, 200f, 300f));
        vehicules.add(new Vehicule(2,"Volkswagen Citreon", 5,8,35, 75f, 100f));
        vehicules.add(new Vehicule(3,"Citröen C3", 5,15,50, 15f, 35f));
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
        return vehicules;
    }

    @Override
    public Vehicule getVehiculeById(String id) {
        return null;
    }
}
