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
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Prechil_13
 */
public class AlertQuitController implements Initializable {

    @FXML
    private TextFlow textflow;
    @FXML
    private Text text;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void non(ActionEvent event) {
          Stage stage=(Stage) textflow.getScene().getWindow();
        stage.close();
        
    }

    @FXML
    private void oui(ActionEvent event) throws IOException {
         System.exit(1);
        
    }

}
