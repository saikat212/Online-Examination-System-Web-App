/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_mcq;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author SAIKAT
 */
public class QuestionSet implements Serializable{
    String coursename,questionId,question,option1,option2,option3,option4,corrctA;

    public QuestionSet(String coursename, String questionId, String question, String option1, String option2, String option3, String option4, String corrctA) {
        this.coursename = coursename;
        this.questionId = questionId;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.corrctA = corrctA;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
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

    public void setCorrctA(String corrctA) {
        this.corrctA = corrctA;
    }

    public String getCoursename() {
        return coursename;
    }

    public String getQuestionId() {
        return questionId;
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

    public String getCorrctA() {
        return corrctA;
    }

    @Override
    public String toString() {
        return "QuestionSet{" + "coursename=" + coursename + ", questionId=" + questionId + ", question=" + question + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", corrctA=" + corrctA + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final QuestionSet other = (QuestionSet) obj;
        if (!Objects.equals(this.coursename, other.coursename)) {
            return false;
        }
        if (!Objects.equals(this.questionId, other.questionId)) {
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
        if (!Objects.equals(this.corrctA, other.corrctA)) {
            return false;
        }
        return true;
    }
    
    
}
