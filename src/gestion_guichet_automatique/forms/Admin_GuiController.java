/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_guichet_automatique.forms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Prechil_13
 */
public class Admin_GuiController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b31;
    @FXML
    private Button b4;
    @FXML
    private TabPane TabPane;
    @FXML
    private Tab tab1;
    
AdminController ad = new AdminController();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tab1.setText("Accueil");
        tab1.setClosable(false);
        tab1.setId("accueil");
        TabPane.setTabMinWidth(100);
        
       //ad.user();
       
    }    

    @FXML
    private void gerer_client(ActionEvent event) {
           Tab tab2=new Tab();
          tab2.setText("Gerer les clients");
        tab2.setClosable(true);
        tab2.setId("tab2");
                try {
                    tab2.setContent(FXMLLoader.load(getClass().getResource("Gestion_client.fxml")));
                } catch (IOException ex) {
                    Logger.getLogger(Admin_GuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
         
                      
          boolean tr=false;
                  int index = 0;
          for(int i=0;i<TabPane.getTabs().size();i++){
              if(TabPane.getTabs().get(i).getId().equals(tab2.getId())){
                  tr=true;
                  index=i;
              }
          }
          if(tr){
                TabPane.getSelectionModel().select(index);
                System.out.println("True");
          }else{
              TabPane.getTabs().add(tab2);
           TabPane.getSelectionModel().select(tab2);
        
          }
    }

    @FXML
    private void creer_compte(ActionEvent event) {
        
           Tab tab3=new Tab();
          tab3.setText("Créer compte");
        tab3.setClosable(true);
        tab3.setId("tab3");
                try {
                    tab3.setContent(FXMLLoader.load(getClass().getResource("Compte.fxml")));
                } catch (IOException ex) {
                    Logger.getLogger(Admin_GuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
         
                      
          boolean tr=false;
                  int index = 0;
          for(int i=0;i<TabPane.getTabs().size();i++){
              if(TabPane.getTabs().get(i).getId().equals(tab3.getId())){
                  tr=true;
                  index=i;
              }
          }
          if(tr){
                TabPane.getSelectionModel().select(index);
                System.out.println("True");
          }else{
              TabPane.getTabs().add(tab3);
           TabPane.getSelectionModel().select(tab3);
        
          }
     
    }

    @FXML
    private void depot(ActionEvent event) {
           Tab tab4=new Tab();
          tab4.setText("Dépôt");
        tab4.setClosable(true);
        tab4.setId("tab4");
                try {
                    tab4.setContent(FXMLLoader.load(getClass().getResource("Depot.fxml")));
                } catch (IOException ex) {
                    Logger.getLogger(Admin_GuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
         
                      
          boolean tr=false;
                  int index = 0;
          for(int i=0;i<TabPane.getTabs().size();i++){
              if(TabPane.getTabs().get(i).getId().equals(tab4.getId())){
                  tr=true;
                  index=i;
              }
          }
          if(tr){
                TabPane.getSelectionModel().select(index);
                System.out.println("True");
          }else{
              TabPane.getTabs().add(tab4);
           TabPane.getSelectionModel().select(tab4);
        
          }
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
    private void deconnecter(ActionEvent event) throws IOException {
        
          Stage stage=(Stage) anchor.getScene().getWindow();
                 stage.close();
          Parent root = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
            Stage pro = new Stage();
            pro.setScene(new Scene(root));
            pro.setTitle("Acceuil");
            //pro.setFullScreen(true);
            pro.show();
    }
    
}
