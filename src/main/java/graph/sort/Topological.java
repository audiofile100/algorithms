package graph.sort;

import graph.ds.DiGraph;
import graph.ds.DiGraph.Edge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DFS is commonly used to find a topological sort.
 */
public class Topological {

    private final List<Integer> ordering;
    private final boolean[] visited;

    public Topological(int vertices) {
        ordering = new ArrayList<>();
        visited = new boolean[vertices];
    }

    public void sort(DiGraph dag) {

        for (int v : dag.keys()) {
            if (!visited[v]) {
                dfsTopo(dag, v);
            }
        }
    }

    private void dfsTopo(DiGraph dag, int vertex) {

        visited[vertex] = true;
        for (Edge e : dag.get(vertex).outgoing) {
            if (!visited[e.dest]) {
                dfsTopo(dag, e.dest);
            }
        }
        ordering.add(vertex);
    }

    public List<Integer> getReverseOrder() {
        Collections.reverse(ordering);
        return ordering;
    }

    public static void main(String[] args) {

        int[] vertices = { 0, 1, 2, 3, 4, 5, 6 };

        DiGraph dag = new DiGraph(vertices);
        dag.edge(1, 3, 1);
        dag.edge(1, 6, 1);
        dag.edge(3, 5, 1);
        dag.edge(6, 2, 1);

        dag.edge(0, 5, 1);
        dag.edge(0, 2, 1);

        dag.edge(5, 4, 1);
        dag.edge(5, 2, 1);

        dag.edge(2, 4, 1);

        dag.print();

        Topological topological = new Topological(vertices.length);
        topological.sort(dag);

        List<Integer> ordering = topological.getReverseOrder();

        System.out.println("topological sort ordering: " + ordering);
    }
}
