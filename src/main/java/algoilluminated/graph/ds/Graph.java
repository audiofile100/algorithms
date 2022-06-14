package algoilluminated.graph.ds;

import lombok.Builder;

import java.util.*;

/**
 * Unweighted graph.
 */
public class Graph {
    @Builder
    private static class Node {
        String key;
        List<Node> neighbors;
    }

    private final Map<String, Node> map;

    public Graph(String[] vertices) {
        map = new HashMap<>();
        Arrays.stream(vertices).forEach(v -> map.put(v, Node.builder().key(v).neighbors(new ArrayList<>()).build()));
    }

    public void connect(String src, String dest) {
        map.get(src).neighbors.add(map.get(dest));
        map.get(dest).neighbors.add(map.get(src));
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
    }
}
