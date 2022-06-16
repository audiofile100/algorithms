package misc.cache;

import lombok.Builder;

import java.util.LinkedList;
import java.util.Map;

public class LRU {
    @Builder
    public static class Node {
        public int key;
    }

    private int capacity;
    private LinkedList<Node> cache;
    private Map<Integer, Node> map;

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    public Node read(int key) {
        return null;
    }
}
