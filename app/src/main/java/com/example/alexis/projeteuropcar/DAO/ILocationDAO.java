package com.example.alexis.projeteuropcar.DAO;

import com.example.alexis.projeteuropcar.BO.Location;
import com.example.alexis.projeteuropcar.BO.Vehicule;

import java.util.List;

public interface ILocationDAO {

    // LOCATION
    List<Location> getListLocation();
    List<Location> getListLocationEnCours();
    Location getLocationById(String id);

    // VOITURE
    List<Vehicule> getListVehicule();
    Vehicule getVehiculeById(String id);

}
