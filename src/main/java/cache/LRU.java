package cache;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    @Builder
    public static class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRU(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = Node.builder().build();
        tail = Node.builder().build();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            add(n);
            return n.val;
        }
        return -1;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.val = val;
            remove(n);
            add(n);
            return;
        }

        Node n = Node.builder().key(key).val(val).build();
        add(n);
        map.put(key, n);

        if (map.size() > capacity) {
            Node rm = head.next;
            remove(rm);
            map.remove(rm.key);
        }
    }

    private void add(Node n) {
        Node end = tail.prev;
        end.next = n;
        n.prev = end;
        n.next = tail;
        tail.prev = n;
    }

    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.next = null;
        n.prev = null;
    }
}
