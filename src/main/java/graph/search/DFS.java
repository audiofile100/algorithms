package graph.search;

import graph.ds.Graph;
import graph.ds.Graph.Edge;
import graph.ds.Graph.Node;

public class DFS {

    public DFS() {

    }

    public boolean hasCycle(Graph graph, int v) {

        graph.get(v).visiting = true;

        for (Edge e : graph.get(v).outgoing) {
            if (graph.get(e.dest).visiting) {
                System.out.println("cycle detected");
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

        int[] vertices = { 0, 1, 2, 3, 4 };
        Graph cyclic = new Graph(vertices);

        cyclic.edge(0, 1, 1);
        cyclic.edge(0, 2, 1);
        cyclic.edge(1, 2, 1);
        cyclic.edge(2, 3, 1);
        cyclic.edge(2, 4, 1);

        cyclic.edge(4, 1, 1);

        DFS dfs = new DFS();

        dfs.hasCycle(cyclic, 0);
    }
}
