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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Prechil_13
 */
public class AcceuilController implements Initializable {

    
    @FXML
    private AnchorPane anchor;
    
    @FXML
    private Button btn_admin;
    @FXML
    private Button btn_cli;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void admin(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Administrateur");
            stage.setResizable(true);
            stage.show();

            Stage admin = (Stage) anchor.getScene().getWindow();
            admin.close();
    }

    @FXML
    private void client(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Client");
             stage.setResizable(true);
            stage.show();

            Stage admin = (Stage) anchor.getScene().getWindow();
            admin.close();
    }
    
}
