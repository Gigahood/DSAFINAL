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
public class HashTableCloseAddressing<K, V>  implements Map<K, V> {
    private int size;
    private Node<K, V> [] bucket;
    private double loadFactor;
    
    private final int INITIAL_CAPACITY = 227;
    private final double DEFAULT_LOAD_FACTOR = 0.85; 

    public HashTableCloseAddressing() {
        this.size = 0;
        this.bucket = new Node[INITIAL_CAPACITY];
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public HashTableCloseAddressing(int size) {
        this.size = size;
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
    public int containKey(K key) {
        return 1;
    }
    
    public boolean containKeys(K key) {
        if (isEmpty()) {
            return false;
        }
        
        int hashIndex = getHashIndex(key);
        Node<K, V> currentNode = bucket[hashIndex];

        if (currentNode != null && currentNode.key != key) {
          currentNode = currentNode.next;
        }
        
        if (currentNode == null) {
            return false;
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
        for (i = 3; i < size / 2 ; i++) {
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
   
 //------------------------------------------------------------------------------
    private class Node <K, V> {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
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
