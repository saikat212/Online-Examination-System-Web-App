/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_mcq;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import static online_mcq.Starting_code.stage;

/**
 * FXML Controller class
 *
 * @author SAIKAT
 */
public class ResultPageController implements Initializable {

    @FXML
    private Label course;
    @FXML
    private Label Totalmark;
    @FXML
    private Label TRY;
    @FXML
    private Label right;
    @FXML
    private Label worng;
    @FXML
    private Label obtainmark;
    @FXML
    private Label time;
    @FXML
    private Label name;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            //StudentResult sr=(StudentResult) ClientConnection.ReadObject();
             name.setText(User_LoginController.loginer);
             course.setText(AfterLoginController.course);
             Totalmark.setText(QuestionPageController.totalquestion+"");
             TRY.setText(QuestionPageController.AttemptNum+"");
             right.setText(QuestionPageController.correct+"");
             worng.setText(QuestionPageController.wrong+"");
             obtainmark.setText(QuestionPageController.correct+"");
             time.setText("5");
      
      
      
    }    

    @FXML
    private void HomeButtonAction(ActionEvent event) throws IOException {
         //  QuestionPageController.i=-1;
          QuestionPageController.AttemptNum=0;
          QuestionPageController.correct=0;
          QuestionPageController.totalquestion=0;
          QuestionPageController.wrong=0;
          AfterLoginController.course=null;         
           Parent root = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            //Starting_code.stage.close();
            stage.show();
    }
    
}
   