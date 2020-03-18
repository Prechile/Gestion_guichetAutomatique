/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_guichet_automatique.forms;

import gestion_guichet_automatique.Dao.Client;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
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
public class New_clientController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private TextField nomText;
    @FXML
    private TextField prenomText;
    @FXML
    private ComboBox<String> sexeText;
    @FXML
    private DatePicker dateText;
    @FXML
    private TextField codeText;
    @FXML
    private Button btn_sauv;
    @FXML
    private Button btn_cancel;
    @FXML
    private TextField compteText;
    
    Client client = new Client();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         btn_sauv.disableProperty().bind(
                  nomText.textProperty().isEmpty()
                 .or(prenomText.textProperty().isEmpty())
                 .or(codeText.textProperty().isEmpty())
                 .or(compteText.textProperty().isEmpty())
           );
         sexeText.getItems().addAll(client.getAllCategorie());
         sexeText.getValue();
    }    

    @FXML
    private void sauver(ActionEvent event) throws IOException {
        
                         if(client.getIdBPlus(nomText.getText(), prenomText.getText(), sexeText.getValue(), Date.valueOf(dateText.getValue()), codeText.getText())>0){
                             
                      FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("AlertBox3.fxml"));
        Loader.load();
        AlertBox3Controller alertBoxController=Loader.getController();
        alertBoxController.setting(new Text("Client déjà existant!"));
        Parent p=Loader.getRoot();
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(p));
        stage.showAndWait();
                         }else{
                               if(client.getIdBMoins(prenomText.getText())>0){
                                     FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("AlertBox3.fxml"));
        Loader.load();
        AlertBox3Controller alertBoxController=Loader.getController();
        alertBoxController.setting(new Text("Ce prenom existe déja!"));
        Parent p=Loader.getRoot();
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(p));
        stage.showAndWait();
                               }else{
                                        try{
                             String[] tb;
                             String g="";
                             tb=prenomText.getText().split(" ");
                      
                             for(int i=0;i<tb.length;i++){
                                 g=g+tb[i];
                             }
client.insertClient(nomText.getText(), prenomText.getText(), sexeText.getValue().toString(), Date.valueOf(dateText.getValue()), codeText.getText(),Integer.parseInt(compteText.getText()));
                                 FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("AlertBoxSuccess.fxml"));
        Loader.load();
       AlertBoxSuccessController alertBoxController=Loader.getController();
        alertBoxController.setting(new Text("Nouveau client ajouté!"));
        Parent p=Loader.getRoot();
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(p));
        stage.showAndWait();
                             
                         }catch(NumberFormatException nb){
                            FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("AlertBox3.fxml"));
        Loader.load();
        AlertBox3Controller alertBoxController=Loader.getController();
        alertBoxController.setting(new Text("Numéro invalide !"));
        Parent p=Loader.getRoot();
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(p));
        stage.showAndWait();
                         }
                               }
                    
                   
                         }
       nomText.setText(" ");
       prenomText.setText(" ");
       codeText.setText(" ");
       compteText.setText(" ");
    }

    @FXML
    private void cancel(ActionEvent event) {
          Stage stage=(Stage) anchor.getScene().getWindow();
        stage.close();
    }
    
}
