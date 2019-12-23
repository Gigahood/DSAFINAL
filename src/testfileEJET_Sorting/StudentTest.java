package testfileEJET_Sorting;

import DataClass.*;
import DataStructure.MyArrayList;
import java.util.Objects;

public class StudentTest implements Comparable <StudentTest>  {
    private String studentID;
    private String password;
    private String firstName;
    private String lastName;
    private String ic;
    private double cgppa;

    public StudentTest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public StudentTest(String studentID, String firstName, String lastName, String ic, double cgppa, String password) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ic = ic;
        this.cgppa = cgppa;
        this.password = password;
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

        str += String.format("%-15s %-10s %-15s %-15s %-20s %-5s",
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
        final StudentTest other = (StudentTest) obj;
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

    @Override
    public int compareTo(StudentTest o) {
        return studentID.compareTo(o.studentID);
        }
    
//    public int compareFirstName(StudentTest o){
//        int returnVal = -1;
//        if (firstName.compareTo(o.firstName) >0 || firstName.compareTo(o.firstName) <0){
//            returnVal = firstName.compareTo(o.firstName);
//        }
//        else if (firstName.compareTo(o.firstName) == 0){
//            returnVal = compareTo(o);
//        }
//        return returnVal;
//    }
//    
//    public int compareIC(StudentTest o){
//        int returnVal = -1;
//        if (ic.compareTo(o.ic) >0 || ic.compareTo(o.ic) <0){
//            returnVal = ic.compareTo(o.ic);
//        }
//        else if (ic.compareTo(o.ic) == 0){
//            returnVal = compareTo(o);
//        }
//        return returnVal;
//    }
//    
//    public int compareCGPA(StudentTest o){
//        int returnVal = -1;
//        if (cgppa <= o.cgppa){
//            returnVal = -1;
//        }
//        else if (cgppa >= o.cgppa){
//           returnVal = 1;
//        }
//        else if (cgppa == o.cgppa){
//            returnVal = compareTo(o);
//        }
//        return returnVal;
//    }
   
}
