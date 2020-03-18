/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_guichet_automatique.Dao;

import gestion_guichet_automatique.connexion.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Prechil_13
 */
public class Administrateur {

    Statement state;

    public Administrateur() {
        Connexion con = new Connexion();

        try {
            this.state = con.getStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getAll() {
        String url = "select * from Administrateur";
        ResultSet resultat = null;
        try {
            resultat = state.executeQuery(url);
        } catch (SQLException ex) {
            Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (resultat.next()) {
               // System.out.println(resultat.getInt(1) + " " + resultat.getString(2) + " " + resultat.getString(3) + " ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int Administrateur_existe(String pseudo, String passe,String matricule) {
        String url = "select * from Administrateur where pseudo = '" + pseudo + "' "
                + "and passe='" + passe + "' and matricule = '"+matricule+"'";
        ResultSet resultat = null;
        int a = 0;
        try {
            resultat = state.executeQuery(url);
        } catch (SQLException ex) {
            Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (resultat.next()) {
                a++;

            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;

    }
    
    
      public Integer getIdBPlus(String pseudo,String passe)
    {
        String url="select * from Administrateur where pseudo='"+pseudo+"'  and passe ='"+passe+"'";
        ResultSet resultat=null;
        Integer a=0;
         try {
             resultat=state.executeQuery(url);
         } catch (SQLException ex) {
             Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(resultat.next())
             {
              a=Integer.parseInt(resultat.getString(1));
              
             }
         } catch (SQLException ex) {
             Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
         }
         return a;
        
    }  

    

    public String getType_of(String pseudo, String passe) {
        String url = "select * from Administrateur where pseudo='" + pseudo + "' and passe='" + passe + "'";
        ResultSet resultat = null;
        String a = null;
        try {
            resultat = state.executeQuery(url);
        } catch (SQLException ex) {
            Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (resultat.next()) {
                a = resultat.getString(3);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;

    }

    public String getNom_of(String pseudo, String passe) {
        String url = "select * from Administrateur where pseudo='" + pseudo + "' and passe='" + passe + "'";
        ResultSet resultat = null;
        String a = null;
        try {
            resultat = state.executeQuery(url);
        } catch (SQLException ex) {
            Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (resultat.next()) {
                a = resultat.getString(3);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;

    }

    public String getName(Integer id) {
        String url = "select * from Administrateur where id_Administrateur=" + id;
        ResultSet resultat = null;
        String a = null;
        try {
            resultat = state.executeQuery(url);
        } catch (SQLException ex) {
            Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (resultat.next()) {
                a = resultat.getString(2) + " " + resultat.getString(3);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;

    }

    public Integer getId(String nom) {
        String url = "select * from Administrateur where pseudo='" + nom + "'";
        ResultSet resultat = null;
        Integer a = 0;
        try {
            resultat = state.executeQuery(url);
        } catch (SQLException ex) {
            Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (resultat.next()) {
                a = Integer.parseInt(resultat.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;

    }

    public Integer getIdB(String nom, String passe) {
        String url = "select * from Administrateur where pseudo='" + nom + "'   and passe = '" + passe + "'";
        ResultSet resultat = null;
        Integer a = 0;
        try {
            resultat = state.executeQuery(url);
        } catch (SQLException ex) {
            Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (resultat.next()) {
                a = Integer.parseInt(resultat.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;

    }

    
   public String Type(String pseudo, String passe) {
        String url = "select pseudo, passe from Administrateur where passe='" + passe + "'";
        ResultSet resultat = null;
        String a = null;
        try {
            resultat = state.executeQuery(url);
        } catch (SQLException ex) {
            Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (resultat.next()) {
                a = resultat.getString(2);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;

    }
}

