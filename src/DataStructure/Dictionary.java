/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

/**
 *
 * @author Kuek Yong Boon
 */
public interface Dictionary<K, V> {
    /*
    Description   : Add a key-value pair to the Dictionary at certain index position
                    If the key existed, replace and return the old value
    Precondition  : Calculate the hashcode of the key
                    Calculate the index based on the key
                    If map is full, rehash the map with bigger map
    Postcondition : A key value pair being added to the map
                    Size of map increase
    Return        : Return the old if key existed
                    Return null if key not existed
    */
    V add (K key, V value);
    /*
    Description   : remove a given key value pair 
    Precondition  : The Dictionary is not empty
    Postcondition : Size of map decrease
                    key value being removed
    Return        : True if key being removed
                    False if key is not removed
    */
    V remove (K key);
    /*
    Description   : remove all key - value pair from the map
    Precondition  : none
    Postcondition : size = 0
                    all key value pair being removed
    Return        : none
    */
    void removeAll();
    /*
    Description   : Get the value of the given key
    Precondition  : The map is not empty
    Postcondition : None
    Return        : Return the value of the given key
                    Return null if the key is not exist
    */
    V getValue (K key);
    /*
    Description   : Check whether the map contain the given key
    Precondition  : None
    Postcondition : None
    Return        : Return true if the map contain the key
                    false if it does not contain the key
    */
    boolean containKey (K key);
    /*
    Description   : Check whether the map is close to full(is it more than the load factor given)
    Precondition  : None
    Postcondition : None
    Return        : Return true if the map current size is more than load factor
                    Return false if lesser than
    */
    boolean isFull();
     /*
    Description   : Check if the map is Empty
    Precondition  : None
    Postcondition : None
    Return        : Return true if it is empty
                    Return false if it is Not empty
    */
    boolean isEmpty();
    /*
    Description   : Get the number of key value pair store inside the map
    Precondition  : None
    Postcondition : None
    Return        : return the number of key value pair store inside the map
    */
    int size();
}
