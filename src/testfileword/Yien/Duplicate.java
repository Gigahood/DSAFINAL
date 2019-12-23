/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfileword.Yien;

import Constant.ConsoleColors;
import DataClass.Student;
import DataStructure.DuplicateSet;
import DataStructure.Set;
import java.util.Scanner;
import testfileword.Database;
import testfileword.Main;

/**
 *
 * @author User
 */
public class Duplicate {

    public static Database db = new Database();
    public static Scanner scanner = new Scanner(System.in);

    public void printList() {
        // db.loadData();
        System.out.println("Duplicate Check Session");
        System.out.println("1. Overall Result");
        System.out.println("2. SearchID");
        System.out.println("3. SearchName");
        System.out.println("4. SearchIc");
        System.out.println("5. Back");
        System.out.print("-->");
        int input = Main.scan.nextInt();

        switch (input) {
            case 1:
                Main.clearScreen();
                testing();
                break;
            case 2:
                Main.clearScreen();
                searchID();
                searchUI(2);
                break;
            case 3:
                Main.clearScreen();
                searchName();
                searchUI(3);
                break;
            case 4:
                Main.clearScreen();
                searchIC();
                searchUI(4);
                break;
            case 5:
                break;
        }

    }

    public void testing() {

        //  db.loadData();
        DuplicateSet<Student> s = new DuplicateSet<Student>();

        Set<Student> s2 = new DuplicateSet<Student>();
        Set<Student> s3 = new DuplicateSet<Student>();
        Set<Student> s4 = new DuplicateSet<Student>();

        for (int i = 0; i < db.studentArrayList.size(); i++) {
            s.add(db.studentArrayList.get(i));

        }

        s2 = s.checkUniqueID();

        System.out.println(s.checkUniqueName());

        s3 = s.checkUniqueName();
        s4 = s.checkUniqueIC();

        System.out.format("%-3s %-15s %-20s %-15s %-16s %-5s %-5s",
                "", "Id", "Name", "Ic", "Pass", "Cgpa", "No. of Duplicate");

        System.out.println("");
        System.out.println(s);

        System.out.println("Original total with duplicate data: " + db.studentArrayList.size());
        System.out.println("Total: " + s.size() + "\t " + "Total Duplicate ID: " + (s.size() - s2.size()) + "\t "
                + "Total Duplicate Name: " + (s.size() - s3.size()) + "\t "
                + "Total Duplicate IC: " + (s.size() - s4.size()));
        scanner.nextLine();

    }

    private void header() {
        System.out.format("%-3s %-15s %-20s %-15s %-16s %-5s %-5s",
                "", "Id", "Name", "Ic", "Pass", "Cgpa", "No. of Duplicate\n");
    }

    private void searchUI(int index) {
        String choice;
        while (true) {
            while (true) {
                System.out.println("1. Search another student.      2. Return Back To Menu");
                System.out.print("--> ");
                choice = scanner.nextLine();
                if (Main.checkInputMenu(2, choice)) {
                    break;
                }
            }
            if (choice.equals("1")) {
                if (index == 2) {
                    Main.clearScreen();
                    searchID();
                } else if (index == 3) {
                    Main.clearScreen();
                    searchName();
                } else if (index == 4) {
                    Main.clearScreen();
                    searchIC();
                }
            } else {
                Main.clearScreen();
                printList();
                break;
            }
        }
    }

    private void validateDuplicate(String input, Set<Student> set) {
        String s = "";
        System.out.println("Search for " + input);
        // Set<Student> set = new DuplicateSet<Student>();

        if (set.size() == 0) {
            System.out.println(ConsoleColors.RED_BOLD + "The " + input + "is not exist"
                    + ConsoleColors.RESET);
        } else {
            if (set.checkDuplicateValue()) {
                 s = "Has Duplicate";
                System.out.println("Result:" + ConsoleColors.RED_BOLD + s + ConsoleColors.RESET);

            } else {
                s = "Unique";
                System.out.println("Result:" + ConsoleColors.RED_BOLD + s + ConsoleColors.RESET);
            }
        }
    }

    public void searchID() {
//        Set<Student> set = new DuplicateSet<Student>();

        DuplicateSet<Student> s = new DuplicateSet<Student>();
        Set<Student> s2 = new DuplicateSet<Student>();

        for (int i = 0; i < db.studentArrayList.size(); i++) {
            s.add(db.studentArrayList.get(i));

        }
        System.out.println("***************** Search Duplicate ID ********************");
        System.out.print("Key in ID : ");
        String input = scanner.nextLine();

        s2 = s.searchID(input);

        validateDuplicate(input, s2);
        header();
        System.out.println(s2);
    }

    public void searchName() {
        DuplicateSet<Student> set = new DuplicateSet<Student>();

        System.out.println("***************** Search Duplicate Name ********************");
        System.out.print("Key in First Name : ");
        String f = scanner.nextLine();
        System.out.print("Key in Last Name : ");
        String l = scanner.nextLine();

        validateDuplicate(l, set);
        header();
        System.out.println(set.searchName(f, l));
    }

    public void searchIC() {
        DuplicateSet<Student> set = new DuplicateSet<Student>();

        for (int i = 0; i < db.studentArrayList.size(); i++) {
            set.add(db.studentArrayList.get(i));

        }

        System.out.println("***************** Search Duplicate IC ********************");
        System.out.print("Key in IC : ");
        String input = scanner.nextLine();

//        validateDuplicate(input, s);
//        header();
//        System.out.println(set.searchIC(input));
    }

}
//set.add(new Student("19001", "Lim", "Yi En", "990102"));
//        set.add(new Student("19001", "Lim", "Yi En", "990122"));
//        set.add(new Student("19001", "Lim", "Yi En", "990102"));
//        set.add(new Student("19001", "Lim", "Yi En", "990102"));
//        set.add(new Student("19001", "Lim", "Yi En", "990102"));
//        set.add(new Student("19001", "Tan", "Yi En", "990102"));
//        set.add(new Student("19001", "Liew", "Yi En", "990102"));
//        set.add(new Student("11001", "Liew", "Yi En", "990102"));
