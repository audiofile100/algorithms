package graph.ds;

import lombok.Builder;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    @Builder
    public static class Edge {
        public int src;
        public int dest;
        public int weight;
        @Override
        public String toString() { return "(" + src + "," + dest + "," + weight + ") "; }
    }
    @Builder
    public static class Node {
        public int key;
        public List<Edge> outgoing;

        // --- utility field (e.g. Dijkstra's Score or weight of vertex etc...)
        public int score;

        // --- cycle detection
        public boolean visiting;
        public boolean visited;

        // --- number of incoming edges
        public int incoming;

        @Override
        public String toString() { return "{key: " + key + ", in: " + incoming + ", score: " + score + "} "; }
    }

    private final Map<Integer, Node> map;

    /**
     * Initializes a graph using int[] vertices as node keys.
     * @param vertices labels for nodes of the graph.
     */
    public Graph(int[] vertices) {
        map = new HashMap<>();
        Arrays.stream(vertices).forEach(v -> map.put(v, Node.builder().key(v).outgoing(new ArrayList<>()).build()));
    }

    /**
     * Initializes a graph with nodes labeled from 0 to n-1.
     * @param n the number of nodes.
     */
    public Graph(int n) {
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, Node.builder().key(i).outgoing(new ArrayList<>()).build());
        }
    }

    /**
     * Creates a weighted edge in both directions for undirected graphs.
     * @param src source node key
     * @param dest destination node key
     * @param weight edge weight
     */
    public void connect(int src, int dest, int weight) {
        map.get(src).outgoing.add(Edge.builder().src(src).dest(dest).weight(weight).build());
        map.get(dest).outgoing.add(Edge.builder().src(dest).dest(src).weight(weight).build());
        incrementIncoming(dest);
        incrementIncoming(src);
    }

    /**
     * Creates a zero weighted edge in both directions for undirected graphs.
     * @param src source node key
     * @param dest destination node key
     */
    public void connect(int src, int dest) {
        map.get(src).outgoing.add(Edge.builder().src(src).dest(dest).weight(0).build());
        map.get(dest).outgoing.add(Edge.builder().src(dest).dest(src).weight(0).build());
        incrementIncoming(dest);
        incrementIncoming(src);
    }

    /**
     * Creates a weighted edge in one direction for directed graphs.
     * @param src source node key
     * @param dest destination node key
     * @param weight edge weight
     */
    public void edge(int src, int dest, int weight) {
        map.get(src).outgoing.add(Edge.builder().src(src).dest(dest).weight(weight).build());
        incrementIncoming(dest);
    }

    /**
     * Creates a zero weighted edge in one direction for directed graphs.
     * @param src source node key
     * @param dest destination node key
     */
    public void edge(int src, int dest) {
        map.get(src).outgoing.add(Edge.builder().src(src).dest(dest).weight(0).build());
        incrementIncoming(dest);
    }

    /*
     * Gets all the root vertices as a set.
     * A root vertex is one with zero incoming edges.
     * @return Set of keys
     */
    public Set<Integer> rootVerticesSet() {
        return map.values().stream().filter(node -> node.incoming == 0).map(node -> node.key).collect(Collectors.toSet());
    }

    public Node get(int key) { return map.get(key); }
    public int size() { return map.size(); }
    public Set<Integer> vertices() { return map.keySet(); }

    // --- print graph
    public void print() {
        for (Node v : map.values()) {
            System.out.print(v);
            for (Edge e : v.outgoing) {
                System.out.print(e);
            }
            System.out.println();
        }
        System.out.println();
    }

    private void incrementIncoming(int key) {
        ++map.get(key).incoming;
    }
}
