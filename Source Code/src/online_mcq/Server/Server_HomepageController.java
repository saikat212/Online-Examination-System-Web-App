/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_mcq.Server;

import com.mysql.jdbc.Connection;
import static java.awt.SystemColor.text;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;



public class Server_HomepageController implements Initializable {

    /**
     * Initializes the controller class.
     */
     static Connection databaseConnection;
    
    @FXML
    
    private TextArea text;
     String str;
     
   
            
    static String msg="start....";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         text.appendText(msg+"\n");
      
         try {
             databaseConnection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/serverdatabase","root","");
             // TODO
         } catch (SQLException ex) {
             Logger.getLogger(Server_HomepageController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    


    @FXML
    private void RefreshAction(ActionEvent event) throws FileNotFoundException {

         String msg=ServerActivity.show();
          text.setText(msg);
//        
//         if(!(msg.equals(str)))
//        {
//             text.setText(msg);
//        }
//         
//        str= msg;
//        
    }
   
     
    
}
