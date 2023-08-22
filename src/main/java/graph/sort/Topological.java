package graph.sort;

import graph.ds.Graph;
import graph.ds.Graph.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DFS is commonly used to find a topological sort.
 */
public class Topological {

    private final List<Integer> ordering;

    public Topological() {
        ordering = new ArrayList<>();
    }

    public void sort(Graph dag) {

        for (int v : dag.vertices()) {
            if (!dag.get(v).visited) {
                dfsTopo(dag, v);
            }
        }
    }

    private void dfsTopo(Graph dag, int vertex) {

        dag.get(vertex).visited = true;
        for (Edge e : dag.get(vertex).outgoing) {
            if (!dag.get(e.dest).visited) {
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

        Graph dag = new Graph(vertices);
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

        Topological topological = new Topological();
        topological.sort(dag);

        List<Integer> ordering = topological.getReverseOrder();

        System.out.println("topological sort ordering: " + ordering);
    }
}
