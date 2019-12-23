/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfileEJET_Sorting;

import DataStructure.MyArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import testfileword.Main;

/**
 *
 * @author user
 */
public class Sorting {

    public Sorting() {
    }

    public void start() {
        String input;
        while (true) {
            while (true) {//validation
                Main.clearScreen();
                MenuUI();
                input = Main.scan.nextLine();

                if (Main.checkInputMenu(2, input)) {
                    break;
                }

            }
            if (input.equals("2")) {//return back 
                break;
            }

            switch (input) {
                case "1":
                    studentIDSort();
                    break;
//                case "2":
//
//                    break;
            }

        }
    }

    private void MenuUI() {
        System.out.println("Select The following class type : ");
        System.out.println("1. Student ID");
//        System.out.println("2. Registration ID");
        System.out.println("2. Return");
        System.out.println("");
        System.out.print("Your Selection --> ");
    }

//    private void selectSortType() {
//        sortTypeUI();
//        String input;
//        while (true) {
//            while (true) {
//                Main.clearScreen();
//                MenuUI();
//                input = Main.scan.nextLine();
//
//                if (Main.checkInputMenu(5, input)) {
//                    break;
//                }
//
//            }
//            if (input.equals("5")) {//return back 
//                break;
//            }
//
//            switch (input) {
//                case "1":
//                    break;
//                case "2":
//
//                    break;
//                case "3":
//
//                    break;
//                case "4":
//
//                    break;
//
//            }
//
//        }
//    }
//    private void sortTypeUI() {
//        System.out.println("Select The sorting type : ");
//        System.out.println("1. Sort by Student ID");
//        System.out.println("2. Sort by First name");
//        System.out.println("3. Sort by CGPA");
//        System.out.println("4. Sort by IC");
//        System.out.println("5. Return");
//        System.out.println("");
//        System.out.print("Your Selection --> ");
//    }
    public void readFile(MyArrayList<StudentTest> arrayList, String file) {
        // The name of the file to open.
        String fileName = file;
        // This will reference one line at a time
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            int numbering = 0;
            try ( // Always wrap FileReader in BufferedReader.
                    final BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while ((line = bufferedReader.readLine()) != null) {
                    String[] assetClasses = line.split(",");
                    StudentTest s = new StudentTest(assetClasses[0], assetClasses[1], assetClasses[2], assetClasses[3], Double.parseDouble(assetClasses[4]), assetClasses[5]);
                    arrayList.add(s);
                    numbering++;
                }
                // Always close files.
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    public void studentIDSort() {
        MyLinkedList<StudentTest> studentIDList = new MyLinkedList();
        MyArrayList<StudentTest> arrayList = new MyArrayList();
        long startTime = System.nanoTime();
        String file = "Student10000.txt";
        readFile(arrayList, file);
        long estimatedTimeUnsort = System.nanoTime() - startTime;
        System.out.println("Time Used in Nanoseconds : " + estimatedTimeUnsort);
        System.out.println("Total Number of records : " + arrayList.getCount());
        
        for (int i = 0; i < arrayList.getCount(); i++) {
            studentIDList.add(arrayList.get(i));
        } //sort by studentID
        long estimatedTimeSort = System.nanoTime() - startTime;
        System.out.println("Time Used in Nanoseconds : " + estimatedTimeSort);
        System.out.println("Total Number of records : " + studentIDList.getListSize());
        System.out.println("List of the unsorted List");
        System.out.println(arrayList.sortStudID()); //unsorted
        System.out.println("List of the Sorted Linked List");
        System.out.println(studentIDList.printStudID()); //sorted > studentID
    }

    public void LinkedListUI() {
        System.out.println("Select The following function : ");
        System.out.println("1. Sort by Student ID");
        System.out.println("2. Add an item");
        System.out.println("3. Remove an item");
        System.out.println("4. Remove item by entry");
        System.out.println("5. Get item position");
        System.out.println("6. Get entry");
        System.out.println("7. Check item existence");
        System.out.println("8. Check size of the list");
        System.out.println("9. Clear the list");
        System.out.print("Your Selection --> ");
    }

    public void LinkedListFunc() {
        String input;
        while (true) {
            while (true) {
                Main.clearScreen();
                LinkedListUI();
                input = Main.scan.nextLine();

                if (Main.checkInputMenu(10, input)) {
                    break;
                }

            }
            if (input.equals("10")) {//return back 
                break;
            }

            switch (input) {
                case "1":
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":
                    break;
                case "6":

                    break;
                case "7":

                    break;
                case "8":

                    break;
                case "9":

                    break;
            }

        }
    }

}
