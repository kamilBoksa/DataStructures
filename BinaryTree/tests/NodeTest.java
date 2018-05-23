import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class NodeTest {
    private Random generator;

    @Before
    public void setup() {
        generator = new Random();
    }

    @Test
    public void testInsert_OneBranchingLeftSide() {
        Node node = new Node(3);
        BinaryTree tree = new BinaryTree(node);
        tree.insert(2);
        int expected = 2;
        int actual = node.getLeftNode().getData();
        assertEquals(expected,actual);
    }

    @Test
    public void testInsert_OneBranchingRightSide() {
        Node node = new Node(3);
        BinaryTree tree = new BinaryTree(node);
        tree.insert(10);
        int expected = 10;
        int actual = node.getRightNode().getData();
        assertEquals(expected, actual);
    }

    @Test
    public void testFind() {
        Node node = new Node(0);
        BinaryTree tree = new BinaryTree(node);
        int number = 0;
        for(int i = 1; i< 10000; i++) {
            int j = generator.nextInt();
            tree.insert(j);
            if(i == 2000) {
                number = j;
            }
        }
        long startTime = System.nanoTime();
        int actual = tree.find(number);
        long endTime = System.nanoTime();
        System.out.println(String.format("Finder estimated time : %d", endTime - startTime));
        int expected = actual;
        assertEquals(expected,actual);
    }

    @Test
    public void testRootSetter_OddAmountOfNumbers() {
        int[] numbers = new int[] {1, 2, 3, 4, 6};
        BinaryTree tree = new BinaryTree(numbers);
        int actual = tree.getRoot().getData();
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void testRootSetter_EvenAmountOfNumbers() {
        int[] numbers = new int[] {4, 3, 2, 1};
        BinaryTree tree = new BinaryTree(numbers);
        int actual = tree.getRoot().getData();
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void testCreateTreeFromGivenNumbers_ThreeElements() {
        int[] numbers = new int[] {1, 2, 3};
        BinaryTree tree = new BinaryTree(numbers);
        assertEquals(2, tree.getRoot().getData());
        assertEquals(1, tree.getRoot().getLeftNode().getData());
        assertEquals(3, tree.getRoot().getRightNode().getData());
    }

    @Test
    public void testCreateTreeFromGivenNumbers_FourElements() {
        int[] numbers = new int[] {8, 3, 6 ,17};
        BinaryTree tree = new BinaryTree(numbers);
        assertEquals(8, tree.getRoot().getData());
        assertEquals(6, tree.getRoot().getLeftNode().getData());
        assertEquals(17, tree.getRoot().getRightNode().getData());
        assertEquals(3, tree.getRoot().getLeftNode().getLeftNode().getData());
    }

    @Test
        public void testCreateTreeFromGivenNumbers_SevenElements_RootData() {
        int[] numbers = new int[]{6, 4, 5, 8, 9, 7, 22};
        BinaryTree tree = new BinaryTree(numbers);
        assertEquals(7, tree.getRoot().getData());
    }
    @Test
        public void testCreateTreeFromGivenNumbers_SevenElements_LeftChildData() {
        int[] numbers = new int[]{6, 4, 5, 8, 9, 7, 22};
            BinaryTree tree = new BinaryTree(numbers);
            assertEquals(6, tree.getRoot().getLeftNode().getData());
    }

    @Test
    public void testCreateTreeFromGivenNumbers_SevenElements_RightChildData() {
        int[] numbers = new int[]{6, 4, 5, 8, 9, 7, 22};
        BinaryTree tree = new BinaryTree(numbers);
        assertEquals(8, tree.getRoot().getRightNode().getData());
    }

    @Test
    public void testCreateTreeFromGivenNumbers_SevenElements_LeftSideLeftGrandsonData() {
        int[] numbers = new int[]{6, 4, 5, 8, 9, 7, 22};
        BinaryTree tree = new BinaryTree(numbers);
        assertEquals(5, tree.getRoot().getLeftNode().getLeftNode().getData());
    }

    @Test
    public void testCreateTreeFromGivenNumbers_SevenElements_RightSideRightGrandsonData() {
        int[] numbers = new int[]{6, 4, 5, 8, 9, 7, 22};
        BinaryTree tree = new BinaryTree(numbers);
        assertEquals(9, tree.getRoot().getRightNode().getRightNode().getData());
    }

    @Test
    public void testCreateTreeFromGivenNumbers_SevenElements_LeftSideLeftGreatGrandsonData() {
        int[] numbers = new int[]{6, 4, 5, 8, 9, 7, 22};
        BinaryTree tree = new BinaryTree(numbers);
        assertEquals(4, tree.getRoot().getLeftNode().getLeftNode().getLeftNode().getData());
    }

    @Test
    public void testCreateTreeFromGivenNumbers_SevenElements_RightSideRightGreatGrandsonData() {
        int[] numbers = new int[]{6, 4, 5, 8, 9, 7, 22};
        BinaryTree tree = new BinaryTree(numbers);
        assertEquals(22, tree.getRoot().getRightNode().getRightNode().getRightNode().getData());
    }

    @Test
    public void testRemove_FirstCase() {
        Node node = new Node(3);
        BinaryTree tree = new BinaryTree(node);
        tree.insert(10);
        tree.insert(2);
        tree.remove(10);
        assertEquals(null, tree.getRoot().getRightNode());
    }

    @Test
    public void testRemove_SecondCase() {
        Node node = new Node(8);
        BinaryTree tree = new BinaryTree(node);
        tree.insert(3);
        tree.insert(10);
        tree.insert(1);
        tree.remove(1);
        assertEquals(null, node.getLeftNode().getLeftNode());
    }

    @Test
    public void testPrintInOrder() {
        int[] numbers = new int[]{6, 4, 5, 8, 9, 7, 22};
        BinaryTree tree = new BinaryTree(numbers);
        tree.printInOrder();
    }
}