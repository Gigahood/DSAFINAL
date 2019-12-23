/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfileword;

import DataClass.Student;
import DataStructure.HashTableLinear;
import DataStructure.MyArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author User
 */
public class Database {
    public MyArrayList<Student> studentArrayList = new MyArrayList<Student>();
    
    public void loadData() {
//        load20StudentData();
//        System.out.println(studentArrayList.size());
//        load150StudentData();
//        System.out.println(studentArrayList.size());
//        load200dStudentData();
//        System.out.println(studentArrayList.size());
        loadYiEnSpecialData();
        System.out.println(studentArrayList.size());
//        load1000StudentData();
//        System.out.println(studentArrayList.size());
//        load10000StudentData();
//        System.out.println(studentArrayList.size());
//        load100000StudentData();

//        System.out.println(studentArrayList.size());
//        load200000dStudentData();

//        System.out.println(studentArrayList.size());
//        
//        load200000dStudentData();
//        System.out.println(studentArrayList.size());
//        load100000sStudentData();
//        System.out.println(studentArrayList.size());
//        load1000000StudentData();
//        System.out.println(studentArrayList.size());

        
        
        // Estimate time use below function
//        long startTime = System.nanoTime();
//        long estimatedTime = System.nanoTime() - startTime;
//        
//        Student n = new Student("19999999", "Drah", "Htpq Ugnp", "940526102511", 3.0, "940526102511");
//        
//        // Put your search Function here
//        studentArrayList.get(n);
//        
//        System.out.println("Time Used in Nanoseconds : " + estimatedTime);
    }
    
    private void load20StudentData() {
        String fileName = "Student20.txt";
        readFile(fileName);
    }
    
    private void load150StudentData() {
        String fileName = "Student150.txt";
        readFile(fileName);
    }
    
    private void load200dStudentData() {
        String fileName = "Student200duplicate.txt";
        readFile(fileName);
    }
    
    private void loadYiEnSpecialData() {
        String fileName = "YiEnSpecial.txt";
        readFile(fileName);
    }
    
    private void load1000StudentData() {
        String fileName = "Student1000.txt";
        readFile(fileName);
    }
    
    private void load10000StudentData() {
        String fileName = "Student10000.txt";
        readFile(fileName);
    }
    
    private void load100000StudentData() {
        String fileName = "Student100000.txt";
        readFile(fileName);
    }
    
    private void load100000sStudentData() {
        String fileName = "Student100000s.txt";
        readFile(fileName);
    }
    
    private void load200000dStudentData() {
        String fileName = "Student200000d.txt";
        readFile(fileName);
    }
    
    private void load1000000StudentData() {
        String fileName = "Student1000000.txt";
        readFile(fileName);
    }
    
    private void readFile(String file) {
        // The name of the file to open.
        String fileName = file;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader
                    = new FileReader(fileName);
            int numbering = 0;

            try ( // Always wrap FileReader in BufferedReader.
                    BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while ((line = bufferedReader.readLine()) != null) {
                    String[] assetClasses = line.split(",");
                    Student s = new Student(assetClasses[0],
                            assetClasses[1],
                            assetClasses[2],
                            assetClasses[3],
                            Double.parseDouble(assetClasses[4]),
                            assetClasses[5]);
                    //s.setStudentID("123123");
                    // System.out.println(numbering);
                    //System.out.println(s);
                    studentArrayList.add(s);
                    //numbering++;
                }
                // Always close files.
            }
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
}
