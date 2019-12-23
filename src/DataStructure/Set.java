/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

/**
 *
 * @author Lim Yi En
 */
public interface Set<T> {
    public void add(T item);
    /*
    Description: To add item into set.
    Precondition: The item is not null and check the item had doesn't exist in the set. 
    Postcondition: case1) If the item does not exist in the list, size increase and item being added into the list
                   case2) If the item exist in the list, add into duplicated item array.
    Return: null
    */
    
    public boolean hasDuplicate();
    /*
    Description: To check if the set has duplicated item
    Precondition: null
    Postcondition: null
    Return: Return false if the set has distinct item
            Return true if the set has duplicated item.
    */
    
    public boolean checkDuplicateValue(String item);
    /*
    Description: To check if the item already exists in the set.
    Precondition: Check the duplicate value
    Postcondition: null
    Return: If no duplicate return -1, if has duplicate return the index of the duplicate item.
    */
    
    public Set getDuplicate();
    /*
    Description: To get the duplicate items from the set.
    Precondition: None
    Postcondition: None
    Return: Return a new Set of consist of duplicate item from the current set
            Return null if there is no duplicated item in the set
    */

    public T get(int index);
    /*
    Description: To get item based on the index.
    Precondition: Check the index must be smaller or equal the size.
    Postcondition: null
    Return: Return the value of the item.
            Return null if the index is invalid.

    */
    
    public T get(String item);
     /*
    Description: To get the item based on the given String value
    Precondition: NOne
    Postcondition: None
    Return: Return the item based on the given String value.
            Return null if the String value does not exist in the set.

    */
    
     public int remove(T item);
    /*
    Description: To remove an item from set.
    Precondition: The set is not empty
                  The item is not null
    Postcondition: The item had been removed, size decreased.
    Return: If exists, return the index of the item, else return -1. 
    */
    
    public int size();
    /*
    Description: To check the size of the set.
    Precondition: null
    Postcondition: null
    Return: Return the size of the set.
    */
    public boolean clear();
    /*
    Description: To empty the set.
    Precondition: null
    Postcondition: Size = 0
                   All item being removed from the set.
    Return: Return true if able to clear
            Return false if unable to clear
    */
    
    public void add(T item, int count);
    /*
    Description: To add the item and the number of repeat into the set.
    Precondition: The item is not null
    Postcondition: If the item existed in the set, add the count to the item count
                    Else add a new item and count the set

    Return: null
    */


}
