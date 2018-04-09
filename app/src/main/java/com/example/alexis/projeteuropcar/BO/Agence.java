package com.example.alexis.projeteuropcar.BO;

import android.arch.persistence.room.Entity;

/**
 * Created by alexis on 09/04/2018.
 */
public class Agence {

    public String id;

    public String nom;

    public Agence(String nom) {
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
