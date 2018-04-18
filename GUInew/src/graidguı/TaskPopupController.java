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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image ;

/**
 * FXML Controller class
 *
 * @author Ege
 */
public class TaskPopupController implements Initializable {

    @FXML
    private ImageView taskRed;
    @FXML
    private ImageView taskYellow;
   // private Image red = new Image("");
   // private Image yellow = new Image("");
   // private Image green = new Image("");

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void setRed(MouseEvent event) {
     ImageView temp = (ImageView)event.getSource();
    // temp.setImage(red);
    }

    @FXML
    private void setYellow(MouseEvent event) {
        ImageView temp = (ImageView)event.getSource();
    // temp.setImage(yellow);
    }

    @FXML
    private void setGreen(MouseEvent event) {
        ImageView temp = (ImageView)event.getSource();
    // temp.setImage(green);
    }
    
}
