package com.example.alexis.projeteuropcar.BO;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.UUID;

@Entity
public class Retour {

    @PrimaryKey
    private String id;
    private Location location;
    private boolean isEndommage;
    private boolean isPleinEffectue;
    private String nbKmEffectues;
    private String photo;

    public Retour() {
        UUID.randomUUID().toString();
    }

    @Ignore
    public Retour(Location location, boolean isEndommage, boolean isPleinEffectue, String nbKmEffectues, String photo) {
        this.id = UUID.randomUUID().toString();
        this.location = location;
        this.isEndommage = isEndommage;
        this.isPleinEffectue = isPleinEffectue;
        this.nbKmEffectues = nbKmEffectues;
        this.photo = photo;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public Location getLocation() {return location;}
    public void setLocation(Location location) {this.location = location;}

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
                ", location=" + location +
                ", isEndommage=" + isEndommage +
                ", isPleinEffectue=" + isPleinEffectue +
                ", nbKmEffectues='" + nbKmEffectues + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
