package com.example.alexis.projeteuropcar.BO;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.UUID;

@Entity
public class Agence {

    @PrimaryKey
    private String id;

    private String raisonSocial;
    private String siret;
    private String voie;
    private String codePostal;
    private String ville;
    private String synchro;

    public Agence() {

    }

    @Ignore
    public Agence(String raisonSocial, String siret, String voie, String codePostal, String ville, String synchro) {
        this.id = UUID.randomUUID().toString();
        this.raisonSocial = raisonSocial;
        this.siret = siret;
        this.voie = voie;
        this.codePostal = codePostal;
        this.ville = ville;
        this.synchro = synchro;
    }

    @Ignore
    public Agence(String raisonSocial, String siret, String voie, String codePostal, String ville) {
        this.raisonSocial = raisonSocial;
        this.siret = siret;
        this.voie = voie;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getRaisonSocial() {return raisonSocial;}
    public void setRaisonSocial(String raisonSocial) {this.raisonSocial = raisonSocial;}

    public String getSiret() {return siret;}
    public void setSiret(String siret) {this.siret = siret;}

    public String getVoie() {return voie;}
    public void setVoie(String voie) {this.voie = voie;}

    public String getCodePostal() {return codePostal;}
    public void setCodePostal(String codePostal) {this.codePostal = codePostal;}

    public String getVille() {return ville;}
    public void setVille(String ville) {this.ville = ville;}

    public String getSynchro() {return synchro;}
    public void setSynchro(String synchro) {this.synchro = synchro;}

    @Override
    public String toString() {
        return "Agence{" +
                "id='" + id + '\'' +
                ", raisonSocial='" + raisonSocial + '\'' +
                ", siret='" + siret + '\'' +
                ", voie='" + voie + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                ", synchro='" + synchro + '\'' +
                '}';
    }
}
