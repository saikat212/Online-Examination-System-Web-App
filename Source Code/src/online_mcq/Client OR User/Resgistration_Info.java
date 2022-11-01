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
public class Resgistration_Info implements Serializable{
    String fullname,email,inst,username,password,type;

    public Resgistration_Info(String fullname, String email, String inst, String username, String password,String type) {
        this.fullname = fullname;
        this.email = email;
        this.inst = inst;
        this.username = username;
        this.password = password;
        this.type=type;
    }

    public void setType(String type) {
        this.type = type;
    }
     public String getType() {
        return type;
    }

    public Resgistration_Info() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInst(String inst) {
        this.inst = inst;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getInst() {
        return inst;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Resgistration_Info{" + "fullname=" + fullname + ", email=" + email + ", inst=" + inst + ", username=" + username + ", password=" + password + ", type=" + type + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Resgistration_Info other = (Resgistration_Info) obj;
        if (!Objects.equals(this.fullname, other.fullname)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.inst, other.inst)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

   

  
    
   
}
