package testfileword.YongBoon;

import Constant.ConsoleColors;
import DataClass.Student;
import DataStructure.HashTableChange;
import DataStructure.HashTableCloseAddressing;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import testfileword.Main;

public class StudentIDHash {

    public StudentIDHash() {
    }

    public void start() {
        // test();

        while (true) {
            Main.clearScreen();
            System.out.println("Hashing --> Yong Boon");
            System.out.println("");
            System.out.println("");
            System.out.println("Press 1 --> Search");
            System.out.println("Press 2 --> View File Content");
            System.out.println("Press 3 --> View with 12 search");
            System.out.println("Press 4 --> HashWithTree");
            System.out.println("Press 5 --> Back");
            System.out.println("");
            System.out.print("Your Selection --> ");
            String input = Main.scan.nextLine();

            if (input.equals("5")) {
                break;
            }

            switch (input) {
                case "1":
                    search();
                    break;
                case "2":
                    viewContent();
                    break;
                case "3":
                    search10();
                    break;
                case "4":
                    hashTreeSearch();
                    break;
            }
        }
    }

    private void readFile(HashTableCloseAddressing<String, Student> studentHash, String file) {
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

    private void readFile(HashTableChange<String, Student> studentHash2, String file) {
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
                    studentHash2.add(s.getStudentID(), s);
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

    private void search() {
        HashTableCloseAddressing<String, Student> studentHash = new HashTableCloseAddressing<>();
        String file = "Student100000s.txt";
        readFile(studentHash, file);

        while (true) {
            Main.clearScreen();

            System.out.print("Please enter Student ID : ");
            String id = Main.scan.nextLine();

            long startTime;
            long estimatedTime;

            startTime = System.nanoTime();
            System.out.println(studentHash.getValue(id));
            estimatedTime = System.nanoTime() - startTime;
            System.out.println("Time Used in Nanoseconds : "
                    + ConsoleColors.YELLOW + estimatedTime + ConsoleColors.RESET);
            System.out.println("Total Number of records : " + studentHash.size());
            System.out.println("-----------------------------------------------------");

            System.out.println("Press 1 To Continue Search");
            System.out.println("Press other To back");
            String input = Main.scan.nextLine();

            if (!input.equals("1")) {
                break;
            }
        }

    }

    private void viewContent() {
        HashTableCloseAddressing<String, Student> studentHash = new HashTableCloseAddressing<>();
        String file = "Student10000.txt";
        readFile(studentHash, file);

        System.out.println(studentHash.printAll());
        System.out.println(studentHash.size());
    }

    private void search10() {
        HashTableCloseAddressing<String, Student> studentHash = new HashTableCloseAddressing<>();
        String file = "Student100000s.txt";
        readFile(studentHash, file);

        while (true) {
            long startTime;
            long estimatedTime;
            long total = 0;

            for (int i = 0; i < 12; i++) {
                startTime = System.nanoTime();
                System.out.println(studentHash.getValue("70373622"));
                estimatedTime = System.nanoTime() - startTime;
                total += estimatedTime;
                System.out.println("Time Used in Nanoseconds : " + ConsoleColors.YELLOW + estimatedTime + ConsoleColors.RESET);
                System.out.println("Total Number of records : " + studentHash.size());
                System.out.println("-----------------------------------------------------");
            }

            System.out.println("Total Time Used : "
                    + ConsoleColors.RED_BOLD + total + ConsoleColors.RESET + " Nanoseconds");

            System.out.println("Press other To back");
            String input = Main.scan.nextLine();

        }
    }

    private void hashTreeSearch() {
        HashTableChange<String, Student> studentHash = new HashTableChange<>();
        String file = "Student100000s.txt";
        readFile(studentHash, file);

        while (true) {
            Main.clearScreen();

            long startTime;
            long estimatedTime;

            System.out.println("Press 1 To Search 1 Time");
            System.out.println("Press 2 To Search 10 Times");
            System.out.println("Press other To back");
            String input = Main.scan.nextLine();

            if (input.equals("1") || input.equals("2")) {
                if (input.equals("1")) {
                    System.out.print("Please enter Student ID : ");
                    String id = Main.scan.nextLine();

                    startTime = System.nanoTime();
                    System.out.println(studentHash.getValue(id));
                    estimatedTime = System.nanoTime() - startTime;
                    System.out.println("Time Used in Nanoseconds : "
                            + ConsoleColors.YELLOW + estimatedTime + ConsoleColors.RESET);
                    System.out.println("Total Number of records : " + studentHash.size());
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Press anything to continue");
                    Main.scan.nextLine();
                }

                if (input.equals("2")) {
                    long total = 0;
                    for (int i = 0; i < 10; i++) {
                        startTime = System.nanoTime();
                        System.out.println(studentHash.getValue("70373622"));
                        estimatedTime = System.nanoTime() - startTime;
                        total += estimatedTime;
                        System.out.println("Time Used in Nanoseconds : "
                                + ConsoleColors.YELLOW + estimatedTime + ConsoleColors.RESET);
                        System.out.println("Total Number of records : " + studentHash.size());
                        System.out.println("-----------------------------------------------------");
                    }
                    System.out.println("Total Time Used : "
                            + ConsoleColors.RED_BOLD + total + ConsoleColors.RESET + " Nanoseconds");
                    System.out.println("Press anything to continue");
                    Main.scan.nextLine();
                }
            } else {
                break;
            }

        }

    }

    private void test() {
        //HashTableLinear<String, Student> studentHash = new HashTableLinear<>();
        System.out.println("HashTableCloseAddressing");
        HashTableCloseAddressing<String, Student> studentHash = new HashTableCloseAddressing<>();
        String file = "Student200000d.txt";
        readFile(studentHash, file);

        long startTime;
        long estimatedTime;

        startTime = System.nanoTime();
        //System.out.println(studentHash);
        System.out.println(studentHash.getValue("19000044"));
        //     System.out.println(studentHash.remove("19000000"));

        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time Used in Nanoseconds : " + estimatedTime);
        System.out.println("Total Number of records : " + studentHash.size());
        System.out.println("-----------------------------------------------------");

        System.out.println("HashTableChange");
        HashTableChange<String, Student> studentHash2 = new HashTableChange<>();
        startTime = System.nanoTime();

        readFile(studentHash2, file);

        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time Used in Nanoseconds : " + estimatedTime);
        System.out.println("Total Number of records : " + studentHash.size());

//        long total1 = 0;
//        for (int i = 0; i < 10; i++) {
//            startTime = System.nanoTime();
//
//            System.out.println(studentHash2.getValue("19000044"));
//
//            estimatedTime = System.nanoTime() - startTime;
//            total1 += estimatedTime;
//            System.out.println("Time Used in Nanoseconds : " + estimatedTime);
//            System.out.println("Total Number of records : " + studentHash.size());
//        }
        System.out.println("-----------------------------------------------------");
        System.out.println("HashTableCloseAddressing");
        HashTableCloseAddressing<String, Student> studentHash3 = new HashTableCloseAddressing<>();
        file = "Student200000d.txt";

        startTime = System.nanoTime();

        readFile(studentHash3, file);

        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time Used in Nanoseconds : " + estimatedTime);
        System.out.println("Total Number of records : " + studentHash.size());

        long total2 = 0;
        for (int i = 0; i < 10; i++) {
            startTime = System.nanoTime();

            //System.out.println(studentHash);
            System.out.println(studentHash.getValue("19000044"));
            //     System.out.println(studentHash.remove("19000000"));
            estimatedTime = System.nanoTime() - startTime;
            total2 += estimatedTime;
            System.out.println("Time Used in Nanoseconds : " + estimatedTime);
            System.out.println("Total Number of records : " + studentHash.size());
        }

        System.out.println("-----------------------------------------------------");

//        System.out.println("Total1 : " + total1);
//        System.out.println("Total2 : " + total2);
    }
}
