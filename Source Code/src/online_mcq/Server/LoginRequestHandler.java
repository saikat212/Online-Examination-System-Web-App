/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_mcq.Server;

import java.io.IOException;
import online_mcq.Resgistration_Info;
import online_mcq.StudentLoginData;

/**
 *
 * @author SAIKAT
 */
public class LoginRequestHandler {

    ServerInputOutput sio;
    int id;

    LoginRequestHandler(ServerInputOutput sio,int id) {
        this.sio = sio;
        this.id=id;
    }

    public void Action(Object obj) throws IOException {

        boolean isLogin = false;
        StudentLoginData sld = (StudentLoginData) obj;

        if (DatabaseAction.AlreadyRegisterList.isEmpty()) {
            sio.SentToClient("Login Failed.Please Register");
            ServerActivity.store(id+"-th User"+"::UserName:->"+sld.getUsername()+". failed to login.");
        } else {
            
            for (Resgistration_Info reginfo : DatabaseAction.AlreadyRegisterList) {
                boolean Matching = reginfo.getUsername().equals(sld.getUsername()) && (reginfo.getPassword().equals(sld.getPassword()));
                
                
                if (Matching) {
                    System.out.println("in matching");
                    isLogin = true;

                    break;
                }

            }

            if (isLogin) {
                sio.SentToClient("Login Successful");
                ServerActivity.store(id+"-th User"+"::UserName:->"+sld.getUsername()+" .Logined Successfully.");

            } else {
                sio.SentToClient("Login Failed.Please Register");
                ServerActivity.store(id+"-th User"+"::UserName:->"+sld.getUsername()+" .failed to Login.");
            }

        }
    }

}
