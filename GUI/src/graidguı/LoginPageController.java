/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graidguı;

import java.net.URL;
import javafx.scene.Node;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Ege
 */
public class LoginPageController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane loginPanel;
    @FXML
    private AnchorPane loginPanel2;
    @FXML
    private TextField emailField;
    @FXML
    private ImageView graidLogo;
    @FXML
    private Label label1;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Label label2;
    @FXML
    private Button signupButton;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }          

    @FXML
    private void loginAction(ActionEvent event) {
        
        //Login işlemi burada yapılacak
        //Aşağıdaki kod main page'e yönlendiriyor
        
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
    private void getSignupPage(ActionEvent event) {
        try{
             Parent root;   
             Stage stage = new Stage();
             root = FXMLLoader.load(getClass().getResource("SignupPage.fxml"));
             stage.setScene(new Scene(root));
             stage.show();
             ((Node)(event.getSource())).getScene().getWindow().hide();
             
         }
         catch (IOException e) {
            e.printStackTrace();
        
        }
    }
}
