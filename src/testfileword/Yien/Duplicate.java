/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfileword.Yien;

import DataClass.Student;
import DataStructure.HashSet;
import DataStructure.Set;
import testfileword.Database;

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
        Set<Student> set = new HashSet<Student>();
        set.add(new Student("19001","Lim","Yi En","990102"));
        set.add(new Student("19001","Lim","Yi En","990102"));
        set.add(new Student("19001","Lim","Yi En","990102"));
        set.add(new Student("19001","Lim","Yi En","990102"));
        set.add(new Student("19001","Lim","Yi En","990102"));
        
        System.out.println(set);
        
        set.intersection(set);
        //set.union(set);
        
        System.out.println(set);
        
        
//        db.loadData();
//        Set<Student> s = new HashSet<Student>();
//        for (int i=0; i<db.studentArrayList.size(); i++){
//            s.add(db.studentArrayList.get(i));
//            
//            System.out.println(s);
//        }
        
//        for (int i=0; i<db.studentArrayList.size(); i++){
//            
//            System.out.println(db.studentArrayList.get(i));
//        }
    }
}
