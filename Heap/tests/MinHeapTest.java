import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinHeapTest {

    private MinHeap heap;

    @Before
    public void setUp() {
        int capacity = 10;
        heap = new MinHeap(capacity);
    }

    @Test
    public void testPeek_threeItemsHeap() {
        heap.add(1);
        heap.add(2);
        heap.add(3);
        int expected = 1;
        int actual = heap.peek();
        assertEquals(actual, expected);
    }

    @Test (expected = IllegalStateException.class)
    public void testPeek_emptyHeapShouldRaiseException() {
        int actual = heap.peek();
    }

    @Test
    public void testPeek_MixedElementsShouldReturnSmallestInt() {
        heap.add(5);
        heap.add(8);
        heap.add(3);
        heap.add(4);
        int expected = 3;
        int actual = heap.peek();
        assertEquals(expected, actual);
    }

    @Test
    public void testPool_ThreeElements() {
        heap.add(1);
        heap.add(2);
        heap.add(3);
        int expected = 1;
        int actual = heap.poll();
        assertEquals(expected, actual);
        assertEquals(2, heap.getSize());
    }

    @Test
    public void testPool_FiveElementsHeapifyDownCorrection() {
        heap.add(5);
        heap.add(8);
        heap.add(3);
        heap.add(4);
        heap.poll();

        int expected = 4;
        int actual = heap.peek();
        assertEquals(expected, actual);
    }

    @Test
    public void testPool_FiveElementsHeapifyUpCorrection() {
        heap.add(15);
        heap.add(8);
        heap.add(2);
        heap.add(6);

        int expected = 2;
        int actual = heap.peek();
        assertEquals(expected, actual);
    }
}