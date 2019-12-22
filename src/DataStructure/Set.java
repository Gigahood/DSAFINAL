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
    Return: Return true if the item i
    */
    public void add(T item, int count);
    public Set getDuplicate();
    
    public int remove(T item);
    /*
    Description: To remove the item from set.
    Precondition: The item is exist in set.
    Postcondition: The item had been removed, size been decreased.
    Return: If exits, return the index of the item, else return -1. 
    */
    public int size();
    /*
    Description: To check the size of the set.
    Precondition: null
    Postcondition: null
    Return: The size
    */
    
    public int checkDuplicate(T item);
    /*
    Description: To check if the item already exists in the set.
    Precondition: Check the duplicate value
    Postcondition: null
    Return: If no duplicate return -1, if has duplicate return the index of the duplicate item.
    */
    
    public boolean hasDuplicate(String item);
    /*
    Description: To check the duplicate item.
    Precondition: null
    Postcondition: null
    Return: If has duplicate item in the  .
    */
    
    
    public T get(int index);
    /*
    Description: To get item in the index.
    Precondition: Check the index must be smaller or equal the size.
    Postcondition: null
    Return: The item.
    */
    public T get(String item);
     /*
    Description: To get the item.
    Precondition: Check the item is exist.
    Postcondition: null
    Return: The item.
    */
    
    public boolean clear();
    /*
    Description: To check the set is empty or not.
    Precondition: null
    Postcondition: null
    Return: If is empty return true, else reuturn false.
    */
    
    public Set searchID(String id);
    public Set searchIC(String ic); 
}
