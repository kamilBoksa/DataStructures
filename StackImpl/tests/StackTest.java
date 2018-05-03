import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void test_StackConstructorCapacityFive() {
        int capacity = 5;
        Stack stack = new Stack(capacity);
        assertEquals(5, stack.getStackCapacity());
    }

    @Test
    public void test_isEmptyShouldReturnTrue() {
        int capacity = 2;
        Stack stack = new Stack(capacity);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void test_isEmptyShouldReturnFalse() {
        int capacity = 5;
        Stack<String> stack = new Stack<>(capacity);
        stack.push("A");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void test_peek() {
        int capacity = 5;
        Stack<String> stack = new Stack<>(capacity);
        stack.push("B");
        assertEquals("B", stack.peek());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_pushIntoFullStackSouldRaiseException() {
        int capacity = 1;
        Stack<Integer> stack = new Stack<>(capacity);
        stack.push(22);
        stack.push(55);
    }

    @Test
    public void test_standardPop() {
        int capacity = 3;
        Stack<Integer> stack = new Stack<>(capacity);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_popOnEmptyStackShouldRaiseException() {
        int capacity = 1;
        Stack<Integer> stack = new Stack<>(capacity);
        stack.push(1);
        stack.pop();
        stack.pop();
    }

    @Test
    public void test_getStackCapacity() {
        int capacity = 3;
        Stack<Integer> stack = new Stack<>(capacity);
        stack.push(1);
        stack.pop();
        assertEquals(3, stack.getStackCapacity());
    }

    @Test
    public void test_getSpaceLeft() {
        int capacity = 5;
        Stack<Integer> stack = new Stack<>(capacity);
        stack.push(1);
        stack.push(3);
        assertEquals(3, stack.getSpaceLeft());

        stack.pop();
        assertEquals(4, stack.getSpaceLeft());
    }

    @Test
    public void test_peekShouldNotRemoveItemFromStack() {
        int capacity = 5;
        Stack<Integer> stack = new Stack<>(capacity);
        stack.push(1);
        stack.push(3);
        assertEquals(3, stack.peek());
        assertEquals(3, stack.peek());
    }
}