package util;

import graph.ds.Graph;

public class Utils {

    /**
     * Undirected Weighted Graph.
     * 6 vertices, 10 edges, MST: 14
     * @return connected undirected weighted graph
     */
    public static Graph defaultUG() {

        int[] vertices = { 0, 1, 2, 3, 4, 5 };

        Graph ug = new Graph(vertices);
        ug.connect(0, 1, 6);
        ug.connect(0, 3, 5);
        ug.connect(0, 4, 4);
        ug.connect(1, 3, 1);
        ug.connect(1, 4, 2);
        ug.connect(1, 5, 3);
        ug.connect(1, 2, 5);
        ug.connect(2, 5, 4);
        ug.connect(3, 4, 2);
        ug.connect(4, 5, 4);

        return ug;
    }
}
