package DataStructure;

import java.util.Arrays;
import testfileEJET_Sorting.StudentTest;

public class MyArrayList<T> implements MyList<T> {

    private T[] data;
    private int count = 0;
    private final int FIXED_SIZE = 10;

    // this is initialize custom size arrayList
    public MyArrayList(int size) {
        this.data = (T[]) new Object[size];
    }

    // this is initialize arrayList default size of 10.
    public MyArrayList() {
        this.data = (T[]) new Object[FIXED_SIZE];
    }

    public int getCount() {
        return count;
    }

    @Override
    public void add(T obj) {
        if (!this.isNull(obj)) {
            if (count >= data.length) {
                this.resizeArray();
            }
            this.data[count++] = obj;
        }
    }

//    @Override
//    public boolean add(int index, T o) {
////       checkArraySize(index);
////       moveBackward((count - 1), index, data);
////       data[index] = o;
////       count++;
//        return false;
//    }

    @Override
    public boolean contains(T o) {
        for (int i = 0; i < count; i++) {
            if (o.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T get(int entry) {
        // check if the entry is within the size
        // throw exception if out of bound
        checkArraySize(entry);
        return this.data[entry];
    }

    @Override
    public T get(T obj) {
        if (isEmpty()) {
            return null;
        }

        int index = getIndex(obj);

        if (index < 0) {
            return null;
        }

        return data[index];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void removeAll() {
        this.data = (T[]) new Object[FIXED_SIZE];
        count = 0;
    }

    @Override
    public boolean remove(int index) {
        // check if the entry is within the size
        // throw exception if out of bound
        checkArraySize(index);

        data[index] = null;
        moveForward(data, index);
        count -= 1;
        return true;

    }

    @Override
    public int size() {
        return this.count;
    }

    // require search for the object, currently just a simple compare
    // improvement can use, apply index on the array to fasten the search process
    @Override
    public boolean remove(T item) {
        // check item is not null, list is not empty, and this list contain this item
        if (!this.isNull(item) && !this.isEmpty() && this.contains(item)) {
            int index = this.indexOf(item);
            moveForward(data, index);
            count--;
            return true;
        }

        return false;
    }

    @Override
    public int indexOf(T o) {

        for (int i = 0; i < count; i++) {
            if (data[i].equals(o)) {

                return i;
            }
        }
        return -1;
    }

    private boolean checkArraySize(int size) {
        if (size > count) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return true;
    }

    private int getIndex(T obj) {
        for (int i = 0; i < count; i++) {
            if (obj.equals(data[i])) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean isFull() {
        return this.count >= data.length;
    }

    @Override
    public boolean replace(Integer givenPosition, T newEntry) {
        checkArraySize(givenPosition);
        this.data[givenPosition] = newEntry;
        return true;
    }

    @Override
    public T getLast() {
        return this.data[count - 1];
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < count; i++) {
            str += data[i];
            str += ", ";
        }

        return str;
    }

    public String sortStudID() {

        String str = "";
        str += "\nThe records is too long, first 20 records are shown instead\n";
        str += String.format("%-5s %-15s %-10s %-15s %-15s %-20s %-5s \n",
                "No", "StudentId", "FirstName",
                "LastName", "IC", "Password", "CGPA");
        if (count > 20) {
            for (int i = 0; i < 20; i++) {
                str += String.format("%-5d %-20s \n",
                        i, get(i));
            }

        } else {
            for (int i = 0; i < count; i++) {;
                str += String.format("%-5d %-20s \n",
                        i, get(i));
            }
        }

        return str;
    }
    // will return a new array with bigger size

    private void resizeArray() {
        this.data = Arrays.copyOf(data, count * count);
    }

    private void moveForward(T data[], int index) {
        for (int i = index; i < count; i++) {
            data[i] = data[i + 1];
            data[i + 1] = null;
        }
    }

    private boolean isNull(T item) {
        return item == null;
    }
}