public class Queue {

    private Node head;
    private Node tail;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public String peek() {
        if(size == 0) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return head.getValue();
    }

    public void enqueue(String data, Integer priority) {
        Node node = new Node(data, priority);

        if(head == null) {
            head = node;
        }

        if(node.getPriority() > head.getPriority()) {
            node.setNextNode(head);
            head = node;
            size++;
            return;
        }

        if(tail != null) {
            tail.setNextNode(node);
        }

        tail = node;
        size++;
        }

    public String dequeue() {
        if(size == 0) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }

        String data = head.getValue();
        head = head.getNextNode();
        if(head == null) {
            tail = null;
        }
        size--;
        return data;
    }

    public int getSize() {
        return size;
    }
}
