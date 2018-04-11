package com.example.alexis.projeteuropcar.BO;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Location.class,
                parentColumns = "id",
                childColumns = "idLocation",
                onDelete = CASCADE
        ), tableName = "Retour")
public class Retour {

    @PrimaryKey
    @NonNull
    private String id;
    @ColumnInfo(name = "idLocation")
    private String idLocation;
    private boolean isEndommage;
    private boolean isPleinEffectue;
    private String nbKmEffectues;
    private String photo;

    public Retour() {
        UUID.randomUUID().toString();
    }

    @Ignore
    public Retour(String idLocation, boolean isEndommage, boolean isPleinEffectue, String nbKmEffectues, String photo) {
        this.id = UUID.randomUUID().toString();
        this.idLocation = idLocation;
        this.isEndommage = isEndommage;
        this.isPleinEffectue = isPleinEffectue;
        this.nbKmEffectues = nbKmEffectues;
        this.photo = photo;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getIdLocation() {return idLocation;}
    public void setIdLocation(String idLocation) {this.idLocation = idLocation;}

    public boolean isEndommage() {return isEndommage;}
    public void setEndommage(boolean endommage) {isEndommage = endommage;}

    public boolean isPleinEffectue() {return isPleinEffectue;}
    public void setPleinEffectue(boolean pleinEffectue) {isPleinEffectue = pleinEffectue;}

    public String getNbKmEffectues() {return nbKmEffectues;}
    public void setNbKmEffectues(String nbKmEffectues) {this.nbKmEffectues = nbKmEffectues;}

    public String getPhoto() {return photo;}
    public void setPhoto(String photo) {this.photo = photo;}

    @Override
    public String toString() {
        return "Retour{" +
                "id='" + id + '\'' +
                ", idLocation='" + idLocation + '\'' +
                ", isEndommage=" + isEndommage +
                ", isPleinEffectue=" + isPleinEffectue +
                ", nbKmEffectues='" + nbKmEffectues + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
