import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {
    private HashMap map;

    @Before
    public void setUp() {
        map = new HashMap();
    }

    @Test
    public void testAdd_SingleItem() {
        map.add("test", 17);
        int expected = 17;
        int actual = map.getValue("test");
        assertEquals(expected, actual);
    }

    @Test
    public void testAdd_ThreeItems() {
        map.add("test", 7);
        map.add("test2", 8);
        map.add("test3", 10);

        int actualOne = map.getValue("test");
        int actualTwo = map.getValue("test2");
        int actualThree = map.getValue("test3");

        assertEquals(7, actualOne);
        assertEquals(8, actualTwo);
        assertEquals(10, actualThree);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAdd_SameKeysShouldRaiseException() {
        map.add("test", 8);
        map.add("test", 10);
    }

    @Test
    public void testAdd_SixteenItems() {
        map.add("test1", 1);
        map.add("test2", 2);
        map.add("test3", 3);
        map.add("test4", 4);
        map.add("test5", 5);
        map.add("test6", 6);
        map.add("test7", 7);
        map.add("test8", 8);
        map.add("test9", 9);
        map.add("test10", 10);
        map.add("test11", 11);
        map.add("test12", 12);
        map.add("test13", 13);
        map.add("test14", 14);
        map.add("test15", 15);
        map.add("test16", 16);

        int expected = 16;
        int actual = map.getValue("test16");
        assertEquals(expected, actual);
    }

    @Test
    public void testRemove_existingElement() {
        map.add("test1", 1);
        map.add("test2", 2);

        map.remove("test2");
        Integer actual = map.getValue("test2");
        assertEquals(null, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemove_nonExistingElement() {
        map.remove("test");
    }

    @Test
    public void testClear() {
        map.add("test1", 1);
        map.add("test2", 2);
        map.add("test3", 3);
        map.add("test4", 4);
        map.add("test5", 5);
        map.add("test6", 6);
        map.add("test7", 7);
        map.add("test8", 8);
        map.add("test9", 9);
        map.add("test10", 10);
        map.add("test11", 11);
        map.add("test12", 12);
        map.add("test13", 13);
        map.add("test14", 14);
        map.add("test15", 15);
        map.add("test16", 16);

        map.clear();
        map.add("test3", 88);
        int actual = map.getValue("test3");
        assertEquals(88, actual);
    }
}