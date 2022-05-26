package ds;

import java.util.ArrayDeque;
import java.util.Deque;

// possibly unbalanced
public class Tree {
    private static class Node {
        int key;
        Node parent;
        Node left;
        Node right;
        public Node(int key) {
            this.key = key;
        }
    }

    private final Node root;
    private int size;

    public Node getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public Tree(Integer[] data) {
        root = new Node(data[0]);
        ++size;
        Deque<Node> curr = new ArrayDeque<>();
        curr.offer(root);
        int idx = 0;

        while (!curr.isEmpty()) {
            int leftIdx = 2 * idx + 1;
            int rightIdx = 2 * idx + 2;

            Node ptr = curr.poll();
            if (leftIdx < data.length && data[leftIdx] != null) {
                Node left = new Node(data[leftIdx]);
                ptr.left = left;
                left.parent = ptr;
                curr.offer(left);
                ++size;
            }
            if (rightIdx < data.length && data[rightIdx] != null) {
                Node right = new Node(data[rightIdx]);
                ptr.right = right;
                right.parent = ptr;
                curr.offer(right);
                ++size;
            }
            ++idx;
        }
    }

    public static void main(String[] args) {

        Integer[] data = { 8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13, null };

        Tree tree = new Tree(data);
        Node root = tree.getRoot();

        tree.inOrder(root);

        System.out.println("height: " + tree.height(root));
        System.out.println("min: " + tree.min(root).key);
        System.out.println("max: " + tree.max(root).key);
        System.out.println("size: " + tree.getSize());

        int searchKey = 14;
        Node search = tree.search(root, searchKey);
        if (search == null) {
            System.out.println(searchKey + " not found");
        }

        Node pred;
        Node succ;
        if (search != null) {
            pred = tree.predecessor(search);
            succ = tree.successor(search);

            String predecessorMsg = "predecessor for " + search.key + ": ";
            System.out.println((pred != null) ? predecessorMsg + pred.key : predecessorMsg + " none -> " + searchKey + " is already min");

            String successorMsg = "successor for " + search.key + ": ";
            System.out.println((succ != null) ? successorMsg + succ.key : successorMsg + " none -> " + searchKey + " is already max");
        }

        int insertKey = 9;
        Node insert = tree.insert(root, insertKey);
        String insertMsg = "inserting " + insertKey + ": ";
        System.out.println((insert != null) ? insertMsg + "successful" : insertMsg + "unsuccessful");

        tree.inOrder(root);

        int deleteKey = 9;
        boolean isDelete = tree.delete(root, deleteKey);
        String deleteMsg = "deleting " + deleteKey + ": ";
        System.out.println((isDelete) ? deleteMsg + "successful" : deleteMsg + "unsuccessful" );

        tree.inOrder(root);
        System.out.println("size: " + tree.getSize());
    }

    // returns the ith-smallest node
    public Node selectIth(int ith) {
        // augment the node object to have size property
        // of subtree including itself
        return null;
    }

    public boolean delete(Node tree, int key) {
        Node node = search(tree, key);     // the node to delete
        if (node == null) return false;

        if (node.left != null && node.right != null) {
            Node pred = predecessor(node);
            node.key = pred.key;
            node = pred;    // point to the node to delete
        }

        Node p = node.parent;
        if (node.left == null && node.right == null) {      // node is a leaf
            if (p.key <= key) {
                p.right = null;
            } else {
                p.left = null;
            }
            node.parent = null;
            --size;
            return true;
        }

        if (node.left != null) {
            node.left.parent = p;
            p.left = node.left;
            node.left = null;
        } else {
            node.right.parent = p;
            p.right = node.right;
            node.right = null;
        }
        node.parent = null;
        --size;

        return true;
    }

    public Node insert(Node tree, int key) {
        Node ptr = tree;
        Node next = new Node(key);
        while (ptr != null) {
            if (ptr.left == null && key < ptr.key) {
                next.parent = ptr;
                ptr.left = next;
                ++size;
                return next;
            }
            if (ptr.right == null && key >= ptr.key) {
                next.parent = ptr;
                ptr.right = next;
                ++size;
                return next;
            }

            if (key < ptr.key) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }
        return null;
    }

    public Node successor(Node node) {
        if (node.right != null) {
            return min(node.right);
        }

        Node p = node.parent;

        while (p != null && p.key < node.key) {
            p = p.parent;
        }

        return p;
    }

    public Node predecessor(Node node) {
        if (node.left != null) {
            return max(node.left);
        }

        Node p = node.parent;

        while (p != null && p.key > node.key) {
            p = p.parent;
        }

        return p;
    }

    public Node max(Node node) {
        if (node.right == null) return node;
        return max(node.right);
    }

    public Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    public Node search(Node tree, int key) {
        if (tree == null) return null;
        if (tree.key == key) return tree;
        else if (tree.key < key) return search(tree.right, key);
        else return search(tree.left, key);
    }

    public int height(Node node) {
        if (node == null) return 0;
        int left = height(node.left) + 1;
        int right = height(node.right) + 1;
        return Math.max(left, right);
    }

    public void inOrder(Node node) {
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
