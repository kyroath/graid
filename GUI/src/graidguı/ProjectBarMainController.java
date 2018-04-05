/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graidguı;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Ege
 */
public class ProjectBarMainController implements Initializable {

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
    private Hyperlink groupLink1;
    @FXML
    private Hyperlink groupLink2;
    @FXML
    private Hyperlink groupLink3;
    @FXML
    private Hyperlink groupLink4;
    @FXML
    private Hyperlink groupLink5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getTagPage(ActionEvent event) {
    }

    @FXML
    private void getGroupSearchPage(ActionEvent event) {
    }

    @FXML
    private void getProfilePage(ActionEvent event) {
    }
    
}
