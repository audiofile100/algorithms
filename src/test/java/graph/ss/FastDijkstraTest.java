package graph.ss;

import graph.ds.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FastDijkstraTest {

    private FastDijkstra fastDijkstra;

    @BeforeEach
    public void setUp() {
        fastDijkstra = new FastDijkstra();
    }

    @Test
    public void fastDijsktraTest() {

        Graph g = new Graph(5);
        g.edge(0, 1, 10);
        g.edge(0, 2, 1);
        g.edge(1, 3, 1);
        g.edge(2, 3, 15);
        g.edge(3, 4, 9);

        fastDijkstra.fastDijkstra(g, 0);

        g.print();
    }
}
