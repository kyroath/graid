/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graidguı;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Ege
 */
public class LoginPageController implements Initializable {
    
    private Label label;
    @FXML
    private ImageView graidLogo;
    @FXML
    private Label label1;
    @FXML
    private JFXPasswordField passwordField;
    @FXML
    private ImageView graidLogo1;
    @FXML
    private Label label11;
    @FXML
    private JFXTextField usernameField;
  

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }          

    public void loginAction(ActionEvent event) {
        
        //Login işlemi burada yapılacak
        //Aşağıdaki kod main page'e yönlendiriyor
        
        try{
             Parent root;   
             Stage stage = new Stage();
             root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
             stage.setScene(new Scene(root));
             stage.show();
        stage.setTitle("graid");
             
             ((Node)(event.getSource())).getScene().getWindow().hide();
             
         }
         catch (IOException e) {
            e.printStackTrace();
        
        }
    }



    public void getSignupPage(MouseEvent event) {
        try{
             Parent root;   
             Stage stage = new Stage();
             root = FXMLLoader.load(getClass().getResource("SignupPage.fxml"));
             stage.setScene(new Scene(root));
             stage.show();
            
        stage.setTitle("graid");

             ((Node)(event.getSource())).getScene().getWindow().hide();
             
         }
         catch (IOException e) {
            e.printStackTrace();
        
        }
    }


}
