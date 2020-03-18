/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_guichet_automatique.forms;

import gestion_guichet_automatique.Dao.Client;
import gestion_guichet_automatique.Dao.ModelTableClient;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class Gestion_clientController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private TextField rech;
    @FXML
    private TableView<ModelTableClient> tableview;
    @FXML
    private TableColumn<ModelTableClient, Integer> id;
    @FXML
    private TableColumn<ModelTableClient, String> nom;
    @FXML
    private TableColumn<ModelTableClient, String> prenom;
    @FXML
    private TableColumn<ModelTableClient, String> sexe;
    @FXML
    private TableColumn<ModelTableClient, Date> date;
    @FXML
    private TableColumn<ModelTableClient, String> passe;
    @FXML
    private TableColumn<ModelTableClient, Integer> compte;
     @FXML
    private TableColumn<ModelTableClient, Float> solde;
    @FXML
    private Button btn;
    @FXML
    private Button btn_supp;
    @FXML
    private Button btn_mod;
    @FXML
    private TextField nomText;
    @FXML
    private TextField prenomText;
    @FXML
    private TextField codeText;
    @FXML
    private TextField compteText;
    @FXML
    private ComboBox<String> sexeText;
    @FXML
    private DatePicker dateText;
     @FXML
    private TextField soldeText;
    @FXML 
    private
      AutocompletionTextField num_rech;
    Client clients = new Client();
    ObservableList<ModelTableClient> oblist;
     ArrayList ar2;
    int id_tab=0;

    String nv_date="";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
           // TODO
           oblist = clients.getAllClient();
            ar2=clients.getAllClientsName2();
       } catch (SQLException ex) {
           Logger.getLogger(Gestion_clientController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (FileNotFoundException ex) {
            Logger.getLogger(Gestion_clientController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        id.setCellValueFactory(new PropertyValueFactory<>("a"));
         nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
               sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
                 date.setCellValueFactory(new PropertyValueFactory<>("date"));
                  passe.setCellValueFactory(new PropertyValueFactory<>("passe"));
                   compte.setCellValueFactory(new PropertyValueFactory<>("compte"));
                    solde.setCellValueFactory(new PropertyValueFactory<>("Solde"));
                     id.setStyle(" -fx-alignment: CENTER;");
         nom.setStyle(" -fx-alignment: CENTER;");
           prenom.setStyle(" -fx-alignment: CENTER;");
             sexe.setStyle(" -fx-alignment: CENTER;");
               date.setStyle(" -fx-alignment: CENTER;");
                  passe.setStyle(" -fx-alignment: CENTER;");
                     compte.setStyle(" -fx-alignment: CENTER;");
                      solde.setStyle(" -fx-alignment: CENTER;");
                        tableview.setItems(oblist);
                        num_rech.getEntries().addAll(ar2);
                        dateText.setValue(LocalDate.now());
                         tableview.getSelectionModel().selectedItemProperty().addListener(observable -> {
                                   if(!tableview.getSelectionModel().isEmpty()){
                                       
                                       String[] st=new String[20];
                                        id_tab= tableview.getSelectionModel().getSelectedItem().getIdentifiant();
                                          nomText.setText(tableview.getSelectionModel().getSelectedItem().getNom());
                                          prenomText.setText(tableview.getSelectionModel().getSelectedItem().getPrenom());
                                          sexeText.setValue(tableview.getSelectionModel().getSelectedItem().getSexe());
                                          dateText.setValue(tableview.getSelectionModel().getSelectedItem().getDate().toLocalDate());
                                           codeText.setText(tableview.getSelectionModel().getSelectedItem().getPasse());
                                           compteText.setText(String.valueOf(tableview.getSelectionModel().getSelectedItem().getCompte()));
                                            //soldeText.setText(String.valueOf(tableview.getSelectionModel().getSelectedItem().getSolde()));
                                   }
                                  
                                   System.out.println(id_tab);
                                
                            });
                          sexeText.getItems().addAll(clients.getAllCategorie());
         sexeText.getValue();
    }    
        
    public void sdate(ActionEvent event) throws SQLException{
                   nv_date=dateText.getValue().toString();
      
  }
    
    @FXML
    private void rechercher(ActionEvent event) throws IOException {
        
         if(!num_rech.getText().isEmpty()){
                    
              ObservableList<ModelTableClient> allClient,clientSelected ;
          allClient=tableview.getItems();
          clientSelected=tableview.getItems();
             int id_rech=0;
       String[] st=new String[5];
                  for(int i=0;i<allClient.size();i++){
                      st=num_rech.getText().split(" ");
                      if(st.length>1){
                            id_rech=clients.client_id(st[0], st[1]);
                          if(allClient.get(i).getIdentifiant()==id_rech){
            clientSelected.setAll(allClient.get(i));
        
                      }
                      }
           }
                    if(id_rech==0){
                      FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("AlertBox3.fxml"));
        Loader.load();
        AlertBox3Controller alertBoxController=Loader.getController();
        alertBoxController.setting(new Text("Désolé! Il n'y a pas de client portant ce nom et prénom"));
        Parent p=Loader.getRoot();
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(p));
        stage.showAndWait();
                  }else{
                      tableview.setItems(clientSelected);
                  }
         
      

                }else{
                    FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("AlertBox3.fxml"));
        Loader.load();
        AlertBox3Controller alertBoxController=Loader.getController();
        alertBoxController.setting(new Text("Veuillez saisir le nom et prénoms !"));
        Parent p=Loader.getRoot();
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(p));
        stage.showAndWait();
                }
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("New_client.fxml"));
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
    private void supprimer(ActionEvent event) throws IOException, SQLException {
               ObservableList<ModelTableClient> allEmp,empSelectedS;
    ModelTableClient empSelected;
          allEmp=tableview.getItems();
          empSelectedS=tableview.getSelectionModel().getSelectedItems();
          if(empSelectedS.size()>0){
               clients.deleteClient(empSelectedS.get(0).getIdentifiant()); 
            FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("AlertBoxSuccess.fxml"));
        Loader.load();
       AlertBoxSuccessController alertBoxController=Loader.getController();
        alertBoxController.setting(new Text("L'article "+ nomText.getText() +" a été suprimé!"));
        Parent p=Loader.getRoot();
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(p));
        stage.showAndWait();
          affiche();
          }else{
             FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("AlertBox3.fxml"));
        Loader.load();
        AlertBox3Controller alertBoxController=Loader.getController();
        alertBoxController.setting(new Text("Désolé! client introuvable"));
        Parent p=Loader.getRoot();
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(p));
        stage.showAndWait();
          }
    }
    
     public void affiche() throws SQLException, FileNotFoundException{
        oblist = clients.getAllClient();
        
         id.setCellValueFactory(new PropertyValueFactory<>("a"));
         nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
               sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
                 date.setCellValueFactory(new PropertyValueFactory<>("date"));
                  passe.setCellValueFactory(new PropertyValueFactory<>("passe"));
                   compte.setCellValueFactory(new PropertyValueFactory<>("compte"));
                    solde.setCellValueFactory(new PropertyValueFactory<>("Solde"));
                     id.setStyle(" -fx-alignment: CENTER;");
         nom.setStyle(" -fx-alignment: CENTER;");
           prenom.setStyle(" -fx-alignment: CENTER;");
             sexe.setStyle(" -fx-alignment: CENTER;");
               date.setStyle(" -fx-alignment: CENTER;");
                  passe.setStyle(" -fx-alignment: CENTER;");
                     compte.setStyle(" -fx-alignment: CENTER;");
                      solde.setStyle(" -fx-alignment: CENTER;");
                        tableview.setItems(oblist);
                        
                        num_rech.getEntries().addAll(ar2);
                       
                                       nomText.clear();
                                        prenomText.clear();
                                        codeText.clear();
                                        compteText.clear();
                                       dateText.setValue(LocalDate.now());
                                        
                                        
    }
    
     @FXML
    public void actualiser(ActionEvent event) throws SQLException, FileNotFoundException {
        affiche();
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException, SQLException {
          if(tableview.getSelectionModel().getSelectedItems().size()!=0){
                   ObservableList<ModelTableClient> platSelected,allPlat;
          allPlat=tableview.getItems();
          platSelected=tableview.getSelectionModel().getSelectedItems();
          try{
         clients.updateClient(platSelected.get(0).getIdentifiant(),nomText.getText(),prenomText.getText(),
                 sexeText.getValue(), Date.valueOf(dateText.getValue()),codeText.getText(), Integer.parseInt(compteText.getText()));
        
           affiche();
          }catch(NumberFormatException nb){
                FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("AlertBox3.fxml"));
        Loader.load();
        AlertBox3Controller alertBoxController=Loader.getController();
        alertBoxController.setting(new Text("Incorrect! Réessayer..."));
        Parent p=Loader.getRoot();
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(p));
        stage.showAndWait();
          }
            }else{
                  FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("AlertBox3.fxml"));
        Loader.load();
        AlertBox3Controller alertBoxController=Loader.getController();
        alertBoxController.setting(new Text("Veuillez selectionner un client!"));
        Parent p=Loader.getRoot();
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(p));
        stage.showAndWait();
        
            }
    }
    
}
