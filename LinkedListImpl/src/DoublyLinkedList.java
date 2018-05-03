public class DoublyLinkedList {
    private Node head;
    private Node last;
    private int length;

    public void append(Object data) {
        if(head == null) {
            head = new Node(data);
            head.previous = null;
            last = head;
            length++;
            return;
        }

        Node current = head;

        while(current.next != null) {
            current = current.next;
        }

        current.next = new Node(data);
        current.next.previous = current;

        last = current.next;
        last.previous = current.next.previous;
        length ++;
    }

    public void prepend(Object data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head.previous = head;
        head = newHead;
        length++;
    }

    public void insert(int index, Object data) {

        if(index == 0) {
            prepend(data);
            return;
        }

        if(index == length) {
            append(data);
            return;
        }

        int counter = 0;
        Node current = head;

        while(current.next != null && counter != index) {
            current = current.next;
            counter++;
        }

        Node newNode = new Node(data);
        if(current.next == null) {
            newNode.previous = current.previous;
            current.previous.next = newNode;
            newNode.next = current;
            current.previous = newNode;

        } else {
            newNode.next = current;
            newNode.previous = current.previous;
            current.previous.next = newNode;
            current.previous = newNode;
        }
        length++;
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
                current.next.next.previous = current;
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
            head.previous = null;
            length--;
        } else if(index == length -1) {
            last = last.previous;
            last.next = null;
            length--;
        } else {
            Node current = head;

            while(current.next != null) {
                if(index  == counter+1) {
                    current.next.next.previous = current;
                    current.next = current.next.next;
                    length--;
                    return;
                }
                counter++;
                current = current.next;
            }
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

    public boolean isEmpty() {
        return length == 0;
    }

    public Object getPrevious() {
        if(last.previous != null) {
            return last.previous.data;
        }
        return null;
    }
}
