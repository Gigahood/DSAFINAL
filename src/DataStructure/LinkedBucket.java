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
public class LinkedBucket<K, V> implements Bucket<K, V> {

    private int size;
    private Node firstNode;

    public LinkedBucket() {
        this.size = 0;
        this.firstNode = null;
    }

    @Override
    public V add(K key, V value) {
        Node newNode = new Node(key, value);
        V oldValue = null;

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            Node currentNode = firstNode;
            Node previousNode = currentNode.getPrevious();

            while (currentNode != null && !currentNode.getKey().equals(key)) {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }

            if (currentNode == null) {
                currentNode = newNode;
                previousNode.setNext(currentNode);
                currentNode.setPrevious(previousNode);
            } else {
                oldValue = (V) currentNode.getValue();
                currentNode.setValue(value);
            }
        }
        size++;

        return oldValue;
    }

    @Override
    public V remove(K key) {
        V removedValue = null;

        if (!isEmpty()) {
            Node currentNode = firstNode;
            Node previousNode = null;

            while (currentNode != null && !currentNode.getKey().equals(key)) {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }

            if (currentNode != null) {
                removedValue = (V) currentNode.getValue();
                if (previousNode == null) {
                    firstNode = currentNode.getNext();
                    currentNode.setNext(null);
                } else if (currentNode.getNext() == null) {
                    currentNode.getPrevious().setNext(null);
                    currentNode.setPrevious(null);
                } else {
                    previousNode.setNext(currentNode.getNext());
                    currentNode.getNext().setPrevious(currentNode.getPrevious());
                    currentNode.setNext(null);
                    currentNode.setPrevious(null);
                }
            }
            size--;
        }
        return removedValue;
    }

    @Override
    public boolean containKey(K key) {
        if (isEmpty()) {
            return false;
        }

        Node currentNode = firstNode;

        while (currentNode != null && !currentNode.getKey().equals(key)) {
            currentNode = currentNode.getNext();
        }

        return currentNode != null;
    }

    @Override
    public V getValue(K key) {
        V value = null;

        if (!isEmpty()) {
            Node currentNode = firstNode;

            while (currentNode != null && !currentNode.getKey().equals(key)) {
                currentNode = currentNode.getNext();
            }

            if (currentNode != null) {
                value = (V) currentNode.getValue();
            }
        }

        return value;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.size <= 0;
    }

    @Override
    public String toString() {
        String str = "";

        Node currentNode = firstNode;

        while (currentNode != null) {
            str += currentNode.getValue();
            str += ", ";
            currentNode = currentNode.getNext();
        }

        return str;
    }
    
    @Override
    public Node<K,V> get(int index) {
        Node currentNode = firstNode;
        for (int i = 0; i < index ; i++) {
            currentNode = currentNode.getNext();
        }
        
        return currentNode;
    }

    @Override
    public int size() {
       return size;
    }

}
