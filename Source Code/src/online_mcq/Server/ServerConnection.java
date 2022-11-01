/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_mcq.Server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAIKAT
 */
class ServerConnection implements Runnable {
       ServerSocket ss;
       Socket ServerSideSocket;
       
       int id=0;
    @Override
    public void run() {
           
           try {
               ss=new ServerSocket(4444);
               while(true)
               {
                  ServerSideSocket=ss.accept();
                  id++;
                   //System.out.println("client connected");
                   System.out.println("User connected");
                   //Server_HomepageController.msg="One Client is connected with server";
                   ServerActivity.store("User: "+id+" is Connected.");
                   
                  
                   WorkerThread wt=new WorkerThread(ServerSideSocket,id);
                   Thread t1=new Thread((Runnable) wt);
                   t1.start();
                 
               }
           } catch (IOException ex) {
               Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
           }
            
       
        
    }
    
}
