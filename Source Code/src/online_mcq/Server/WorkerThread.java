/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_mcq.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import online_mcq.QuestionSet;
import online_mcq.StudentLoginData;
import online_mcq.Resgistration_Info;
import online_mcq.StudentResult;

/**
 *
 * @author SAIKAT
 */
class WorkerThread implements Runnable {

    DataInputStream dis;
    DataOutputStream dos;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    Socket ServerSideSocket;
    int id;

    public WorkerThread(Socket s, int id) throws SQLException {
        // RegisterList rl=new RegisterList();
        ServerSideSocket = s;
        this.id = id;

    }

    @Override
    public void run() {

        try {
            dis = new DataInputStream(ServerSideSocket.getInputStream());
            dos = new DataOutputStream(ServerSideSocket.getOutputStream());
            ois = new ObjectInputStream(ServerSideSocket.getInputStream());
            oos = new ObjectOutputStream(ServerSideSocket.getOutputStream());

            while (true) {
                ServerInputOutput sio = new ServerInputOutput(dis, dos, ois, oos);
                DatabaseAction db = new DatabaseAction();
                DatabaseAction dba = new DatabaseAction(sio);

                Object obj = ois.readObject();

                if (obj.equals(null)) {
                    continue;
                }

                if (!(obj.equals(null))) {

                    if (obj instanceof StudentLoginData) {

                        StudentLoginData SLD = (StudentLoginData) obj;
                        ServerActivity.store(id + "-th User" + "::UserName:->" + SLD.getUsername() + ". Sent a Login Request.");
                        LoginRequestHandler LRH = new LoginRequestHandler(sio, id);
                        LRH.Action(SLD);

                    } else if (obj instanceof Resgistration_Info) {

                        Resgistration_Info RIN = (Resgistration_Info) obj;
                        ServerActivity.store(id + "-th User" + "::UserName:->" + RIN.getUsername() + ".Sent a Sign Up Request.");
                        RegistrationRequestHandler RRH = new RegistrationRequestHandler(sio, id);

                        RRH.Action(RIN);

                    } else if (obj instanceof StudentResult) {

                        StudentResult sr = (StudentResult) obj;
                        ServerActivity.store(id + "-th User" + "::UserName:->" + sr.getUserName() + " .Request to see his exam Result.");
                        DatabaseAction.ResultInsert(sr);
                        //marking apply here
                    } else if (obj instanceof QuestionSet) {
                        QuestionSet QS = (QuestionSet) obj;
                        ServerActivity.store("Teacher Sent a Question Of " + QS.getCoursename() + " Topics to set");
                        dba.QuestionInsert(QS);
                        
                        
                    } else if (obj instanceof String) {

                        String msg = (String) obj;

                        if (msg.charAt(0) == 'S') {
                            String uname = msg.substring(3);
                             ServerActivity.store(id+"-::UserName:->"+uname+". Request to see his profile.");
                            dba.ProvideProfileOf(uname);

                        } else if (msg.charAt(0) == 'E') {
                            
                            String course = msg.substring(3);
                            if (course.equals("JAVA")) {
                                
                                ServerActivity.store("Start Examination on JAVA");
                                dba.QuestionSendingFrom("javaquestion");
                                

                            } else if (course.equals("C++")) {
                                ServerActivity.store("Start Examination on C++");
                                dba.QuestionSendingFrom("cppquestion");
                            }
                        } else if (msg.charAt(0) == 'R') {
//                     String studentName=msg.substring(3);
//                     DatabaseAction.ProvideResultOf(studentName);

                        } else if (msg.charAt(0) == 'A') {
                            String str = msg.substring(2);
                            File file = new File("AdminInfo.txt");
                            if (!(file.exists())) {
                                file.createNewFile();
                            }
                            Scanner in = new Scanner(file);
                            String str1 = "";
                            while (in.hasNext()) {
                                str1 = str1 + in.nextLine();
                            }
                            if (str.equals(str1)) {
                                ServerActivity.store("Teacher successfully login");
                                dos.writeUTF("Admin Login Successful");
                                dos.flush();
                            } else {
                                ServerActivity.store("Teacher fail to login");
                                dos.writeUTF("!!Login Failed.Incorrect Information!!");
                                dos.flush();
                            }

                        }

                    }

                }

            }

        } catch (IOException ex) {
            Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
