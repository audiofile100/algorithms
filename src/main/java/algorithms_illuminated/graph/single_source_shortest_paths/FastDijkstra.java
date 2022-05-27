package algorithms_illuminated.graph.single_source_shortest_paths;

import algorithms_illuminated.ds.component.Edge;
import algorithms_illuminated.ds.Graph;
import algorithms_illuminated.ds.component.GNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Optimal implementation of Dijkstra's Algorithm.
 * Solves the single-source shortest-paths problem
 * on any weighted directed graph. Weights must be
 * non-negative.
 */
public class FastDijkstra {

    private List<Character> visit;
    private final PriorityQueue<GNode> heap;

    public FastDijkstra() {
        visit = new ArrayList<>();
        this.heap = new PriorityQueue<>(Comparator.comparingInt(GNode::getScore));
    }

    public void fastDijkstra(Graph g) {

        // --- init score
        g.getNode(0).setScore(0);
        heap.add(g.getNode(0));
        for (int i = 1; i < g.getVertices(); i++) {
            g.getNode(i).setScore(Integer.MAX_VALUE);
            heap.add(g.getNode(i));
        }
        // --- end init

        while (!heap.isEmpty()) {
            GNode w = heap.poll();      // O(1)
            w.setLen(w.getScore());     // len(v) is the true shortest path dist(s, v)
            if (!visit.contains(w.getLabel())) {
                visit.add(w.getLabel());    // save visit order
            }
            for (Edge e : w.getOutgoing()) {
                GNode y = g.getNode(e.getDestination());
                heap.remove(y);     // O(log n)
                y.setScore(Math.min(y.getScore(), w.getLen() + e.getWeight()));     // score is minimum dijkstra score of an edge with head w and tail in X
                heap.add(y);        // O(log n)
            }
        }
    }

    public static void main(String[] args) {

        int V = 7;
        Graph g = new Graph(V);
        g.addOutgoingWeightedDirectedEdge(0, 1, 3);
        g.addOutgoingWeightedDirectedEdge(0, 3, 2);
        g.addOutgoingWeightedDirectedEdge(0, 6, 6);
        g.addOutgoingWeightedDirectedEdge(1, 2, 6);
        g.addOutgoingWeightedDirectedEdge(1, 4, 1);
        g.addOutgoingWeightedDirectedEdge(2, 5, 1);
        g.addOutgoingWeightedDirectedEdge(3, 4, 3);
        g.addOutgoingWeightedDirectedEdge(4, 5, 4);
        g.addOutgoingWeightedDirectedEdge(6, 5, 2);
        //g.printEdges();

        FastDijkstra fd = new FastDijkstra();
        fd.fastDijkstra(g);

        g.printNodes();

        System.out.println("visit order: " + fd.visit);
    }
}
