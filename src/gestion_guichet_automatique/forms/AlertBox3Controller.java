/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_guichet_automatique.forms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Prechil
 */
public class AlertBox3Controller implements Initializable {
@FXML
        private TextFlow textFlow;
          @FXML
        private Text text;
             @FXML
        private ImageView image;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
         public void ok(ActionEvent event){
        Stage stage=(Stage) textFlow.getScene().getWindow();
        stage.close();
    }
            public void setting(Text text2){
        text.setText(text2.getText());
    }
    
}
