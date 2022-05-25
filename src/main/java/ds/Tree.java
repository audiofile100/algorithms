package ds;

import ds.component.Node;
import lombok.NoArgsConstructor;

import java.util.ArrayDeque;
import java.util.Deque;

@NoArgsConstructor
public class Tree {

    private Node root;

    public Node genTree(Integer[] data) {

        root = new Node(data[0]);
        Deque<Node> curr = new ArrayDeque<>();
        curr.offer(root);
        int idx = 0;

        while (!curr.isEmpty()) {
            int leftIdx = 2 * idx + 1;
            int rightIdx = 2 * idx + 2;

            Node ptr = curr.poll();
            if (leftIdx < data.length && data[leftIdx] != null) {
                Node left = new Node(data[leftIdx]);
                ptr.setLeft(left);
                left.setParent(ptr);
                curr.offer(left);
            }
            if (rightIdx < data.length && data[rightIdx] != null) {
                Node right = new Node(data[rightIdx]);
                ptr.setRight(right);
                right.setParent(ptr);
                curr.offer(right);
            }

            ++idx;
        }

        return root;
    }

    public static void main(String[] args) {

        Integer[] data = { 8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13, null };

        Tree tree = new Tree();
        Node root = tree.genTree(data);
        tree.inOrder(root);

        System.out.println("\nheight: " + tree.height(root));
        Node search = tree.search(root, 20);
        System.out.println((search != null) ? "search: " + search.getId() : "not found");
        System.out.println("min: " + tree.min(root).getId());
        System.out.println("max: " + tree.max(root).getId());
        Node pred = tree.predecessor(root);
        System.out.println((pred != null) ? "predecessor: " + pred.getId() : "none");
        Node succ = tree.successor(root);
        System.out.println((succ != null) ? "successor: " + succ.getId() : "none");

        //Node ins = tree.insert(9);
        //System.out.println((ins != null) ? "insert: " + ins.getId() : "error");
        //tree.inOrder(root);
    }

    public Node insert(int key) {
        Node ptr = root;
        Node next = new Node(key);
        while (ptr != null) {
            if (ptr.getLeft() == null && key < ptr.getId()) {
                next.setParent(ptr);
                ptr.setLeft(next);
                return next;
            }
            if (ptr.getRight() == null && key >= ptr.getId()) {
                next.setParent(ptr);
                ptr.setRight(next);
                return next;
            }
            if (key < ptr.getId()) ptr = ptr.getLeft();
            else ptr = ptr.getRight();
        }
        return null;
    }

    public Node successor(Node ptr) {
        if (ptr.getRight() != null) return min(ptr.getRight());
        Node curr = ptr.getParent();
        while (curr != null && curr.getId() < ptr.getId()) {
            curr = curr.getParent();
        }
        return curr;
    }

    public Node predecessor(Node ptr) {
        if (ptr.getLeft() != null) return max(ptr.getLeft());
        Node curr = ptr.getParent();
        while (curr != null && curr.getId() > ptr.getId()) {
            curr = curr.getParent();
        }
        return curr;
    }

    public Node max(Node ptr) {
        if (ptr.getRight() == null) return ptr;
        return max(ptr.getRight());
    }

    public Node min(Node ptr) {
        if (ptr.getLeft() == null) return ptr;
        return min(ptr.getLeft());
    }

    public Node search(Node ptr, int key) {
        if (ptr == null) return null;
        if (ptr.getId() == key) return ptr;
        else if (ptr.getId() < key) return search(ptr.getRight(), key);
        else return search(ptr.getLeft(), key);
    }

    public int height(Node ptr) {
        if (ptr == null) return 0;
        int left = height(ptr.getLeft()) + 1;
        int right = height(ptr.getRight()) + 1;
        return Math.max(left, right);
    }

    public void inOrder(Node ptr) {
        if (ptr == null) return;
        inOrder(ptr.getLeft());
        System.out.print(ptr.getId() + " ");
        inOrder(ptr.getRight());
    }
}
