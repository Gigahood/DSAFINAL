/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataClass;

import java.util.Objects;

/**
 *
 * @author User
 */
public class Registration {
    private String registrationID;
    private String password;
    private Student student;
    private String registrationStatus;

    public Registration() {
    }

    public Registration(String registrationID, String password, Student student, String registrationStatus) {
        this.registrationID = registrationID;
        this.password = password;
        this.student = student;
        this.registrationStatus = registrationStatus;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        int prime  = 89;
        
        hash = prime * hash + Objects.hashCode(this.registrationID);
        hash = prime * hash + Objects.hashCode(this.password);
        hash = prime * hash + Objects.hashCode(this.student);
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
        final Registration other = (Registration) obj;
        return true;
    }
    
    
}
