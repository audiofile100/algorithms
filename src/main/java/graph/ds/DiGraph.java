package graph.ds;

import lombok.Builder;

import java.util.*;

/**
 * Unweighted graph with directed edges.
 */
public class DiGraph {
    @Builder
    public static class Edge {
        String src;
        String dest;
        int weight;
    }
    @Builder
    public static class Node {
        String key;
        List<Edge> outgoing;
    }

    private final Map<String, Node> map;

    public DiGraph(String[] vertices) {
        map = new HashMap<>();
        Arrays.stream(vertices).forEach(v -> map.put(v, Node.builder().key(v).outgoing(new ArrayList<>()).build()));
    }

    public void edge(String src, String dest, int weight) {
        Edge edge = Edge.builder().src(src).dest(dest).weight(weight).build();
        map.get(src).outgoing.add(edge);
    }

    public Node get(String key) {
        return map.get(key);
    }

    // --- print weighted graph
    public void print() {
        for (Node vertex : map.values()) {
            System.out.print(vertex.key + ": ");
            for (Edge e : vertex.outgoing) {
                System.out.print("(" + e.src + "," + e.dest + "," + e.weight + ")");
            }
            System.out.println();
        }
        System.out.println();
    }
}
