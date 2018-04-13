package com.example.alexis.projeteuropcar.BO;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;

@Entity
public class Vehicule {

    @PrimaryKey
    @NonNull
    private String id;

    private String libelle;
    private int nbPlaces;
    private int locationMinimum;
    private int locationMaximum;
    private float tarifMinimum;
    private float tarifMaximum;
    private float tarifMoyen;
    private boolean isDispo;

    public Vehicule() {

    }

    @Ignore
    public Vehicule(int id, String libelle, int nbPlaces, int locationMinimum, int locationMaximum, float tarifMinimum, float tarifMaximum) {
        this.id = UUID.randomUUID().toString();
        this.libelle = libelle;
        this.nbPlaces = nbPlaces;
        this.locationMinimum = locationMinimum;
        this.locationMaximum = locationMaximum;
        this.tarifMinimum = tarifMinimum;
        this.tarifMaximum = tarifMaximum;
    }

    public Vehicule(@NonNull String id, int nbPlaces, int locationMinimum, int locationMaximum, float tarifMinimum, float tarifMaximum, float tarifMoyen, boolean isDispo) {
        this.id = UUID.randomUUID().toString();
        this.nbPlaces = nbPlaces;
        this.locationMinimum = locationMinimum;
        this.locationMaximum = locationMaximum;
        this.tarifMinimum = tarifMinimum;
        this.tarifMaximum = tarifMaximum;
        this.tarifMoyen = tarifMoyen;
        this.isDispo = isDispo;
    }


    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getLibelle() {return libelle;}
    public void setLibelle(String libelle) {this.libelle = libelle;}

    public int getNbPlaces() {return nbPlaces;}
    public void setNbPlaces(int nbPlaces) {this.nbPlaces = nbPlaces;}

    public int getLocationMinimum() {return locationMinimum;}
    public void setLocationMinimum(int locationMinimum) {this.locationMinimum = locationMinimum;}

    public int getLocationMaximum() {return locationMaximum;}
    public void setLocationMaximum(int locationMaximum) {this.locationMaximum = locationMaximum;}

    public float getTarifMinimum() {return tarifMinimum;}
    public void setTarifMinimum(float tarifMinimum) {this.tarifMinimum = tarifMinimum;}

    public float getTarifMaximum() {return tarifMaximum;}
    public void setTarifMaximum(float tarifMaximum) {this.tarifMaximum = tarifMaximum;}

    public float getTarifMoyen() {return tarifMoyen;}
    public void setTarifMoyen(float tarifMoyen) {this.tarifMoyen = tarifMoyen;}

    public boolean isDispo() {return isDispo;}
    public void setDispo(boolean dispo) {isDispo = dispo;}

    @Override
    public String toString() {
        return "Vehicule{" +
                "id='" + id + '\'' +
                ", libelle='" + libelle + '\'' +
                ", nbPlaces=" + nbPlaces +
                ", locationMinimum=" + locationMinimum +
                ", locationMaximum=" + locationMaximum +
                ", tarifMinimum=" + tarifMinimum +
                ", tarifMaximum=" + tarifMaximum +
                ", tarifMoyen=" + tarifMoyen +
                ", isDispo=" + isDispo +
                '}';
    }
}
