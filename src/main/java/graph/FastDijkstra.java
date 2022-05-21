package graph;

import ds.Edge;
import ds.Graph;
import ds.Node;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FastDijkstra {

    private final PriorityQueue<Node> heap;

    public FastDijkstra() {
        this.heap = new PriorityQueue<>(Comparator.comparingInt(Node::getKey).thenComparingInt(Node::getId));
    }

    public void fastDijkstra(Graph g) {

        // init
        for (int i = 1; i < g.getVertices(); i++) {
            g.getNode(i).setKey(Integer.MAX_VALUE);
            heap.add(g.getNode(i));
        }
        g.getNode(0).setKey(0);
        heap.add(g.getNode(0));

        while (!heap.isEmpty()) {
            Node w = heap.poll();
            w.setLen(w.getKey());
            for (Edge e : w.getOutgoing()) {
                Node y = g.getNode(e.getDestination());
                heap.remove(y);
                y.setKey(Math.min(y.getKey(), w.getLen() + e.getWeight()));
                heap.add(y);
            }
        }
    }

    public static void main(String[] args) {

        int V = 5;
        Graph g = new Graph(V);
        g.addOutgoingWeightedDirectedEdge(0, 1, 2);
        g.addOutgoingWeightedDirectedEdge(0, 2, 5);
        g.addOutgoingWeightedDirectedEdge(1, 2, 2);
        g.addOutgoingWeightedDirectedEdge(1, 3, 6);
        g.addOutgoingWeightedDirectedEdge(1, 4, 4);
        g.addOutgoingWeightedDirectedEdge(2, 4, 1);
        g.addOutgoingWeightedDirectedEdge(4, 3, 3);
        g.printEdges();

        FastDijkstra fd = new FastDijkstra();
        fd.fastDijkstra(g);

        g.printNodes();
    }
}
