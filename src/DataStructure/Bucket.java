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
public interface Bucket<K, V>{
    V add(K key, V value);
    V remove(K key);
    boolean containKey(K key);
    V getValue(K key);
    boolean isFull();
    boolean isEmpty();
    int size();
    Node<K,V> get(int index);
}
