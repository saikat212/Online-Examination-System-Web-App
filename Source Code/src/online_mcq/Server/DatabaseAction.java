/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_mcq.Server;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import online_mcq.QuestionSet;
import online_mcq.Resgistration_Info;
import online_mcq.StudentResult;


/**
 *
 * @author SAIKAT
 */
public class DatabaseAction {
     static ObservableList<Resgistration_Info> AlreadyRegisterList=FXCollections.observableArrayList();
       ArrayList<QuestionDatabase> AllQuestion=new ArrayList<QuestionDatabase>();
     public static  HashMap<String,String> Id_CorrectAnswer=new HashMap<String,String>();
      
     static Statement statement1,statement2,statement3,statement4,statement5,statement6,statement7;
       
        ServerInputOutput sio;
       
     DatabaseAction(ServerInputOutput sio) {
       this.sio=sio;
    }
   
     DatabaseAction() throws SQLException
    {
        
       statement1=(Statement)Server_HomepageController.databaseConnection.createStatement();
       
       
        String query="select * from registrationtable";
        ResultSet rs=statement1.executeQuery(query);
        
        while(rs.next())
        {
            String Name=rs.getString("Name");
            String Email=rs.getString("Email");
            System.out.println("before institution");
            String Inst=rs.getString("Institution");
            System.out.println("after institution");
            String Uname=rs.getString("Username");
            String Pass=rs.getString("Password");
            String type=rs.getString("Type");
           
            
            
            
            
            
            Resgistration_Info reginfo=new Resgistration_Info(Name,Email,Inst,Uname,Pass,type);
            
            AlreadyRegisterList.add(reginfo);
        }
        
    
        
    }
     
     static void DataInsert(Resgistration_Info reginfo) throws SQLException
        {
           statement2=(Statement)Server_HomepageController.databaseConnection.createStatement();
            System.out.println("data inserting");
            String Name=reginfo.getFullname();
            String Email=reginfo.getEmail();
            String Institution=reginfo.getInst();
            
            String Username=reginfo.getUsername();
            String Password=reginfo.getPassword();
            String Type=reginfo.getType();
            System.out.println("before query setup");
           String query="insert into registrationtable values('"+Name+"','"+Email+"','"+Institution+"','"+Username+"','"+Password+"','"+Type+"')";
           statement1.executeUpdate(query);
           
           
            System.out.println("Insert Successfully");
            
        }
      void ProvideProfileOf(String name) throws SQLException, IOException
     {
         statement3=(Statement)Server_HomepageController.databaseConnection.createStatement();
       
         System.out.println("before query chechking");
        String query1="select * from registrationtable where Username='"+name+"'";
         System.out.println("before result set");
         System.out.println("Query:"+query1);
        ResultSet rs1=statement3.executeQuery(query1);
        //  rs1.beforeFirst();
           while(rs1.next())
           {
            String Name=rs1.getString("Name");
            System.out.println("Name finding by rs1: "+Name);
            String Email=rs1.getString("Email");
            System.out.println("before institution");
            String Inst=rs1.getString("Institution");
            System.out.println("after institution");
            String Uname=rs1.getString("Username");
            String Pass=rs1.getString("Password");
            String type=rs1.getString("Type");
           
             Resgistration_Info reginfo=new Resgistration_Info(Name,Email,Inst,Uname,Pass,type);
             sio.SentObjectToClient(reginfo);
             System.out.println("server profile info pathai");
         
           }
           
        }
       void ProvideResultOf(String name) throws SQLException, IOException
      {
          statement6=(Statement)Server_HomepageController.databaseConnection.createStatement();
       
         System.out.println("before query chechking");
        String query1="select * from studentresult where Username='"+name+"'";
         System.out.println("before result set");
         System.out.println("Query:"+query1);
        ResultSet rs1=statement6.executeQuery(query1);
        //  rs1.beforeFirst();
           while(rs1.next())
           {
            String uname=rs1.getString("Username");
            String cname=rs1.getString("CourseName");
            
            String totalM=rs1.getString("TotalMark");
            System.out.println("before institution");
            String tryn=rs1.getString("Try");
            System.out.println("after institution");
            String right=rs1.getString("RightAnswer");
            String wron=rs1.getString("WrongAnswer");
            String obM=rs1.getString("ObtainedMark");
            String tim=rs1.getString("Time");
           StudentResult sr=new StudentResult(uname, cname, totalM, tryn,right, wron, obM, tim);
             sio.SentObjectToClient(sr);
      }
  }

   
     
      void QuestionSendingFrom(String questiontable) throws SQLException, IOException
     {
          statement4=(Statement)Server_HomepageController.databaseConnection.createStatement();
       
       
        String query="select * from "+questiontable;
        ResultSet rs=statement4.executeQuery(query);
        
        while(rs.next())
        {
           String qid=rs.getString("ID");
           String ques=rs.getString("QuestionBody");
           String op1=rs.getString("Option1");
           String op2=rs.getString("Option2");
           String op3=rs.getString("Option3");
           String op4=rs.getString("Option4");
           String corAns=rs.getString("CorrectAnswer");
            
            
           QuestionDatabase qdb=new QuestionDatabase(qid, ques, op1, op2, op3, op4, corAns);
            System.out.println(qdb);
            AllQuestion.add(qdb);
            System.out.println("hi");
            System.out.println(AllQuestion.size());
            //d_CorrectAnswer.put(qid,corAns);
           
        }
         System.out.println("now server sent all qes");
         System.out.println(AllQuestion.size());
         if(sio==null)
                 {
                     
                     System.out.println("sio is null ");
                 }
         else 
         {
             sio.SentObjectToClient(AllQuestion);
         }
         
         System.out.println("question send succesfully");
        
     
}
      
      void QuestionInsert(QuestionSet QS) throws SQLException, IOException
      {
           statement7=(Statement)Server_HomepageController.databaseConnection.createStatement();
            System.out.println("data inserting");
            String query=null;
           
           String qid=QS.getQuestionId();
           String ques=QS.getQuestion();
           String op1=QS.getOption1();
           String op2=QS.getOption2();
           String op3=QS.getOption3();
           String op4=QS.getOption4();
           String corAns=QS.getCorrctA();
            
            System.out.println("before query setup");
            if(QS.getCoursename().equalsIgnoreCase("JAVA"))
            {
                 query="insert into javaquestion values('"+qid+"','"+ques+"','"+op1+"','"+op2+"','"+op3+"','"+op4+"','"+corAns+"')";
            }
            else if(QS.getCoursename().equalsIgnoreCase("C++"))
            {
                query="insert into cppquestion values('"+qid+"','"+ques+"','"+op1+"','"+op2+"','"+op3+"','"+op4+"','"+corAns+"')";
            }
            if(query!=null)
            {
            statement7.executeUpdate(query);
            sio.SentToClient("Question Set Successfully");
            }
           
          
      }
     
     public static void ResultInsert(StudentResult stdR) throws SQLException
     {
         statement5=(Statement)Server_HomepageController.databaseConnection.createStatement();
            System.out.println("data inserting");
            String uname=stdR.getUserName();
            String CourseName=stdR.getCourseName();
            String Totalmark=stdR.getTotalMark();
            String trial=stdR.getTry();
            String right=stdR.getRight();
            String wrong=stdR.getWrong();
            String obmark=stdR.getRight();
            String time =stdR.getTime();
            
           
            String query="insert into studentresult values('"+uname+"','"+CourseName+"','"+Totalmark+"','"+trial+"','"+right+"','"+wrong+"','"+obmark+"','"+time+"')";
            statement5.executeUpdate(query);
           
     }
}

