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
public class Depot {
      Statement  state;

    public Depot() {
        Connexion con=new Connexion();
    
       try {
           this.state = con.getStatement();
       } catch (SQLException ex) {
           Logger.getLogger(Depot.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
      public void insertDepot(int id,float solde)
    {

        String update="update client set solde='"+solde+"' where id="+id+"";
        ResultSet resultat=null;
        int a=0;
         try {
             state.executeUpdate(update);
         } catch (SQLException ex) {
             Logger.getLogger(Depot.class.getName()).log(Level.SEVERE, null, ex);
       
    }
    }
        
          public void getAll()
    {
        String url="select * from Client";
        ResultSet resultat=null;
         try {
             resultat=state.executeQuery(url);
         } catch (SQLException ex) {
             Logger.getLogger(Depot.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(resultat.next())
             {
                System.out.println(resultat.getString(1)+" "+resultat.getString(2)+" "+resultat.getString(3)+" "+resultat.getString(4)+" "+resultat.getString(5)+" "+resultat.getString(6)+" "+resultat.getString(7)+" "+resultat.getString(8)+" ") ;
             }
         } catch (SQLException ex) {
             Logger.getLogger(Depot.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
          
                 public ObservableList getAllDepot() throws SQLException
    {
        String url="select * from Client";
        ResultSet rs=null;
        ObservableList<ModelTableDepot> list=FXCollections.observableArrayList();
        int a=1;
         try {
             rs=state.executeQuery(url);
         } catch (SQLException ex) {
             Logger.getLogger(Depot.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(rs.next()){
                  list.add(new ModelTableDepot(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),Float.parseFloat(rs.getString(7)),a));
             a=a+1;
             }
         } catch (SQLException ex) {
             Logger.getLogger(Depot.class.getName()).log(Level.SEVERE, null, ex);
         
         }
         return list;
    }
                 
                     public ObservableList getAllDepotsName() throws SQLException
    {
        String url="select * from Client";
        ResultSet rs=null;
        ObservableList<String> list=FXCollections.observableArrayList();
         try {
             rs=state.executeQuery(url);
         } catch (SQLException ex) {
             Logger.getLogger(Depot.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(rs.next()){
             list.add(rs.getString(2) + " "+rs.getString(3));
             }
         } catch (SQLException ex) {
             Logger.getLogger(Depot.class.getName()).log(Level.SEVERE, null, ex);
         }
         return list;
    }
          
            public int Depot_id(String nom,String prenom)
    {
        String url="select * from Client where nom='"+nom+"' and prenom='"+prenom+"'";
        ResultSet resultat=null;
        int a=0;
         try {
             resultat=state.executeQuery(url);
         } catch (SQLException ex) {
             Logger.getLogger(Depot.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(resultat.next())
             {
            a=Integer.parseInt(resultat.getString(1));
              
             }
         } catch (SQLException ex) {
             Logger.getLogger(Depot.class.getName()).log(Level.SEVERE, null, ex);
         }
         return a;
        
    }  
          
          
           public ArrayList getAllDepotsName2() throws SQLException
    {
        String url="select * from Client";
        ResultSet rs=null;
        ArrayList<String> list = new ArrayList();
         try {
             rs=state.executeQuery(url);
         } catch (SQLException ex) {
             Logger.getLogger(Depot.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(rs.next()){
             list.add(rs.getString(2) + " "+rs.getString(3));
             }
         } catch (SQLException ex) {
             Logger.getLogger(Depot.class.getName()).log(Level.SEVERE, null, ex);
         }
         return list;
    }
           
             public Integer getIdBPlus(String nom, String prenom,
                String sexe,Date age,String passe)
    {
        String url="select * from Client where nom='"+nom+"'  and prenom ='"+prenom+"' "
                + "and passe ='"+passe+"'";
        ResultSet resultat=null;
        Integer a=0;
         try {
             resultat=state.executeQuery(url);
         } catch (SQLException ex) {
             Logger.getLogger(Depot.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(resultat.next())
             {
              a=Integer.parseInt(resultat.getString(1));
              
             }
         } catch (SQLException ex) {
             Logger.getLogger(Depot.class.getName()).log(Level.SEVERE, null, ex);
         }
         return a;
        
    }  

    public int getIdBMoins(String text) {
       String url="select * from Client where prenom='"+text+"'";
        ResultSet resultat=null;
        Integer a=0;
         try {
             resultat=state.executeQuery(url);
         } catch (SQLException ex) {
             Logger.getLogger(Depot.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(resultat.next())
             {
              a=Integer.parseInt(resultat.getString(1));
              
             }
         } catch (SQLException ex) {
             Logger.getLogger(Depot.class.getName()).log(Level.SEVERE, null, ex);
         }
         return a;
    }

}
