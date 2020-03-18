/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_guichet_automatique.forms;

import gestion_guichet_automatique.Dao.Client;
import gestion_guichet_automatique.Dao.ModelTableClient;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Prechil_13
 */
public class ClientController implements Initializable {

  
        @FXML
    private AnchorPane anchor;
    @FXML
    private Label Error;
    @FXML
    private PasswordField code;
    @FXML
    private Button btn_client;
    ModelTableClient client = new ModelTableClient(); 
   static Client cli= new Client();
    String type_of_db="";
    int var =0;
    
      public static String mdp; 
        
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void valider_client(ActionEvent event) throws IOException {
        
        String password = code.getText().trim();
        mdp= code.getText();
       var=cli.Client_existe(code.getText());
        int ref=var;
      System.out.print(ref);
       type_of_db=cli.getType_of(code.getText());
        code.equals(cli.getId(password));
        
        
         try {
                //cli.getAll();

         if(var>0) {
              Stage stage=(Stage) anchor.getScene().getWindow();
              stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("Client_gui.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Acceuil");
            stage.setResizable(false);
            stage.show();

           
        } else {
             Error.setText("code secret incorrect,Réessayer!!!");

        }
    } catch (IOException e) {
    }
         code.setText("");
 
       }
  
   public static int id_user(){
      return cli.getId(mdp);
            
   }
  
      @FXML
    private void retour(ActionEvent event) throws IOException {
        Stage stage=(Stage) anchor.getScene().getWindow();
                 stage.close();
          Parent root = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
            Stage pro = new Stage();
            pro.setScene(new Scene(root));
            pro.setTitle("Acceuil");
            pro.show();
    }
    
}
