// Question on getAllKey
/*
To-do
    1. Prime Number for size
    2. Decide whether make use of the isAvailable
*/


package DataStructure;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author User
 */
public class HashTableLinear<K, V> implements Map<K, V> {

    private Entry<K, V>[] hashMap;
    private int size;
    private double loadFactor;

    // this is a prime number so that the key will distribute evenly throughout 
    // the hashmap
    // testing is put as 10
    private final int INITIAL_CAPACITY = 227;

    private final double DEFAULT_LOAD_FACTOR = 0.75;

    public HashTableLinear() {
        this.hashMap = new Entry[INITIAL_CAPACITY];
        this.size = 0;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public HashTableLinear(int size) {
        this.hashMap = new Entry[size];
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    // will change this to nextPrime number next time
    public HashTableLinear(int size, double loadFactor) {
        this.hashMap = new Entry[size];
        this.loadFactor = loadFactor;
    }

    /*
    For adding :
    1. Check if hashmap is full
    2. Rehash if full
    3. Use hashcode to get the hashIndex
    4. Check the hashIndex
        4.1 If the hashindex had value before and current key not same, hashindex++
        4.2 repeat 4.1 with the new hashindex until the encounter index that have no value before
        4.3 If the key is same, return old value, set the new value
        4.3 If the hashindex does not have value before, current value will be the new value, return null
     */
    @Override
    public V add(K key, V value) {
        V oldValue = null;
        int index;

        if (isFull()) {   // Step 1
            //System.out.println(size);
            rehash();
            //System.out.println("1");
        } 
            //System.out.println(value);
            if (containKey(key) >= 0) {
                //System.out.println("1");
                index = containKey(key);
                oldValue = hashMap[index].value;
                hashMap[index].value = value;
            } else {
                index = getHashIndex(key);
                // getMapIndex will make sure to solve the collision
                // the returned index will be either with the same key 
                // or a new index based on resolved collision
                index = getMapIndex(index);
                hashMap[index] = new Entry(key, value);
                //System.out.println(key);
                size++;
            }
       
        
        //System.out.println("size = " + size);
        return oldValue;
    }

    @Override
    public boolean remove(K key) {
        int index = containKey(key);

        if (isEmpty() || index < 0) {
            return false;
        }

        hashMap[index].remove();
        size--;

        return true;
    }

    @Override
    public void removeAll() {
        this.hashMap = new Entry[INITIAL_CAPACITY];
        this.size = 0;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    @Override
    public V getValue(K key) {
        int index;

        if (!isEmpty() && containKey(key) >= 0) {
            index = containKey(key);
            return hashMap[index].value;
        }
        return null;
    }
    
    public Collection<K> getAllKeys() {
        Collection<K> keyset = new ArrayList<>();
       int length = hashMap.length;
        
        for (int i = 0; i < length; i++) {
            if (hashMap[i] != null &&  hashMap[i].getKey() != null) {
                keyset.add(hashMap[i].getKey());
            }
        }
        return keyset;
    }

    /*
    1. Get the hashIndex
    2. Get the MapIndex
    3. Go to MapIndex, check if the key same as given key or not, if yes return
        the MapIndex, else return -1
     */
    @Override
    public int containKey(K key) {
        int hashIndex = getHashIndex(key);
        
        //System.out.println(hashIndex);
        while (collision(hashIndex)) {
            if (!hashMap[hashIndex].key.equals(key)) {
                hashIndex = solveCollision(hashIndex);
            } else {
                return hashIndex;
            }
        }
        return -1;
    }

    @Override
    public boolean isFull() {
        return (this.size / (double) hashMap.length) >= this.loadFactor;
    }

    @Override
    public boolean isEmpty() {
        return this.size <= 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int getHashIndex(K key) {
        int index;

        // if null key, assign 0 to it
        if (key == null) {
            index = 0;
        } else {
            index = key.hashCode() % hashMap.length;
            if (index == 0) {
                index = 1;
            }
            
            if (index < 0) {
                index = index + hashMap.length;
            } // end if
        }
        return index;
    }

    // if no collision, return back the original hashIndex as MapIndex
    // inside here will not have the same key
    // following is to solve collision using linear probing
    // just move the next index if there is element 
    private int getMapIndex(int index) {
        
        while (collision(index)) {   
            index = solveCollision(index);
        }
        return index;
    }

    // the size will change to get next prime number
    private void rehash() {
        Entry<K, V>[] oldMap = hashMap;
        int old = hashMap.length;

        this.hashMap = new Entry[old * 2];
        this.size = 0;
        //Entry<K,V> currentEntry;

        for (int i = 0; i < old; i++) {
            
            if (oldMap[i] != null && !oldMap[i].available) {
                //System.out.println(oldMap[i].getValue());
                add(oldMap[i].getKey(), oldMap[i].getValue());
            }
        }
    }

    private int solveCollision(int index) {
        return (index + 1) % hashMap.length;
    }

    private class Entry<K, V> {

        private K key;
        private V value;
        private boolean available;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.available = false;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        public void remove() {
            this.key = null;
            this.value = null;
            this.available = true;
        }

    }

    private boolean collision(int hashIndex) {
       //System.out.println(hashIndex);
       return (hashMap[hashIndex] != null && !hashMap[hashIndex].isAvailable());
    }

    @Override
    public String toString() {
        String str = "";
        String index;
        String mapIndex;
        String key;
        String value;

        str += String.format("%-5s %-10s %-15s %-15s %-15s %-10s %-15s %-15s %-20s %-5s \n",
                "No", "Ori.Index.", "AfterIndex", "Key", "StudentId", "FirstName",
                "LastName", "IC", "Password", "CGPA");

        for (int i = 0; i < hashMap.length; i++) {
            index = getStringIndex(i);
            mapIndex = getStringMapIndex(i);
            key = getStringKey(i);
            value = getStringValue(i);
            
            str += String.format("%-5s %-10s %-15s %-15s %-20s \n",
                    i, index, mapIndex, key, value);
        }
        return str;
    }

    private String getStringIndex(int index) {
        if (hashMap[index] == null) {
            return "null";
        }

        if (hashMap[index].isAvailable()) {
            return "removed";
        }

        return getHashIndex(hashMap[index].getKey()) + " ";
    }

    private String getStringKey(int index) {
        if (hashMap[index] == null) {
            return "null";
        }

        if (hashMap[index].isAvailable()) {
            return "removed";
        }

        return ("" + hashMap[index].key + " ");
    }

    private String getStringValue(int index) {
        if (hashMap[index] == null) {
            return "null";
        }

        if (hashMap[index].isAvailable()) {
            return "removed";
        }

        return (hashMap[index].value + "");
    }

    private String getStringMapIndex(int index) {
        if (hashMap[index] == null) {
            return "null";
        }

        if (hashMap[index].isAvailable()) {
            return "removed";
        }

        if (containKey(hashMap[index].getKey()) >= 0) {
            int x = containKey(hashMap[index].getKey());
            return x + "";
        } else {
            int x = (getMapIndex(getHashIndex(hashMap[index].getKey())));
            System.out.println(x);
            return x + "";

        }
    }

}