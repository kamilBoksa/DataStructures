import java.util.Arrays;

public class BinaryTree {
    private Node root;

    BinaryTree(int[] numbers) {
        setTreeRootFromGivenNumbers(numbers);
        createTreeFromGivenNumbers(numbers);
    }

    BinaryTree(Node root) {
        this.root = root;
    }

    public void insert(int value) {
        root.insert(value);
    }

    public int find(int value) {
        return root.find(value);
    }

    public Node getRoot() {
        return root;
    }

    public void remove(int data) {
        root.removeNode(data);
    }

    public void printInOrder() {
        root.printInOrder();
    }

    private void setTreeRootFromGivenNumbers(int[] numbers) {
        Arrays.sort(numbers);
        this.root = new Node(numbers[numbers.length / 2]);
    }

    private void createTreeFromGivenNumbers(int[] numbers) {
        boolean isCreating = true;
        int rootIndex = numbers.length / 2;
        int counter = 1;
        while (isCreating) {
            if (counter < numbers.length - 1) {
                if(rootIndex - counter >= 0) {
                    root.insert(numbers[rootIndex - counter]);
                }
                if(rootIndex + counter <= numbers.length - 1) {
                    root.insert(numbers[rootIndex + counter]);
                }
            }
            else {
                isCreating = false;
            }
            counter++;
        }
    }
}
