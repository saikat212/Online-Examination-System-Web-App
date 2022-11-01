/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_mcq.Server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import online_mcq.Resgistration_Info;

/**
 *
 * @author SAIKAT
 */
public class RegistrationRequestHandler {
    ServerInputOutput sio;
    int id;
   

    RegistrationRequestHandler(ServerInputOutput sio,int id) {
        this.sio=sio;
        this.id=id;
    }

    // static ObservableList<Resgistration_Info> RList = FXCollections.observableArrayList();
    //static HashMap<String,String> name_pass=new HashMap<String,String>();
    public void Action(Object obj) throws IOException, SQLException {
        Resgistration_Info RIN = (Resgistration_Info) obj;
        boolean isregister=false;

        for (Resgistration_Info resgistration_Info : DatabaseAction.AlreadyRegisterList) {
            
            if (RIN.equals(resgistration_Info)) {
                
                isregister=true;
                break;
            }

        }
        if(DatabaseAction.AlreadyRegisterList.isEmpty())
        {
            isregister=false;
        }
        if(isregister)
        {
            sio.SentToClient("Your have Already registered");
           ServerActivity.store(id+"-th User"+"::UserName:->"+RIN.getUsername()+" .wanted to register again.");
            
            
            
        }
        else
        {
            DatabaseAction.DataInsert(RIN);
           
            sio.SentToClient("You have registered succesfully");
            ServerActivity.store(id+"-th User"+"::UserName:->"+RIN.getUsername()+" .Successfully to Register.");
        }
        
    }

}
