public class Stack <T> {
    private Node top;
    private int capacity;
    private int spaceLeft;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.spaceLeft = capacity;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Object peek() {
        return top.getData();
    }

    public void push(T data) {
        if(spaceLeft == 0) {
            throw new IndexOutOfBoundsException("Stack is full");
        }
        Node node = new Node(data);
        node.setNext(top);
        top = node;
        spaceLeft--;
    }

    public Object pop() {
        if(spaceLeft == capacity) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        Object data = top.getData();
        top = top.getNext();
        spaceLeft++;
        return data;
    }

    public int getStackCapacity() {
        return  capacity;
    }

    public int getSpaceLeft() {
        return  spaceLeft;
    }
}
