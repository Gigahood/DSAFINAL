/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfileword.Yien;

import DataClass.Student;
import DataStructure.DuplicateSet;
import DataStructure.HashTableCloseAddressing;
import DataStructure.HashTableLinear;
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

    public Duplicate() {
        printList();
    }

    public void printList() {

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

//        System.out.println(s.getStudentID());
//        System.out.println(s.toString1());
//        System.out.println(set.get(0));
//        System.out.println(set.searchID("19001"));
//        long startTime = System.nanoTime();
//        
//        //System.out.println(set.checkUniqueID());
//        //System.out.println(set.searchIC("990102"));
//        long estimatedTime = System.nanoTime() - startTime;
//        System.out.println("Time Used in Nanoseconds : " + estimatedTime);
//        
//        Set duplicate = set.getDuplicate();
//        //set.union(set);
//        
        // System.out.println(set);
//        System.out.println(duplicate);
        db.loadData();
        Set<Student> s = new DataStructure.DuplicateSet<Student>();
//        HashTableLinear<String, Student> a = new HashTableLinear<>();
//        
//        for (int i=0; i<db.studentArrayList.size(); i++){
//            a.add(db.studentArrayList.get(i).getStudentID(),db.studentArrayList.get(i) );
//           // System.out.println(s);
//        }
//        
//        System.out.println(a.size());
//        
//        System.out.println(s);
        // System.out.println(s.size());
//        for (int i=0; i<db.studentArrayList.size(); i++){
//            
//            System.out.println(db.studentArrayList.get(i));
//        }
    }

    public void testing() {

        Set<Student> set = new DuplicateSet<Student>();
        set.add(new Student("19001", "Lim", "Yi En", "990102"));
        set.add(new Student("19001", "Lim", "Yi En", "990122"));
        set.add(new Student("19001", "Lim", "Yi En", "990102"));
        set.add(new Student("19001", "Lim", "Yi En", "990102"));
        set.add(new Student("19001", "Lim", "Yi En", "990102"));
        set.add(new Student("19001", "Tan", "Yi En", "990102"));
        set.add(new Student("19001", "Liew", "Yi En", "990102"));
        set.add(new Student("11001", "Liew", "Yi En", "990102"));

        db.loadData();
        Set<Student> s = new DataStructure.DuplicateSet<Student>();
        for (int i = 0; i < db.studentArrayList.size(); i++) {
            s.add(db.studentArrayList.get(i));

        }

        System.out.format("%-3s %-15s %-20s %-15s %-16s %-5s %-5s",
                "", "Id", "Name", "Ic", "Pass", "Cgpa", "No. of Duplicate");

        System.out.println("");
        System.out.println(s);

        System.out.println("Total: " + s.size() + 1 + "\t " + "Duplicate ID: ");

    }

    public void header() {
        System.out.format("%-3s %-15s %-20s %-15s %-16s %-5s %-5s",
                "", "Id", "Name", "Ic", "Pass", "Cgpa", "No. of Duplicate\n");
    }

    public void searchUI(int index) {
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
            } 
            else{
                Main.clearScreen();
                printList();
                break;
            }
        }
    }

    public void validateDuplicate(String input) {
        String s = "";
        System.out.println("Search for" + input);
        Set<Student> set = new DuplicateSet<Student>();

        if (set.hasDuplicate(input)) {
            s = "Has Duplicate";
            System.out.println("Result:" + s);
        } else {
            s = "Unique";
            System.out.println("Result:" + s);
        }
    }

    public void searchID() {
        Set<Student> set = new DuplicateSet<Student>();
        set.add(new Student("19001", "Lim", "Yi En", "990102"));
        set.add(new Student("19001", "Lim", "Yi En", "9901112"));

        set.add(new Student("11001", "Liew", "Yi En", "990102"));

        System.out.println("***************** Search Duplicate ID ********************");
        System.out.print("Key in ID : ");
        String input = scanner.nextLine();

        validateDuplicate(input);
        header();
        System.out.println(set.searchID(input));
    }

    public void searchName() {
        Set<Student> set = new DuplicateSet<Student>();

        System.out.println("***************** Search Duplicate Name ********************");
        System.out.print("Key in First Name : ");
        String f = scanner.nextLine();
        System.out.print("Key in Last Name : ");
        String l = scanner.nextLine();

        validateDuplicate(l);
        header();
        System.out.println(set.searchName(f, l));
    }

    public void searchIC() {
        Set<Student> set = new DuplicateSet<Student>();

        System.out.println("***************** Search Duplicate IC ********************");
        System.out.print("Key in IC : ");
        String input = scanner.nextLine();

        validateDuplicate(input);
        header();
        System.out.println(set.searchIC(input));
    }

}
