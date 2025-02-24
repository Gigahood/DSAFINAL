package testfileword;

import Constant.ConsoleColors;
import java.util.Scanner;
import testfileword.Yien.Duplicate;
import testfileEJET_Sorting.Sorting;
import static testfileword.Yien.Duplicate.db;
import testfileword.YongBoon.Indexing;
import testfileword.YongBoon.StudentIDHash;

public class Main {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        db.loadData();
        start();

//        WriteFile wf = new WriteFile();
//        wf.start();
//        testForHash();
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
                if (checkInputMenu(2, input)) {
                    break;
                }
            } // Menu UI End

            if (input.equals("2")) {
                break;
            } // end the program

            switch (input) {
//                case "1":
////                    WriteFile wf = new WriteFile();
////                    wf.start();
              //      break; // Go to Write File
                case "1":
                    readFile();
                    break; // Go to Read File
            }
        } // Main logic End
    }

    private static void menuUI() {
        System.out.println("1. Enter Data To File");
        //System.out.println("2. Read Data From File");
        System.out.println("2. Exit");
        System.out.println("");
        System.out.print("Your Selection --> ");
    }

    private static void readFileUI() {
        clearScreen();
        System.out.println("Select 1 of the People Module : ");
        System.out.println("1. Yong Boon --> Indexing");
        System.out.println("2. Yi En --> Duplicate");
        System.out.println("3. E Jet --> Sorting");
//        System.out.println("4. Man Quan --> ");
        System.out.println("4. Return");
        System.out.println("");
        System.out.print("Your Selection --> ");
    }

    private static void readFile() {
        String input;

        while (true) {
            while (true) {
                readFileUI();

                input = scan.nextLine();
                if (checkInputMenu(4, input)) {
                    break;
                }
            }// end Selection UI

            if (input.equals("4")) {
                break;
            }

            switch (input) {
                case "1":
                    Indexing index = new Indexing();
                    index.start();
                    break;
                case "2":
                    clearScreen();
                            
                    Duplicate set = new Duplicate();
                    
                    set.printList();
                    
                    break;
                case "3":
                    Sorting sort = new Sorting();
                    sort.start();
                    break;
//                case "4":
//                    break;
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
