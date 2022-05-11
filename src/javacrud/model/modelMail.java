/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.model;

import java.sql.Date;

/**
 *
 * @author r.bessede
 */
public class modelMail {

    private String expediteur, Destinataire, Objet, ContenuMail;
    private Date DateEnvoie, DateReception;

    public modelMail(String expediteur, String Destinataire, String Objet, String ContenuMail, Date DateEnvoie, Date DateReception) {
        this.expediteur = expediteur;
        this.Destinataire = Destinataire;
        this.Objet = Objet;
        this.ContenuMail = ContenuMail;
        this.DateEnvoie = DateEnvoie;
        this.DateReception = DateReception;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
    }

    public String getDestinataire() {
        return Destinataire;
    }

    public void setDestinataire(String Destinataire) {
        this.Destinataire = Destinataire;
    }

    public String getObjet() {
        return Objet;
    }

    public void setObjet(String Objet) {
        this.Objet = Objet;
    }

    public String getContenuMail() {
        return ContenuMail;
    }

    public void setContenuMail(String ContenuMail) {
        this.ContenuMail = ContenuMail;
    }

    public Date getDateEnvoie() {
        return DateEnvoie;
    }

    public void setDateEnvoie(Date DateEnvoie) {
        this.DateEnvoie = DateEnvoie;
    }

    public Date getDateReception() {
        return DateReception;
    }

    public void setDateReception(Date DateReception) {
        this.DateReception = DateReception;
    }
    
}
