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
public class MyLinkedList<T extends Comparable<T>> implements SortedListADT<T> {

    private Node firstNode;
    private int listSize = 0;

    public MyLinkedList() {
        firstNode = null;
    }

    public int getListSize() {
        return listSize;
    }

    //need to compare student id, registration id, name, and maybe programme
    public void add(T data) { //bubble sort add
        Node newNode = new Node(data);
        if (data != null) {
            if (firstNode == null) {
                firstNode = newNode;
            } else if (data.compareTo(firstNode.data) < 0) {
                newNode.next = firstNode;
                firstNode = newNode;
            } else {
                Node current = firstNode;
                Node previous = null;
                while (current != null && data.compareTo(current.data) > 0) {
                    previous = current;
                    current = current.next;
                }
                previous.next = newNode;
                newNode.next = current;
            }
            listSize++;
        } else {
            System.out.println("The data entry should not be empty.");
        }

    }

    public void reverseSort(T data) {
        Node newNode = new Node(data);
        if (data != null) {
            if (firstNode == null) {
                firstNode = newNode;
            } else if (data.compareTo(firstNode.data) > 0) {
                newNode.next = firstNode;
                firstNode = newNode;
            } else {
                Node current = firstNode;
                Node previous = null;
                while (current != null && data.compareTo(current.data) < 0) {
                    previous = current;
                    current = current.next;
                }
                previous.next = newNode;
                newNode.next = current;
            }
            listSize++;
        } else {
            System.out.println("The data entry should not be empty.");
        }
    }

    public boolean remove(T anEntry) {
        Node newNode = new Node(anEntry);
        Node current = firstNode;
        Node previous = newNode;
        boolean found = false;
        while (current != null) {
            if (current.data.compareTo(anEntry) == 0) {
                previous.next = current.next;
                current.next = null;
                found = true;
                break;
            } else {
                previous.next = current;
                current = current.next;
            }
        }
        return found;
    }

    public T remove(int givenPosition) {
        Node deletedNode = new Node();
        Node current = firstNode;
        Node previous = new Node();
        if (givenPosition < 0) {
            System.out.println("The given position should not be smaller than 1");
        } else if (givenPosition > listSize) {
            System.out.println("The given position is larger than the size of the list");
        } else {

            int counter = 1;
            if (listSize == 0) {
                System.out.println("There are nothing contained in the list");
            } else {
                while (current != null && counter != givenPosition) {
                    current = current.next;
                    counter++;
                }
                previous.next = current.next;
                deletedNode = current;
                current.next = null;
                listSize--;
            }
        }
        return deletedNode.data;
    }

    public int getPosition(T anEntry) {
        Node current = firstNode;
        int counter = 1;
        boolean found = false;
        if (firstNode == null) {
            counter = -1; //list is empty and the node will be added as the firstNode which is in first location            
        } else {
            while (current != null) {
                if (anEntry.compareTo(current.data) == 0) {
                    found = true;
                    break;
                } else {
                    current = current.next;
                    counter++;
                }
            }
        }
        if (firstNode != null && found == false) {
            current = firstNode;
            counter = 1;
            if (anEntry.compareTo(firstNode.data) < 0) {
                counter = -1;
            } else {
                while (current != null && anEntry.compareTo(current.data) > 0) {
                    current = current.next;
                    counter++;
                }
                counter = counter * -1;
            }
        }
        return counter;
    }

    public void clear() {
        listSize = 0;
        firstNode = null;
    }

    public T getEntry(Integer givenPosition) {
        Node tempNode = new Node();
        Node current = firstNode;
        Node previous = new Node();
        if (givenPosition < 0) {
            System.out.println("The given position should not be smaller than 1");
        } else if (givenPosition > listSize) {
            System.out.println("The given position is larger than the size of the list");
        } else {
            int counter = 1;
            if (listSize == 0) {
                System.out.println("There are nothing contained in the list");
            } else {
                while (current != null && counter != givenPosition) {
                    current = current.next;
                    counter++;
                }
            }
        }
        return tempNode.data;
    }

    public boolean contains(T anEntry) {
        Node current = firstNode;
        boolean found = false;
        if (firstNode == null) {
            System.out.println("There are nothing contained in the list");
        } else {
            while (current != null) {
                if (anEntry.compareTo(current.data) == 0) {
                    found = true;
                    break;
                } else {
                    current = current.next;
                }
            }
        }
        return found;
    }

    public int getLength() {
        return listSize;
    }

    public boolean isEmpty() {
        if (firstNode == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        return false;
    }

    public String toString() {
        String str = "";
        Node current;
        current = firstNode;
        if (firstNode == null) {
            str = "There is no item in the list";
        } else {
            while (current != null) {
                str += current.data + "";
                current = current.next;
            }
        }
        return str;
    }

    public String printStudID() {
        Node current = firstNode;
        String str = "";
        int counter = 1;
        str += String.format("%-5s %-15s %-10s %-15s %-15s %-20s %-5s \n",
                "No", "StudentId", "FirstName",
                "LastName", "IC", "Password", "CGPA");

        if (listSize > 20) {
            while (counter <= 20) {
                str += String.format("%-5d %-20s \n",
                        counter, current.data);
                current = current.next;
                counter++;
            }
            System.out.println("\nThe records is too long, first 20 records are shown instead");
        } else {
            while (current != null) {
                str += String.format("%-5d %-20s \n",
                        counter, current.data);
                current = current.next;
                counter++;
            }
        }
        return str;
    }

    private class Node {

        private T data;
        private Node next;

        public Node() {

        }

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
}
