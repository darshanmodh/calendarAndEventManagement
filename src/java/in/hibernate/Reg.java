package in.hibernate;
// Generated Apr 1, 2013 8:20:25 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Reg generated by hbm2java
 */
public class Reg  implements java.io.Serializable {


     private String uname;
     private String fname;
     private String lname;
     private String pass;
     private String cpass;
     private String email;
     private String bday;
     private Set userEvents = new HashSet(0);

    public Reg() {
    }

	
    public Reg(String uname, String fname, String lname, String pass, String cpass, String email, String bday) {
        this.uname = uname;
        this.fname = fname;
        this.lname = lname;
        this.pass = pass;
        this.cpass = cpass;
        this.email = email;
        this.bday = bday;
    }
    public Reg(String uname, String fname, String lname, String pass, String cpass, String email, String bday, Set userEvents) {
       this.uname = uname;
       this.fname = fname;
       this.lname = lname;
       this.pass = pass;
       this.cpass = cpass;
       this.email = email;
       this.bday = bday;
       this.userEvents = userEvents;
    }
   
    public String getUname() {
        return this.uname;
    }
    
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getFname() {
        return this.fname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return this.lname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getCpass() {
        return this.cpass;
    }
    
    public void setCpass(String cpass) {
        this.cpass = cpass;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getBday() {
        return this.bday;
    }
    
    public void setBday(String bday) {
        this.bday = bday;
    }
    public Set getUserEvents() {
        return this.userEvents;
    }
    
    public void setUserEvents(Set userEvents) {
        this.userEvents = userEvents;
    }




}

