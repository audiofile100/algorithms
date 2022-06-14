package algoilluminated.graph.ds;

import lombok.Builder;

import java.util.*;

/**
 * Unweighted graph with directed edges.
 */
public class DiGraph {
    @Builder
    private static class Edge {
        String src;
        String dest;
        int weight;
    }
    @Builder
    private static class Node {
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

    // --- print weighted graph
    public void print() {
        for (Node vertex : map.values()) {
            System.out.print(vertex.key + ": ");
            for (Edge e : vertex.outgoing) {
                System.out.print("(" + e.src + "," + e.dest + "," + e.weight + ")");
            }
            System.out.println();
        }
    }
}
