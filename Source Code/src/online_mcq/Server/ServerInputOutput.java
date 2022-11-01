/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_mcq.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author SAIKAT
 */
public class ServerInputOutput {
    DataInputStream dis;
    DataOutputStream dos;
    ObjectInputStream ois;
    ObjectOutputStream oos;

    public ServerInputOutput(DataInputStream dis,DataOutputStream dos,ObjectInputStream ois,ObjectOutputStream oos) {
        
        this.dis=dis;
        this.dos=dos;
        this.ois=ois;
        this.oos=oos;
    }
     
   
    public void SentObjectToClient(Object obj) throws IOException
    {
        System.out.println("yes coming");
        oos.writeObject(obj);
        oos.flush();
    }
    
     public void SentToClient(String str) throws IOException
    {
        dos.writeUTF(str);
        dos.flush();
    }
      public String ReadFromClient() throws IOException
    {
        return dis.readUTF();
          
    }
      
        public Object ReadObjectFromClient() throws IOException, ClassNotFoundException
    {
        return ois.readObject();
          
    }
}
