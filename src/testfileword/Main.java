package testfileword;

import Constant.ConsoleColors;
import DataClass.Student;
import DataStructure.HashTableCloseAddressing;
import java.util.Scanner;
import testfileword.YongBoon.Indexing;
import testfileword.YongBoon.StudentIDHash;

public class Main {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        //start();
        Database db = new Database();
        db.loadData();
        
       
//        StudentIDHash as = new StudentIDHash();
//        as.start();
        //test();
//        WriteFile wf = new WriteFile();
//        wf.start();
        //testForHash();
       // testHash2();
    }

    private static void testHash2() {
        HashTableCloseAddressing<Integer, String> hs = new HashTableCloseAddressing<>(10);
        
        hs.add(1, "1");
        hs.add(3, "3");
        hs.add(2, "2");
        hs.add(2, "5");
        
        for (int i = 0; i < 20; i++) {
            hs.add(i, (i + ""));
        }
        
        
        System.out.println(hs.printAll());
        System.out.println(hs.size());
        
        //System.out.println(hs);
        
    }

    private static void testForHash() {
        StudentIDHash hs = new StudentIDHash();
        hs.start();
    }

    private static void start() {
        String input;
        while (true) {
            while (true) {
                System.out.println("Please enter 1 of the following : ");
                menuUI();

                input = scan.nextLine();
                if (checkInputMenu(3, input)) {
                    break;
                }
            } // Menu UI End

            if (input.equals("3")) {
                break;
            } // end the program

            switch (input) {
                case "1":
                    WriteFile wf = new WriteFile();
                    wf.start();
                    break; // Go to Write File
                case "2":
                    readFile();
                    break; // Go to Read File
            }
        } // Main logic End
    }

    private static void menuUI() {
        System.out.println("1. Enter Data To File");
        System.out.println("2. Read Data From File");
        System.out.println("3. Exit");
        System.out.println("");
        System.out.print("Your Selection --> ");
    }

    private static void readFileUI() {
        clearScreen();
        System.out.println("Select 1 of the People Module : ");
        System.out.println("1. Yong Boon --> Indexing");
        System.out.println("2. Yi En --> Duplicate");
        System.out.println("3. E Jet --> ");
        System.out.println("4. Man Quan --> ");
        System.out.println("5. Return");
        System.out.println("");
        System.out.print("Your Selection --> ");
    }

    private static void readFile() {
        String input;

        while (true) {
            while (true) {
                readFileUI();

                input = scan.nextLine();
                if (checkInputMenu(5, input)) {
                    break;
                }
            }// end Selection UI

            if (input.equals("5")) {
                break;
            }

            switch (input) {
                case "1":
                    Indexing index = new Indexing();
                    index.start();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
            }
        }
    }

    public static boolean checkInputMenu(int limit, String input) {
        if (input.isEmpty()) {
            System.out.println("");
            System.out.println(ConsoleColors.RED_BOLD + "Cannot be empty field!" + ConsoleColors.RESET);
            System.out.println("Press Enter To Continue");
            scan.nextLine();
            clearScreen();
            return false;
        }

        try {
            int inputInt = Integer.parseInt(input);
            boolean valid = ((inputInt >= 1 && inputInt <= limit));

            if (!valid) {
                System.out.println("");
                System.out.println(ConsoleColors.BLUE_BOLD + "INVALID INPUT! Please key in number within range!!" + ConsoleColors.RESET);
                System.out.println("Press Enter To Continue");
                scan.nextLine();
                clearScreen();
            }

            return valid;
        } catch (Exception e) {
            System.out.println("");
            System.out.println(ConsoleColors.BLUE_BOLD + "INVALID INPUT! Please key in number." + ConsoleColors.RESET);
            System.out.println("Press Enter To Continue");
            scan.nextLine();
            clearScreen();
            return false;
        }
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }

}
