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
public class HashTableCloseAddressing<K, V> implements Map<K, V> {

    private int size;
    private Node<K, V>[] bucket;
    private double loadFactor;

    private final int INITIAL_CAPACITY = 227;
    private final double DEFAULT_LOAD_FACTOR = 0.85;

    public HashTableCloseAddressing() {
        this.size = 0;
        this.bucket = new Node[INITIAL_CAPACITY];
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public HashTableCloseAddressing(int size) {
        this.size = 0;
        this.bucket = new Node[getNextPrime(size)];
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public HashTableCloseAddressing(int size, double loadFactor) {
        this.size = 0;
        this.bucket = new Node[getNextPrime(size)];
        this.loadFactor = loadFactor;
    }

    @Override
    public V add(K key, V value) {
        int index = getHashIndex(key);
        if (isFull()) {
            rehash();
        }

        Node newNode = new Node(key, value);
        Node currentNode = bucket[index];

        // if currentNode is null, mean it does not have item before, so just
        // put the new item in
        if (currentNode == null) {
            bucket[index] = newNode;
            size++;
        } else {
            Node previousNode = bucket[index].previous;
            // tranverse through the bucket
            while (currentNode != null) {
                
                // check if the currentNode key same with the given key
                // if same
                // replace the old value with new value
                // return the old value
                if (currentNode.key.equals(key)) {
                    V returnValue;
                    returnValue = (V) currentNode.value;
                    currentNode.value = value;
                    return returnValue;
                }
                
                // not the same key, continue to advance
                currentNode = currentNode.next;
            }
            
            // no key found, link the new node to the bucket
            previousNode.next = newNode;
            currentNode = newNode;
            size++;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        return true;
    }

    @Override
    public void removeAll() {

    }

    @Override
    public V getValue(K key) {
        return null;
    }

    @Override
    public boolean containKey(K key) {
        if (isEmpty()) {
            return false;
        }

        int index = getHashIndex(key);

        // if the bucket is null, mean it never had item before
        if (bucket[index] == null) {
            return false;
        }

        Node currentNode = bucket[index];

        // moving to the next node inside the bucket
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    @Override
    public boolean isFull() {
        return this.size / this.bucket.length < this.loadFactor;
    }

    @Override
    public boolean isEmpty() {
        return this.size <= 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String str = "";
        Node currentNode;

        for (int i = 0; i < bucket.length; i++) {
            currentNode = bucket[i];

            while (currentNode != null) {
                str += currentNode.value;
                str += "\n";
                currentNode = currentNode.next;
            }
        }

        return str;
    }

    public String printAll() {
        String str = "";
        Node currentNode;

        for (int i = 0; i < bucket.length; i++) {
            currentNode = bucket[i];

            if (currentNode == null) {
                str += "null\n";
            } else {
                while (currentNode != null) {
                    str += currentNode.value;
                    str += "\n";

                    currentNode = currentNode.next;
                }
            }

        }

        return str;
    }

//----------------------------------------------------------------------------
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
            index = key.hashCode() % bucket.length;
            if (index == 0) {
                index = 1;
            }

            // this only occur when overflow
            if (index < 0) {
                index = index + bucket.length;
            } // end if
        }
        return index;

    }
    
    private void rehash() {
        
    }

    //------------------------------------------------------------------------------
    private class Node<K, V> {

        private K key;
        private V value;
        private Node next;
        private Node previous;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.previous = null;
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

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

}
