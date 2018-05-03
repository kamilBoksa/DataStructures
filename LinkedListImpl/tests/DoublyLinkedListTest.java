import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    private DoublyLinkedList linkedList;

    @Before
    public void setUp() {
        linkedList = new DoublyLinkedList();
    }

    @Test
    public void test_appendStringTwoElements() {
        Node first = new Node("John");
        Node second = new Node("Doe");
        linkedList.append(first);
        linkedList.append(second);

        assertEquals(2, linkedList.size());
        assertEquals(first, linkedList.getPrevious());
    }

    @Test
    public void test_appendIntegerOneElement() {
        Node node = new Node(1);
        linkedList.append(node);

        assertEquals(1, linkedList.size());
        assertEquals(node, linkedList.getByIndex(0));
    }

    @Test
    public void test_isEmptyShouldReturnTrue() {
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void test_isEmptyShouldReturnFalse() {
        linkedList.append("John Doe");
        assertFalse(linkedList.isEmpty());
    }

    @Test
    public void test_appendCharsFiveElements() {
        Node first = new Node('a');
        Node second = new Node('b');
        Node third = new Node('c');
        Node fourth = new Node('d');
        Node fifth = new Node('e');
        linkedList.append(first);
        linkedList.append(second);
        linkedList.append(third);
        linkedList.append(fourth);
        linkedList.append(fifth);
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
    public void test_getPreviousOneElement() {
        linkedList.append("ABC");
        assertEquals(null, linkedList.getPrevious());
    }

    @Test
    public void test_getPreviousThreeElements() {
        linkedList.append("A");
        linkedList.append("AB");
        linkedList.append("ABC");
        assertEquals("AB", linkedList.getPrevious());
    }

    @Test
    public void test_prepend() {
        linkedList.append(1);
        linkedList.append(2);
        linkedList.prepend(77);

        assertEquals(3, linkedList.size());
        assertEquals(77, linkedList.getHead());
        assertEquals(1, linkedList.getPrevious());
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
        linkedList.append(5);
        linkedList.append(6);
        linkedList.append(7);
        linkedList.append(8);

        assertEquals(5, linkedList.getByIndex(0));
    }

    @Test
    public void test_getByIndexLastElement() {
        linkedList.append(11);
        linkedList.append(22);
        linkedList.append(33);
        linkedList.append(44);

        assertEquals(44, linkedList.getByIndex(3));
    }

    @Test
    public void test_insertSecondIndex() {
        linkedList.append('A');
        linkedList.append('B');
        linkedList.append('D');
        linkedList.insert(2, 'C');

        assertEquals(4, linkedList.size());
        assertEquals('C', linkedList.getByIndex(2));
        assertEquals('D', linkedList.getByIndex(3));
    }

    @Test
    public void test_insertThirdIndex() {
        linkedList.append('A');
        linkedList.append('B');
        linkedList.append('C');
        linkedList.append('D');
        linkedList.insert(2, 'Z');

        assertEquals(5, linkedList.size());
        assertEquals('Z', linkedList.getByIndex(2));
        assertEquals('C', linkedList.getByIndex(3));
        assertEquals('D', linkedList.getByIndex(4));
    }

    @Test
    public void test_insertFirstIndex() {
        linkedList.append('A');
        linkedList.append('B');
        linkedList.insert(0, 'C');
        assertEquals(3, linkedList.size());
        assertEquals('C', linkedList.getByIndex(0));
        assertEquals('A', linkedList.getByIndex(1));
    }

    @Test
    public void test_insertLastIndex() {
        linkedList.append('A');
        linkedList.append('B');
        linkedList.insert(2, 'C');
        assertEquals(3, linkedList.size());
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
        assertEquals(4, linkedList.getByIndex(2));
        assertEquals(2, linkedList.getByIndex(1));
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
        assertEquals(33, linkedList.getByIndex(1));
    }

    @Test
    public  void test_deleteByIndexFirstElement() {
        linkedList.append(10);
        linkedList.append(22);
        linkedList.append(33);
        linkedList.deleteByIndex(0);

        assertEquals(2, linkedList.size());
        assertEquals(22, linkedList.getByIndex(0));
        assertEquals(33, linkedList.getByIndex(1));
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
        assertEquals(22, linkedList.getByIndex(1));
        assertEquals(66, linkedList.getByIndex(3));
    }

    @Test
    public void test_deleteByIndexLastElement() {
        linkedList.append("Lorem");
        linkedList.append("Ipsum");
        linkedList.append("Dolor");
        linkedList.deleteByIndex(2);

        assertEquals(2, linkedList.size());
        assertEquals("Ipsum", linkedList.getByIndex(1));
        assertEquals("Lorem", linkedList.getByIndex(0));
        assertFalse(linkedList.getByIndex(2).equals("Dolor"));
    }
}