package com.example.alexis.projeteuropcar.BO;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Vehicule {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String libelle;
    private int nbPlaces;
    private int locationMinimum;
    private int locationMaximum;
    private Double tarifMinimum;
    private Double tarifMaximum;

    public Vehicule() {

    }

    @Ignore
    public Vehicule(int id, String libelle, int nbPlaces, int locationMinimum, int locationMaximum, Double tarifMinimum, Double tarifMaximum) {
        this.id = id;
        this.libelle = libelle;
        this.nbPlaces = nbPlaces;
        this.locationMinimum = locationMinimum;
        this.locationMaximum = locationMaximum;
        this.tarifMinimum = tarifMinimum;
        this.tarifMaximum = tarifMaximum;
    }

    @Ignore
    public Vehicule(String libelle, int nbPlaces, int locationMinimum, int locationMaximum, Double tarifMinimum, Double tarifMaximum) {
        this.libelle = libelle;
        this.nbPlaces = nbPlaces;
        this.locationMinimum = locationMinimum;
        this.locationMaximum = locationMaximum;
        this.tarifMinimum = tarifMinimum;
        this.tarifMaximum = tarifMaximum;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", nbPlaces=" + nbPlaces +
                ", locationMinimum='" + locationMinimum + '\'' +
                ", locationMaximum='" + locationMaximum + '\'' +
                ", tarifMinimum='" + tarifMinimum + '\'' +
                ", tarifMaximum='" + tarifMaximum + '\'' +
                '}';
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getLibelle() {return libelle;}
    public void setLibelle(String libelle) {this.libelle = libelle;}

    public int getNbPlaces() {return nbPlaces;}
    public void setNbPlaces(int nbPlaces) {this.nbPlaces = nbPlaces;}

    public int getLocationMinimum() {return locationMinimum;}
    public void setLocationMinimum(int locationMinimum) {this.locationMinimum = locationMinimum;}

    public int getLocationMaximum() {return locationMaximum;}
    public void setLocationMaximum(int locationMaximum) {this.locationMaximum = locationMaximum;}

    public Double getTarifMinimum() {return tarifMinimum;}
    public void setTarifMinimum(Double tarifMinimum) {this.tarifMinimum = tarifMinimum;}

    public Double getTarifMaximum() {return tarifMaximum;}
    public void setTarifMaximum(Double tarifMaximum) {this.tarifMaximum = tarifMaximum;}
}
