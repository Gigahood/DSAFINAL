package testfileword.YongBoon;

import DataClass.Student;
import DataStructure.HashTableLinear;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StudentIDHash {

    public StudentIDHash() {
    }

    public void start() {
        HashTableLinear<String, Student> studentHash = new HashTableLinear<>();
        long startTime = System.nanoTime();
        String file = "Student100000.txt";
        
        
        readFile(studentHash, file);
        long estimatedTime = System.nanoTime() - startTime;
        
        studentHash.getValue("2");
        
        System.out.println("Time Used in Nanoseconds : " + estimatedTime);
      // System.out.println(studentHash);
//
////        Student s = new Student("123", "1234");
////        s.setStudentID("111231218");
////        Student s2 = new Student("123", "1234");
////        s2.setStudentID("5");
//        System.out.println("-------------------------------");
////        studentHash.add(s.getStudentID(), s);
       // studentHash.remove("19000003");
        //studentHash.getValue("19000003");
////        studentHash.add(s2.getStudentID(), s2);
////        System.out.println("After add Student : ");
////        System.out.println(studentHash);
//        System.out.println("-------------------------------");
//
//        System.out.println("");
        System.out.println("Total Number of records : " + studentHash.size());
//        System.out.println("Press enter to continue");
//        Main.scan.nextLine();
    }

    private void readFile(HashTableLinear<String, Student> studentHash, String file) {
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
