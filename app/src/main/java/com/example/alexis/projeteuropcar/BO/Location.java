package com.example.alexis.projeteuropcar.BO;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;
import java.util.UUID;

/**
 * Created by alexis on 09/04/2018.
 */

@Entity
public class Location {

    @PrimaryKey
    private String id;
    private Agence agence;
    private Vehicule vehicule;
    private float tarifJournalier;
    private boolean onProgress;
    private Date dateDebut;
    private Date dateFin;

    public Location(){

    }

    public Location(String id, Agence agence, Vehicule vehicule, float tarifJournalier, boolean onProgress, Date dateDebut, Date dateFin) {
        this.id = UUID.randomUUID().toString();
        this.agence = agence;
        this.vehicule = vehicule;
        this.tarifJournalier = tarifJournalier;
        this.onProgress = onProgress;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Agence getAgence() {return agence;}
    public void setAgence(Agence agence) {this.agence = agence;}

    public Vehicule getVehicule() {return vehicule;}
    public void setVehicule(Vehicule vehicule) {this.vehicule = vehicule;}

    public float getTarifJournalier() {return tarifJournalier;}
    public void setTarifJournalier(float tarifJournalier) {this.tarifJournalier = tarifJournalier;}

    public boolean isOnProgress() {return onProgress;}
    public void setOnProgress(boolean onProgress) {this.onProgress = onProgress;}

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", agence=" + agence +
                ", vehicule=" + vehicule +
                ", tarifJournalier=" + tarifJournalier +
                ", onProgress=" + onProgress +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                '}';
    }
}
