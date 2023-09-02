package graph.search;

import graph.ds.Graph;
import graph.ds.Graph.Edge;

import java.util.Set;

/**
 * Created by mg on 8/19/2023.
 */
public class DFSCycleDetection {

    public DFSCycleDetection() { }

    public boolean hasCycle(Graph graph) {

        Set<Integer> vertices = graph.vertices();
        for (int v : vertices) {
            if (!graph.get(v).visited && hasCycle(graph, v)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasCycle(Graph graph, int v) {

        graph.get(v).visiting = true;

        for (Edge e : graph.get(v).outgoing) {
            if (graph.get(e.dest).visiting) {
                return true;
            }
            if (!graph.get(e.dest).visited && hasCycle(graph, e.dest)) {
                return true;
            }
        }

        graph.get(v).visiting = false;
        graph.get(v).visited = true;

        return false;
    }

    public static void main(String[] args) {

        Graph graph = new Graph(4);
        graph.edge(0, 1);
        graph.edge(1, 2);
        graph.edge(2, 0);
        graph.edge(2, 3);

        DFSCycleDetection cd = new DFSCycleDetection();
        boolean result = cd.hasCycle(graph);

        System.out.println(result);
    }
}
