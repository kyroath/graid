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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ege
 */
public class GroupCreatePageController implements Initializable {

    @FXML
    private Button homeButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button profileButton;
    @FXML
    private ImageView profilePicture;
    @FXML
    private Label usernameLabel;
    @FXML
    private Hyperlink groupLink1;
    @FXML
    private Hyperlink groupLink2;
    @FXML
    private Hyperlink groupLink3;
    @FXML
    private Hyperlink groupLink4;
    @FXML
    private Hyperlink groupLink5;
    @FXML
    private TextField tagSearchField;
    @FXML
    private TextField noOfParticipants;
    @FXML
    private TableColumn<?, ?> tagTable;
    @FXML
    private TextField groupName;
    @FXML
    private Button createGroupButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getMainPage(ActionEvent event) {
        try{
             Parent root;   
             Stage stage = new Stage();
             root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
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
    private void createGroup(ActionEvent event) {
        try{
             Parent root;   
             Stage stage = new Stage();
             root = FXMLLoader.load(getClass().getResource("GroupProfilePage.fxml"));
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
