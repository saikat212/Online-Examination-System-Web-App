
package online_mcq.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import online_mcq.Starting_code;


public class Server extends Application {
   
    public static  HashMap<String,String> Users=new HashMap<String,String>();
     public static  HashMap<String,DataOutputStream> UserDataOutput=new HashMap<String,DataOutputStream>();
     public static  HashMap<String,ObjectOutputStream> UserObjectOutput=new HashMap<String,ObjectOutputStream>();
    
    public static int client_no=0;
    public static int id=0;
    
     
   
   
          
    
    @Override
    public void start(Stage stage) throws IOException {
         
        
        Parent root = FXMLLoader.load(getClass().getResource("Server_Homepage.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        //Starting_code.stage.close();
        stage.show();
        
         ServerConnection trd=new ServerConnection();
         Thread t=new Thread(trd);
         t.start();

   
}

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
