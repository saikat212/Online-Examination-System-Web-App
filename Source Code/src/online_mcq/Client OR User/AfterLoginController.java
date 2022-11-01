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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import online_mcq.Server.ServerActivity;
import static online_mcq.Starting_code.stage;

/**
 * FXML Controller class
 *
 * @author SAIKAT
 */
public class AfterLoginController implements Initializable {

    @FXML
    private AnchorPane profilepageCenter;
    static String course;
    @FXML
    private Label selectcourse;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ProfileButtonAction(ActionEvent event) throws IOException, InterruptedException {
        String str="S"+"##"+User_LoginController.loginer;
        String strobj=new String(str);
        ClientConnection.SentObject(strobj);
        
         Parent root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
        
         Scene scene = new Scene(root);
        
         stage.setScene(scene);
         stage.show();
        
        
        
        
    }

    @FXML
    private void CppAction(ActionEvent event) {
        course="C++";
        
    }

    @FXML
    private void JavaAction(ActionEvent event) {
        course="JAVA";
        
    }

    @FXML
    private void startExamAction(ActionEvent event) throws IOException {
        
        String com="E"+"##"+course;
        if(course!=null)
        {
        ClientConnection.SentObject(com);
        Parent root = FXMLLoader.load(getClass().getResource("QuestionPage.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }
        else
        {
            selectcourse.setText("Please Select Any Course.");
        }
        
        
    }
    

    @FXML
    private void LogoutAction(ActionEvent event) throws IOException {
        ServerActivity.store("UserName:->>"+User_LoginController.loginer+" .LogOut .");
        course=null;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void RankingAction(ActionEvent event) {
    }

    @FXML
    private void CLICKACTION(ActionEvent event) {
    }

    @FXML
    private void SENDACTION(ActionEvent event) {
    }
    
}
