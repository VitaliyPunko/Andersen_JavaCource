package andersen.homework1.myarraylist;

import java.util.Comparator;

    public interface MyArrayList<T> {

        //necessary methods

        void add(T element);

        void sort(Comparator<? super T> c);

        void concat(MyArrayList<T> anotherList);

        boolean delete(int index);

        T get(int index);

        int size();

        //other methods

        MyArrayList<T> copy(MyArrayList<T> currentList);
    }

