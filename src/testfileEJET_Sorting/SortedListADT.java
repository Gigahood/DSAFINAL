/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfileEJET_Sorting;

/**
 *
 * @author user
 */
public interface SortedListADT<T> {

    public void add(T data);

    /*
    Description : to add data in ascending order
    Precondition :  the data is not null
    Postcondition : the data is added to the list
    Return :  none
     */
//    public String search(String code);
//    /*
//    Description : To search the data in the list
//    Precondition : The string is not empty
//    Postcondition : None
//    Return : The item from the list is returned, if there is nothing in the list the system will return "Game not Found"
//    */
    public boolean remove(T anEntry);

    /*
        Description	:	Removes the first or only occurrence of anEntry from the sorted list.
        Postcondition	:	anEntry has been removed from the list.  If anEntry was not located in the list, the list remains unchanged.
        Returns	:	true if anEntry was located and removed, else false. 
     */
    public T remove(int givenPosition);

    /*
        Description	:	Removes the entry at position givenPosition within the list.  
        Precondition	:	givenPosition must be between 1 to total entries.
        Postcondition	:	The entry at position givenPosition has been removed from the list.
        Returns	:	The entry that was removed from the list.
     */
    public int getPosition(T anEntry);

    /*
        Description	:	Gets the position of the first or only occurrence of  anEntry.
        Postcondition	:	The list remains unchanged.
        Returns	:	Returns the position anEntry if it occurs in the list. Otherwise, returns the position where anEntry would occur in the list, but as a negative integer.
     */
    public void clear();

    /*
        Description	:	Removes all entries from the list.
        Postcondition	:	The list is now empty.
     */
    public T getEntry(Integer givenPosition);

    /*
        Description	:	Retrieves the entry at position givenPosition in the list.
        Precondition	:	newPosition must be between1 to total entries.
        Postcondition	:	The list remains unchanged.
        Returns	:	The entry at position givenPosition.
     */
    public boolean contains(T anEntry);

    /*
        Description	:	Determines whether the list contains anEntry.
        Postcondition	:	The list remains unchanged.
        Returns	:	true if anEntry is in the list, or false if not.
     */
    public int getLength();

    /*
        Description	:	Gets the number of entries currently in the list.
        Postcondition	:	The list remains unchanged.
        Returns	:	The number of entries currently in the list.
     */
    public boolean isEmpty();

    /*
        Description	:	Determines whether the list is empty.
        Postcondition	:	The list remains unchanged.
        Returns	:	true if the list is empty, or false if not.
     */
//    public boolean isFull();
//    /*
//        Description	:	Determines whether the list is full.
//        Postcondition	:	The list remains unchanged.
//        Returns	:	true if the list is full, or false if not.
//     */
    public boolean isFull();
    /*
        Description	:	Determines whether the list is full.
        Postcondition	:	The list remains unchanged.
        Returns	:	true if the list is full, or false if not.

     */

}
