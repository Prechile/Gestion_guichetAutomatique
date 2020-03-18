/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_guichet_automatique.forms;

import gestion_guichet_automatique.Dao.Compte;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Prechil_13
 */
public class CompteController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private TextField admin_respo;
    @FXML
    private ComboBox<String> choisir_cli;
    @FXML
    private TextField compte_num;
    @FXML
    private Button btn_compte;
    
    int id=0;
AdminController ad = new AdminController();
Compte cpte = new Compte();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //String user = ad.user();
        //admin_respo.setText(user);
        
      choisir_cli.getItems().addAll(cpte.getAllClient());
         choisir_cli.getValue();
    }    
     
      

    @FXML
    private void creer_compte(ActionEvent event) {
        
    }

    @FXML
    private void annuler(MouseEvent event) {
    }
    
}
