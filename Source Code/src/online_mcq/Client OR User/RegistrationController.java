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
import javafx.scene.control.TextField;
import static online_mcq.Starting_code.stage;

/**
 * FXML Controller class
 *
 * @author SAIKAT
 */
public class RegistrationController implements Initializable {

    @FXML
    private TextField fullname;
    @FXML
    private TextField username;
    @FXML
    private TextField institution;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private Label RCM;
    @FXML
    private TextField type;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void RegisterButtonAction(ActionEvent event) throws IOException {
        String FName=fullname.getText();
        String E=email.getText();
        String in=institution.getText();
        String uname=username.getText();
        String pass=password.getText();
        String typ=type.getText();
        System.out.println("CLIENT SENT SUCCESSFULLY");
        Resgistration_Info regInfo=new Resgistration_Info(FName,E,in,uname,pass,typ);
        ClientConnection.SentObject(regInfo);
        System.out.println("CLIENT SENT SUCCESSFULLY");
        String str=ClientConnection.ReadMsg();
            System.out.println("server resmessag:"+str);
        RCM.setText(str);
        
        
        
        
        
        
        
    }

    @FXML
    private void HomeFromRegister(ActionEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        
    }
    
}
