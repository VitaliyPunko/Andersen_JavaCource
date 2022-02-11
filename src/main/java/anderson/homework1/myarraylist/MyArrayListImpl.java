package anderson.homework1.myarraylist;

import java.util.Arrays;

public class MyArrayListImpl<T> implements MyArrayList<T> {

    private int initialCapacity = 10;
    private int currentIndex = 0; // real size of MyArrayList
    private Object[] array = new Object[initialCapacity];

    public MyArrayListImpl() {
    }

    public MyArrayListImpl(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        array = new Object[initialCapacity];
    }

    /*
     * If myArrayList is full -> create new array with bigger size
     * @param element
     */
//    @Override
//    public void add(T element) {
//        if (currentIndex == initialCapacity) {
//            Object[] newArray = changeSize(array);
//            newArray[currentIndex++] = element;
//            array = newArray;
//        } else {
//            array[currentIndex++] = element;
//        }
//    }


    @Override
    public void add(T element) {

    }

    @Override
    public void sort() {

    }

    @Override
    public void concat(MyArrayList anotherList) {

    }

    /*
    copy elements from deleting index+1 to deleting index
    length - count of copping elements = count of elements after deleting index
     */
    @Override
    public boolean delete(int index) {
        if (currentIndex <= index) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + array.length);
        }
        currentIndex--;
        System.arraycopy(array, index + 1, array, index, currentIndex - index);
        array[currentIndex] = null;
        return true;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    /**
     * Return count of elements
     * not a size of array
     *
     * @return
     */
    @Override
    public int size() {
        return currentIndex;
    }


    @Override
    public MyArrayList<T> copy(MyArrayList<T> currentList) {
        MyArrayList<T> newMyArrayList = new MyArrayListImpl<>(currentList.size());
        for (int i = 0; i < currentList.size(); i++) {
            newMyArrayList.add(currentList.get(i));
        }
        return newMyArrayList;
    }

    /*
     * increase size of array
     * @param array - old array which size we want to increase
     * @return array with increased size
     */
    private Object[] changeSize(Object[] array) {
        Object[] newArray = new Object[(int) (initialCapacity * 1.5) + 1];
        newArray = Arrays.copyOf(array, newArray.length);
        initialCapacity = newArray.length;
        return newArray;
    }

    /*
     * toString returns only elements that was added;
     * @return beauty view of MyArrayList
     */
    @Override
    public String toString() {
        Object[] arrayToString = Arrays.copyOf(array, currentIndex);
        return "MyArrayListImpl" +
                "array=" + Arrays.toString(arrayToString);
    }
}
