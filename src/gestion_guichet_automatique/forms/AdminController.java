/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_guichet_automatique.forms;

import gestion_guichet_automatique.Dao.Administrateur;
import gestion_guichet_automatique.connexion.Connexion;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Prechil_13
 */
public class AdminController implements Initializable {
    @FXML
    private AnchorPane anchor;
    
    @FXML
    private TextField pseudo;
    @FXML
    private PasswordField mdp;
    @FXML
    private TextField matri;
    @FXML
    private Button btn_admin;
    @FXML
    private Label labelError;

     Administrateur admin = new Administrateur();
      String type_of_db="";
      int var =0;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }    

    @FXML
    private void valider_admin(ActionEvent event) throws IOException {
        
        String username = pseudo.getText().trim();
        String password = mdp.getText().trim();
        String matricule = matri.getText().trim();
    
       var=admin.Administrateur_existe(pseudo.getText(), mdp.getText(),matri.getText());
         type_of_db=admin.getType_of(pseudo.getText(), mdp.getText());
        pseudo.equals(admin.getId(username));
        mdp.equals(admin.getId(password));
           
    try {
     admin.getAll();

         if(var>0) {
              Stage stage=(Stage) anchor.getScene().getWindow();
              stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("Admin_Gui.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Acceuil");
            //stage.setFullScreen(true);
            stage.show();

           
        } else {
             labelError.setText("Pseudo,matricule ou Mot de passe incorrect");
//            wrongInputFXML();
        }
    } catch (IOException e) {
    }
    
    pseudo.setText("");
    mdp.setText("");
    matri.setText("");
    
    }
    
    public String user(){
        String username = pseudo.getText().trim();
        return username;
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
