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
public class HashTableChange<K, V> implements Dictionary<K, V> {
  private Bucket[] hashTable;
    private int size;

    private double loadFactor;

    private final int INITIAL_CAPACITY = 227;
    private final double DEFAULT_LOAD_FACTOR = 10.85;

    public HashTableChange() {
        this.size = 0;
        this.hashTable = new Bucket[INITIAL_CAPACITY];
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public HashTableChange(int size) {
        this.size = 0;
        //this.bucket = new Node[getNextPrime(size)];
        this.hashTable = new Bucket[getNextPrime(size)];
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public HashTableChange(int size, double loadFactor) {
        this.size = 0;
        this.hashTable = new Bucket[getNextPrime(size)];
        this.loadFactor = loadFactor;
    }

    @Override
    public V add(K key, V value) {
        int index = getHashIndex(key);

        if (isFull()) {
            System.out.println("rehash");
            rehash();
        }

        V returnValue = null;

        if (hashTable[index] == null) {
            hashTable[index] = new LinkedBucket();

        } else {
            if (hashTable[index] instanceof LinkedBucket == true && hashTable[index].size() >= 8) {
                changeToBST(index);
            }
        }
        

        returnValue = (V) hashTable[index].add(key, value);
        
        if (returnValue == null) {
            size++;
        }
        return returnValue;
    }

    @Override
    public V remove(K key) {
        V removedValue = null;
        int index = getHashIndex(key);
        if (!isEmpty()) {
            removedValue = (V) hashTable[index].remove(key);
        }

        if (removedValue != null) {
            size--;
        }

        return removedValue;
    }

    @Override
    public void removeAll() {
        this.size = 0;
        this.hashTable = new Bucket[getNextPrime(size)];
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    @Override
    public V getValue(K key) {
        int index = getHashIndex(key);
        V returnValue = null;

        if (!isEmpty()) {
            returnValue = (V) hashTable[index].getValue(key);
        }

        return returnValue;
    }

    @Override
    public boolean containKey(K key) {
        int index = getHashIndex(key);
        if (!isEmpty()) {
            return hashTable[index].containKey(key);
        }
        return false;
    }

    @Override
    public boolean isFull() {
        return (this.size / this.hashTable.length) > this.loadFactor;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int getNextPrime(int size) {
        // if is even, will not be prime, make it become odd
        if (size % 2 == 0) {
            size++;
        }

        // get next odd number if it is not prime number
        while (!isPrime(size)) {
            size += 2;
        }
        
       

        return size;
    }

    private boolean isPrime(int size) {
        int i;

        // size 1,2,3 is prime number
        if (size == 1 || size == 2 || size == 0) {
            return true;
        }

        // above 3, modulus by every number start from 3 
        for (i = 3; i < size / 2; i++) {
            if (size % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int getHashIndex(K key) {
        int index;

        // if null key, assign 0 to it
        if (key == null) {
            index = 0;
        } else {
            // index 0 left for null key
            index = key.hashCode() % hashTable.length;
            if (index == 0) {
                index = 1;
            }

            // this only occur when overflow
            if (index < 0) {
                index = index + hashTable.length;
            } // end if
        }
        return index;

    }
    
    private void rehash() {
        Bucket[] oldBucket = hashTable;
        int oldSize = size;
        hashTable = new Bucket[getNextPrime(oldSize * 2)];
        size = 0;
        
        for (int i = 0; i < oldBucket.length; i++) {
            if (oldBucket[i] != null) {
                for (int j = 0; j < oldBucket[i].size(); j++) {
                    add((K) oldBucket[i].get(j).getKey(),(V) oldBucket[i].get(j).getValue());
                }
            }
        }
    }
    
    private void changeToBST(int index) {
        Bucket newBST = new BinaryBucket();
        Bucket oldLinked = hashTable[index];
        
        for (int i = 0; i < oldLinked.size(); i++) {
            newBST.add(oldLinked.get(i).getKey(), oldLinked.get(i).getValue());
        }
        hashTable[index] = null;
        hashTable[index] = newBST;

    }

    @Override
    public String toString() {
        String str = "";

        for (Bucket hashTable1 : hashTable) { 
//            if (hashTable1 instanceof BinaryBucket) {
//                System.out.println("Binary");
//            } else if (hashTable1 instanceof LinkedBucket) {
//                System.out.println("Linked");
//            }

            if (hashTable1 == null) {
                str += "null";
            } else {
                str += hashTable1;
            }
            str += "\n";
        }

        return str;
    }

}