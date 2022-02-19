package andersen.homework2.mylinkedlist;

import java.util.Comparator;

public class MyLinkedListImpl<T> implements MyLinkedList<T> {

    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyLinkedListImpl() {
    }

    public MyLinkedListImpl(MyLinkedList<T> list) {
        addAll(list);
    }

    /*
    добаляет элемент в конец листа
     */
    @Override
    public void add(T element) {
        Node<T> previousNode = last; //сохраняю значение предыдущей Node
        Node<T> node = new Node<>(previousNode, element, null);
        last = node;
        if (previousNode == null) {
            first = node;       // если предвдущий элемент равен null, то это будет певый эелемент.
            //т.к. не тело елемента, а вся нода
        } else {
            previousNode.next = node; //если предыдущий не null, тогда ссылка прошлой ноды на next = эта нода
        }
        size++;
    }

    /*
    selection sort
     */
    @Override
    public void sort(Comparator<? super T> c) {
        T[] array = (T[]) this.toArray();
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            T min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (c.compare(array[j], array[minIndex]) < 0) {
                    min = array[j];
                    minIndex = j;
                }
            }
            T temp = array[i];
            array[i] = min;
            array[minIndex] = temp;
        }
        this.clear();
        for (T t : array) {
            this.add(t);
        }
    }

    @Override
    public void concat(MyLinkedList<T> anotherList) {
        for (int i = 0; i < anotherList.size(); i++) {
            add(anotherList.get(i));
        }
    }

    @Override
    public boolean delete(int index) {
        checkIndex(index);
        Node<T> x = getNodeByIndex(index);
        if (x.next == null && x.prev == null) {
            x.item = null;
        } else if (x.prev == null) { // если удаляем первый элемент
            Node<T> node = x.next;
            node.prev = null;
            first = node;
        } else if (x.next == null) { // если удаляем последний элемент
            Node<T> node = x.prev;
            node.next = null;
            last = node;
        } else {
            Node<T> nodeP = x.prev;
            Node<T> nodeN = x.next;
            nodeP.next = nodeN;
            nodeN.prev = nodeP;
        }
        size--;
        return true;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        Node<T> x = getNodeByIndex(index);
        return x.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getFirst() {
        return first.item;
    }

    @Override
    public T getLast() {
        return last.item;
    }

    @Override
    public void addAll(MyLinkedList<T> anotherList) {
        for (int i = 0; i < anotherList.size(); i++) {
            this.add(anotherList.get(i));
        }
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> x;
        if (index < (size / 2)) { //если индекс в первой половине листа, то проходим с начала листа
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else { // иначе идем с хвоста
            x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
        }
        return x;
    }

    private boolean isIndexCorrect(int index) {
        return index >= 0 && index < size;
    }

    private void checkIndex(int index) {
        if (!isIndexCorrect(index))
            throw new IndexOutOfBoundsException("There isn't such index " + index + " in this size = " + size);
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("MyLinkedListImpl: {");
        Node<T> node = first;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(node.item).append(" ");
            node = node.next;
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private Object[] toArray() {
        if (size == 0) {
            return new Object[0];
        }
        Node<T> node = first;
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = node.item;
            node = node.next;
        }
        return array;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }
}
