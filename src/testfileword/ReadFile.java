package testfileword;

import DataStructure.HashTableLinear;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public void start() {
        //readFile();
    }

//    public void readFile(HashTableLinear<String, OldStudent> a) {
//        // The name of the file to open.
//        String fileName = "filename.txt";
//
//        // This will reference one line at a time
//        String line = null;
//
//        try {
//            // FileReader reads text files in the default encoding.
//            FileReader fileReader
//                    = new FileReader(fileName);
//
//            // Always wrap FileReader in BufferedReader.
//            BufferedReader bufferedReader
//                    = new BufferedReader(fileReader);
//
//            while ((line = bufferedReader.readLine()) != null) {
//                
//                String[] assetClasses = line.split(",");
//                
//                OldStudent s = new OldStudent(assetClasses[0], assetClasses[1]);
//                s.setStudentID();
//                a.add(s.getStudentID(), s);
//            }
//
//            // Always close files.
//            bufferedReader.close();
//        } catch (FileNotFoundException ex) {
//            System.out.println(
//                    "Unable to open file '"
//                    + fileName + "'");
//        } catch (IOException ex) {
//            System.out.println(
//                    "Error reading file '"
//                    + fileName + "'");
//            // Or we could just do this: 
//            // ex.printStackTrace();
//        }
//    }
}
