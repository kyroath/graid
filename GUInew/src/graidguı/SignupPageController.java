/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graidguı;

import com.jfoenix.controls.JFXPasswordField;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ege
 */
public class SignupPageController implements Initializable {

    @FXML
    private ImageView graidLogo;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private AnchorPane signupPanel;
    @FXML
    private ImageView graidLogo1;
    @FXML
    private Label label1;
    @FXML
    private JFXTextField usernameField;
    @FXML
    private Label label11;
    @FXML
    private Button registerButton;
    @FXML
    private Label label12;
    @FXML
    private Label label111;
    @FXML
    private JFXPasswordField passwordField2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    public void registerAction(ActionEvent event) {
        
        //Kayıt olma işlemi burada yapılacak
        // İşlem tamamlanınca aşağıdaki kod login sayfasını açacak
        
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
    
            
    
       
    
}
