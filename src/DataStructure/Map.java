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
public interface Map<K, V> {
    /*
    Description   : Add a key-value pair to the Map at certain index position
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
    Precondition  : The Map is not empty
                    The key existed in the map
    Postcondition : Size of map decrease
                    key value being removed
                    Flag the index as removed 
    Return        : True if key being removed
                    False if key is not removed
    */
    boolean remove (K key);
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
                    The map contain the key
    Postcondition : None
    Return        : Return the value of the given key
                    Return null if there is no key 
    */
    V getValue (K key);
    /*
    Description   : Check whether the map contain the given key
    Precondition  : The map is not empty
    Postcondition : None
    Return        : the index of the key if the key exist
                    -1 if the key not exist
    */
    int containKey (K key);
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
