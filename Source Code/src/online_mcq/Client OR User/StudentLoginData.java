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
public class StudentLoginData implements Serializable{
    String username;
    String password;
   

    public StudentLoginData(String username, String password) {
        this.username = username;
        this.password = password;
      
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
  
   

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
 
    @Override
    public String toString() {
        return super.toString();
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
        final StudentLoginData other = (StudentLoginData) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
       
        return true;
    }
              
    
    
}
