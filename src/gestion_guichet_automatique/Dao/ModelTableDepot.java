/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_guichet_automatique.Dao;

/**
 *
 * @author Prechil_13
 */
public class ModelTableDepot {
    int identifiant;
    String nom, prenom;
    float compte;
    int a;

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

    public float getCompte() {
        return compte;
    }

    public void setCompte(float compte) {
        this.compte = compte;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public ModelTableDepot(int identifiant, String nom, String prenom, float compte, int a) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.compte = compte;
        this.a = a;
    }

   
    
    
}
