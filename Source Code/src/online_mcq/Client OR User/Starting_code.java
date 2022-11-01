



package online_mcq;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Starting_code extends Application {
    public static Stage stage;
   
    
    @Override
    public void start(Stage stage) throws Exception {
        
        this.stage=stage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        ClientConnection cwt=new ClientConnection();
        Thread t2=new Thread(cwt);
        t2.start();
        
    }

   
    public static void main(String[] args) throws IOException { 
       launch(args);
    }
    
}
