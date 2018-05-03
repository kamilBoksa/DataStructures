public class Node {
    Node next;
    Node previous;
    Object data;

    Node(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
