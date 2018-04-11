package com.example.alexis.projeteuropcar.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.alexis.projeteuropcar.BO.Location;

import java.util.List;

@Dao
public interface LocationDAO {
    @Insert
    void insert(Location location);

    @Insert
    void insertAll(Location... locations);

    @Delete
    void delete(Location location);

    @Update
    int update(Location location);

    @Query("SELECT * FROM Location WHERE id = (:id) LIMIT 1")
    Location getById(String id);

    @Query("SELECT * FROM Location")
    List<Location> getAll();
}
