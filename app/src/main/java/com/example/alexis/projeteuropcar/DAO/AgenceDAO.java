package com.example.alexis.projeteuropcar.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.alexis.projeteuropcar.BO.Agence;

import java.util.List;

@Dao
public interface AgenceDAO {
    @Insert
    String insert(Agence agence);

    @Insert
    String[] insertAll(Agence... agences);

    @Delete
    void delete(Agence agence);

    @Update
    int update(Agence agence);

    @Query("SELECT * FROM Agence WHERE id = (:id) LIMIT 1")
    Agence getById(String id);

    @Query("SELECT * FROM Agence")
    List<Agence> getAll();
}
