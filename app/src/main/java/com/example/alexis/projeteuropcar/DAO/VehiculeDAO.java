package com.example.alexis.projeteuropcar.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.alexis.projeteuropcar.BO.Vehicule;

import java.util.List;

@Dao
public interface VehiculeDAO {
    @Insert
    void insert(Vehicule vehicule);

    @Insert
    void insertAll(Vehicule... vehicules);

    @Delete
    void delete(Vehicule vehicule);

    @Update
    int update(Vehicule vehicule);

    @Query("SELECT * FROM Vehicule WHERE id = (:id) LIMIT 1")
    Vehicule getById(String id);

    @Query("SELECT * FROM Vehicule")
    List<Vehicule> getAll();
}
