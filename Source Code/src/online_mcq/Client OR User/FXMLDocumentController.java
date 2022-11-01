
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static online_mcq.Starting_code.stage;




public class FXMLDocumentController implements Initializable {




    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
       
        
      
        
        
    }  
    
     @FXML
    private void User_Login(ActionEvent event) throws IOException {
        
           
      Parent root = FXMLLoader.load(getClass().getResource("User_Login.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        Starting_code.stage.close();
        stage.show();
    }
   
    @FXML
    private void EnterForAdminLogin(ActionEvent event) throws IOException {
        
           
      Parent root = FXMLLoader.load(getClass().getResource("Admin_Login.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        Starting_code.stage.close();
        stage.show();
        
    }

    public FXMLDocumentController() {
    }

   

    @FXML
    private void UserRegisterAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        Starting_code.stage.close();
        stage.show();
      
    }

    @FXML
    private void HelpbuttonAction(ActionEvent event) {
    }

    @FXML
    private void CREDITACTION(ActionEvent event) {
    }



   
   

}
