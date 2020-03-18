/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_guichet_automatique.forms;

import gestion_guichet_automatique.Dao.Client;
import gestion_guichet_automatique.Dao.ModelTableClient;
import static gestion_guichet_automatique.forms.ClientController.id_user;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Prechil_13
 */
public class RetraitController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private TextField montant;
    @FXML
    private Button btn_retrait;
    @FXML
    private Label error;
   
    Client cli = new Client();
 ModelTableClient client = new ModelTableClient();
ClientController co = new ClientController(); 
int val =0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       
    }    
       @FXML
    public void retrait(ActionEvent event) throws IOException{
   
        //code here 
         
         float somme = Float.parseFloat(montant.getText());
        client = ClientController.cli.retrait(somme, val);
        float sold = client.getSolde();
        int id=client.getIdentifiant();
        float somsolde=0;
        if(somme<sold)
        {
            somsolde=sold-somme;
            
            cli.retrait(somsolde,id);
        }
        
          
    }
    
     @FXML
    private void fermer(MouseEvent event) {
          Stage stage=(Stage) anchor.getScene().getWindow(); 
                 stage.close();
    }
    
}
