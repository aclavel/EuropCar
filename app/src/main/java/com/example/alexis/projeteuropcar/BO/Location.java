package com.example.alexis.projeteuropcar.BO;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by alexis on 09/04/2018.
 */

@Entity
public class Location {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private Date dateDebut;
    private Date dateFin;
    private Double tarif;

    public Location(Date dateDebut, Date dateFin, Double tarif) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.tarif = tarif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Double getTarif() {
        return tarif;
    }

    public void setTarif(Double tarif) {
        this.tarif = tarif;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", tarif=" + tarif +
                '}';
    }
}
