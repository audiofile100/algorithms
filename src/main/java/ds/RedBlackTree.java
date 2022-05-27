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

    public static void main(String[] args) {

        RedBlackTree tree = new RedBlackTree();
        Node root = new Node(11);
        tree.insert(root);
        tree.insert(new Node(2));

        tree.print();
    }

    public void insert(Node z) {
        Node x = root;
        Node y = null;
        while (x != null) {
            y = x;
            if (z.key < x.key) x = x.left;
            else x = x.right;
        }
        z.parent = y;
        if (y == null) {
            root = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = null;
        z.right = null;
        // new node starts off red
        z.color = Color.RED;
        restoreInsertion(z);
    }

    private void restoreInsertion(Node z) {
        while (z.parent != null && z.parent.color == Color.RED) {
            if (z.parent == z.parent.parent.left) {     // z's parent is a left child
                Node y = z.parent.parent.right;         // y is z's uncle
                if (y.color == Color.RED) {             // z's parent and uncle are both red
                    z.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        LR(z);
                    }
                    z.parent.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    RR(z.parent.parent);
                }
            } else {
                Node y = z.parent.parent.left;
                if (y.color == Color.RED) {
                    z.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        RR(z);
                    }
                    z.parent.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    LR(z.parent.parent);
                }
            }
        }
        root.color = Color.BLACK;
    }

    private void LR(Node x) {     // log(n)
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {    // x is left child
            x.parent.left = y;
        } else {                            // x is right child
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void RR(Node y) {     // log(n)
        Node x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (x.parent == null) {
            root = x;
        } else if (y == y.parent.right) {   // y is right child
            y.parent.right = x;
        } else {
            y.parent.left = x;
        }
        x.right = y;
        y.parent = x;
    }

    private void print() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        inOrderHelper(node);
        System.out.println();
    }

    private void inOrderHelper(Node node) {
        if (node == null) return;
        inOrderHelper(node.left);
        System.out.print(node.key + " ");
        inOrderHelper(node.right);
    }
}
