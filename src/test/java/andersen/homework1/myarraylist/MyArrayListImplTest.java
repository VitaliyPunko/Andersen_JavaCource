package andersen.homework1.myarraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyArrayListImplTest {

    @Test
    void shouldAddElementInMyList() {
        MyArrayList<Integer> myArrayList = new MyArrayListImpl<>();
        int sizeBefore = myArrayList.size();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        int sizeAfter = myArrayList.size();
        Assertions.assertTrue(sizeAfter > sizeBefore);
    }

    @Test
    void shouldReturnCorrectSize() {
        MyArrayList<Integer> myArrayList = new MyArrayListImpl<>();
        int sizeBefore = myArrayList.size();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        int sizeAfter = myArrayList.size();
        Assertions.assertEquals(0, sizeBefore);
        Assertions.assertEquals(3, sizeAfter);
    }

    @Test
    void shouldCopyOneListToAnother() {
        MyArrayList<String> myArrayList = new MyArrayListImpl<>();
        myArrayList.add("Hello");
        myArrayList.add(null);
        myArrayList.add("Beauty");
        myArrayList.add("world");
        MyArrayList<String> anotherList = myArrayList.copy(myArrayList);

        Assertions.assertEquals(myArrayList.size(), anotherList.size());
        Assertions.assertEquals(myArrayList.get(0), anotherList.get(0));
        Assertions.assertEquals(myArrayList.get(1), anotherList.get(1));
        Assertions.assertEquals(myArrayList.get(2), anotherList.get(2));
    }

    @Test
    void shouldReturnElementByIdMethodGet() {
        MyArrayList<String> myArrayList = new MyArrayListImpl<>();
        myArrayList.add("Hello");
        myArrayList.add("Beauty");
        String hello = myArrayList.get(0);
        String beauty = myArrayList.get(1);

        Assertions.assertEquals(myArrayList.get(0), hello);
        Assertions.assertEquals(myArrayList.get(1), beauty);
        Assertions.assertEquals(myArrayList.get(0).length(), hello.length());
    }

    @Test
    void shouldDeleteElement() {
        MyArrayList<String> myArrayList = new MyArrayListImpl<>();
        myArrayList.add("Hello");
        myArrayList.add("Beauty");
        myArrayList.add("World");
        int sizeBeforeDelete = myArrayList.size();
        myArrayList.delete(0);

        Assertions.assertEquals("Beauty", myArrayList.get(0));
        Assertions.assertEquals(sizeBeforeDelete - 1, myArrayList.size());
    }

    @Test
    void shouldThrowExceptionDeleteWrongIndex() {
        MyArrayList<String> myArrayList = new MyArrayListImpl<>();
        myArrayList.add("Hello");
        myArrayList.add("World");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            myArrayList.delete(2);
        });
    }

    @Test
    void shouldConcatMyArrayListToAnother() {
        MyArrayList<String> myArrayList = new MyArrayListImpl<>();
        myArrayList.add("Hello");
        myArrayList.add("Beauty");
        myArrayList.add("World");
        int sizeBeforeConcat = myArrayList.size();

        MyArrayList<String> anotherList = new MyArrayListImpl<>();
        anotherList.add("This");
        anotherList.add("is");
        anotherList.add("another");
        anotherList.add("list");
        myArrayList.concat(anotherList);
        int sizeAfterConcat = myArrayList.size();

        Assertions.assertEquals(sizeBeforeConcat + anotherList.size(), sizeAfterConcat);
        Assertions.assertEquals(myArrayList.get(4), anotherList.get(1));
    }

    @Test
    void sort() {
        MyArrayList<String> myArrayList = new MyArrayListImpl<>();
        myArrayList.add("Hello");
        myArrayList.add("Beauty");
        myArrayList.add("World");
        myArrayList.sort(String::compareToIgnoreCase);

        Assertions.assertEquals("Beauty", myArrayList.get(0));
    }

}
