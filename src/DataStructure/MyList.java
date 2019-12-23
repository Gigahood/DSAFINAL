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
public interface MyList<T> {
    
/*
    Description   : 1. add a new object at the end of the list
    Precondition  : 1. check if the list if full, add only if it is not full
                    2. Item is not null
    Postcondition : 1. size of the list is increased
                    2. an item being added to the list
    Return        :    void
 */
    void add(T obj);
    
//    //add a new Object to the list at the given position, if fail return
//    // false, if true return true
//    /*
//        Description   : Add a new Object at the index position
//        Precondition  : Index should be less than size of the list
//        Postcondition : Size increase
//                        An item being added to the index of the item
//        Return        : True if can add
//                        False if fail to add
//    */
//    boolean add(int index, T o);
    
    // return the current amount of elements inside the list
    /*
        Description   : Get the current number of element inside the list
        Precondition  : None
        Postcondition : None
        Return        : The number of element inside the list
    */
    int size();
    
    // replace the current element at the given position
    /*
        Description   : Replace the element in the given position of the list
        Precondition  : given positon is less than the size of the list
        Postcondition : Item in the index position being replaced with new item
        Return        : True if success replaced
                        False if fail to replace
    */
    boolean replace(Integer givenPosition, T newEntry);
    
    // this will to get the item from the list
    /*
        Description   : Get the element from the index element inside the list
        Precondition  : the index is valid ( less than size of the list and is positive)
        Postcondition : None
        Return        : Return the element of the given index
                        Return error if index of bound
    */
    T get(int entry);
    
    /*
    Description   : Get the given object from the list
    Precondition  : The Object exist in the list
                    The list is not empty
    Postcondition : None
    Return        : Return the object in the list if it exist
                    Return null if not exist
 */
    T get(T obj);
    
    /*
        Description   : Remove every element inside the list
        Precondition  : None
        Postcondition : All element being removed fomr the list
        Return        : None 
    */
    void removeAll();
    
    /*
        Description   : Remove an element form the given Index of the list
        Precondition  : The index is valid ( less than size of the list and is positive)
        Postcondition : Item of the given index being removed
                        Subsequent item in the list being move forward
                        Size decrease
        Return        : True if success remove
                        False if failed to remove
    */
    boolean remove(int index);
    
    /*
        Description   : Remove the given element from the 
        Precondition  : The given element exist in the list
        Postcondition : Size decrease
                        The given element being removed
                        Subsequent element in the list move forward
        Return        : True if success remove
                        throw exception if index of out bound
    */
    boolean remove(T o);
    
    /*
        Description   : Check if the element exist in the list
        Precondition  : The array is not empty
        Postcondition : None
        Return        : return true if contain the item
                        throw exception if index of out bound
    */
    boolean contains(T o);
    
    /*
        Description   : Check if the list is empty
        Precondition  : None
        Postcondition : None
        Return        : True if the list is empty
                        False if the list is not empty
    */
    boolean isEmpty();
    
    /*
        Description   : Check if the list is full
        Precondition  : None
        Postcondition : None
        Return        : True if the list is full
                        False if the list is not full
    */
    boolean isFull();
    
    /*
        Description   : Get the position of the given item in the list
        Precondition  : The list is not empty
        Postcondition : None
        Return        : Return the position of the given item in the list
                        Return -1 if the item not exist in the list
    */
    int indexOf(T o);
    
    /*
        Description   : Get the last element in the list
        Precondition  : The list is not empty
        Postcondition : None
        Return        : The last element in the list
    */
    T getLast();
    
}
