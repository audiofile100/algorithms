package tree.ds;

import lombok.Builder;

/**
 * Unbalanced binary search tree.
 * 1. Key is greater than all keys in the left subtree.
 * 2. Key is less than (or equal to) all keys in the right subtree.
 */
public class BST {
    @Builder
    public static class Node {
        public int key;
        public Node left;
        public Node right;
    }


}
