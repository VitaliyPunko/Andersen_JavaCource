package anderson.homework1.myarraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayListImpl<T> implements MyArrayList<T> {
    private int capacity = 9;
    private int index;
    private Object [] objects = new Object[capacity];
    List<T> list = new ArrayList<>();



    @Override
    public void add(T element) {
        if (index <= capacity){
            objects[index] = element;
            index++;
        }else {
            capacity = capacity*2;
            objects[index] = element;
        }

    }
    /*public void add(T element) {
        if (index <= objects.length - 1) {
            objects[index] = element;
            index++;
        } else {
            Object[] obj = new Object[capacity * 2];
            System.arraycopy(objects, 0, obj, 0, capacity);
            objects = obj;
        }
    }*/

    @Override
    public void sort() {

    }

    @Override
    public void concat(MyArrayList<T> anotherList) {

    }

    @Override
    public boolean delete(int index) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public MyArrayList<T> copy(MyArrayList<T> currentList) {
        return null;
    }
}
