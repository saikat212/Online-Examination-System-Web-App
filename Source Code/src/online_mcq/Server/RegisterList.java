/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_mcq.Server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.net.Socket;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import online_mcq.StudentLoginData;

/**
 *
 * @author SAIKAT
 */
public class RegisterList implements Serializable {
    String name;
    String pass;
    public static  ObservableList<StudentLoginData> RegisterList1=FXCollections.observableArrayList();
    public  RegisterList() throws FileNotFoundException {
        File file=new File("Register.txt");
        Scanner input=new Scanner(file);
        while(input.hasNext())
        {
            String str=input.nextLine();
            String[] info=str.split("##");
            StudentLoginData sl=new StudentLoginData(info[0], info[1]);
            RegisterList1.add(sl);
            
        }
        
}

   
}
