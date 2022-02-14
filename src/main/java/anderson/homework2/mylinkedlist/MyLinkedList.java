package anderson.homework2.mylinkedlist;

public interface MyLinkedList<T> {

    //necessary methods

    void add(T element);

    void sort();

    void concat(MyLinkedList<T> anotherList);

    boolean delete(int index);

    T get(int index);

    int size();

    //other methods

    T getFirst();

    T getLast();

    void addAll(MyLinkedList<T> anotherList);
}
