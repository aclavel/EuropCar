package com.example.alexis.projeteuropcar.Utils;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.alexis.projeteuropcar.BO.Agence;
import com.example.alexis.projeteuropcar.BO.Location;
import com.example.alexis.projeteuropcar.BO.Retour;
import com.example.alexis.projeteuropcar.BO.Vehicule;
import com.example.alexis.projeteuropcar.DAO.AgenceDAO;
import com.example.alexis.projeteuropcar.DAO.LocationDAO;
import com.example.alexis.projeteuropcar.DAO.RetourDAO;
import com.example.alexis.projeteuropcar.DAO.VehiculeDAO;

@Database(entities = {Location.class, Retour.class, Vehicule.class, Agence.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AgenceDAO agenceDAO();
    public abstract LocationDAO locationDAO();
    public abstract VehiculeDAO vehiculeDAO();
    public abstract RetourDAO retourDAO();
}
