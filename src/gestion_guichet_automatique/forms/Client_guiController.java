/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_guichet_automatique.forms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Prechil_13
 */
public class Client_guiController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private Label user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void retrait(ActionEvent event) throws IOException {
          FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("Retrait.fxml"));
        Loader.load();
        Parent p=Loader.getRoot();
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(p));
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    private void modifier_code(ActionEvent event) throws IOException {
         FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("Modifier_passe.fxml"));
        Loader.load();
        Parent p=Loader.getRoot();
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(p));
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    private void quitter(ActionEvent event) throws IOException {
           FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("AlertQuit.fxml"));
        Loader.load();
        Parent p=Loader.getRoot();
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(p));
        stage.showAndWait();
    }

    @FXML
    private void consultation(ActionEvent event) throws IOException {
              FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("Consultation.fxml"));
        Loader.load();
        Parent p=Loader.getRoot();
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(p));
        stage.showAndWait();
    }
    
}
