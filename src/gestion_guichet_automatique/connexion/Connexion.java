/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_guichet_automatique.connexion;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Prechil_13
 */
public class Connexion {
        public static String server="localhost";
   public static String dbname="GAB"; 
   public static String user="root";
    public static String password="";
    public Connection con=null;
    
    public Connection getConnexion()
    {
                    try {
             Class.forName("com.mysql.jdbc.Driver");
             }
             catch (ClassNotFoundException e) {
             System.err.println("Driver loading error : " + e);
             }
       
        String url="jdbc:mysql://"+server+"/"+dbname;
        
        try {
            con=DriverManager.getConnection(url,user,password);
        } catch (SQLException ex) {
              System.err.println("Erreur de connexion à la base  de donnée"+ex);
        }
        return con;
    }    
    
   public  java.sql.Statement getStatement() throws SQLException
   {
       con=getConnexion();
       return con.createStatement();
   }
}
