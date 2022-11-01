/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_mcq;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static online_mcq.Starting_code.stage;

/**
 * FXML Controller class
 *
 * @author SAIKAT
 */
public class QuestionSetterController implements Initializable {

    @FXML
    private TextField QS_coursename;
    @FXML
    private TextField questionID;
    @FXML
    private TextArea questionArea;
    @FXML
    private TextField option1;
    @FXML
    private TextField option4;
    @FXML
    private TextField option3;
    @FXML
    private TextField option2;
    @FXML
    private TextField correctAns;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitAction(ActionEvent event) throws IOException, InterruptedException {
        
        String cname=QS_coursename.getText();
        String qid=questionID.getText();
        String ques=questionArea.getText();
        String op1=option1.getText();
        
        String op2=option2.getText();
        String op3=option3.getText();
        String op4=option4.getText();
        String cA=correctAns.getText();
        QuestionSet QS=new QuestionSet(cname, qid, ques, op1, op2, op3, op4, cA);
        ClientConnection.SentObject(QS);
        String msg=ClientConnection.ReadMsg();
        if(msg.equals("Question Set Successfully"))
        {
            label.setText(msg);
            
        }
        else
        {
            label.setText("Question Set Failed");
        }
      
        
        
        
    }

    @FXML
    private void HomeAction(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
    }
    
}
