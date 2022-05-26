package ds;

public class RedBlackTree {
    private enum Color {
        RED, BLACK
    }
    private static class Node {
        int key;
        Color color;
        Node parent;
        Node left;
        Node right;
        public Node(int key) {
            this.key = key;
        }
    }

    private Node root;
    private int size;

    public RedBlackTree() {
        root = null;
        size = 0;
    }

    public Node getRoot() {
        return root;
    }
    public int getSize() {
        return size;
    }

    public Node insert(int key) {
        if (root == null) {
            root = new Node(key);
            root.color = Color.BLACK;
            return root;
        }
        Node next = new Node(key);
        Node ptr = root;
        Node p = ptr;
        while (ptr != null) {
            p = ptr;
            if (ptr.key > key) ptr = ptr.left;
            else ptr = ptr.right;
        }
        next.parent = p;

        if (next.key < p.key) {
            p.left = next;
        } else {
            p.right = next;
        }

        // new node starts off red
        next.color = Color.RED;
        restore(next);
        return next;
    }

    private void restore(Node next) {
        Node p = next.parent;
        while (next.parent.color == Color.RED) {
            if (next.parent == next.parent.parent.left) {       // next's parent is a left child
                p = next.parent.parent.right;                   // p is next's uncle

            }
        }
    }

    private void LR() {     // log(n)

    }

    private void RR() {     // log(n)

    }
}
