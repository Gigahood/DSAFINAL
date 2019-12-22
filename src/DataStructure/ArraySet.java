/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

import DataClass.Student;



/**
 *
 * @author Lim Yi En
 */
public class ArraySet<T> implements Set<T> {

    private Node[] array;
    private int size;

    public ArraySet() {
        array = new Node[10];
        size = 0;
    }

    @Override
    public void add(T item) {
        if (item != null) { //item is not empty
            if (checkDuplicate(item) < 0) { //if there is NOT a duplicate value
                if (size == array.length) {
                    expandArray();
                }
                //add the item into array
                Node newEntry = new Node(item);
                array[size] = newEntry;
                
                size++;
            } 
            else {
                array[checkDuplicate(item)].count++;
            }

        }
    }

    public boolean hasDuplicate(String item) {

        for (int i = 0; i < size; i++) {
            if (array[i].count > 0) {
                return true;
            }
        }

        return false;

    }
    
    public int checkDuplicate(T item) {
        for (int i = 0; i < size; i++) {
            if (array[i].value.equals(item)) {
                return i; //The index of the duplicate value
            }
        }
        return -1; // If no duplicate value return null.
    }
    
    @Override
    public Set getDuplicate() {
        Set dupValue = new ArraySet();

        for (int i = 0; i < size; i++) {
            if (array[i].getCount() != 0) {
                dupValue.add(array[i].getValue(), array[i].getCount());
            }
        }
        
         return dupValue;
    }
      
    public Set checkUniqueID() {
        ArraySet idSet = new ArraySet();
        
        for (int i = 0; i < size; i++) {
            
            Student s = (Student) array[i].getValue();

            if (checkDuplicateID(s.getStudentID(), idSet) < 0) {
                idSet.add(s, array[i].getCount());
            } 
            else {
                Node ad = (Node) idSet.getNode(checkDuplicateID(s.getStudentID(), idSet));
                //ad.count += duplicateArray[i].getCount();
                //System.out.println(duplicateArray[i].getCount());
                ad.count++;
            }
        }

        return idSet;
    }

    public int checkDuplicateID(String id, Set idSet) {
        for (int i = 0; i < idSet.size(); i++) {
            Student s = (Student) idSet.get(i);

            if (s.getStudentID().equals(id)) {
                return i;
            }
        }

        return -1;
    }
    

    @Override
    public void add(T item, int count) {
        if (item != null) { //item is not empty
            if (checkDuplicate(item) < 0) { //if there is NOT a duplicate value
                if (size == array.length) {
                    expandArray();
                }
                //add the item into array
                Node newEntry = new Node(item, count);
                array[size] = newEntry;

                size++;

            } 
            else {
                array[checkDuplicate(item)].count++;
            }

        }
    }
    //=---------------------------------------search------------------------------------------------------------------
    
    public Set searchID(String id) {
        Set result = new ArraySet();
        
        for (int i = 0; i < size; i++) {
            if (array[i].value instanceof Student) {
                Student s = (Student) array[i].value;
                if (s.getStudentID().equals(id)) {
                    result.add(s, array[i].getCount());
                }
            }
        }

        return result;
    }

    public Set searchIC(String ic) {
        Set result = new ArraySet();

        for (int i = 0; i < size; i++) {
            if (array[i].value instanceof Student) {
                Student s = (Student) array[i].value;
                if (s.getIc().equals(ic)) {
                    result.add(s, array[i].getCount());
                }
            }
        }

        return result;
    }

    //--------------------------------------------------------------------------------------------------------------
    public int remove(T item) {
        int index = -1;
        if (item != null && array != null) {
            for (int i = 0; i < size; i++) {
                if (array[i].equals(item)) {
                    shifItemToLeft(i);
                    size--;
                    index = i;
                }
            }
        }
        return index;
    }

    private void shifItemToLeft(int currentIndex) {
        for (int i = currentIndex; i < size - 1; i++) {
            array[i] = array[i + 1];

        }
        array[size - 1] = null;
    }

    public int size() {
        return size;
    }

    public boolean clear() {
        for (int i = 0; i < size - 1; i++) {
            array[i].value = null;
        }
        return true;
    }
    
    
    public void expandArray() {
        Node[] oldArray = array;
        //duplicateArray = (T[]) new Object[oldArray.length * 2];
        array = new Node[oldArray.length * 2];
        size = 0;
        for (int i = 0; i < oldArray.length; i++) {
            add((T) oldArray[i].value);
            array[i].setCount(oldArray[i].count);
        }
        oldArray = null;
    }

    //----------------------------------------------getValue---------------------------------------------------------
    @Override
    public T get(int index) {
        T data = null;
        
        if((index>=0)&& index<=size){
            data = (T)array[index].value;
        }
        
//        for (int i = 0; i < array.length; i++) {
//            if (i == index) {
//                data = (T) array[i].value;
//            }
//        }
        return data;
    }
    
    @Override
    public T get(String item) {
        T data = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i].value.equals(item)) {
                data = (T) array[i].value;
            }
        }
        return data;
    }

    public Node getNode(int index) {
        Node data = null;
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                data = (Node) array[i];
            }
        }
        return data;
    }
    //----------------------------------------------------------------------------------------------------------------
   @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < size; i++) {
            str += array[i].value +"\t   " + array[i].count;
            str += "\n";
        }

        return str;

    } 

    private class Node<T> {

        private T value;
        private int count;

        public Node(T value, int count) {
            this.value = value;
            this.count = count;
        }

        public Node(T value) {
            this.value = value;
            this.count = 1;
        }

        public T getValue() {
            return value;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public int getCount() {
            return count;
        }

        @Override
        public String toString() {
            return this.value + " " + this.count;
        }

    }
}