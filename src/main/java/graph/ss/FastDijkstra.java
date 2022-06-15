package graph.ss;

import graph.ds.DiGraph;
import graph.ds.DiGraph.Edge;
import graph.ds.DiGraph.Node;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * FastDijkstra uses a priority queue.
 * Dijkstra solves the single source-shortest path
 * on any weighted graph with non-negative weights.
 */
public class FastDijkstra {

    public void fastDijkstra(DiGraph g, int src) {

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.score));
        pq.add(g.get(src));

        // --- init scores
        g.vertices().forEach(v -> g.get(v).score = Integer.MAX_VALUE);
        g.get(src).score = 0;
        // --- end init scores

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            for (Edge e : n.outgoing) {
                g.get(e.dest).score = n.score + e.weight;
                pq.add(g.get(e.dest));
            }
        }
    }

    public static void main(String[] args) {

        int[] vertices = { 0, 1, 2, 3 };

        DiGraph dg = new DiGraph(vertices);
        dg.edge(0, 1, 1);
        dg.edge(0, 2, 4);
        dg.edge(1, 2, 2);
        dg.edge(1, 3, 6);
        dg.edge(2, 3, 3);
        dg.print();

        FastDijkstra fd = new FastDijkstra();
        fd.fastDijkstra(dg, 0);

        dg.print();
    }
}
