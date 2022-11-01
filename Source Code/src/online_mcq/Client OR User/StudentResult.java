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
public class StudentResult implements Serializable{
    String UserName,CourseName,TotalMark,Try,Right,Wrong,obMark,Time;

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
        final StudentResult other = (StudentResult) obj;
        if (!Objects.equals(this.UserName, other.UserName)) {
            return false;
        }
        if (!Objects.equals(this.CourseName, other.CourseName)) {
            return false;
        }
        if (!Objects.equals(this.TotalMark, other.TotalMark)) {
            return false;
        }
        if (!Objects.equals(this.Try, other.Try)) {
            return false;
        }
        if (!Objects.equals(this.Right, other.Right)) {
            return false;
        }
        if (!Objects.equals(this.Wrong, other.Wrong)) {
            return false;
        }
        if (!Objects.equals(this.obMark, other.obMark)) {
            return false;
        }
        if (!Objects.equals(this.Time, other.Time)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StudentResult{" + "UserName=" + UserName + ", CourseName=" + CourseName + ", TotalMark=" + TotalMark + ", Try=" + Try + ", Right=" + Right + ", Wrong=" + Wrong + ", obMark=" + obMark + ", Time=" + Time + '}';
    }

    public String getUserName() {
        return UserName;
    }

    public String getCourseName() {
        return CourseName;
    }

    public String getTotalMark() {
        return TotalMark;
    }

    public String getTry() {
        return Try;
    }

    public String getRight() {
        return Right;
    }

    public String getWrong() {
        return Wrong;
    }

    public String getObMark() {
        return obMark;
    }

    public String getTime() {
        return Time;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public void setTotalMark(String TotalMark) {
        this.TotalMark = TotalMark;
    }

    public void setTry(String Try) {
        this.Try = Try;
    }

    public void setRight(String Right) {
        this.Right = Right;
    }

    public void setWrong(String Wrong) {
        this.Wrong = Wrong;
    }

    public void setObMark(String obMark) {
        this.obMark = obMark;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public StudentResult(String UserName, String CourseName, String TotalMark, String Try, String Right, String Wrong, String obMark, String Time) {
        this.UserName = UserName;
        this.CourseName = CourseName;
        this.TotalMark = TotalMark;
        this.Try = Try;
        this.Right = Right;
        this.Wrong = Wrong;
        this.obMark = obMark;
        this.Time = Time;
    }

   
    
    
}
