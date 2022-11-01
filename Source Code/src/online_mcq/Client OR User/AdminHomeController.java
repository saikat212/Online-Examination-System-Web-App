/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_mcq;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import online_mcq.Server.ServerActivity;
import static online_mcq.Starting_code.stage;

/**
 * FXML Controller class
 *
 * @author SAIKAT
 */
public class AdminHomeController implements Initializable {

    @FXML
    private TextArea textarea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void setQuestionAction(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("QuestionSetter.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void sendAction(ActionEvent event) {
    }

    @FXML
    private void clickButtonAction(ActionEvent event) {
    }

    @FXML
    private void LogoutAction(ActionEvent event) throws IOException {
         ServerActivity.store("Teacher Logout .");
        Parent root = FXMLLoader.load(getClass().getResource("Admin_Login.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
