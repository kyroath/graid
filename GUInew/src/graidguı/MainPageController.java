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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ege
 */
public class MainPageController implements Initializable {

    @FXML
    private ImageView profilePicture;
    @FXML
    private Label usernameLabel;
    @FXML
    private ImageView tagIcon;
    @FXML
    private ImageView searchIcon;
    @FXML
    private ImageView logoutIcon;
    @FXML
    private AnchorPane groupPane1;
    @FXML
    private AnchorPane groupPane2;
    @FXML
    private AnchorPane groupPane3;
    @FXML
    private AnchorPane groupPane4;
    @FXML
    private AnchorPane groupPane5;
    @FXML
    private ImageView groupImage1;
    @FXML
    private Label groupName1;
    @FXML
    private Label groupDesc1;
    @FXML
    private ImageView groupImage2;
    @FXML
    private Label groupName2;
    @FXML
    private Label groupDesc2;
    @FXML
    private ImageView groupImage3;
    @FXML
    private Label groupName3;
    @FXML
    private Label groupDesc3;
    @FXML
    private ImageView groupImage4;
    @FXML
    private Label groupName4;
    @FXML
    private Label groupDesc4;
    @FXML
    private ImageView groupImage5;
    @FXML
    private Label groupName5;
    @FXML
    private Label groupDesc5;
    @FXML
    private Label panelName1;
    @FXML
    private Label panelDesc1;
    @FXML
    private Label panelName2;
    @FXML
    private Label panelDesc2;
    @FXML
    private Label panelName3;
    @FXML
    private Label panelDesc3;
    @FXML
    private Label task1Title1;
    @FXML
    private Label task1Desc1;
    @FXML
    private Label task1Title2;
    @FXML
    private Label task1Title3;
    @FXML
    private Label task1Desc2;
    @FXML
    private Label task1Desc3;
    @FXML
    public ImageView task1img1;
    @FXML
    private ImageView task1img2;
    @FXML
    private ImageView task1img3;
    @FXML
    private AnchorPane taskPanel1;
    @FXML
    private AnchorPane taskPanel2;
    @FXML
    private AnchorPane taskPanel3;
    @FXML
    private Label task2Title1;
    @FXML
    private Label task2Desc1;
    @FXML
    private Label task2Title2;
    @FXML
    private Label task2Title3;
    @FXML
    private Label task2Desc2;
    @FXML
    private Label task2Desc3;
    @FXML
    private ImageView task2img1;
    @FXML
    private ImageView task2img2;
    @FXML
    private ImageView task2img3;
    @FXML
    private Label task3Title1;
    @FXML
    private Label task3Desc1;
    @FXML
    private Label task3Title2;
    @FXML
    private Label task3Title3;
    @FXML
    private Label task3Desc2;
    @FXML
    private Label task3Desc3;
    @FXML
    private ImageView task3img1;
    @FXML
    private ImageView task3img2;
    @FXML
    private ImageView task3img3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Burada groupPane'ler invisible yapılabilir 
       
        

    }    




    private void getTagPage(MouseEvent event) {
        try{
             Parent root;   
             Stage stage = new Stage();
             root = FXMLLoader.load(getClass().getResource("TagPage.fxml"));
             stage.setScene(new Scene(root));
             stage.show();
             
        stage.setTitle("graid");
             ((Node)(event.getSource())).getScene().getWindow().hide();
             
         }
         catch (IOException e) {
            e.printStackTrace();
    }
    }

    @FXML
    private void getGroupSearchPage(MouseEvent event) {
        try{
             Parent root;   
             Stage stage = new Stage();
             root = FXMLLoader.load(getClass().getResource("GroupSearchPage.fxml"));
             stage.setScene(new Scene(root));
             stage.show();
             
        stage.setTitle("graid");
             ((Node)(event.getSource())).getScene().getWindow().hide();
             
         }
         catch (IOException e) {
            e.printStackTrace();
    }
    }

    @FXML
    private void getProfilePage(MouseEvent event) {
        try{
             Parent root;   
             Stage stage = new Stage();
             root = FXMLLoader.load(getClass().getResource("ProfilePage.fxml"));
             stage.setScene(new Scene(root));
             stage.show();
             
        stage.setTitle("graid");
             ((Node)(event.getSource())).getScene().getWindow().hide();
             
         }
         catch (IOException e) {
            e.printStackTrace();
    }
    }

    @FXML
    private void logout(MouseEvent event) {
        
        //Burada logout işlemi yapılacak
        //Aşağıdaki kod login screen'e yönlendiriyor
        
        try{
             Parent root;   
             Stage stage = new Stage();
             root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
             stage.setScene(new Scene(root));
             stage.show();
             
        stage.setTitle("graid");
             ((Node)(event.getSource())).getScene().getWindow().hide();
             
         }
         catch (IOException e) {
            e.printStackTrace();
    }
    }

    @FXML
    private void getGroupPage(MouseEvent event) {
        
        //Tıklanan grubun sayfasına yönlendiriyor
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
    private void setTaskColor(MouseEvent event) {
        
    try {
            Parent root;
            Stage stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("TaskPopup.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
           
        stage.setTitle("graid");

        } catch (IOException e) {
            e.printStackTrace();
        }
}

    @FXML
    private void getGroupProfilePage(MouseEvent event) {
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
    
    
    
}
