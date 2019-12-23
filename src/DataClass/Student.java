package DataClass;

import java.util.Objects;

public class Student implements Comparable<Student> {

    private String studentID;
    private String password;
    private String firstName;
    private String lastName;
    private String ic;
    private double cgppa;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String studentID, String firstName, String lastName, String ic, double cgppa, String password) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ic = ic;
        this.cgppa = cgppa;
        this.password = password;
    }
    
    public Student(String studentID, String firstName, String lastName, String ic) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ic = ic;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public double getCgppa() {
        return cgppa;
    }

    public void setCgppa(double cgppa) {
        this.cgppa = cgppa;
    }

    // this will cause overflow and the result will become negative if it is 
    // a String
    @Override
    public String toString() {
        String str = "";

        str += String.format("%-15s %-5s %-15s %-15s %-20s %-5s", 
                this.studentID, this.firstName, 
                this.lastName, this.ic, this.password, this.cgppa);

        return str;
    }
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        int prime = 83;
        hash = prime * hash + Objects.hashCode(this.studentID);
        hash = prime * hash + Objects.hashCode(this.firstName);
        hash = prime * hash + Objects.hashCode(this.lastName);
        hash = prime * hash + Objects.hashCode(this.ic);
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
        final Student other = (Student) obj;
        if (!Objects.equals(this.studentID, other.studentID)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.ic, other.ic)) {
            return false;
        }
        return true;
    }
    
     public boolean equalID(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.studentID, other.studentID)) {
            return false;
        }
  
        return true;
    }

    @Override
    public int compareTo(Student o) {        
        return studentID.compareTo(o.studentID);
    }

}
