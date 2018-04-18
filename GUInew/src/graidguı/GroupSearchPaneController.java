/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graidguı;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

/**
 * FXML Controller class
 *
 * @author Ege
 */
public class GroupSearchPaneController implements Initializable {

    @FXML
    private Label groupName;
    @FXML
    private Label groupDescription;
    @FXML
    private Label tag1;
    @FXML
    private Label tag2;
    @FXML
    private Label tag3;
    @FXML
    private ProgressIndicator percentage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
