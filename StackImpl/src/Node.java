class Node <T> {
    private T data;
    private Node next;

    Node(T data) {
        this.data = data;
    }

    public T getData () {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
