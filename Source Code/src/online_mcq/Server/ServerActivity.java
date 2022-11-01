/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_mcq.Server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author SAIKAT
 */
public class ServerActivity {
    
   
    public static void store(String str) throws IOException
    {
        File file =new File("serveractivity.txt");
        if(!(file.exists()))
        {
            file.createNewFile();
            
        }
        FileWriter fw=new FileWriter(file,true);
        fw.write(str+"\n");
        fw.close();
    }
   public static String show() throws FileNotFoundException
    {
       File file =new File("serveractivity.txt");
       Scanner in=new Scanner(file);
       String str="";
       while(in.hasNext())
       {
           str+=in.nextLine()+"\n";
           
       }
      
       return str;
      
        
    }
    
    
}
