/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfileword.Yien;

import DataClass.Student;
import DataStructure.ArraySet;
import DataStructure.HashTableCloseAddressing;
import DataStructure.HashTableLinear;
import DataStructure.Set;
import testfileword.Database;
import testfileword.Main;

/**
 *
 * @author User
 */
public class Duplicate {
    public static Database db = new Database();
    
    public Duplicate(){
        printList();
    }
    
    public void printList(){
        
        
        
        
        System.out.println("Duplicate Check Session");
        System.out.println("1. Overall Result");
        System.out.println("2. Search");
        System.out.print("-->");
        int input = Main.scan.nextInt();
        
        switch(input) {
                case 1:
                    testing();
                    break;
                case 2:
                    searchUI();
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
        
        
//       db.loadData();
//        Set<Student> s = new DataStructure.ArraySet<Student>();
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
    
    public void testing(){
       
       
        Set<Student> set = new ArraySet<Student>();
        set.add(new Student("19001","Lim","Yi En","990102"));
        set.add(new Student("19001","Lim","Yi En","990122"));
        set.add(new Student("19001","Lim","Yi En","990102"));
        set.add(new Student("19001","Lim","Yi En","990102"));
        set.add(new Student("19001","Lim","Yi En","990102"));
        set.add(new Student("19001","Tan","Yi En","990102"));
        set.add(new Student("19001","Liew","Yi En","990102"));
        set.add(new Student("11001","Liew","Yi En","990102"));
        
        
        System.out.format("%-3s %-15s %-20s %-15s %-16s %-5s %-5s", 
                "","Id","Name","Ic","Pass","Cgpa","No. of Duplicate");
 
        System.out.println("");
        System.out.println(set);
        
        
        
    }
    
    public void searchUI(){
        String s = "";
        
        Set<Student> set = new ArraySet<Student>();
        set.add(new Student("19001","Lim","Yi En","990102"));
        set.add(new Student("19001","Lim","Yi En","990122"));
        
        set.add(new Student("11001","Liew","Yi En","990102"));
        
        System.out.print("Key in ID : ");
        String input = Main.scan.nextLine();
        
        System.out.println(set.searchID(input));
        
        if(set.hasDuplicate(input)){
            s = "Has Duplicate";
            System.out.println("Result:"+ s);
        }
        else{
            s = "Unique";
            System.out.println("Result:"+ s);
        }
        
        
        System.out.format("%-3s %-15s %-20s %-15s %-16s %-5s %-5s", 
                "","Id","Name","Ic","Pass","Cgpa","No. of Duplicate");
        
        
    }
    
}
