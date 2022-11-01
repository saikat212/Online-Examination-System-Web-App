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
public class ProfileController implements Initializable {

    @FXML
    private Label pname;
    @FXML
    private Label pemail;
    @FXML
    private Label pinstittution;
    @FXML
    private Label pusername;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            System.out.println("ini");
            Resgistration_Info profileinfo= (Resgistration_Info) ClientConnection.ReadObject();
            System.out.println("after ini");
            pname.setText(profileinfo.fullname);
            pemail.setText(profileinfo.email);
            pinstittution.setText(profileinfo.inst);
            pusername.setText(profileinfo.username);
            
        } catch (IOException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void backAction(ActionEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            Starting_code.stage.close();
            stage.show();
    }
    
}
