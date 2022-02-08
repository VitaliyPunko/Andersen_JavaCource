package anderson.homework1.myarraylist;

public interface MyArrayList<T> {

    //necessary methods
    void add();

    void sort();

    void concat(MyArrayList<T> anotherList);

    boolean delete(int index);

    T get(int index);

    int size();

    //other methods
}
