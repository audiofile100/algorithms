package graph.ds;

import lombok.Builder;

import java.util.*;

/**
 * Unweighted graph.
 */
public class Graph {
    @Builder
    public static class Node {
        public int key;
        public List<Node> neighbors;
    }

    private final Map<Integer, Node> map;

    public Graph(int[] vertices) {
        map = new HashMap<>();
        Arrays.stream(vertices).forEach(v -> map.put(v, Node.builder().key(v).neighbors(new ArrayList<>()).build()));
    }

    public void connect(int src, int dest) {
        map.get(src).neighbors.add(map.get(dest));
        map.get(dest).neighbors.add(map.get(src));
    }

    public Node get(int key) {
        return map.get(key);
    }

    // --- print graph
    public void print() {
        for (Node vertex : map.values()) {
            System.out.print(vertex.key + ": ");
            for (Node n : vertex.neighbors) {
                System.out.print(n.key + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
