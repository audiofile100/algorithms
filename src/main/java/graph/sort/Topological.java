package graph.sort;

import graph.ds.DiGraph;

import java.util.List;

/**
 * DFS is commonly used to find a topological sort.
 */
public class Topological {

    public Topological() {

    }

    public List<String> sort(DiGraph.Node start) {
        return null;
    }

    public static void main(String[] args) {

        String[] vertices = { "A", "B", "C", "D", "E", "F", "G" };

        DiGraph dag = new DiGraph(vertices);
        dag.edge("B", "D", 1);
        dag.edge("D", "F", 1);
        dag.edge("F", "E", 1);

        dag.edge("B", "G", 1);
        dag.edge("G", "C", 1);
        dag.edge("C", "E", 1);

        dag.edge("A", "C", 1);
        dag.edge("A", "F", 1);
        dag.edge("F", "C", 1);

        dag.print();

        DiGraph.Node start = dag.get("B");

        Topological topological = new Topological();
        List<String> ordering = topological.sort(start);

        System.out.println("topological sort ordering: " + ordering);
    }
}
