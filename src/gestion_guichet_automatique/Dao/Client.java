/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_guichet_automatique.Dao;


import gestion_guichet_automatique.connexion.Connexion;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Prechil_13
 */
public class Client {
     Statement  state;

    public Client() {
        Connexion con=new Connexion();
    
       try {
           this.state = con.getStatement();
       } catch (SQLException ex) {
           Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
        public void insertClient(String nom, String prenom,String sexe,
                Date age,String passe, int num_compte)
    {

        String req="INSERT INTO Client(nom, prenom, sexe, age, passe, num_compte)"
                + " values('"+nom+"','"+prenom+"','"+sexe+"','"+age+"','"+passe+"',"+num_compte+")";
      
       try {
           state.executeUpdate(req);
       } catch (SQLException ex) {
           Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }
        
          public void getAll()
    {
        String url="select * from Client";
        ResultSet resultat=null;
         try {
             resultat=state.executeQuery(url);
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(resultat.next())
             {
              //System.out.println(resultat.getString(1)+" "+resultat.getString(2)+" "+resultat.getString(3)+" "+resultat.getString(4)+" "+resultat.getDate(5)+" "+resultat.getString(6)+" "+resultat.getInt(7)+" "+resultat.getFloat(8)) ;
             }
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
          
       public int Client_existe(String passe) {
            String url = "select * from Client where passe='"+passe+"'";
            ResultSet resultat = null;
            int a = 0;
            try {
                resultat = state.executeQuery(url);
            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while (resultat.next()) {
                    a++;

                }
            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            return a;

    }
       
//      public void faireRetrait(float solde, ModelTableClient client) throws MontantInsuffisantException {
//        String url = "select solde from client where num_compte = " + client.getCompte();
//        ResultSet resultat = null;
//        float montant = 0;
//        try {
//            resultat = state.executeQuery(url);
//        } catch (SQLException ex) {
//            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            while (resultat.next()) {
//                montant = resultat.getFloat(1);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        if (montant < solde) {
//            PreparedStatement req;
//            try {
//   req = Connexion.getConnexion().prepareStatement(""
//                        + "UPDATE client SET solde = ? WHERE id =? ");
//                req.setFloat(1,montant - client.getSolde());
//                req.setInt(2, client.getA())-+;
//                req.executeUpdate();
//                System.out.println("-------------------------------------------------");
//                System.out.println("Compte " + client.getA() + " modifier");
//            } catch (SQLException ex) {
//                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            throw new MontantInsuffisantException("Solde insuffisant");
//        }
//
//    }
       
         public ModelTableClient retrait(float solde ,int id)
             {
                 String url="update client set solde='"+solde+"' where id='"+id+"'";
                 ResultSet rs=null;
       ModelTableClient cli = null;
       try {
             state.executeUpdate(url);
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
        
         return cli;
                 
             }

           
           public Integer getId(String passe) {
        String url = "select * from Client where passe='"+passe+"'";
        ResultSet resultat = null;
        Integer a = 0;
        try {
            resultat = state.executeQuery(url);
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (resultat.next()) {
                a = Integer.parseInt(resultat.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;

    }
           
              public float solde(int id) {
        String url = "select solde from Client where id= "+id+"";
        ResultSet resultat = null;
        float a = 0;
        try {
            resultat = state.executeQuery(url);
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (resultat.next()) {
                a = Float.parseFloat(resultat.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;

    }
           
           
            public String getType_of(String passe) {
        String url = "select * from Client where passe='"+passe+"'";
        ResultSet resultat = null;
        String a = null;
        try {
            resultat = state.executeQuery(url);
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (resultat.next()) {
                a = resultat.getString(3);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;

    }
            
            
            
          
                public ObservableList getAllCategorie()
    {
        String url="select * from genre";
        ResultSet resultat=null;
        ObservableList<String> list=FXCollections.observableArrayList();
         try {
             resultat=state.executeQuery(url);
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(resultat.next())
             {
                System.out.println(resultat.getString(1)+" ") ;
                list.add(resultat.getString(1));
             }
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
         return list;
    }
          
             public ObservableList getAllClient() throws SQLException, FileNotFoundException
    {
        String url="select * from Client";
        ResultSet rs=null;
        ObservableList<ModelTableClient> list=FXCollections.observableArrayList();
        int a=1;
        SimpleDateFormat format =new SimpleDateFormat("dd-MM-yyyy");
         try {
             rs=state.executeQuery(url);
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(rs.next()){
                  list.add(new ModelTableClient(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(6),Integer.parseInt(rs.getString(7)),rs.getDate(5),Float.parseFloat(rs.getString(8)),a));
             a=a+1;
             }
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         
         }
         return list;
    }
          
          public ObservableList getAllClientsName() throws SQLException
    {
        String url="select * from client";
        ResultSet rs=null;
        ObservableList<String> list=FXCollections.observableArrayList();
         try {
             rs=state.executeQuery(url);
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(rs.next()){
             list.add(rs.getString(2) + " "+rs.getString(3));
             }
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
         return list;
    }
          
            public int client_id(String nom,String prenom)
    {
        String url="select * from Client where nom='"+nom+"' and prenom='"+prenom+"'";
        ResultSet resultat=null;
        int a=0;
         try {
             resultat=state.executeQuery(url);
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(resultat.next())
             {
            a=Integer.parseInt(resultat.getString(1));
              
             }
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
         return a;
        
    }  
          
          
           public ArrayList getAllClientsName2() throws SQLException
    {
        String url="select * from Client";
        ResultSet rs=null;
        ArrayList<String> list = new ArrayList();
         try {
             rs=state.executeQuery(url);
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(rs.next()){
             list.add(rs.getString(2) + " "+rs.getString(3));
             }
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
         return list;
    }
           
             public Integer getIdBPlus(String nom, String prenom,
                String sexe,Date age,String passe)
    {
        String url="select * from Client where nom='"+nom+"'  and prenom ='"+prenom+"' and sexe='"+sexe+"' and age ='"+age+"'"
                + "and passe ='"+passe+"'";
        ResultSet resultat=null;
        Integer a=0;
         try {
             resultat=state.executeQuery(url);
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(resultat.next())
             {
              a=Integer.parseInt(resultat.getString(1));
              
             }
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
         return a;
        
    }  
             
        public float consultation(int id, float solde)  {
  
        String url="select id, solde from Client where id="+id+"";
        ResultSet resultat=null;
        float a=0;
         try {
           
             resultat=state.executeQuery(url);
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(resultat.next())
             {
                 a++;
             }
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
        return 0;
    }

    public int getIdBMoins(String text) {
       String url="select * from Client where prenom='"+text+"'";
        ResultSet resultat=null;
        Integer a=0;
         try {
             resultat=state.executeQuery(url);
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             while(resultat.next())
             {
              a=Integer.parseInt(resultat.getString(1));
              
             }
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
         return a;
    }

      
    public void deleteClient(int id) {
     

         String req="DELETE FROM Client where id="+id+" ";
      
       try {
           state.executeUpdate(req);
       } catch (SQLException ex) {
           Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public void updateClient(int id, String nom, String prenom,String sexe,Date age,String passe,int num_compte) {
            String update="update client set nom='"+nom+"',prenom ='"+prenom+"',sexe ='"+sexe+"',age ='"+age+"', passe='"+passe+"', num_compte="+num_compte+" where id="+id+"";
        ResultSet resultat=null;
        int a=0;
         try {
             state.executeUpdate(update);
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }   
    }
    
     public void updatePasse(int id,String passe) {
            String update="update client set passe='"+passe+"' where id="+id+"";
        ResultSet resultat=null;
        int a=0;
         try {
             state.executeUpdate(update);
         } catch (SQLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }   
    }

 
    
}

