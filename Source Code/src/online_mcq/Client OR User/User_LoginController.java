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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static online_mcq.Starting_code.stage;

/**
 * FXML Controller class
 *
 * @author SAIKAT
 */
public class User_LoginController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private Label label;
    
    static String loginer;
    @FXML
    private PasswordField passfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Login_button_Action(ActionEvent event) throws IOException, InterruptedException {
        String name = username.getText();

        //String pass = password.getText();
        String pass=passfield.getText();

        StudentLoginData SLD = new StudentLoginData(name, pass);
      
        
        ClientConnection.SentObject(SLD);
       
        //Thread.sleep(1000);
        String str = ClientConnection.ReadMsg();
        System.out.println("Server Msg: " + str);
        //label.setText("Login successful");
          

      
        
        if (str.equalsIgnoreCase("Login Successful")) {
           
            loginer=name;
            Parent root = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            //Starting_code.stage.close();
            stage.show();
        } else {
            label.setText("Incorrect password or username");
        }

    }

    @FXML
    private void BackAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        
    }

}
