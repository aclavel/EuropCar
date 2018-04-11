package com.example.alexis.projeteuropcar.BO;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.example.alexis.projeteuropcar.Utils.ConvertersDate;

import java.util.Date;
import java.util.UUID;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys =
        @ForeignKey(entity = Vehicule.class,
                parentColumns = "id",
                childColumns = "idVehicule",
                onDelete = CASCADE
        )
, tableName = "Location")
public class Location {

    @PrimaryKey(autoGenerate = false)
    @NonNull
    private String id;
    private String idAgence;
    private String idVehicule;
    private float tarifJournalier;
    private boolean onProgress;
    @TypeConverters(ConvertersDate.class)
    private Date dateDebut;
    @TypeConverters(ConvertersDate.class)
    private Date dateFin;

    public Location() {
        this.id = UUID.randomUUID().toString();
    }

    @Ignore
    public Location(String idAgence, String idVehicule, float tarifJournalier, boolean onProgress, Date dateDebut, Date dateFin) {
        this.id = UUID.randomUUID().toString();
        this.idAgence = idAgence;
        this.idVehicule = idVehicule;
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
    public String getIdAgence() {return idAgence;}
    public void setIdAgence(String idAgence) {this.idAgence = idAgence;}
    public String getIdVehicule() {return idVehicule;}
    public void setIdVehicule(String idVehicule) {this.idVehicule = idVehicule;}
    public float getTarifJournalier() {return tarifJournalier;}
    public void setTarifJournalier(float tarifJournalier) {this.tarifJournalier = tarifJournalier;}
    public boolean isOnProgress() {return onProgress;}
    public void setOnProgress(boolean onProgress) {this.onProgress = onProgress;}

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", idAgence='" + idAgence + '\'' +
                ", idVehicule='" + idVehicule + '\'' +
                ", tarifJournalier=" + tarifJournalier +
                ", onProgress=" + onProgress +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                '}';
    }
}
