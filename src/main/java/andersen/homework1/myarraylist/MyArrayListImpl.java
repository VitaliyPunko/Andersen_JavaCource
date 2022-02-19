package andersen.homework1.myarraylist;

import java.util.Arrays;
import java.util.Comparator;

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

    @Override
    public void add(T element) {
        if (currentIndex <= array.length - 1) {
            array[currentIndex] = element;
            currentIndex++;
        } else {
            Object[] obj = new Object[initialCapacity * 2];
            System.arraycopy(array, 0, obj, 0, initialCapacity);
            array = obj;
        }
    }

    @Override
    public void sort(Comparator<? super T> c) {
        T[] array1 = (T[]) this.array;
        for (int i = 0; i < currentIndex; i++) {
            int minIndex = i;
            T min = array1[i];
            for (int j = i + 1; j < currentIndex; j++) {
                if (c.compare(array1[j], array1[minIndex]) < 0) {
                    min = array1[j];
                    minIndex = j;
                }
            }
            T temp = array1[i];
            array1[i] = min;
            array1[minIndex] = temp;
        }
    }

    @Override
    public void concat(MyArrayList<T> anotherList) {
        Object[] newArray = new Object[this.array.length + anotherList.size()];
        Object[] anotherArray = new Object[anotherList.size()];
        for (int i = 0; i < anotherList.size(); i++) {
            anotherArray[i] = anotherList.get(i);
        }
        System.arraycopy(array, 0, newArray, 0, array.length);
        System.arraycopy(anotherArray, 0, newArray, currentIndex, anotherArray.length);
        currentIndex = currentIndex + anotherList.size();
        this.array = newArray;
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

    /**
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
