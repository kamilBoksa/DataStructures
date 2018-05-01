public class SinglyLinkedList {
    private Node head;
    private Node last;
    private int length;

    public void append(Object data) {
        if(head == null) {
            head = new Node(data);
            last = head;
            length++;
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }

        current.next = new Node(data);
        last = current.next;
        length ++;
    }

    public void prepend(Object data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
        length++;
    }

    public void insert(int index, Object data) {
        int counter = 0;
        Node current = head;

        while(current.next != null) {
            if(counter == index) {
                current.next = new Node(data);
                length++;
                return;
            }
            counter++;
        }
    }

    public void deleteByValue(Object data) {
        if (head == null) {
            return;
        }
        if(head.data.equals(data)) {
            head = head.next;
            length--;
            return;
        }

        Node current = head;
        while(current.next != null) {
            if(current.next.data.equals(data)) {
                current.next = current.next.next;
                length--;
                return;
            }
            current = current.next;
        }
    }

    public void deleteByIndex(int index) {
        int counter = 0;
        if (index == 0) {
            head = head.next;
            length--;
            return;
        }

        Node current = head;
        while(current.next != null) {
            if(index  == counter+1) {
                current.next = current.next.next;
                length--;
                return;
            }
            counter++;
            current = current.next;
        }
    }

    public Object getByData(Object data) {
        Node current = head;
        if(current.data.equals(data)) {
            return current.data;
        }
        while(current.next != null) {
            if(current.next.data.equals(data)) {
                return current.next.data;
            }
            current = current.next;
        }
        return null;
    }

    public Object getByIndex(int index) {
        int counter = 0;
        Node current = head;

        if(index == 0) {
            return current.data;
        }

        while(current.next != null) {
            if(counter == index) {
                return current.data;
            }
            current = current.next;
            counter++;
        }
        return current.data;
    }

    public Object getHead() {
        return head.data;
    }

    public Object getLast() {
        return last.data;
    }

    public int size() {
        return  length;
    }
}
