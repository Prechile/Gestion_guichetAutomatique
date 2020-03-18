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
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
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
public class Modifier_passeController implements Initializable {

    @FXML
    private TextField code_old;
    @FXML
    private TextField code_new;
    @FXML
    private Button btn;
    @FXML
    private Label error;
    @FXML
    private AnchorPane anchor;
    int val=0;
Client cli = new Client();
ObservableList<ModelTableClient> mod;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            mod=cli.getAllClient();
        } catch (SQLException ex) {
            Logger.getLogger(Modifier_passeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Modifier_passeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void changer(ActionEvent event) throws IOException {
                if(cli.Client_existe(code_old.getText())!=0){    
                     val = id_user();
         cli.updatePasse(val,code_new.getText());
        
         
                FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("AlertBoxSuccess.fxml"));
        Loader.load();
        AlertBoxSuccessController alertBoxSucces=Loader.getController();
        alertBoxSucces.setting(new Text("reussi"));
        Parent p=Loader.getRoot();
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(p));
        stage.showAndWait();
          
            }else{
                  FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("AlertBox3.fxml"));
        Loader.load();
        AlertBox3Controller alertBoxController=Loader.getController();
        alertBoxController.setting(new Text("Echoué, Réessayer"));
        Parent p=Loader.getRoot();
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(p));
        stage.showAndWait();
        
            }
         code_old.setText(" ");
         code_new.setText(" ");
         
    }
    
    
 
     @FXML
    private void fermer(MouseEvent event) {
          Stage stage=(Stage) anchor.getScene().getWindow();
                 stage.close();
    }
}
