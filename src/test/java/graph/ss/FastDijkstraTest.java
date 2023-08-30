package graph.ss;

import graph.ds.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FastDijkstraTest {

    private FastDijkstra fastDijkstra;

    @BeforeEach
    public void setUp() {
        fastDijkstra = new FastDijkstra();
    }

    @Test
    public void fastDijkstraTest() {

        Graph g = new Graph(5);
        g.edge(0, 1, 10);
        g.edge(0, 2, 1);
        g.edge(1, 3, 1);
        g.edge(2, 3, 15);
        g.edge(3, 4, 9);

        fastDijkstra.fastDijkstra(g, 0);

        assertEquals(0, g.get(0).score);
        assertEquals(10, g.get(1).score);
        assertEquals(1, g.get(2).score);
        assertEquals(11, g.get(3).score);
        assertEquals(20, g.get(4).score);

        g.print();
    }
}
