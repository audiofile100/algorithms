package graph.search;

import graph.ds.Graph;
import graph.ds.Graph.Edge;

/**
 * Created by mg on 8/19/2023.
 */
public class DFSCycleDetection {

    private final Graph graph;

    public DFSCycleDetection(Graph graph) {
        this.graph = graph;
    }

    public boolean hasCycle(int v) {

        graph.get(v).visiting = true;

        for (Edge e : graph.get(v).outgoing) {
            if (graph.get(e.dest).visiting) {
                return true;
            }
            if (!graph.get(e.dest).visited && hasCycle(e.dest)) {
                return true;
            }
        }

        graph.get(v).visiting = false;
        graph.get(v).visited = true;

        return false;
    }
}
