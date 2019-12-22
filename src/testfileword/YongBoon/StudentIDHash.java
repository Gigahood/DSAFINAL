package testfileword.YongBoon;

import DataClass.Student;
import DataStructure.HashTableChange;
import DataStructure.HashTableCloseAddressing;
import DataStructure.HashTableLinear;
import DataStructure.LinkedBucket;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StudentIDHash {

    public StudentIDHash() {
    }

    public void start() {
        //HashTableLinear<String, Student> studentHash = new HashTableLinear<>();
        System.out.println("HashTableCloseAddressing");
        HashTableCloseAddressing<String, Student> studentHash = new HashTableCloseAddressing<>();
        long startTime = System.nanoTime();
        String file = "Student200000d.txt";
        
        
        readFile(studentHash, file);
        long estimatedTime = System.nanoTime() - startTime;
        
        //System.out.println(studentHash);
        System.out.println(studentHash.getValue("19000005"));
   //     System.out.println(studentHash.remove("19000000"));
        
        System.out.println("Time Used in Nanoseconds : " + estimatedTime);
        System.out.println("Total Number of records : " + studentHash.size());
        System.out.println("-----------------------------------------------------");

//        HashTableChange<Integer, String> studentHash = new HashTableChange<>(5);
//    
//        studentHash.add(1, "1");
//        studentHash.add(2, "2");
//        studentHash.add(3, "3");
//        studentHash.add(4, "4");
//        studentHash.add(5, "5");
//        
//        System.out.println(studentHash);
//        studentHash.remove(1);
//        studentHash.remove(5);
//        //System.out.println(studentHash.remove(5));
//        System.out.println(studentHash);
        
    }

    private void readFile(HashTableCloseAddressing<String, Student> studentHash , String file) {
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
                    studentHash.add(s.getStudentID(), s);
                    numbering++;
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
