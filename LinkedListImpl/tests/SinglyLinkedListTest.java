import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class SinglyLinkedListTest {
    private SinglyLinkedList linkedList;

    @Before
    public void setUp() {
        linkedList = new SinglyLinkedList();
    }

    @Test
    public void test_appendStringTwoElements() {
        linkedList.append("John");
        linkedList.append("Doe");
        assertEquals(2, linkedList.size());
    }

    @Test
    public void test_appendIntegerOneElement() {
        linkedList.append(1);
        assertEquals(1, linkedList.size());
    }

    @Test
    public void test_appendCharsFiveElements() {
        linkedList.append('a');
        linkedList.append('b');
        linkedList.append('c');
        linkedList.append('d');
        linkedList.append('e');
        assertEquals(5, linkedList.size());
    }

    @Test
    public void test_getHeadStringOneElement() {
        linkedList.append("Element");
        assertEquals("Element", linkedList.getHead());
    }

    @Test
    public void test_getHeadIntegerThreeElements() {
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        assertEquals(1, linkedList.getHead());
    }

    @Test
    public void test_getLastStringThreeElements() {
        linkedList.append("John");
        linkedList.append("Doe");
        linkedList.append("Lorem Ipsum");
        assertEquals("Lorem Ipsum", linkedList.getLast());
    }

    @Test
    public void test_getLastIntegerOneElement() {
        linkedList.append(1);
        assertEquals(1, linkedList.getLast());
    }

    @Test
    public void test_prepend() {
        linkedList.append(1);
        linkedList.append(2);
        linkedList.prepend(77);

        assertEquals(3, linkedList.size());
        assertEquals(77, linkedList.getHead());
    }

    @Test
    public void test_getByIndexSecondElement() {
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        assertEquals(2, linkedList.getByIndex(1));
    }

    @Test
    public void test_getByIndexFirstElement() {
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);

        assertEquals(1, linkedList.getByIndex(0));
    }

    @Test
    public void test_getByIndexLastElement() {
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);

        assertEquals(4, linkedList.getByIndex(3));
    }

    @Test
    public void test_insert() {
        linkedList.append('A');
        linkedList.append('B');
        linkedList.append('D');
        linkedList.insert(2, 'C');

        assertEquals(4, linkedList.size());
        assertEquals('C', linkedList.getByIndex(2));
    }

    @Test
    public void test_getByDataString() {
        linkedList.append("John");
        linkedList.append("Doe");
        linkedList.append("Lorem");
        linkedList.append("Ipsum");

        assertEquals("Lorem", linkedList.getByData("Lorem"));
    }

    @Test
    public void test_getByDataFloat() {
        linkedList.append(1.0);
        linkedList.append(1.5);
        linkedList.append(5.5);
        linkedList.append(92.5);

        assertEquals(5.5, linkedList.getByData(5.5));
    }

    @Test
    public void test_deleteByValueInteger() {
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.deleteByValue(3);

        assertEquals(3, linkedList.size());
        assertEquals(4, linkedList.getByIndex(3));
    }

    @Test
    public void test_deleteByValueFirstElement() {
        linkedList.append(10);
        linkedList.append(22);
        linkedList.append(33);
        linkedList.append(44);
        linkedList.deleteByValue(10);

        assertEquals(3, linkedList.size());
        assertEquals(22, linkedList.getByIndex(0));
    }

    @Test
    public  void test_deleteByIndexFirstElement() {
        linkedList.append(10);
        linkedList.append(22);
        linkedList.append(33);
        linkedList.deleteByIndex(0);

        assertEquals(2, linkedList.size());
        assertEquals(22, linkedList.getByIndex(0));
    }

    @Test
    public void test_deleteByIndexThirdElement() {
        linkedList.append(10);
        linkedList.append(22);
        linkedList.append(33);
        linkedList.append(55);
        linkedList.append(66);
        linkedList.deleteByIndex(2);

        assertEquals(4, linkedList.size());
        assertEquals(55, linkedList.getByIndex(2));
    }

    @Test
    public void test_deleteByIndexLastElement() {
        linkedList.append("Lorem");
        linkedList.append("Ipsum");
        linkedList.append("Dolor");
        linkedList.deleteByIndex(2);

        assertEquals(2, linkedList.size());
        assertEquals("Ipsum", linkedList.getByIndex(1));
        assertFalse(linkedList.getByIndex(2).equals("Dolor"));
    }
}