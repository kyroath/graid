/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graidguı;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Ege
 */
public class PollPaneController implements Initializable {

    @FXML
    private JFXTextField pollQuestion;
    @FXML
    private JFXTextField pollChoice1;
    @FXML
    private JFXTextField pollChoice2;
    @FXML
    private JFXTextField pollChoice3;
    @FXML
    private JFXTextField pollChoice4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void startPoll(ActionEvent event) {
      
    }

    @FXML
    private void closeWindow(ActionEvent event) {
    }
    
}
