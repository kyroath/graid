/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graidguı;

import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ege
 */
public class TagPageController implements Initializable {

    @FXML
    private ImageView profilePicture;
    @FXML
    private Label usernameLabel;
    @FXML
    private RadioButton regularTag;
    @FXML
    private RadioButton credentialTag;
    @FXML
    private TableView<?> tagTable1;
    @FXML
    private ImageView searchIcon;
    @FXML
    private ImageView logoutIcon;
    @FXML
    private AnchorPane groupPane1;
    @FXML
    private ImageView groupImage1;
    @FXML
    private Label groupName1;
    @FXML
    private Label groupDesc1;
    @FXML
    private AnchorPane groupPane2;
    @FXML
    private ImageView groupImage2;
    @FXML
    private Label groupName2;
    @FXML
    private Label groupDesc2;
    @FXML
    private AnchorPane groupPane3;
    @FXML
    private ImageView groupImage3;
    @FXML
    private Label groupName3;
    @FXML
    private Label groupDesc3;
    @FXML
    private AnchorPane groupPane4;
    @FXML
    private ImageView groupImage4;
    @FXML
    private Label groupName4;
    @FXML
    private Label groupDesc4;
    @FXML
    private AnchorPane groupPane5;
    @FXML
    private ImageView groupImage5;
    @FXML
    private Label groupName5;
    @FXML
    private Label groupDesc5;
    @FXML
    private ImageView homeIcon;
    @FXML
    private TableView<?> tagTable2;
    @FXML
    private Button tagCreateButton;
    @FXML
    private JFXTextField tagNameField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   

    @FXML
    private void createTag(ActionEvent event) {
    }

    @FXML
    private void getProfilePage(MouseEvent event) {
        try {
            Parent root;
            Stage stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("ProfilePage.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
           
        stage.setTitle("graid");
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
    }
    }

    @FXML
    private void getGroupSearchPage(MouseEvent event) {
        try {
            Parent root;
            Stage stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("GroupSearchPage.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
           
        stage.setTitle("graid");
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
    }
    }

    @FXML
    private void logout(MouseEvent event) {
        
        
       //logout işlemi
       
        
        try {
            Parent root;
            Stage stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
           
        stage.setTitle("graid");
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
    }
    }

    @FXML
    private void getGroupPage(MouseEvent event) {
        try {
            Parent root;
            Stage stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("GroupPage.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
           
        stage.setTitle("graid");
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
    }
    }

    @FXML
    private void getMainPage(MouseEvent event) {
        try {
            Parent root;
            Stage stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
           
        stage.setTitle("graid");
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
    }
    }
    
}
