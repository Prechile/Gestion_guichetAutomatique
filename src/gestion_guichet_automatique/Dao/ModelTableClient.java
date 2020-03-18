/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_guichet_automatique.Dao;


import java.sql.Date;

/**
 *
 * @author Prechil_13
 */
public class ModelTableClient {
    int identifiant;
    String nom,prenom,sexe,passe;
    int compte;
    Date date;
    int a;
    float solde;

    public ModelTableClient() {
    }

   
    public ModelTableClient(int identifiant, String nom, String prenom, String sexe, String passe, int compte, Date date, float solde, int a) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.passe = passe;
        this.compte = compte;
        this.date = date;
        this.solde= solde;
        this.a = a;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPasse() {
        return passe;
    }

    public void setPasse(String passe) {
        this.passe = passe;
    }


    public int getCompte() {
        return compte;
    }

    public void setCompte(int compte) {
        this.compte = compte;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    
}
