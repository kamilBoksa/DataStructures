import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    private Queue queue;

    @Before
    public void setUp() {
        queue = new Queue();
    }

    @Test
    public void test_isEmptyShouldReturnTrue() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test_peekTwoElementsQueue() {
        queue.enqueue("A", 5);
        queue.enqueue("B", 2);
        String actual = queue.peek();
        assertEquals("A", actual);
    }

    @Test
    public void test_enqueueCreateStandardQueue() {
        queue.enqueue("A", 4);
        queue.enqueue("B", 3);
        queue.enqueue("C", 2);
        queue.enqueue("D", 1);

        assertEquals("A", queue.peek());
        assertEquals(4, queue.getSize());
    }

    @Test
    public void test_enqueueCreateQueueWithMixedPriorities() {
        queue.enqueue("A", 2);
        queue.enqueue("B", 3);
        queue.enqueue("C", 7);
        queue.enqueue("D", 1);

        assertEquals(4, queue.getSize());
        assertEquals("C", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals("A", queue.dequeue());
        assertEquals("D", queue.dequeue());
        assertEquals(0, queue.getSize());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_peekFromEmptyQueueShouldRaiseException() {
        queue.peek();
    }

    @Test
    public void test_standardDequeue() {
        queue.enqueue("A", 4);
        queue.enqueue("B", 3);
        queue.enqueue("C", 2);
        queue.enqueue("D", 1);

        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.dequeue());
        assertEquals("D", queue.dequeue());
    }

}