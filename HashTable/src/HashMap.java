import java.util.LinkedList;

public class HashMap {

    private int size;
    private LinkedList[] elements;

    HashMap() {
        size = 16;
        this.elements = new LinkedList[size];
    }

    public void add(String key, Integer value) {
        int position = getHash(key);

        if(elements[position] != null) {
            LinkedList<Node> list = elements[position];
            for(Node item : list) {
                if(item.getKey().equals(key)) {
                    throw new IllegalArgumentException("Key already exists");
                }
            }
            list.add(new Node(key, value));
        } else {
            elements[position] = new LinkedList<Node>();
            elements[position].add(new Node(key, value));
        }
    }

    public Integer getValue(String key) {
        int position = getHash(key);
        LinkedList<Node> list = elements[position];
        for(Node item : list) {
            if(item.getKey().equals(key)) {
                return item.getValue();
            }
        }
        return null;
    }

    public void remove(String key) {
        int position = getHash(key);
        if(elements[position] != null) {
            LinkedList<Node> list = elements[position];
            for(Node node : list) {
                if(node.getKey().equals(key)) {
                    list.remove(node);
                }
            }
        } else {
            throw new IllegalArgumentException("Cannot find given key!");
        }
    }

    public void clear() {
        for(int i=0; i<size; i++) {
            elements[i] = null;
        }
    }

    private int getHash(String key) {
        return Math.floorMod(key.hashCode(), size);
    }
}
