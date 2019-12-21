/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

/**
 *
 * @author User
 */
public class HashSet<T> implements Set<T> {

    private Node[] duplicateArray;

    private int size;

    public HashSet() {
        //    array = (T[]) new Object[5];
        duplicateArray = new Node[10];
        size = 0;
    }

    @Override
    public void add(T item) {
        if (item != null) { //item is not empty
            if (union(item) < 0) { //if there is NOT a duplicate value

                if (size == duplicateArray.length) {
                    expandArray();
                }
                //add the item into array
                Node newEntry = new Node(item);
                duplicateArray[size] = newEntry;

                size++;

            } else {
                duplicateArray[union(item)].count++;
            }

        }
    }

    public Set intersection(Set set) {
        Node dupValue = new Node(set);

        while (union((T) dupValue) > 0) {

            if (set != null) {

                duplicateArray[size] = dupValue;
                duplicateArray[union((T) dupValue)].count++;

            }

        }
        return (Set) dupValue;
    }

    public int union(T item) {
        for (int i = 0; i < size; i++) {
            if (duplicateArray[i].value.equals(item)) {
                return i; //The index of the duplicate value
            }

        }
        return -1; // If no suplicate value return null.
    }

    public boolean hasDuplicate() {

        for (int i = 0; i < size; i++) {
            if (duplicateArray[i].count > 0) {
                return true;
            }
        }

        return false;

    }

    public int remove(T item) {
        int index = -1;
        if (item != null && duplicateArray != null) {
            for (int i = 0; i < size; i++) {
                if (duplicateArray[i].equals(item)) {
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
            duplicateArray[i] = duplicateArray[i + 1];

        }
        duplicateArray[size - 1] = null;
    }

    public int size() {
        return size;
    }


    public boolean clear() {
        for (int i = 0; i < size - 1; i++) {
            duplicateArray[i].value = null;
        }
        return true;
    }
    

    public void expandArray() {
        Node[] oldArray = duplicateArray;
        //duplicateArray = (T[]) new Object[oldArray.length * 2];
        duplicateArray = new Node[oldArray.length * 2];
        size = 0;
        for (int i = 0; i < oldArray.length; i++) {
            add((T) oldArray[i].value);
            duplicateArray[i].setCount(oldArray[i].count);
        }
        oldArray = null;
    }

    @Override
    public T get(int index) {
        T data = null;
        for (int i = 0; i < duplicateArray.length; i++) {
            if (i == index) {
                duplicateArray[index].value = data;
            }
        }
        return data;
    }

    @Override
    public T get(T item) {
        T data = null;
        for (int i = 0; i < duplicateArray.length; i++) {
            if (duplicateArray[i].value.equals(item)) {
                duplicateArray[i].value = data;
            }
        }
        return data;
    }

    @Override
    public void printDuplicateItems() {

    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < size; i++) {
            str += duplicateArray[i];
            str += "\n";
        }

        return str;

    }

    private class Node<T> {

        private T value;
        private int count;

        public Node(T value) {
            this.value = value;
            this.count = 0;
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
