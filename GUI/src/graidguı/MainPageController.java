/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graidguı;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ege
 */
public class MainPageController implements Initializable {

    @FXML
    private Button tagButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button profileButton;
    @FXML
    private ImageView profilePicture;
    @FXML
    private Label usernameLabel;
    @FXML
    private Hyperlink leftGroupLink1;
    @FXML
    private Hyperlink leftGroupLink2;
    @FXML
    private Hyperlink leftGroupLink3;
    @FXML
    private Hyperlink leftGroupLink4;
    @FXML
    private Hyperlink leftGroupLink5;
    @FXML
    private Hyperlink mainGroupLink1;
    @FXML
    private Hyperlink mainGroupLink2;
    @FXML
    private Hyperlink mainGroupLink3;
    @FXML
    private Label g1Label1;
    @FXML
    private Label g1Label2;
    @FXML
    private Label g1Label3;
    @FXML
    private RadioButton g1tick1;
    @FXML
    private RadioButton g1tick2;
    @FXML
    private RadioButton g1tick3;
    @FXML
    private Label g2Label1;
    @FXML
    private Label g2Label2;
    @FXML
    private Label g2Label3;
    @FXML
    private RadioButton g2tick1;
    @FXML
    private RadioButton g2tick2;
    @FXML
    private RadioButton g2tick3;
    @FXML
    private Label g3Label1;
    @FXML
    private Label g3Label2;
    @FXML
    private Label g3Label3;
    @FXML
    private RadioButton g3tick1;
    @FXML
    private RadioButton g3tick2;
    @FXML
    private RadioButton g3tick3;
    @FXML
    private ProgressBar projectProgress1;
    @FXML
    private ProgressBar projectProgress2;
    @FXML
    private ProgressBar projectProgress3;
    @FXML
    private Label timeLabel1;
    @FXML
    private Label timeLabel2;
    @FXML
    private Label timeLabel3;
    @FXML
    private Label smTime1;
    @FXML
    private Label sMessage1;
    @FXML
    private Hyperlink smGroupLink1;
    @FXML
    private Hyperlink smGroupLink2;
    @FXML
    private Hyperlink smGroupLink3;
    @FXML
    private Label smTime2;
    @FXML
    private Label smTime3;
    @FXML
    private Label sMessage2;
    @FXML
    private Label sMessage3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getTagPage(ActionEvent event) {
         try{
             Parent root;   
             Stage stage = new Stage();
             root = FXMLLoader.load(getClass().getResource("ProfilePage.fxml"));
             stage.setScene(new Scene(root));
             stage.show();
             ((Node)(event.getSource())).getScene().getWindow().hide();
             
         }
         catch (IOException e) {
            e.printStackTrace();
    }
    }

    @FXML
    private void getGroupSearchPage(ActionEvent event) {
        try{
             Parent root;   
             Stage stage = new Stage();
             root = FXMLLoader.load(getClass().getResource("GroupSearchPage.fxml"));
             stage.setScene(new Scene(root));
             stage.show();
             ((Node)(event.getSource())).getScene().getWindow().hide();
             
         }
         catch (IOException e) {
            e.printStackTrace();
    }
    }

    @FXML
    private void getProfilePage(ActionEvent event) {
        try{
             Parent root;   
             Stage stage = new Stage();
             root = FXMLLoader.load(getClass().getResource("ProfilePage.fxml"));
             stage.setScene(new Scene(root));
             stage.show();
             ((Node)(event.getSource())).getScene().getWindow().hide();
             
         }
         catch (IOException e) {
            e.printStackTrace();
    }
    }

    @FXML
    private void getGroupPage(ActionEvent event) {
        try{
             Parent root;   
             Stage stage = new Stage();
             root = FXMLLoader.load(getClass().getResource("GroupPage.fxml"));
             stage.setScene(new Scene(root));
             stage.show();
             ((Node)(event.getSource())).getScene().getWindow().hide();
             
         }
         catch (IOException e) {
            e.printStackTrace();
    }
    }
    
}
