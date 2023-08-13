package graph.search;

import graph.ds.Graph;
import graph.ds.Graph.Node;
import graph.ds.Graph.Edge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Computes minimum number of edges from start
 * to every other vertex.
 */
public class BFS {

    private final boolean[] visited;
    private final List<Integer> ordering;

    public BFS(int vertices) {
        visited = new boolean[vertices];
        ordering = new ArrayList<>();
    }

    public void bfs(Graph graph) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {

            Node v = graph.get(queue.poll());

            ordering.add(v.key);

            for (Edge e : v.outgoing) {
                if (!visited[e.dest]) {
                    visited[e.dest] = true;
                    queue.offer(e.dest);

                    graph.get(e.dest).score = graph.get(e.src).score + e.weight;
                }
            }
        }
    }

    public void print() {
        for (int v : ordering) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] vertices = { 0, 1, 2, 3, 4, 5, 6 };
        Graph graph = new Graph(vertices);

        graph.connect(0, 1, 1);
        graph.connect(0, 2, 1);
        graph.connect(1, 3, 1);
        graph.connect(2, 3, 1);
        graph.connect(3, 5, 1);
        graph.connect(2, 5, 1);
        graph.connect(3, 4, 1);
        graph.connect(4, 6, 1);

        graph.print();

        BFS bfs = new BFS(vertices.length);

        bfs.bfs(graph);
        bfs.print();

        graph.print();
    }
}
