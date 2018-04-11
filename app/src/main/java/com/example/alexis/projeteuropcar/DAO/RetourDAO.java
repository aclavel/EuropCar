package com.example.alexis.projeteuropcar.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import com.example.alexis.projeteuropcar.BO.Retour;

import java.util.List;

@Dao
public interface RetourDAO {
    @Insert
    void insert(Retour retour);

    @Insert
    void insertAll(Retour... retours);

    @Delete
    void delete(Retour retour);

    @Update
    int update(Retour retour);

    @Query("SELECT * FROM Retour WHERE id = (:id) LIMIT 1")
    Retour getById(String id);

    @Query("SELECT * FROM Retour")
    List<Retour> getAll();

}

