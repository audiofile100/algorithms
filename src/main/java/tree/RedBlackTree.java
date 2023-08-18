package tree;

import lombok.Builder;

/**
 * Self-balancing binary search tree.
 * 1. Red nodes can only have black children.
 * 2. Null is black.
 */
public class RedBlackTree {
    public enum Color {
        RED, BLACK
    }
    @Builder
    public static class Node {
        public int key;
        public Color color;
        public Node left;
        public Node right;
    }
}
