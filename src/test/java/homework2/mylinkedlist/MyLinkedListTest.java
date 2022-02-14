package homework2.mylinkedlist;

import anderson.homework2.mylinkedlist.MyLinkedList;
import anderson.homework2.mylinkedlist.MyLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyLinkedListTest {

    @Test
    public void shouldAddElementIntoMyLinkedList() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedListImpl<>();
        myLinkedList.add(0);
        myLinkedList.add(3);
        myLinkedList.add(5);

        Assertions.assertTrue(myLinkedList.size() > 0);
        Assertions.assertEquals(0, myLinkedList.get(0));
        Assertions.assertEquals(3, myLinkedList.get(1));
        Assertions.assertEquals(5, myLinkedList.get(2));
    }

    @Test
    public void shouldDeleteElementInTheMiddleFromMyLinkedList() {
        MyLinkedList<String> myLinkedList = new MyLinkedListImpl<>();
        myLinkedList.add("Power");
        myLinkedList.add("and");
        myLinkedList.add("delete me, please");
        myLinkedList.add("honor");

        int sizeBeforeDeleting = myLinkedList.size();
        myLinkedList.delete(2);
        int sizeAfterDeleting = myLinkedList.size();

        Assertions.assertEquals(sizeBeforeDeleting, sizeAfterDeleting + 1);
        Assertions.assertEquals("honor", myLinkedList.get(2));
    }

    @Test
    public void shouldDeleteFirstElementInMyLinkedList() {
        MyLinkedList<String> myLinkedList = new MyLinkedListImpl<>();
        myLinkedList.add("delete me, please");
        myLinkedList.add("Power");
        myLinkedList.add("and");
        myLinkedList.add("honor");

        int sizeBeforeDeleting = myLinkedList.size();
        myLinkedList.delete(0);
        int sizeAfterDeleting = myLinkedList.size();

        Assertions.assertEquals(sizeBeforeDeleting, sizeAfterDeleting + 1);
        Assertions.assertEquals("Power", myLinkedList.get(0));
    }

    @Test
    public void shouldDeleteLastElementInMyLinkedList() {
        MyLinkedList<String> myLinkedList = new MyLinkedListImpl<>();
        myLinkedList.add("Power");
        myLinkedList.add("and");
        myLinkedList.add("honor");
        myLinkedList.add("delete me, please");

        int sizeBeforeDeleting = myLinkedList.size();
        myLinkedList.delete(3);
        int sizeAfterDeleting = myLinkedList.size();

        Assertions.assertEquals(sizeBeforeDeleting, sizeAfterDeleting + 1);
        Assertions.assertEquals("honor", myLinkedList.getLast());
    }

    @Test
    public void shouldReturnFirstElement() {
        MyLinkedList<String> myLinkedList = new MyLinkedListImpl<>();
        myLinkedList.add("Power");
        myLinkedList.add("and");
        myLinkedList.add("honor");

        Assertions.assertEquals("Power", myLinkedList.getFirst());
    }

    @Test
    public void shouldReturnLastElement() {
        MyLinkedList<String> myLinkedList = new MyLinkedListImpl<>();
        myLinkedList.add("Power");
        myLinkedList.add("and");
        myLinkedList.add("honor");

        Assertions.assertEquals("honor", myLinkedList.getLast());
    }

    @Test
    public void shouldAddAllElementsFromAnotherList() {
        MyLinkedList<String> myLinkedList = new MyLinkedListImpl<>();
        myLinkedList.add("Power");
        myLinkedList.add("and");
        myLinkedList.add("honor");

        MyLinkedList<String> anotherLinkedList = new MyLinkedListImpl<>();
        anotherLinkedList.addAll(myLinkedList);

        Assertions.assertTrue(anotherLinkedList.size() > 0);
        Assertions.assertEquals(myLinkedList.size(), anotherLinkedList.size());
        Assertions.assertEquals(myLinkedList.getFirst(), anotherLinkedList.getFirst());
    }

    @Test
    public void shouldCreateListByAnotherList() {
        MyLinkedList<String> myLinkedList = new MyLinkedListImpl<>();
        myLinkedList.add("Power");
        myLinkedList.add("and");
        myLinkedList.add("honor");

        MyLinkedList<String> anotherLinkedList = new MyLinkedListImpl<>(myLinkedList);
        Assertions.assertTrue(anotherLinkedList.size() > 0);
        Assertions.assertEquals(myLinkedList.size(), anotherLinkedList.size());
        Assertions.assertEquals(myLinkedList.getFirst(), anotherLinkedList.getFirst());
    }

    @Test
    public void shouldConcatAnotherListToThis() {
        MyLinkedList<String> myLinkedList = new MyLinkedListImpl<>();
        myLinkedList.add("Power");
        myLinkedList.add("and");
        myLinkedList.add("honor");
        int sizeBeforeConcat = myLinkedList.size();

        MyLinkedList<String> anotherLinkedList = new MyLinkedListImpl<>();
        anotherLinkedList.add("Fight");
        anotherLinkedList.add("with");
        anotherLinkedList.add("honor");
        anotherLinkedList.add("friend");

        myLinkedList.concat(anotherLinkedList);
        int sizeAfterConcat = myLinkedList.size();

        Assertions.assertTrue(sizeBeforeConcat < sizeAfterConcat);
        Assertions.assertEquals(myLinkedList.getLast(), anotherLinkedList.getLast());
    }
}
