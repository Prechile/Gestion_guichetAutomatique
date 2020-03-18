/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_guichet_automatique.Dao;

import gestion_guichet_automatique.connexion.Connexion;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Prechil_13
 */
public class Compte {
    
       Statement  state;

    public Compte() {
        Connexion con=new Connexion();
    
       try {
           this.state = con.getStatement();
       } catch (SQLException ex) {
           Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
               public ObservableList getAllClient( )
    {
        String url="select * from Client";
        ResultSet resultat=null;
        ObservableList<String> list=FXCollections.observableArrayList();
         try {
             resultat=state.executeQuery(url);
         } catch (SQLException ex) {
             Logger.getLogger(Compte.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(resultat.next())
             {
                System.out.println(resultat.getString(2)+" "+resultat.getString(3)) ;
                list.add(resultat.getString(2)+" "+resultat.getString(3));
             }
         } catch (SQLException ex) {
             Logger.getLogger(Compte.class.getName()).log(Level.SEVERE, null, ex);
         }
         return list;
    }
               
                public void updateClient(int id,int num_compte) {
            String update="update client set num_compte="+num_compte+" where id="+id+"";
        ResultSet resultat=null;
        int a=0;
         try {
             state.executeUpdate(update);
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }   
    }
}
