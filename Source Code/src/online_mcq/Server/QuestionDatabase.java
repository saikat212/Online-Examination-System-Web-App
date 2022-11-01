/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_mcq.Server;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author SAIKAT
 */
public class QuestionDatabase implements Serializable{
    
    String QID,question,option1,option2,option3,option4,correctAns;

    public QuestionDatabase(String QID, String question, String option1, String option2, String option3, String option4, String correctAns) {
        this.QID = QID;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAns = correctAns;
    }

    public void setQID(String QID) {
        this.QID = QID;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public String getQID() {
        return QID;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    @Override
    public String toString() {
        return "QuestionDatabase{" + "QID=" + QID + ", question=" + question + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", correctAns=" + correctAns + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QuestionDatabase other = (QuestionDatabase) obj;
        if (!Objects.equals(this.QID, other.QID)) {
            return false;
        }
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        if (!Objects.equals(this.option1, other.option1)) {
            return false;
        }
        if (!Objects.equals(this.option2, other.option2)) {
            return false;
        }
        if (!Objects.equals(this.option3, other.option3)) {
            return false;
        }
        if (!Objects.equals(this.option4, other.option4)) {
            return false;
        }
        if (!Objects.equals(this.correctAns, other.correctAns)) {
            return false;
        }
        return true;
    }
    
    
  
    
    
}
