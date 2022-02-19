package andersen.homework2.mylinkedlist;

import java.util.Comparator;

public interface MyLinkedList<T> {

    //necessary methods

    void add(T element);

    void sort(Comparator<? super T> c);

    void concat(MyLinkedList<T> anotherList);

    boolean delete(int index);

    T get(int index);

    int size();

    //other methods

    T getFirst();

    T getLast();

    void addAll(MyLinkedList<T> anotherList);

    void clear();
}
