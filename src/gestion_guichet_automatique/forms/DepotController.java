/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_guichet_automatique.forms;

import gestion_guichet_automatique.Dao.Depot;
import gestion_guichet_automatique.Dao.ModelTableDepot;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class DepotController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private TableView<ModelTableDepot> tableview;
    @FXML
    private TableColumn<ModelTableDepot, Integer> id;
    @FXML
    private TableColumn<ModelTableDepot, String> nom;
    @FXML
    private TableColumn<ModelTableDepot, String> prenom;
    @FXML
    private TableColumn<ModelTableDepot, Integer> compte;
    @FXML
    private TextField num;
    @FXML
    private TextField compteText;
    @FXML
    private TextField soldeText;
     @FXML
    private Text labDate;
  
    @FXML
    private Button btn;
    @FXML
    private Button btn_rech;
    
    ObservableList<ModelTableDepot> oblist; 
   
           @FXML
        private AutocompletionTextField num_rech;
         ArrayList ar1;
     int id_tab=0;
      Depot dep = new Depot();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
         // TODO
         oblist = dep.getAllDepot();
         ar1=dep.getAllDepotsName2();
         id.setCellValueFactory(new PropertyValueFactory<>("a"));
          id.setStyle(" -fx-alignment: CENTER;");
         nom.setStyle(" -fx-alignment: CENTER;");
           prenom.setStyle(" -fx-alignment: CENTER;");
               compte.setStyle(" -fx-alignment: CENTER;");
               
                 id.prefWidthProperty().bind(tableview.widthProperty().multiply(0.07));
               nom.prefWidthProperty().bind(tableview.widthProperty().multiply(0.25));
                prenom.prefWidthProperty().bind(tableview.widthProperty().multiply(0.25));
                compte.prefWidthProperty().bind(tableview.widthProperty().multiply(0.25));
               
                  id.setResizable(false);
                     nom.setResizable(false);
                        prenom.setResizable(false);
                        compte.setResizable(false);
                              
         nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
         prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         compte.setCellValueFactory(new PropertyValueFactory<>("Compte"));
        
             num_rech.getEntries().addAll(ar1);
         tableview.setItems(oblist);
     } catch (SQLException ex) {
         Logger.getLogger(DepotController.class.getName()).log(Level.SEVERE, null, ex);
     }
      
       tableview.getSelectionModel().selectedItemProperty().addListener(observable -> {
                                   if(!tableview.getSelectionModel().isEmpty()){
                                        id_tab= tableview.getSelectionModel().getSelectedItem().getIdentifiant();
                                        num.setText(String.valueOf(tableview.getSelectionModel().getSelectedItem().getA()));
                                          compteText.setText(String.valueOf(tableview.getSelectionModel().getSelectedItem().getCompte()));
                                           // soldeText.setText(String.valueOf(tableview.getSelectionModel().getSelectedItem().get);
                                   }
                                  
                                   System.out.println(id_tab);
                               }
                               );
   
      datecourant();
    }    
    
       public void datecourant(){
	 Thread clock = new Thread(){
		public void run(){
			for(;;){
				Calendar cal = new GregorianCalendar();

				int second = cal.get(Calendar.SECOND);
				int minute = cal.get(Calendar.MINUTE);
				int heure =  cal.get(Calendar.HOUR_OF_DAY);
                              
				labDate.setText("Heure: " +heure+":"+(minute)+":"+second);
				try{
					sleep(1000);
                                        
				}catch(Exception ex){
				  Logger.getLogger(Calendar.class.getName()).log(Level.SEVERE,null,ex);
				}
                                
							}
		}
	};
        clock.start();
}

    @FXML
    private void effectuer(ActionEvent event) throws IOException {
                        
                           if(tableview.getSelectionModel().getSelectedItems().size()!=0){
                   ObservableList<ModelTableDepot> platSelected,allPlat;
          allPlat=tableview.getItems();
          platSelected=tableview.getSelectionModel().getSelectedItems();
          try{
         dep.insertDepot(platSelected.get(0).getIdentifiant(),Float.parseFloat(soldeText.getText()));
                                        
                            FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("AlertBoxSuccess.fxml"));
        Loader.load();
       AlertBoxSuccessController alertBoxController=Loader.getController();
        alertBoxController.setting(new Text("depot effectué, solde mis à jour!"));
        Parent p=Loader.getRoot();
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(p));
        stage.showAndWait();
                          //affiche();
          
                         }catch(NumberFormatException nb){
                            FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("AlertBox3.fxml"));
        Loader.load();
        AlertBox3Controller alertBoxController=Loader.getController();
        alertBoxController.setting(new Text("invalide, réessayer !"));
        Parent p=Loader.getRoot();
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(p));
        stage.showAndWait();
                         }
                               
                         
                           }                                    
                                           soldeText.setText(" ");
    }

    @FXML
    private void rechercher(ActionEvent event) throws IOException {
             if(!num_rech.getText().isEmpty()){
                    
              ObservableList<ModelTableDepot> allClient,clientSelected ;
          allClient=tableview.getItems();
          clientSelected=tableview.getItems();
             int id_rech=0;
       String[] st=new String[5];
                  for(int i=0;i<allClient.size();i++){
                      st=num_rech.getText().split(" ");
                      if(st.length>1){
                            id_rech=dep.Depot_id(st[0], st[1]);
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
    
}
