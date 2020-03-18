/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_guichet_automatique.forms;

import gestion_guichet_automatique.Dao.Client;
import gestion_guichet_automatique.Dao.ModelTableClient;
import static gestion_guichet_automatique.forms.ClientController.id_user;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Prechil_13
 */
public class ConsultationController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private Text solde_text;
    
   static Client cli = new Client();
    ModelTableClient client = new ModelTableClient();
ObservableList<ModelTableClient> oblist,oblist1;    
int val=0;

/**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO

            oblist=cli.getAllClient();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConsultationController.class.getName()).log(Level.SEVERE, null, ex);
        }
         val = id_user();
        solde_text.setDisable(true);
        solde_text.setText(""+ClientController.cli.solde(val)); 
        
         
         
    }    

    @FXML
    private void ok(ActionEvent event) {
         Stage stage=(Stage) anchor.getScene().getWindow();
                 stage.close();
    }
    
    
}
