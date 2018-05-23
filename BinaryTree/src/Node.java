public class Node {
    private Node left;
    private Node right;
    private int data;

    Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if(value <= data) {
            if(left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if(right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }

    public int find(int value) {
        if(data == value) {
            return data;
        } else if(value < data) {
            if(left == null) {
                return 0;
            } else {
                return left.find(value);
            }

        } else {
            if(right == null) {
                return 0;
            } else {
                return right.find(value);
            }
        }
    }

    public void removeNode(int value) {
        if(this.getLeftNode() != null) {
            if(this.getLeftNode().getData() == value) {
                this.setLeft(null);
            }
        }
        if(this.getRightNode() != null) {
            if (this.getRightNode().getData() == value) {
                this.setRight(null);
            }
        }

        if(value < data) {
            if(left != null) {
                left.removeNode(value);
            }
            if(right != null) {
                right.removeNode(value);
            }
        }
    }

    public void printInOrder() {
        if(left != null) {
            left.printInOrder();
        }
        System.out.println(data);
        if(right != null) {
            right.printInOrder();
        }
    }

    public int getData() {
        return data;
    }

    public Node getLeftNode() {
        return left;
    }

    public Node getRightNode() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
