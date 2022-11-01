/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_mcq;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAIKAT
 */
class ClientConnection implements Runnable  {
            static Socket s;
             static DataInputStream dis;
             static DataOutputStream dos;
             static ObjectOutputStream oos;
            static ObjectInputStream ois;
    @Override
    public void run() {
              try {
                  s=new Socket("127.0.0.1",4444);
                  
                  dis=new DataInputStream(s.getInputStream());
                  dos=new DataOutputStream(s.getOutputStream());
                  oos=new ObjectOutputStream(s.getOutputStream());
                  ois=new ObjectInputStream (s.getInputStream());
                
              } catch (IOException ex) {
                  Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
              }
       
    }
    
     public static void SentObject(Object obj) throws IOException
        {
            oos.writeObject(obj);
            oos.flush();
        }
    public static Object ReadObject() throws IOException, ClassNotFoundException
        {
            return ois.readObject();
            
        }
        public static void SentMsg(String str) throws IOException
        {
            dos.writeUTF(str);
            dos.flush();
        }
        
         public static String ReadMsg() throws IOException
        {
           return dis.readUTF();
           
        }
    
}
