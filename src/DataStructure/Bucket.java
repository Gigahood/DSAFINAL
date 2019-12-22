/*
 This ADT exist to let the linked list and binary tree interchangable in the
HashTableChange
 */
package DataStructure;

/**
 *
 * @author Kuek Yong Boon
 */
public interface Bucket<K, V>{
    /*
    Description   : Add an key value pair into the bucket
    Precondition  : The bucket is not empty
    Postcondition : If key not exist 
                        An item being added to the bucket
                        Size of the bucket increase
                    If key exist
                        The value of the key being replaced
    Return        : Return the old value if key exist
                    Else Return null
    */
    V add(K key, V value);
    /*
    Description   : Remove an item from the bucket with the given key
    Precondition  : The bucket is not empty
    Postcondition : If key exist, remove the key-value pair from the bucket
                        Size decrease
                    Else   
                        Nothing happen
    Return        : If the key exist, return the remove value
                    Else Return null
    */
    V remove(K key);
    /*
    Description   : Check if the bucket contain the 
    Precondition  : None
    Postcondition : None
    Return        : If key exist
                        Return true
                    Else    
                        Return false
    */
    boolean containKey(K key);
    /*
    Description   : Get the value from the bucket with the given key
    Precondition  : The bucket is not empty
    Postcondition : None
    Return        : If the key exist
                        Return the value
                    Else
                        Return null
    */
    V getValue(K key);
    /*
    Description   : Check if the bucket is Full
    Precondition  : None
    Postcondition : None
    Return        : If bucket is full
                        Return true
                    Else
                        Return false
    */
    boolean isFull();
    /*
    Description   : Check if the bucket is Empty
    Precondition  : None
    Postcondition : None
    Return        : If bucket is empty
                        Return true
                    Else
                        Return false
    */
    boolean isEmpty();
    /*
    Description   : Get the current number of key-value pair from the bucket
    Precondition  : None
    Postcondition : None
    Return        : key-value pairs in the bucket
    */
    int size();
    /*
    Description   : Get the nth Node from the bucket
    Precondition  : The given index is within the size of the bucket
    Postcondition : None
    Return        : Return the Node if index is valid 
                    Return null if the index is invalid
    */
    Node<K,V> get(int index);
}
